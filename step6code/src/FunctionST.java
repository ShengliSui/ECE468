import java.util.*; 
import org.antlr.v4.runtime.*;

public class FunctionST{

    private Map<String,String> offsetTable;

    public FunctionST(){
	offsetTable = new LinkedHashMap<String,String>();
    }

    public void add(String name, int offset){
	offsetTable.put(name,"$"+String.valueOf(offset));
    }

    public void addParam(String name, int offset){
	offsetTable.put(name,"$P"+String.valueOf(offset));
    }

    public void addLocal(String name, int offset){
	offsetTable.put(name,"$L"+String.valueOf(offset));
    }

    public String get(String name){
	if(!offsetTable.containsKey(name)){
	    //System.out.println(name+" is not in fst!");
	    /*
	    print();
	    System.exit(1);*/
	    return name;
	}
	return offsetTable.get(name);
    }
    
    public void print(){
	for(Map.Entry<String,String> entry : offsetTable.entrySet()){
	    System.out.println(entry.getKey() + ":" + entry.getValue());
	}
    }
}
