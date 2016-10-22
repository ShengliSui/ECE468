grammar Micro;

@header
{
import java.util.*;
}

@members
{
	int blockCount = 0;
	String cat;
	TokenClass temp;
	public SymbolTable st = new SymbolTable();
	public ShuntingYardStructure sy = new ShuntingYardStructure();
}

fragment ANY_LETTER: [A-Za-z];
fragment ANY_DIGIT: [0-9];
fragment COMMENT_BEGIN: '--';


KEYWORD: 'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSIF'|'ENDIF'|'DO'|'WHILE'|'CONTINUE'|'BREAK'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT'|'TRUE'|'FALSE' ;

INTLITERAL: ANY_DIGIT+ ;
FLOATLITERAL: (ANY_DIGIT*)'.'(ANY_DIGIT+) ;
STRINGLITERAL: '"'(~[\"])*'"' ;                  /* add '\0' if necessary */
IDENTIFIER: (ANY_LETTER)((ANY_LETTER | ANY_DIGIT)+)?;
COMMENT: COMMENT_BEGIN(~[\n\r])* -> skip;
WHITESPACE: [\n\r\t ]+ -> skip;

ADD: '+';
SUB: '-';
MULT: '*';
DIV: '/';
LP: '(';
RP: ')';
SCOLON: ';';
COMMA: ',';
ASSIGN: ':=';

COMPOP : '<'|'>'|'='|'!='|'<='|'>=';

/* PROGRAM */
program           : KEYWORD id KEYWORD pgm_body KEYWORD ;

id returns [String iden]
: IDENTIFIER
{
	$iden = $IDENTIFIER.text;
}
;

pgm_body          : decl func_declarations;
decl              : string_decl decl | var_decl decl | ;

/* Global String Declaration */
string_decl
: KEYWORD id ASSIGN str SCOLON
{
	st.addField($id.iden,"STRING",$str.strLit);
}
;

str returns [String strLit]
: STRINGLITERAL
{
	$strLit = $STRINGLITERAL.text;
}
;

/* Variable Declaration */
var_decl
: var_type id_list SCOLON
{
	st.addField($id_list.idList,$var_type.text);
}
;

var_type          : KEYWORD | KEYWORD;
any_type          : var_type | KEYWORD;

id_list returns [ArrayList<String> idList]
: id tail=id_tail
{
	$idList = $tail.idList;
	$idList.add(0,$id.iden);
}
;

id_tail returns [ArrayList<String> idList]
: COMMA id tail=id_tail
{
	$idList = $tail.idList;
	$idList.add(0,$id.text);
}
|  /*empty string*/
{
	$idList = new ArrayList<String>();
}
;

/* Function Paramater List */
param_decl_list
: param_decl param_decl_tail
{
	$param_decl_tail.pdt.get(0).add(0,$param_decl.paramDecl[0]);
	$param_decl_tail.pdt.get(1).add(0,$param_decl.paramDecl[1]);	
	st.addField($param_decl_tail.pdt.get(0),$param_decl_tail.pdt.get(1));	
}
|
;

param_decl returns [String[] paramDecl]
: var_type id
{
	$paramDecl = new String[]{$id.iden,$var_type.text};
}
;

param_decl_tail returns [ArrayList<ArrayList<String>> pdt]
: COMMA param_decl tail=param_decl_tail
{
	$pdt = $tail.pdt;
	$pdt.get(0).add(0,$param_decl.paramDecl[0]);
	$pdt.get(1).add(0,$param_decl.paramDecl[1]);	
}
| 
{
	$pdt = new ArrayList<ArrayList<String>>();
	$pdt.add(new ArrayList<String>());
	$pdt.add(new ArrayList<String>());	
}
;

/* Function Declarations */
func_declarations : func_decl func_declarations | ;

func_decl
: KEYWORD any_type id
{
	st.addScope($id.iden);
}
LP param_decl_list RP KEYWORD func_body KEYWORD
{
	st.removeScope();
};

func_body         : decl stmt_list ;

/* Statement List */
stmt_list         : stmt stmt_list | ;
stmt              : base_stmt | if_stmt | do_while_stmt;
base_stmt         : assign_stmt | read_stmt | write_stmt | return_stmt;

/* Basic Statements */
assign_stmt       : assign_expr SCOLON;
assign_expr
: id
{
	sy.pushOperand(new TokenClass(TokenEnum.VAR, $id.iden));
}
ASSIGN
{
	sy.pushOperator(new TokenClass(TokenEnum.BINARY_OP, $ASSIGN.text));
}
expr;

read_stmt
: KEYWORD
{
	if($KEYWORD.text == "READ"){
		sy.pushOperator(new TokenClass(TokenEnum.IO,$KEYWORD.text));
	}
}
LP
{
	sy.pushOperator(new TokenClass(TokenEnum.UNARY_OP, $LP.text));
}
id_list
{
	for(String item : $id_list.idList){
		sy.pushOperand(new TokenClass(TokenEnum.VAR,item));	
	}
}
RP
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.UNARY_OP && temp.getString() != "(" && temp.getString() != ":="){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();
	}
	sy.popOperator();
	if(temp.getType() == TokenEnum.IO){
		sy.popOperator();
	}
}
SCOLON;

