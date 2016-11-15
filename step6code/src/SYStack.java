import java.util.*; 
import org.antlr.v4.runtime.*;

public class SYStack{

    private Deque<TokenClass> operatorStack;
    private Deque<TokenClass> outputQueue;
    private Deque<String> evalStack;
    private Deque<IRNode> IRList;

    private Deque<Integer> dwhileLabel;
    private Deque<Integer> endLabel;
    private Deque<Integer> elifLabel;
    private FunctionST fst;
    private int localNum;

    private int printFlag;
    
    SYStack(){
	this.operatorStack = new ArrayDeque<TokenClass>();
	this.outputQueue = new ArrayDeque<TokenClass>();
	this.evalStack = new ArrayDeque<String>();
	this.IRList = new ArrayDeque<IRNode>();

	this.elifLabel = new ArrayDeque<Integer>();
	this.dwhileLabel = new ArrayDeque<Integer>();
	this.endLabel = new ArrayDeque<Integer>();		
	this.printFlag = 0;
    }

    public void writeInit(FunctionST fst, int localNum){
	this.localNum = localNum;
	this.fst = fst;
    }

    public TokenClass peekOperator(){
	return operatorStack.peekFirst();
    }

    public TokenClass peekOperand(){
	return outputQueue.peekFirst();
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

    public boolean evalIsEmpty(){
	return evalStack.isEmpty();
    }

    public boolean operatorIsEmpty(){
	return operatorStack.isEmpty();
    }        

    public boolean operandIsEmpty(){
	return outputQueue.isEmpty();
    }
    
    public void pushNode(IRNode node){
	IRList.add(node);
	if(printFlag==1){
	    printg(IRList);
	}
    }

    public IRNode pollNode(){
	IRNode n = IRList.pollLast();
	if(printFlag==1){
	    printg(IRList);
	}
	return n;
    }    

    public void writeIR(){
	for(IRNode node : IRList){
	    writeA(node);
	}
    }
	
    public void writeTiny(){
	for(IRNode node : IRList){
	    writeS(node);
	}
    }

    private String getOp(String op){
	if(op.equals("")){
	    return "";
	}else if(op.startsWith("$T")){
	    return "r"+Integer.toString(Integer.parseInt(op.substring(2))-1)+" ";
	}else if(op.startsWith("$L")||op.startsWith("$P")||op.startsWith("$R")){
	    return fst.get(op)+" ";
	}else{
	    return op+" ";
	}
    }

    private void writeS(IRNode node){
	String opcode1;
	String opcode2;
	String op1;
	String op2;
	String result;

	op1 = getOp(node.getOp1());
	op2 = getOp(node.getOp2());
	result = getOp(node.getResult());

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
	case "WRITES":
	    opcode1 = "sys writes ";
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
	    try{
		int dummyI = Integer.parseInt(result.substring(5));
	    }catch(Exception a){
		try{
		    float dummyF = Float.parseFloat(result.substring(5));
		}catch(Exception b){
		    opcode2 = "link " + String.valueOf(localNum);
		    System.out.println(opcode2);		    
		}
	    }
	    break;
	case "RET":
	    opcode1 = "unlnk";
	    opcode2 = "ret";
	    System.out.println(opcode1);
	    System.out.println(opcode2);
	    break;
	case "PUSH":
	    opcode1 = "push ";
	    System.out.println(opcode1+result);
	    break;
	case "POP":
	    opcode1 = "pop ";
	    System.out.println(opcode1+result);
	    break;	    
	case "JSR":
	    opcode1 = "jsr ";
	    pushReg();
	    System.out.println(opcode1+result);
	    popReg();
	    break;
	}
    }

    private void pushReg(){
	System.out.print("push r0\npush r1\npush r2\npush r3\n");
    }

    private void popReg(){
	System.out.print("pop r3\npop r2\npop r1\npop r0\n");
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
}
