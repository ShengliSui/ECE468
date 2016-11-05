import java.util.*; 
import org.antlr.v4.runtime.*;

public class ShuntingYardStructure{

    private Deque<TokenClass> operatorStack;
    private Deque<TokenClass> outputQueue;
    private Deque<String> evalStack;
    private Deque<IRNode> IRList;
    private int regVal;
    private int labelVal = 1;
    private int printFlag = 0;
    private int elsifFlag = 1;
    private Deque<Integer> dwhileLabel;
    private Deque<Integer> endLabel;
    private Deque<Integer> elifLabel;
    private SymbolTable st;
    
    ShuntingYardStructure(){
	operatorStack = new ArrayDeque<TokenClass>();
	outputQueue = new ArrayDeque<TokenClass>();
	evalStack = new ArrayDeque<String>();
	IRList = new ArrayDeque<IRNode>();
	elifLabel = new ArrayDeque<Integer>();
	dwhileLabel = new ArrayDeque<Integer>();
	endLabel = new ArrayDeque<Integer>();		
	regVal = 1;
    } 

    public void initializeST(SymbolTable symboltable){
	st = symboltable;
    }

    private void print(Deque<TokenClass> q){
	Iterator<TokenClass> i = q.iterator();
	while(i.hasNext()){
	    TokenClass tt = i.next();
	    print(tt);
	}
	System.out.println("");
    }

    private void printt(Deque<String> q){
	Iterator<String> i = q.iterator();
	while(i.hasNext()){
	    String tt = i.next();
	    print(tt);
	}
	System.out.println("");
    }

    private void printg(Deque<IRNode> q){
	Iterator<IRNode> i = q.iterator();
	while(i.hasNext()){
	    IRNode tt = i.next();
	    print(tt);
	}
	System.out.println("");
    }

    private void print(IRNode g){
	System.out.println("-"+g.getOpcode()+"-"+g.getOp1()+"-"+g.getOp2()+"-"+g.getResult());
    }

    private void print(String q){
	System.out.print(q+" ");
    }

    private void print(TokenClass item){
	System.out.print(item.getValue()+ " ");
    }

    private void print(String s,TokenClass item){
	System.out.print(s + " ");
	System.out.print(item.getValue()+ " ");
    }
    public TokenClass peekOperatorStack(){
	return operatorStack.peekFirst();
    }

    public void pushOperator(TokenClass item){
	operatorStack.push(item);
	if(printFlag==1){
	    print(operatorStack);
	    print(outputQueue);
	    printt(evalStack);
	    System.out.println("--------------");
	}
    }

    public TokenClass popOperator(){
	TokenClass t = operatorStack.pop();
	if(printFlag==1){
	    print(operatorStack);
	    print(outputQueue);
	    printt(evalStack);
	    System.out.println("--------------");
	}
	return t;
    }

    public void pushOperand(TokenClass item){
	outputQueue.push(item);
	if(printFlag==1){
	    print(operatorStack);
	    print(outputQueue);
	    printt(evalStack);
	    System.out.println("--------------");
	}
    }

    public TokenClass pollOperand(){
	TokenClass f = outputQueue.pollLast();
	if(printFlag==1){
	    print(operatorStack);
	    print(outputQueue);
	    printt(evalStack);
	    System.out.println("--------------");
	}
	return f;
    }    

    public void pushEval(String item){
	evalStack.push(item);
	if(printFlag==1){
	    print(operatorStack);
	    print(outputQueue);
	    printt(evalStack);
	    System.out.println("--------------");
	}
    }

    public String popEval(){
	String g = evalStack.pop();
	if(printFlag==1){
	    print(operatorStack);
	    print(outputQueue);
	    printt(evalStack);
	    System.out.println("--------------");
	}
	return g;
    }

    private void pushNode(IRNode node){
	IRList.add(node);
	if(printFlag==1){
	    printg(IRList);
	}
    }

    private IRNode pollNode(){
	IRNode n = IRList.pollLast();
	if(printFlag==1){
	    printg(IRList);
	}
	return n;
    }    

