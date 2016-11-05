import java.util.*; 
import org.antlr.v4.runtime.*;

public class IRNode{
    private String opcode;
    private String op1;
    private String op2;
    private String result;

    IRNode(){
	this.opcode = "";
	this.op1 = "";
	this.op2 = "";
	this.result = "";	
    }

    IRNode(String opcode,String op1,String op2,String result){
	this.opcode = opcode;
	this.op1 = op1;
	this.op2 = op2;
	this.result = result;	
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