write_stmt
: KEYWORD
{
	if($KEYWORD.text == "WRITE"){
		sy.pushOperator(new TokenClass(TokenEnum.IO,$KEYWORD.text));
	}
}
LP
{
	sy.pushOperator(new TokenClass(TokenEnum.UNARY_OP, $LP.text));
}
id_list
{
	for(String item : $id_list.idList){
		sy.pushOperand(new TokenClass(TokenEnum.VAR,item));	
	}
}
RP
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.UNARY_OP && temp.getString() != "(" && temp.getString() != ":="){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();
	}
	sy.popOperator();
	if(temp.getType() == TokenEnum.IO){
		sy.popOperator();
	}
}
SCOLON;

return_stmt       : KEYWORD expr SCOLON;

/* Expressions */
expr              : expr_prefix factor;
expr_prefix       : expr_prefix factor addop | ;
factor            : factor_prefix postfix_expr;
factor_prefix     : factor_prefix postfix_expr mulop | ;
postfix_expr      : primary | call_expr;

call_expr
: id
{
	sy.pushOperand(new TokenClass(TokenEnum.VAR, $id.iden));
}
LP
{
	sy.pushOperator(new TokenClass(TokenEnum.UNARY_OP, $LP.text));
}
expr_list RP
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.UNARY_OP && temp.getString() != "(" && temp.getString() != ":="){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();
	}
	sy.popOperator();
	if(temp.getType() == TokenEnum.IO){
		sy.popOperator();
	}
}
;
expr_list         : expr expr_list_tail | ;
expr_list_tail    : COMMA expr expr_list_tail | ;

primary
: LP
{
	sy.pushOperator(new TokenClass(TokenEnum.UNARY_OP, $LP.text));
}
expr RP
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.UNARY_OP && temp.getString() != "(" && temp.getString() != ":="){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();
	}
	sy.popOperator();
	if(temp.getType() == TokenEnum.IO){
		sy.popOperator();
	}
}
| id
{
	sy.pushOperand(new TokenClass(TokenEnum.VAR, $id.iden));
}
| INTLITERAL
{
	sy.pushOperand(new TokenClass(TokenEnum.CONST_I, $INTLITERAL.text));
}
| FLOATLITERAL
{
	sy.pushOperand(new TokenClass(TokenEnum.CONST_F, $FLOATLITERAL.text));
}
;

addop
: ADD
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.BINARY_OP && (temp.getString() == "+" || temp.getString() == "-")){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();	
	}
	sy.pushOperator(new TokenClass(TokenEnum.BINARY_OP,$ADD.text));
}
| SUB
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.BINARY_OP && (temp.getString() == "+" || temp.getString() == "-")){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();	
	}
	sy.pushOperator(new TokenClass(TokenEnum.BINARY_OP,$SUB.text));
}
;
mulop
: MULT
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.BINARY_OP && (temp.getString() == "*" || temp.getString() == "/")){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();	
	}
	sy.pushOperator(new TokenClass(TokenEnum.BINARY_OP,$MULT.text));
}
| DIV
{
	temp = sy.peekOperatorStack();
	while(temp.getType() == TokenEnum.BINARY_OP && (temp.getString() == "*" || temp.getString() == "/")){
		sy.pushOperand(sy.popOperator());
		temp = sy.peekOperatorStack();	
	}
	sy.pushOperator(new TokenClass(TokenEnum.BINARY_OP,$DIV.text));
}
;

/* Complex Statements and Condition */ 
if_stmt
: KEYWORD LP cond RP
{
	blockCount++;
	cat = "BLOCK "+Integer.toString(blockCount);
	st.addScope(cat);
}
decl stmt_list else_part KEYWORD
{
	st.removeScope();
}
;

else_part
: KEYWORD LP cond RP
{
	st.removeScope();
	blockCount++;
	cat = "BLOCK "+Integer.toString(blockCount);	
	st.addScope(cat);
}
decl stmt_list else_part
|
;

cond              : expr compop expr | KEYWORD | KEYWORD;
compop            : COMPOP;

do_while_stmt
: KEYWORD
{
	blockCount++;
	cat = "BLOCK "+Integer.toString(blockCount);		
	st.addScope(cat);
}
decl stmt_list KEYWORD LP cond RP
{
	st.removeScope();
}
SCOLON
;

