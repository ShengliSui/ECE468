import java.util.*; 
import org.antlr.v4.runtime.*;

public class Counter{
    private int val;
    private int init;
    
    public Counter(int init){
	this.init = init;
	this.val = init;
    }

    public int get_update(){
	return (val>=0 ? val++ : val--);
    }

    public int get(){
	return val;
    }

    public void reset(){
	val = init;
    }
}
