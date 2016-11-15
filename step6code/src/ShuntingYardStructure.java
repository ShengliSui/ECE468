import java.util.*; 
import org.antlr.v4.runtime.*;

public class ShuntingYardStructure{

    private final int TEMP_MAGIC = 1;
    private final int LABEL_MAGIC = 1;
    
    private Map<String,Function> funcMap;
    private Deque<String> funcScope;
    private SymbolTable st; 

    private Counter temp;
    private Counter label;
    private int elsifFlag;
    private int prevTrueFlag;
    private int funcAssign;

    private Deque<Integer> dwhileLabel;
    private Deque<Integer> endLabel;
    private Deque<Integer> elifLabel;
    
    ShuntingYardStructure(){
	funcMap = new LinkedHashMap<String,Function>();
	funcMap.put("GLOBAL",new Function());
	funcScope = new ArrayDeque<String>();
	funcScope.push("GLOBAL");

	this.temp = new Counter(TEMP_MAGIC);
	this.label = new Counter(LABEL_MAGIC);
	this.elsifFlag = 1;
	this.prevTrueFlag = 0;
	this.funcAssign = 0;

	this.elifLabel = new ArrayDeque<Integer>();
	this.dwhileLabel = new ArrayDeque<Integer>();
	this.endLabel = new ArrayDeque<Integer>();		
    } 

    public void initializeST(SymbolTable st){
	this.st = st;
    }

    public String lookup(String scope,String name){
	if(name.equals("") || name.startsWith("$")) return name;
	return funcMap.get(scope).lookup(name);
    }

    public void addFuncParam(ArrayList<String> params){
	Collections.reverse(params);	
	funcMap.get(peekScope()).addParam(params);
    }	

    public void addFuncLocal(ArrayList<String> locals){
	funcMap.get(peekScope()).addLocal(locals);
    }

    public void addFuncLocal(String local){
	funcMap.get(peekScope()).addLocal(local);
    }

    public void addScope(String scope){
	funcScope.push(scope);
	funcMap.put(scope,new Function());
    }

    public void removeScope(){
	funcScope.pop();
    }

    public String peekScope(){
	return funcScope.peekFirst();
    }

    public void pushOperator(TokenClass item){
	funcMap.get(peekScope()).pushOperator(item);
    }

    public void pushOperator(String scope, TokenClass item){
	funcMap.get(scope).pushOperator(item);
    }    
    
    public TokenClass popOperator(){
	return funcMap.get(peekScope()).popOperator();
    }

    public TokenClass popOperator(String scope){
	return funcMap.get(scope).popOperator();
    }
    
    public void pushOperand(TokenClass item){
	funcMap.get(peekScope()).pushOperand(item);
    }

    public void pushOperand(String scope, TokenClass item){
	funcMap.get(scope).pushOperand(item);
    }    
    
    public TokenClass pollOperand(){
	return funcMap.get(peekScope()).pollOperand();
    }    

    public TokenClass pollOperand(String scope){
	return funcMap.get(scope).pollOperand();
    }    
    
    public TokenClass peekOperator(){
	return funcMap.get(peekScope()).peekOperator();
    }

    public TokenClass peekOperator(String scope){
	return funcMap.get(scope).peekOperator();
    }    
    
    public TokenClass peekOperand(){
	return funcMap.get(peekScope()).peekOperand();
    }

    public TokenClass peekOperand(String scope){
	return funcMap.get(scope).peekOperand();
    }    

    private void pushNode(String scope, IRNode node){
	funcMap.get(scope).pushNode(node);
    }    

    private IRNode pollNode(String scope){
	return funcMap.get(scope).pollNode();
    }

    private void pushEval(String scope, String item){
	funcMap.get(scope).pushEval(item);
    }

    private String popEval(String scope){
	return funcMap.get(scope).popEval();
    }

    public boolean operatorIsEmpty(){
	return funcMap.get(peekScope()).operatorIsEmpty();
    }

    public boolean operatorIsEmpty(String scope){
	return funcMap.get(scope).operatorIsEmpty();
    }    

