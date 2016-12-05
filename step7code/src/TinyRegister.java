import java.util.*;
import org.antlr.v4.runtime.*;

public class TinyRegister {
    String regVal;
    String tempRegVal; 
    Boolean dirty;

    public TinyRegister(String regVal) {
	this.regVal = regVal;
	this.tempRegVal = "";
	this.dirty = false;
    }

    public void printVal(){
	System.out.println("regVal:"+this.regVal+" tempregVal:"+this.tempRegVal+" dirty:"+this.dirty);
    }
}