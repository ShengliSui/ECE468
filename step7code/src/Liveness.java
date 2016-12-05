import java.util.*;
import org.antlr.v4.runtime.*;

public class Liveness{

    private static Boolean printFlag = false;

    public static void findLiveness(){
	generateCFG();
	analyzeCFG();
    }

    private static void analyzeCFG(){
	IRNode curr = null;
	String opcode,op1,op2,res;
	LinkedList<IRNode> workList = new LinkedList<IRNode>();
	for(Map.Entry<String,Function> entry:ShuntingYardStructure.funcMap.entrySet()){
	    workList.clear();	    
	    Function value = entry.getValue();
	    ArrayDeque<IRNode> IRList = value.getIRList();

	    while(!IRList.isEmpty()){
		workList.add(IRList.pop());
	    }

	    Iterator<IRNode> it = workList.iterator();
	    IRNode tempNode = null;
	    while(it.hasNext()){
		Boolean modified = false;
		tempNode = workList.remove();

		op1 = tempNode.getOp1();
		op2 = tempNode.getOp2();
		opcode = tempNode.getOpcode();
		res = tempNode.getResult();					

		if(opcode.equals("RET")){
		    tempNode.inSet.addAll(ShuntingYardStructure.getKeySet("GLOBAL"));
		}

		Iterator<IRNode> succ = tempNode.successors.iterator();
		while(succ.hasNext()){
		    tempNode.inSet.addAll(succ.next().outSet);
		}

		//		HashSet<IRNode> tempSet = tempNode.cloneOutSet();
		
		//out = in + gen - kill
		if (tempNode.outSet.addAll(tempNode.inSet)) { 
		    if(printFlag){
			System.out.print("inset modified! ");
		    }
		    modified = true;
		}

		//gen
		if (tempNode.outSet.addAll(generate(opcode, op1, op2, res))) { 
		    if(printFlag){
			System.out.print("gen modified! ");
		    }
		    modified = true;
		}

		//kill
		if (tempNode.outSet.removeAll(kill(opcode,op1,op2,res))) { 
		    if(printFlag){
			System.out.print("kill modified! ");
		    }
		    modified = true;
		}

		if (modified) {
		    workListAdd(workList,tempNode); 
		}
		if(printFlag){
		    System.out.print(";");
		    tempNode.printNode();
		}
	    }
	    if(printFlag){
		System.out.println();
	    }
	}
    }

    private static void workListAdd(LinkedList<IRNode> workList, IRNode node) {
	Iterator<IRNode> it = node.predecessors.iterator();
	while(it.hasNext()) {
	    IRNode pred = it.next();
	    if(printFlag){
		System.out.print(" >");
		pred.printNode();
	    }
	    if (!workList.contains(pred)) {
		workList.add(pred);
		if(printFlag){
		    System.out.println("added back to list");
		}
	    }
	    else {
		if(printFlag){
		    System.out.println("already on list");
		}
	    }
	}
    }

    private static Set<String> generate(String opcode, String op1, String op2, String res){
	Set<String> set = new LinkedHashSet<String>();
	if (opcode.startsWith("ADD") ||
	    opcode.startsWith("SUB") ||
	    opcode.startsWith("MULT") ||
	    opcode.startsWith("STORE") ||
	    opcode.startsWith("DIV") ||
	    opcode.startsWith("GE") ||
	    opcode.startsWith("LE") ||
	    opcode.startsWith("GT") ||
	    opcode.startsWith("LT") ||
	    opcode.startsWith("EQ") ||
	    opcode.startsWith("NE")){
	    if (!op1.isEmpty() && isVarOrTemp(op1)) {
		set.add(op1);
	    }
	    if (!op2.isEmpty() && isVarOrTemp(op2)) {
		set.add(op2);
	    }
	}
	if(opcode.startsWith("WRITE") ||
	   opcode.startsWith("PUSH")) {
	    if (!res.isEmpty() && isVarOrTemp(res)) {
		set.add(res);
	    }
	}
	if(opcode.equals("JSR")){
	    set.addAll(ShuntingYardStructure.getKeySet("GLOBAL"));
	}
	return set;
    }

    private static Set<String> kill(String opcode, String op1, String op2, String res) {
	Set<String> set = new LinkedHashSet<String>();
	if (opcode.startsWith("ADD") ||
	    opcode.startsWith("SUB") ||
	    opcode.startsWith("MULT") ||
	    opcode.startsWith("DIV") ||
	    opcode.startsWith("READ") ||
	    opcode.startsWith("STORE") ||
	    opcode.startsWith("POP")) {
	    if (!res.isEmpty() && isVarOrTemp(res)) {
		set.add(res);
	    }
	}
	return set;
    }

    private static Boolean isVarOrTemp(String op){
	if(op.startsWith("$"))
	    return true;
	if(op.matches("[0-9]+.?([0-9])*"))
	    return false;
	else
	    return true;
    }

    private static void generateCFG(){
	IRNode prev = null;
	IRNode curr = null;
	IRNode next = null;	

	for(Map.Entry<String,Function> entry:ShuntingYardStructure.funcMap.entrySet()){
	    String key = entry.getKey();
	    Function value = entry.getValue();
	    Deque<IRNode> IRList = value.getIRList();

	    for(IRNode node : IRList){
		curr = node;
		if(prev!=null && !(prev.getOpcode().equals("JUMP") || prev.getOpcode().equals("RET"))){
		    if(curr!=null) prev.addSucc(curr);
		    curr.addPred(prev);
		}

		String temp = curr.getOpcode().substring(0,2);
                if(temp.equals("GE") || temp.equals("LE") ||
		   temp.equals("GT") || temp.equals("LT") ||
		   temp.equals("EQ") || temp.equals("NE") || curr.getOpcode().equals("JUMP")){
		    next = getLabelNode(curr.getResult()); //curr.res = label
		    if (next == null) {
			System.out.println("Could not find "+curr.getResult());
			System.exit(1);
		    }
		    curr.addSucc(next);
		    next.addPred(curr);
		}

		else if (curr.getOpcode().equals("JSR")) {
		    next = getLabelNode(curr.getResult());
		    if (next == null) {
			System.out.println("Could not find "+curr.getResult());
		    }
		    next.clearPred();
		}
		prev = curr;
	    }
	}
    }

    private static IRNode getLabelNode(String label) {
	IRNode node = ShuntingYardStructure.labelNodes.get(label);
	return node;
    }
}