    public boolean operandIsEmpty(){
	return funcMap.get(peekScope()).operandIsEmpty();
    }

    public boolean operandIsEmpty(String scope){
	return funcMap.get(scope).operandIsEmpty();
    }    

    private boolean evalIsEmpty(){
	return funcMap.get(peekScope()).evalIsEmpty();
    }    

    private boolean evalIsEmpty(String scope){
	return funcMap.get(scope).evalIsEmpty();
    }    
    
    private Enum.instrType findInstructionType(String curScope,String opLeft, String opRight, String result){
	String target="";
	String[] datatype = null;
	Enum.instrType returndata = Enum.instrType.ERROR;
	
	if(!opLeft.equals("")){
	    target = opLeft;
	}else if(!opRight.equals("")){
	    target = opRight;
	}else if(!result.equals("")){
	    target = result;
	}

	assert !target.equals("") : "instruction with no operands?";
	
	datatype = st.getType(curScope,target);

	if(datatype == null){
	    datatype = st.getType(peekScope(),target);
	}
	if(datatype == null){
	    datatype = st.getType("GLOBAL",target);
	}
	/*
	if(target.startsWith("$")){
	    datatype = st.getType(curScope,target);
	}else{
	    datatype = st.getType("GLOBAL",target);
	}
	*/
	if(datatype == null){ //can't find var in symbol table
	    if(target.startsWith("$")){//operand is reg
		System.out.println(target);
		st.printSymbolTable();
		printFST();
		System.out.println("reg is not found in st. what's going on");
		System.exit(1);
	    }else{//operand is constant or stringval
		returndata = parseOperand(target);
	    }
	}else{

	    if(datatype[0].equals("INT")){
		returndata = Enum.instrType.INT;
	    }else if(datatype[0].equals("FLOAT")){
		returndata = Enum.instrType.FLOAT;
	    }else if(datatype[0].equals("STRING")){
		returndata = Enum.instrType.STRING;
	    }
	}

	assert returndata != Enum.instrType.ERROR : "invalid return data";

	return returndata;
    }

    private Enum.instrType parseOperand(String operand){
	try{//INT
	    Integer.parseInt(operand);
	    return Enum.instrType.INT;
	}catch(NumberFormatException e){
	    try{//FLOAT
		Float.parseFloat(operand);
		return Enum.instrType.FLOAT;
	    }catch(NumberFormatException e2){
		System.out.println("operand is neither valid var,int or float");
		return Enum.instrType.STRING;
	    }		
	}
    }
    
