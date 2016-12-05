import java.util.*; 
import org.antlr.v4.runtime.*;

public class Enum{

    public enum tokenType{
	VAR,
	CONST_I,
	CONST_F,
	BINARY_OP,
	UNARY_OP,
	IO,
	BRANCH,
	FUNC;
    }

    public enum instrType{
	INT("INT"),
	FLOAT("FLOAT"),
	STRING("STRING"),
	ERROR("ERROR");

	private String val;

	private instrType(String e){
	    this.val = e;
	}

	public String getValue(){
	    return val;
	}
    }
}
