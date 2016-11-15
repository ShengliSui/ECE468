import java.util.*; 
import org.antlr.v4.runtime.*;

public class Function{
    private final int PARAM_MAGIC_S = 6;
    private final int LOCAL_MAGIC_S = -1;

    private int paramNum;
    private int localNum;
    private FunctionST fst;
    private SYStack sy;
    private Counter paramCounter_S;
    private Counter localCounter_S;    
    private Counter paramCounter_A;
    private Counter localCounter_A;    

    public Function(){
	this.fst = new FunctionST();
	fst.add("$R",PARAM_MAGIC_S);
	this.sy = new SYStack();
	this.localNum = 0;
	this.localCounter_S = new Counter(LOCAL_MAGIC_S);
	this.paramCounter_S = new Counter(PARAM_MAGIC_S);
	this.paramCounter_A = new Counter(1);
	this.localCounter_A = new Counter(1);	
    }
    /*
    public void initializeST(SymbolTable fst){
	this.fst = fst;
    }
    
    public void initializeSY(SymbolTable sy){
	this.sy = sy;
    }
    */

    public void printFST(){
	fst.print();
    }

    public int getParamNum(){
	return paramNum;
    }

    public void addParam(ArrayList<String> params){
	paramNum = params.size();
	//return reg
	fst.add("$R",PARAM_MAGIC_S + paramNum);

	for(int i = 0; i < paramNum; i++){
	    int count = paramCounter_A.get_update();
	    fst.addParam(params.get(i),count);
	    addParamS(fst.get(params.get(i)));
	}
    }

    private void addParamS(String param){
	fst.add(param,paramCounter_S.get_update());
    }


    public void addLocal(ArrayList<String> locals){
	localNum += locals.size();

	for(int i = 0; i < locals.size(); i++){
	    int count = localCounter_A.get_update();
	    fst.addLocal(locals.get(i),count);
	    addLocalS(fst.get(locals.get(i)));
	}
    }

    public void addLocal(String local){
	int count = localCounter_A.get_update();
	fst.addLocal(local,count);
	localNum++;
	addLocalS(fst.get(local));
    }

    public void addLocalS(String param){
	fst.add(param,localCounter_S.get_update());
    }    

    public String lookup(String name){
	return fst.get(name);
    }

    public TokenClass peekOperator(){
	return sy.peekOperator();
    }

    public TokenClass peekOperand(){
	return sy.peekOperand();
    }

    public void pushOperator(TokenClass item){
	sy.pushOperator(item);
    }
    
    public TokenClass popOperator(){
	return sy.popOperator();
    }

    public void pushOperand(TokenClass item){
	sy.pushOperand(item);
    }
    
    public TokenClass pollOperand(){
	return sy.pollOperand();
    }    

    public void pushEval(String item){
	sy.pushEval(item);
    }
    
    public String popEval(){
	return sy.popEval();
    }

    public boolean evalIsEmpty(){
	return sy.evalIsEmpty();
    }

    public boolean operatorIsEmpty(){
	return sy.operatorIsEmpty();
    }

    public boolean operandIsEmpty(){
	return sy.operandIsEmpty();
    }

    public void pushNode(IRNode node){
	sy.pushNode(node);
    }

    public IRNode pollNode(){
	return sy.pollNode();
    }    

    public void writeIR(){
	sy.writeIR();
    }

    public void writeTiny(){
	sy.writeInit(fst,localNum);
	sy.writeTiny();
    }    
}
