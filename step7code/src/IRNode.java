import java.util.*; 
import org.antlr.v4.runtime.*;

public class IRNode{
    private String opcode;
    private String op1;
    private String op2;
    private String result;
    private IRNode target;

    Boolean visited;
    public Set<IRNode> predecessors = new LinkedHashSet<IRNode>();
    public Set<IRNode> successors = new LinkedHashSet<IRNode>(); 
    public Set<String> outSet = new LinkedHashSet<String>();
    public Set<String> inSet = new LinkedHashSet<String>();
    public Map<String,String> in;
    public Map<String,String> out;
    public Map<String,String> gen;
    public Map<String,String> kill;

    IRNode(){
	this.opcode = "";
	this.op1 = "";
	this.op2 = "";
	this.result = "";	

	inSet.clear();
	outSet.clear();
	this.visited = false;
    }

    IRNode(String opcode,String op1,String op2,String result){
	this.opcode = opcode;
	this.op1 = op1;
	this.op2 = op2;
	this.result = result;	

	inSet.clear();
	outSet.clear();
	this.visited = false;
    }

    public void printNode() {
	System.out.print(opcode+" "+op1+" "+op2+" "+result);
    }
    
    public void addSucc(IRNode succ) {
	successors.add(succ);
    }

    public void addPred(IRNode pred) {
	predecessors.add(pred);
    }
    
    public void clearPred() {
	predecessors.clear();
    }

    public void printInSet() {
	Iterator<String> iter = inSet.iterator();
	System.out.print(" in{");
	while(iter.hasNext()) {
	    String temp = iter.next();
	    System.out.print(temp+" ");
	}
	System.out.print("}");
    }

    public void printOutSet() {
	Iterator<String> iter = outSet.iterator();
	System.out.print(" out{");
	while(iter.hasNext()) {
	    String temp = iter.next();
	    System.out.print(temp+" ");
	}
	System.out.print("}");
    }

    public void printPredSucc() {
	Iterator<IRNode> iterP = predecessors.iterator();
	System.out.print("  {PRED:");
	while(iterP.hasNext()) {
	    IRNode node = iterP.next();
	    node.printNode();
	}
	System.out.print("} ");

	Iterator<IRNode> iterS = successors.iterator();
	System.out.print("{SUCC:");
	while(iterS.hasNext()) {
	    IRNode node = iterS.next();
	    node.printNode();
	}
	System.out.println("}");
    }

    public String getOpcode(){
	return opcode;
    }
    public String getOp1(){
	return op1;
    }
    public String getOp2(){
	return op2;
    }
    public String getResult(){
	return result;
    }

    public void setOpcode(String opcode){
	this.opcode = opcode;
    }
    public void setOp1(String op1){
	this.op1 = op1;
    }
    public void setOp2(String op2){
	this.op2 = op2;
    }
    public void setResult(String result){
	this.result = result;
    }    
}