    private void generateList(String scope){
	String opcode;
	String result;
	String opLeft;
	String opRight;
	String dataType;

	emptyOperatorStack(scope);
	//	st.addScope("TEMP");
	
	while(!operandIsEmpty(scope)){
	    opcode = "";
	    result = "";
	    opLeft = "";
	    opRight = "";
	    dataType = "";
	    
	    TokenClass token = pollOperand(scope);

	    switch(token.getType()){
	    case VAR:
	    case CONST_I:
	    case CONST_F:
		pushEval(scope,token.getValue());
		break;
	    case BRANCH:
		String cond;
		switch(token.getValue()){
		case "IF":
		    cond = popEval(scope);
		    if(cond.equals("TRUE")){
			endLabel.push(label.get_update());
			prevTrueFlag = 1;
		    }else if(cond.equals("FALSE")){
			elsifFlag = 0;
		    }else{
			switch(cond){
			case ">":
			    opcode = "LE"; break;
			case ">=":
			    opcode = "LT"; break;
			case "<":
			    opcode = "GE"; break;
			case "<=":
			    opcode = "GT"; break;
			case "!=":
			    opcode = "EQ"; break;
			case "=":
			    opcode = "NE"; break;
			default:
			    System.out.println("comp went kuku"); break;
			}
			opRight = popEval(scope);
			opLeft = popEval(scope);
			int dummyI; float dummyF;
			String tempr,templ;
			try{
			    dummyI = Integer.parseInt(opRight);
			    tempr = "$T"+Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode("STOREI",lookup(scope,opRight),"",tempr));
			    st.updateTemp(scope,tempr,"INT");
			    opcode += "I";
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opRight);
				tempr = "$T"+Integer.toString(temp.get_update());			    
				pushNode(scope,new IRNode("STOREF",lookup(scope,opRight),"",tempr));
				st.updateTemp(scope,tempr,"FLOAT");
				opcode += "F";
			    }catch(NumberFormatException nff){
				tempr = "$T"+Integer.toString(temp.get_update());			    
				if(findInstructionType(scope,"",opRight,"")==Enum.instrType.INT){
				    pushNode(scope,new IRNode("STOREI",lookup(scope,opRight),"",tempr));
				    st.updateTemp(scope,tempr,"INT");				    
				    opcode += "I";
				}else if(findInstructionType(scope,"",opRight,"")==Enum.instrType.FLOAT){
				    pushNode(scope,new IRNode("STOREF",lookup(scope,opRight),"",tempr));
				    st.updateTemp(scope,tempr,"FLOAT");
				    opcode += "F";
				}else{
				    System.out.println("findInstructionType went kuku");
				    System.exit(1);
				}
			    }
			}
			try{
			    dummyI = Integer.parseInt(opLeft);
			    templ = "$T"+Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode("STOREI",lookup(scope,opLeft),"",templ));
			    st.updateTemp(scope,tempr,"INT");
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opLeft);
				templ = "$T"+Integer.toString(temp.get_update());
				pushNode(scope,new IRNode("STOREF",lookup(scope,opLeft),"",templ));
				st.updateTemp(scope,tempr,"FLOAT");
			    }catch(NumberFormatException nff){
				templ = opLeft;
			    }
			}
			endLabel.push(label.get_update());
			elifLabel.push(label.get_update());
			result = "label"+Integer.toString(elifLabel.peekFirst());
			pushNode(scope,new IRNode(opcode,lookup(scope,templ),lookup(scope,tempr),result)); //to else if
		    }
		    break;

		case "ELSIF":
		    if(elsifFlag == 1)
			pushNode(scope,new IRNode("JUMP","","","label"+Integer.toString(endLabel.peekFirst()))); //to endif
		    elsifFlag = 1;

		    if(prevTrueFlag == 0)
			pushNode(scope,new IRNode("LABEL","","","label"+Integer.toString(elifLabel.peekFirst()))); //else if
		    prevTrueFlag = 0;
		    
		    cond = popEval(scope);
		    if(cond.equals("TRUE")){
			prevTrueFlag = 1;
		    }else if(cond.equals("FALSE")){
			elsifFlag = 0;
		    }else{
			switch(cond){
			case ">":
			    opcode = "LE"; break;
			case ">=":
			    opcode = "LT"; break;
			case "<":
			    opcode = "GE"; break;
			case "<=":
			    opcode = "GT"; break;
			case "!=":
			    opcode = "EQ"; break;
			case "=":
			    opcode = "NE"; break;
			default:
			    System.out.println("comp went kuku"); break;
			}
			opRight = popEval(scope);
			opLeft = popEval(scope);
			int dummyI; float dummyF;
			String tempr,templ;
			try{
			    dummyI = Integer.parseInt(opRight);
			    tempr = "$T"+Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode("STOREI",opRight,"",tempr));
			    st.updateTemp(scope,tempr,"INT");
			    opcode += "I";
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opRight);
				tempr = "$T"+Integer.toString(temp.get_update());			    
				pushNode(scope,new IRNode("STOREF",opRight,"",tempr));
				st.updateTemp(scope,tempr,"FLOAT");
				opcode += "F";
			    }catch(NumberFormatException nff){
				tempr = "$T"+Integer.toString(temp.get_update());
				if(findInstructionType(scope,"",opRight,"")==Enum.instrType.INT){
				    pushNode(scope,new IRNode("STOREI",lookup(scope,opRight),"",tempr));
				    st.updateTemp(scope,tempr,"INT");				    
				    opcode += "I";
				}else if(findInstructionType(scope,"",opRight,"")==Enum.instrType.FLOAT){
				    pushNode(scope,new IRNode("STOREF",lookup(scope,opRight),"",tempr));
				    st.updateTemp(scope,tempr,"FLOAT");				    
				    opcode += "F";
				}else{
				    System.out.println("findInstructionType went kuku");
				    System.exit(1);
				}
			    }
			}
			try{
			    dummyI = Integer.parseInt(opLeft);
			    templ = "$T"+Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode("STOREI",opLeft,"",templ));
			    st.updateTemp(scope,templ,"INT");
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opLeft);
				templ = "$T"+Integer.toString(temp.get_update());
				pushNode(scope,new IRNode("STOREF",opLeft,"",templ));
				st.updateTemp(scope,tempr,"FLOAT");
			    }catch(NumberFormatException nff){
				templ = opLeft;
			    }
			}
			elifLabel.pop();
			elifLabel.push(label.get_update());
			result = "label"+Integer.toString(elifLabel.peekFirst());
			pushNode(scope,new IRNode(opcode,lookup(scope,templ),lookup(scope,tempr),result)); //to else if
		    }
		    break;

		case "ENDIF":
		    if(prevTrueFlag == 0)
			pushNode(scope,new IRNode("LABEL","","","label"+Integer.toString(elifLabel.peekFirst())));
		    prevTrueFlag = 0;

		    pushNode(scope,new IRNode("LABEL","","","label"+Integer.toString(endLabel.peekFirst())));
		    endLabel.pop();
		    elifLabel.pop();
		    break;
		case "DO":
		    dwhileLabel.push(label.get_update());
		    opcode = "LABEL";
		    result = "label" + Integer.toString(dwhileLabel.peekFirst());
		    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),lookup(scope,opRight),result));
		    break;
		case "WHILE":
		    cond = popEval(scope);
		    if(cond.equals("TRUE")){
			opcode = "JUMP";
			result = "label"+Integer.toString(dwhileLabel.peekFirst());
			pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),lookup(scope,opRight),result));
		    }else if(cond.equals("FALSE")){
			//do nothing
		    }else{
			switch(cond){
			case ">":
			    opcode = "LE"; break;
			case ">=":
			    opcode = "LT"; break;
			case "<":
			    opcode = "GE"; break;
			case "<=":
			    opcode = "GT"; break;
			case "!=":
			    opcode = "EQ"; break;
			case "=":
			    opcode = "NE"; break;
			default:
			    System.out.println("comp went kuku"); break;
			}
			opRight = popEval(scope);
			opLeft = popEval(scope);
			int dummyI; float dummyF;
			String tempr,templ;
			try{
			    dummyI = Integer.parseInt(opRight);
			    tempr = "$T"+Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode("STOREI",opRight,"",tempr));
			    st.updateTemp(scope,tempr,"INT");
			    opcode += "I";
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opRight);
				tempr = "$T"+Integer.toString(temp.get_update());			    
				pushNode(scope,new IRNode("STOREF",opRight,"",tempr));
				st.updateTemp(scope,tempr,"FLOAT");
				opcode += "F";
			    }catch(NumberFormatException nff){
				tempr = "$T"+Integer.toString(temp.get_update());			    
				if(findInstructionType(scope,"",opRight,"")==Enum.instrType.INT){
				    pushNode(scope,new IRNode("STOREI",lookup(scope,opRight),"",tempr));
				    st.updateTemp(scope,tempr,"INT");				    
				    opcode += "I";
				}else if(findInstructionType(scope,"",opRight,"")==Enum.instrType.FLOAT){
				    pushNode(scope,new IRNode("STOREF",lookup(scope,opRight),"",tempr));
				    st.updateTemp(scope,tempr,"FLOAT");				    
				    opcode += "F";
				}else{
				    System.out.println("findInstructionType went kuku");
				    System.exit(1);
				}
			    }
			}
			try{
			    dummyI = Integer.parseInt(opLeft);
			    templ = "$T"+Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode("STOREI",opLeft,"",templ));
			    st.updateTemp(scope,templ,"INT");
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opLeft);
				templ = "$T"+Integer.toString(temp.get_update());
				pushNode(scope,new IRNode("STOREF",opLeft,"",templ));
				st.updateTemp(scope,templ,"FLOAT");
			    }catch(NumberFormatException nff){
				templ = opLeft;
			    }
			}
			result = "label"+Integer.toString(label.get_update());
			pushNode(scope,new IRNode(opcode,lookup(scope,templ),lookup(scope,tempr),result));
			opcode = "JUMP";result = "label"+Integer.toString(dwhileLabel.peekFirst());
			pushNode(scope,new IRNode(opcode,"","",result));
			opcode = "LABEL";result = "label"+Integer.toString(label.get()-1);
			pushNode(scope,new IRNode(opcode,"","",result));
		    }
		}
		break;
	    case UNARY_OP:
		switch(token.getValue()){
		case "TRUE":
		case "FALSE":
		    pushEval(scope,token.getValue());
		    break;
		case "RETURN":
		    opLeft = popEval(scope);
		    if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "STOREI";
			dataType = "INT";			
		    }else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "STOREF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    result = "$R";
		    if(!lookup(scope,opLeft).startsWith("$T")){
			opRight = "$T" + Integer.toString(temp.get_update());
			pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),"",opRight));
			pushNode(scope,new IRNode(opcode,opRight,"",result));
		    }else{
			pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),"",result));
		    }
		    pushNode(scope,new IRNode("RET","","",""));
		}
		break;
	    case BINARY_OP:
	  	switch(token.getValue()){
		case "=":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "!=":
		    pushEval(scope,token.getValue());
		    break;
		case ":=":
		    if(funcAssign == 1){
			result = popEval(scope);
			opLeft = "$T" + Integer.toString(temp.get_update());
			pushNode(scope,new IRNode("POP","","",opLeft));
			if(findInstructionType(scope,"","",result)==Enum.instrType.INT){
			    opcode = "STOREI";
			    dataType = "INT";
			}else if(findInstructionType(scope,"","",result)==Enum.instrType.FLOAT){
			    opcode = "STOREF";
			    dataType = "FLOAT";			
			}else{
			    System.out.println("findInstructionType went kuku");
			    System.exit(1);
			}
			pushNode(scope,new IRNode(opcode,opLeft,"",lookup(scope,result)));
			result = opLeft;
			funcAssign = 0;
		    }else{
			opLeft = popEval(scope);//20
			opRight = popEval(scope);//a
			if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			    opcode = "STOREI";
			    dataType = "INT";
			}else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			    opcode = "STOREF";
			    dataType = "FLOAT";			
			}else{
			    System.out.println("findInstructionType went kuku");
			    System.exit(1);
			}
			if(!lookup(scope,opLeft).startsWith("$T")){
			    result = "$T" + Integer.toString(temp.get_update());
			    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),"",result));
			    pushNode(scope,new IRNode(opcode,result,"",lookup(scope,opRight)));
			}else{
			    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),"",lookup(scope,opRight)));
			}
		    }
		    break;

		case "*":
		    result = "$T" + Integer.toString(temp.get_update());
		    opLeft = popEval(scope);//b
		    opRight = popEval(scope);//a
		    if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "MULTI";
			dataType = "INT";
		    }else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "MULTF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(scope,result);
		    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),lookup(scope,opRight),result));
		    break;		    

		case "+":
		    result = "$T" + Integer.toString(temp.get_update());
		    opLeft = popEval(scope);//T2
		    opRight = popEval(scope);//c
		    if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "ADDI";
			dataType = "INT";			
		    }else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "ADDF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(scope,result);		    
		    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),lookup(scope,opRight),result));
		    break;		    

		case "-":
		    result = "$T" + Integer.toString(temp.get_update());
		    opRight = popEval(scope);//a
		    opLeft = popEval(scope);//b
		    if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "SUBI";
			dataType = "INT";			
		    }else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "SUBF";
			dataType = "FLOAT";						
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(scope,result);
		    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),lookup(scope,opRight),result));
		    break;		    

		case "/":
		    result = "$T" + Integer.toString(temp.get_update());
		    opRight = popEval(scope);//c
		    opLeft = popEval(scope);//T2
		    if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "DIVI";
			dataType = "INT";									
		    }else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "DIVF";
			dataType = "FLOAT";
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(scope,result);		    
		    pushNode(scope,new IRNode(opcode,lookup(scope,opLeft),lookup(scope,opRight),result));
		    break;		    
		}
		break;
	    case IO:
		switch(token.getValue()){
		case "WRITE":
		    do{
			result = popEval(scope);//a
			String tempResult = result;

			if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			    opcode = "WRITEI";
			    dataType = "INT"; tempResult = lookup(scope,result);
			}else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			    opcode = "WRITEF";
			    dataType = "FLOAT";	tempResult = lookup(scope,result);		
			}else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.STRING){
			    opcode = "WRITES";
			    dataType = "STRING";
			}else{
			    System.out.println("findInstructionType went kuku");
			    System.exit(1);
			}
			pushNode(scope,new IRNode(opcode,"","",tempResult));
		    }while(!evalIsEmpty(scope));
		    break;
		case "READ":
		    do{
			result = popEval(scope);//a
			if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.INT){
			    opcode = "READI";
			    dataType = "INT";
			}else if(findInstructionType(scope,opLeft,opRight,result)==Enum.instrType.FLOAT){
			    opcode = "READF";
			    dataType = "FLOAT";
			}else{
			    System.out.println("findInstructionType went kuku");
			    System.exit(1);
			}
			pushNode(scope,new IRNode(opcode,"","",lookup(scope,result)));
		    }while(!evalIsEmpty(scope));
		    break;
		}
		break;
	    case FUNC:
		switch(token.getValue()){
		case "FUNCTION":
		    temp.reset();
		    pushNode(scope,new IRNode("LABEL",opLeft,opRight,scope));
		    pushNode(scope,new IRNode("LINK",opLeft,opRight,result));
		    break;
		default:
		    if(!funcMap.containsKey(token.getValue())){
			System.out.println("invalid function name " + token.getValue() + token.getType());
		    }
		    Stack<String> res = new Stack<String>();
		    pushNode(scope,new IRNode("PUSH","","",""));
		    for(int i = 0; i < funcMap.get(token.getValue()).getParamNum(); i++){
			res.push(popEval(scope));
		    }
		    while(!res.isEmpty()){
			pushNode(scope,new IRNode("PUSH","","",lookup(scope,res.pop())));
		    }
		    pushNode(scope,new IRNode("JSR","","",token.getValue()));
		    for(int i = 0; i < funcMap.get(token.getValue()).getParamNum(); i++){
			pushNode(scope,new IRNode("POP","","",""));
		    }
		    funcAssign = 1;
		    break;
		}
		break;
	    }
	    assert !dataType.equals("");
	    if(result.startsWith("$T")){
		st.updateTemp(scope,result,dataType);
	    }
	}
    }

    private void emptyOperatorStack(String scope){
	while(!operatorIsEmpty(scope)){
	    pushOperand(scope,popOperator(scope));
	}
    }

    public void writeResults(){
	System.out.println(";IR code");
	for(Map.Entry<String,Function> entry : funcMap.entrySet()){
	    String key = entry.getKey();
	    Function value = entry.getValue();
	    generateList(key);
	    value.writeIR();
	}

	writeHeader();
	for(String key : funcMap.keySet()){
	    funcMap.get(key).writeTiny();
	}
	System.out.println("end");
    }

    private void writeHeader(){
	System.out.println(";tiny code");
	for(String name : st.getNames("GLOBAL")){
	    String[] type_val = st.getType("GLOBAL",name);
	    if(type_val[0].equals("STRING")){
		System.out.println("str " + name + " " + type_val[1]); 
	    }else{
		System.out.println("var " + name); 
	    }
	}
	pushReg();
	System.out.println("jsr main");
	System.out.println("sys halt");
    }

    private void pushReg(){
	System.out.print("push \npush r0\npush r1\npush r2\npush r3\n");
    }

    private void printFST(){
	for(Map.Entry<String,Function> entry : funcMap.entrySet()){
	    String key = entry.getKey();
	    Function value = entry.getValue();
	    System.out.println(key);
	    value.printFST();
	    System.out.println();
	}
    }
}
