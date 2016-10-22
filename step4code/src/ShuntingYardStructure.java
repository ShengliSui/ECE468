import java.util.*; 
import org.antlr.v4.runtime.*;

public class ShuntingYardStructure{

    private Deque<TokenClass> operatorStack;
    private Deque<TokenClass> outputQueue;
    private Deque<String> evalStack;
    private Deque<IRNode> IRList;
    private int regVal;
    private int tempVal;

    ShuntingYardStructure(){
	operatorStack = new ArrayDeque<TokenClass>();
	outputQueue = new ArrayDeque<TokenClass>();
	evalStack = new ArrayDeque<String>();
	IRList = new ArrayDeque<IRNode>();
	regVal = 0;
	tempVal = 1;
    } 

    public TokenClass peekOperatorStack(){
	return operatorStack.peek();
    }

    public void pushOperator(TokenClass item){
	operatorStack.push(item);
    }

    public TokenClass popOperator(){
	return operatorStack.pop();
    }

    public void pushOperand(TokenClass item){
	outputQueue.push(item);
    }

    public TokenClass pollOperand(){
	return outputQueue.poll();
    }    

    public void pushEval(String item){
	evalStack.push(item);
    }

    public String popEval(){
	return evalStack.pop();
    }

    private void pushNode(IRNode node){
	IRList.push(node);
    }

    private IRNode pollNode(){
	return IRList.poll();
    }    

    private void generateList(SymbolTable st){
	String opcode;
	String result;
	String opLeft;
	String opRight;
	String[] dataType;

	while(!outputQueue.isEmpty()){
	    TokenClass temp = pollOperand();
	    switch(temp.getType()){
	    case VAR:
		pushEval(temp.getString());
		break;
	    case CONST_I:
		pushEval(Integer.toString(temp.getInt()));
		break;
	    case CONST_F:
		pushEval(Float.toString(temp.getFloat())); //push to evaluation stack
		break;
	    case BINARY_OP:
		switch(temp.getString()){
		case ":=":
		    result = "$T" + Integer.toString(tempVal++);
		    opLeft = popEval();//20
		    opRight = popEval();//a
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "STOREI";
		    }else{
			opcode = "STOREF";
		    }
		    pushNode(new IRNode(opcode,opLeft,"",result));
		    pushNode(new IRNode(opcode,result,"",opRight));
		    break;
		case "*":
		    result = "$T" + Integer.toString(tempVal++);
		    opLeft = popEval();//b
		    opRight = popEval();//a
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "MULTI";
		    }else{
			opcode = "MULTF";
		    }
		    pushEval(result);
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    

		case "+":
		    result = "$T" + Integer.toString(tempVal++);
		    opLeft = popEval();//T2
		    opRight = popEval();//c
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "ADDI";
		    }else{
			opcode = "ADDF";
		    }
		    pushEval(result);		    
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    

		case "-":
		    result = "$T" + Integer.toString(tempVal++);
		    opRight = popEval();//a
		    opLeft = popEval();//b
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "SUBI";
		    }else{
			opcode = "SUBF";
		    }
		    pushEval(result);
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    

		case "/":
		    result = "$T" + Integer.toString(tempVal++);
		    opRight = popEval();//c
		    opLeft = popEval();//T2
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "DIVI";
		    }else{
			opcode = "DIVF";
		    }
		    pushEval(result);		    
		    pushNode(new IRNode(opcode,opLeft,opRight,result));
		    break;		    
		}
	    case IO:
		switch(temp.getString()){
		case "WRITE":
		    opRight = popEval();//a
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "WRITEI";
		    }else{
			opcode = "WRITEF";
		    }
		    pushNode(new IRNode(opcode,"","",opRight));
		    break;
		case "READ":
		    opRight = popEval();//a
		    dataType = st.getType("GLOBAL",opRight);
		    if(dataType[0] == "INT"){
			opcode = "READI";
		    }else{
			opcode = "READF";
		    }
		    pushNode(new IRNode(opcode,"","",opRight));
		    break;
		}
	    }	
	}
    }

    public void writeResults(SymbolTable st){
	generateList(st);
	writeA("IR code");
	for(IRNode node : IRList){
	    writeA(node);
	}
	writeA("tiny code");
	for(String item : st.getNames("GLOBAL")){
	    writeS(item);
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
	if(node.getOp1() == ""){
	    op1 = "";
	}else if(node.getOp1().startsWith("$")){
	    op1 = "r"+Integer.toString(regVal++)+" ";
	}else{
	    op1 = node.getOp1()+" ";
	}
	if(node.getOp2() == ""){
	    op2 = "";
	}else if(node.getOp2().startsWith("$")){
	    op2 = "r"+Integer.toString(regVal++)+" ";
	}else{
	    op2 = node.getOp2()+" ";
	}	
	if(node.getResult() == ""){
	    result = "";
	}else if(node.getResult().startsWith("$")){
	    result = "r"+Integer.toString(regVal++);
	}else{
	    result = node.getResult();
	}	
	switch(node.getOpcode()){
	case "ADDI":
	    opcode1 = "move ";
	    opcode2 = "addi ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "ADDF":
	    opcode1 = "move ";
	    opcode2 = "addr ";
	    System.out.println(opcode1+op1+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "SUBI":
	    opcode1 = "move ";
	    opcode2 = "subi ";
	    System.out.println(opcode1+op2+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "SUBF":
	    opcode1 = "move ";
	    opcode2 = "subr ";
	    System.out.println(opcode1+op2+result);
	    System.out.println(opcode2+op1+result);	    
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
	    System.out.println(opcode1+op2+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "DIVF":
	    opcode1 = "move ";
	    opcode2 = "divr ";
	    System.out.println(opcode1+op2+result);
	    System.out.println(opcode2+op1+result);	    
	    break;
	case "STOREI":
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
	}
    }

    private void writeS(String var){
	System.out.println("var "+var);
    }

    private void writeA(IRNode node){
	String s1 = (node.getOp1() == "") ? "" : " ";
	String s2 = (node.getOp2() == "") ? "" : " ";	
	System.out.println(";"+node.getOpcode()+" "+node.getOp1()+s1+node.getOp2()+s2+node.getResult());
    }

    private void writeA(String var){
	System.out.println(";" + var);
    }
}