    private Enum.instrType findInstructionType(String curScope, String opLeft, String opRight, String result){
	String target="";
	String[] datatype;
	Enum.instrType returndata = Enum.instrType.ERROR;
	
	if(!opLeft.equals("")){
	    target = opLeft;
	}else if(!opRight.equals("")){
	    target = opRight;
	}else if(!result.equals("")){
	    target = result;
	}

	assert !target.equals("") : "instruction with no operands?";
	
	if(target.startsWith("$")){
	    datatype = st.getType(curScope,target);
	}else{
	    datatype = st.getType("GLOBAL",target);
	}

	if(datatype == null){ //can't find var in symbol table
	    if(target.startsWith("$")){//operand is reg
		System.out.println(target);
		st.printSymbolTable();
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
    
    private void generateList(){
	String opcode;
	String result;
	String opLeft;
	String opRight;
	String dataType;

	emptyOperatorStack();
	st.addScope("TEMP");
	
	while(!outputQueue.isEmpty()){
	    opcode = "";
	    result = "";
	    opLeft = "";
	    opRight = "";
	    dataType = "";
	    
	    TokenClass token = pollOperand();

	    switch(token.getType()){
	    case VAR:
	    case CONST_I:
	    case CONST_F:
		pushEval(token.getValue());
		break;
	    case BRANCH:
		String cond;
		switch(token.getValue()){
		case "IF":
		    cond = popEval();
		    if(cond.equals("TRUE")){
			endLabel.push(labelVal++);
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
			opRight = popEval();
			opLeft = popEval();
			int dummyI; float dummyF;
			String tempr,templ;
			try{
			    dummyI = Integer.parseInt(opRight);
			    tempr = "$T"+Integer.toString(regVal++);
			    pushNode(new IRNode("STOREI",opRight,"",tempr));
			    updateSymbolTable(tempr,"INT");
			    opcode += "I";
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opRight);
				tempr = "$T"+Integer.toString(regVal++);			    
				pushNode(new IRNode("STOREF",opRight,"",tempr));
				updateSymbolTable(tempr,"FLOAT");
				opcode += "F";
			    }catch(NumberFormatException nff){
				tempr = "$T"+Integer.toString(regVal++);			    
				if(findInstructionType(st.peekScope(),"",opRight,"")==Enum.instrType.INT){
				    pushNode(new IRNode("STOREI",opRight,"",tempr));
				    updateSymbolTable(tempr,"INT");				    
				    opcode += "I";
				}else if(findInstructionType(st.peekScope(),"",opRight,"")==Enum.instrType.FLOAT){
				    pushNode(new IRNode("STOREF",opRight,"",tempr));
				    updateSymbolTable(tempr,"FLOAT");
				    opcode += "F";
				}else{
				    System.out.println("findInstructionType went kuku");
				    System.exit(1);
				}
			    }
			}
			try{
			    dummyI = Integer.parseInt(opLeft);
			    templ = "$T"+Integer.toString(regVal++);
			    pushNode(new IRNode("STOREI",opLeft,"",templ));
			    updateSymbolTable(tempr,"INT");
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opLeft);
				templ = "$T"+Integer.toString(regVal++);
				pushNode(new IRNode("STOREF",opLeft,"",templ));
				updateSymbolTable(tempr,"FLOAT");
			    }catch(NumberFormatException nff){
				templ = opLeft;
			    }
			}
			endLabel.push(labelVal++);
			elifLabel.push(labelVal++);
			result = "label"+Integer.toString(elifLabel.peekFirst());
			pushNode(new IRNode(opcode,templ,tempr,result)); //to else if
		    }
		    break;

		case "ELSIF":
		    if(elsifFlag == 1)
			pushNode(new IRNode("JUMP","","","label"+Integer.toString(endLabel.peekFirst()))); //to endif
		    elsifFlag = 1;
		    pushNode(new IRNode("LABEL","","","label"+Integer.toString(elifLabel.peekFirst()))); //else if
		    cond = popEval();
		    if(cond.equals("TRUE")){
			//do nothing
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
			opRight = popEval();
			opLeft = popEval();
			int dummyI; float dummyF;
			String tempr,templ;
			try{
			    dummyI = Integer.parseInt(opRight);
			    tempr = "$T"+Integer.toString(regVal++);
			    pushNode(new IRNode("STOREI",opRight,"",tempr));
			    updateSymbolTable(tempr,"INT");
			    opcode += "I";
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opRight);
				tempr = "$T"+Integer.toString(regVal++);			    
				pushNode(new IRNode("STOREF",opRight,"",tempr));
				updateSymbolTable(tempr,"FLOAT");
				opcode += "F";
			    }catch(NumberFormatException nff){
				tempr = "$T"+Integer.toString(regVal++);			    						    if(findInstructionType(st.peekScope(),"",opRight,"")==Enum.instrType.INT){
				    pushNode(new IRNode("STOREI",opRight,"",tempr));
				    updateSymbolTable(tempr,"INT");				    
				    opcode += "I";
				}else if(findInstructionType(st.peekScope(),"",opRight,"")==Enum.instrType.FLOAT){
				    pushNode(new IRNode("STOREF",opRight,"",tempr));
				    updateSymbolTable(tempr,"FLOAT");				    
				    opcode += "F";
				}else{
				    System.out.println("findInstructionType went kuku");
				    System.exit(1);
				}
			    }
			}
			try{
			    dummyI = Integer.parseInt(opLeft);
			    templ = "$T"+Integer.toString(regVal++);
			    pushNode(new IRNode("STOREI",opLeft,"",templ));
			    updateSymbolTable(tempr,"INT");
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opLeft);
				templ = "$T"+Integer.toString(regVal++);
				pushNode(new IRNode("STOREF",opLeft,"",templ));
				updateSymbolTable(tempr,"FLOAT");
			    }catch(NumberFormatException nff){
				templ = opLeft;
			    }
			}
			elifLabel.pop();
			elifLabel.push(labelVal++);
			result = "label"+Integer.toString(elifLabel.peekFirst());
			pushNode(new IRNode(opcode,templ,tempr,result)); //to else if
		    }
		    break;

		case "ENDIF":
		    pushNode(new IRNode("LABEL","","","label"+Integer.toString(elifLabel.peekFirst())));
		    pushNode(new IRNode("LABEL","","","label"+Integer.toString(endLabel.peekFirst())));
		    endLabel.pop();
		    elifLabel.pop();
		    break;
		case "DO":
		    dwhileLabel.push(labelVal++);
		    opcode = "LABEL";
		    result = "label" + Integer.toString(dwhileLabel.peekFirst());
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;
		case "WHILE":
		    cond = popEval();
		    if(cond.equals("TRUE")){
			opcode = "JUMP";
			result = "label"+Integer.toString(dwhileLabel.peekFirst());
			pushNode(new IRNode(opcode,opLeft,opRight,result));
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
			opRight = popEval();
			opLeft = popEval();
			int dummyI; float dummyF;
			String tempr,templ;
			try{
			    dummyI = Integer.parseInt(opRight);
			    tempr = "$T"+Integer.toString(regVal++);
			    pushNode(new IRNode("STOREI",opRight,"",tempr));
			    updateSymbolTable(tempr,"INT");
			    opcode += "I";
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opRight);
				tempr = "$T"+Integer.toString(regVal++);			    
				pushNode(new IRNode("STOREF",opRight,"",tempr));
				updateSymbolTable(tempr,"FLOAT");
				opcode += "F";
			    }catch(NumberFormatException nff){
				tempr = "$T"+Integer.toString(regVal++);			    
				if(findInstructionType(st.peekScope(),"",opRight,"")==Enum.instrType.INT){
				    pushNode(new IRNode("STOREI",opRight,"",tempr));
				    updateSymbolTable(tempr,"INT");				    
				    opcode += "I";
				}else if(findInstructionType(st.peekScope(),"",opRight,"")==Enum.instrType.FLOAT){
				    pushNode(new IRNode("STOREF",opRight,"",tempr));
				    updateSymbolTable(tempr,"FLOAT");				    
				    opcode += "F";
				}else{
				    System.out.println("findInstructionType went kuku");
				    System.exit(1);
				}
			    }
			}
			try{
			    dummyI = Integer.parseInt(opLeft);
			    templ = "$T"+Integer.toString(regVal++);
			    pushNode(new IRNode("STOREI",opLeft,"",templ));
			    updateSymbolTable(tempr,"INT");
			}catch(NumberFormatException nfi){
			    try{
				dummyF = Float.parseFloat(opLeft);
				templ = "$T"+Integer.toString(regVal++);
				pushNode(new IRNode("STOREF",opLeft,"",templ));
				updateSymbolTable(tempr,"FLOAT");
			    }catch(NumberFormatException nff){
				templ = opLeft;
			    }
			}
			result = "label"+Integer.toString(labelVal++);
			pushNode(new IRNode(opcode,templ,tempr,result));
			opcode = "JUMP";result = "label"+Integer.toString(dwhileLabel.peekFirst());
			pushNode(new IRNode(opcode,"","",result));
			opcode = "LABEL";result = "label"+Integer.toString(labelVal-1);
			pushNode(new IRNode(opcode,"","",result));
		    }
		}
	    case UNARY_OP:
		switch(token.getValue()){
		case "TRUE":
		case "FALSE":
		    pushEval(token.getValue());
		    break;
		}
	    case BINARY_OP:
	  	switch(token.getValue()){
		case "=":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "!=":
		    pushEval(token.getValue());
		    break;
		case ":=":
		    result = "$T" + Integer.toString(regVal++);
		    opLeft = popEval();//20
		    opRight = popEval();//a
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "STOREI";
			dataType = "INT";
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "STOREF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushNode(new IRNode(opcode,opLeft,"",result));
		    pushNode(new IRNode(opcode,result,"",opRight));
		    break;

		case "*":
		    result = "$T" + Integer.toString(regVal++);
		    opLeft = popEval();//b
		    opRight = popEval();//a
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "MULTI";
			dataType = "INT";
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "MULTF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(result);
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    

		case "+":
		    result = "$T" + Integer.toString(regVal++);
		    opLeft = popEval();//T2
		    opRight = popEval();//c
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "ADDI";
			dataType = "INT";			
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "ADDF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(result);		    
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    

		case "-":
		    result = "$T" + Integer.toString(regVal++);
		    opRight = popEval();//a
		    opLeft = popEval();//b
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "SUBI";
			dataType = "INT";			
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "SUBF";
			dataType = "FLOAT";						
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(result);
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    

		case "/":
		    result = "$T" + Integer.toString(regVal++);
		    opRight = popEval();//c
		    opLeft = popEval();//T2
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "DIVI";
			dataType = "INT";									
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "DIVF";
			dataType = "FLOAT";
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }
		    pushEval(result);		    
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    
		}
	    case IO:
		switch(token.getValue()){
		case "WRITE":
		    result = popEval();//a
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "WRITEI";
			dataType = "INT";
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "WRITEF";
			dataType = "FLOAT";			
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }

		    pushNode(new IRNode(opcode,"","",result));
		    break;
		case "READ":
		    result = popEval();//a
		    if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.INT){
			opcode = "READI";
			dataType = "INT";
		    }else if(findInstructionType(st.peekScope(),opLeft,opRight,result)==Enum.instrType.FLOAT){
			opcode = "READF";
			dataType = "FLOAT";
		    }else{
			System.out.println("findInstructionType went kuku");
			System.exit(1);
		    }

		    pushNode(new IRNode(opcode,"","",result));
		    break;
		}
	    }
	    assert !dataType.equals("");
	    if(result.startsWith("$")){
		updateSymbolTable(result,dataType);
	    }
	}
	st.removeScope();
    }

    private void updateSymbolTable(String name, String type){
	if(st.containsName(name)){
	    st.updateField(name,type);
	}else{
	    st.addField(name,type);
	}
    }

    private void emptyOperatorStack(){
	while(!operatorStack.isEmpty()){
	    pushOperand(popOperator());
	}
    }

    public void writeResults(){
	generateList();

	writeA("IR code");
	for(IRNode node : IRList){
	    writeA(node);
	}
	writeA("tiny code");
	for(String item : st.getNames("GLOBAL")){
	    writeS("var "+item);
	}
	for(IRNode node : IRList){
	    writeS(node);
	}
	writeS("sys halt");
    }

    private void writeS(IRNode node){
	String opcode1;
	String opcode2;
	String op1;
	String op2;
	String result;

	if(node.getOp1().equals("")){
	    op1 = "";
	}else if(node.getOp1().startsWith("$")){
	    op1 = "r"+Integer.toString(Integer.parseInt(node.getOp1().substring(2))-1)+" ";
	}else{
	    op1 = node.getOp1()+" ";
	}
	if(node.getOp2().equals("")){
	    op2 = "";
	}else if(node.getOp2().startsWith("$")){
	    op2 = "r"+Integer.toString(Integer.parseInt(node.getOp2().substring(2))-1)+" ";
	}else{
	    op2 = node.getOp2()+" ";
	}	
	if(node.getResult().equals("")){
	    result = "";
	}else if(node.getResult().startsWith("$")){
	    result = "r"+Integer.toString(Integer.parseInt(node.getResult().substring(2))-1);
	}else{
	    result = node.getResult();
	}	
	switch(node.getOpcode()){
	case "ADDI":
	    opcode1 = "move ";
	    opcode2 = "addi ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op2+result);	    
	    break;
	case "ADDF":
	    opcode1 = "move ";
	    opcode2 = "addr ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op2+result);	    
	    break;
	case "SUBI":
	    opcode1 = "move ";
	    opcode2 = "subi ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op2+result);	    
	    break;
	case "SUBF":
	    opcode1 = "move ";
	    opcode2 = "subr ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op2+result);	    
	    break;
	case "MULTI":
	    opcode1 = "move ";
	    opcode2 = "muli ";
	    System.out.println(opcode1+op2+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "MULTF":
	    opcode1 = "move ";
	    opcode2 = "mulr ";
	    System.out.println(opcode1+op2+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "DIVI":
	    opcode1 = "move ";
	    opcode2 = "divi ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op2+result);	    
	    break;
	case "DIVF":
	    opcode1 = "move ";
	    opcode2 = "divr ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op2+result);	    
	    break;
	case "STOREI":
	    opcode1 = "move ";
	    System.out.println(opcode1+op1+result);
	    break;
	case "STOREF":
	    opcode1 = "move ";
	    System.out.println(opcode1+op1+result);
	    break;
	case "READI":
	    opcode1 = "sys readi ";
	    System.out.println(opcode1+result);	    		    
	    break;	 	    
	case "READF":
	    opcode1 = "sys readr ";
	    System.out.println(opcode1+result);
	    break;	 	    
	case "WRITEI":
	    opcode1 = "sys writei ";
	    System.out.println(opcode1+result);
	    break;	 	    
	case "WRITEF":
	    opcode1 = "sys writer ";
	    System.out.println(opcode1+result);
	    break;	 	    
	case "LTI":
	    opcode1 = "cmpi ";
	    opcode2 = "jlt ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "LEI":
	    opcode1 = "cmpi ";
	    opcode2 = "jle ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "GTI":
	    opcode1 = "cmpi ";
	    opcode2 = "jgt ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "GEI":
	    opcode1 = "cmpi ";
	    opcode2 = "jge ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "NEI":
	    opcode1 = "cmpi ";
	    opcode2 = "jne ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "EQI":
	    opcode1 = "cmpi ";
	    opcode2 = "jeq ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "LTF":
	    opcode1 = "cmpr ";
	    opcode2 = "jlt ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "LEF":
	    opcode1 = "cmpr ";
	    opcode2 = "jle ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "GTF":
	    opcode1 = "cmpr ";
	    opcode2 = "jgt ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "GEF":
	    opcode1 = "cmpr ";
	    opcode2 = "jge ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "NEF":
	    opcode1 = "cmpr ";
	    opcode2 = "jne ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "EQF":
	    opcode1 = "cmpr ";
	    opcode2 = "jeq ";	    
	    System.out.println(opcode1+op1+op2);
	    System.out.println(opcode2+result);	    
	    break;	 	    
	case "JUMP":
	    opcode1 = "jmp ";
	    System.out.println(opcode1+result);
	    break;	 	    
	case "LABEL":
	    opcode1 = "label ";
	    System.out.println(opcode1+result);	    
	    break;	 	    
	}
    }

    private void writeS(String var){
	System.out.println(var);
    }

    private void writeA(IRNode node){
	String s1 = (node.getOp1().equals("")) ? "" : " ";
	String s2 = (node.getOp2().equals("")) ? "" : " ";
	String op = node.getOpcode();
	switch(op){
	case "EQF":
	case "NEF":
	case "GTF":
	case "LTF":
	case "GEF":
	case "LEF":	    	    	    	    	    	    
	case "EQI":
	case "NEI":
	case "GTI":
	case "LTI":
	case "GEI":
	case "LEI":
	    op = op.substring(0,2);
	}
	System.out.println(";"+op+" "+node.getOp1()+s1+node.getOp2()+s2+node.getResult());
    }

    private void writeA(String var){
	System.out.println(";" + var);
    }
}
