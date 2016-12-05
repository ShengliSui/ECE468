import java.util.*; 
import org.antlr.v4.runtime.*;

public class TokenClass{

    private Enum.tokenType tokentype = Enum.tokenType.VAR;
    private String value = "";


    TokenClass(Enum.tokenType type, String val){
	tokentype = type;	    
	value = val;
    }

    TokenClass(Enum.tokenType type, int val){
	tokentype = type;
	value = Integer.toString(val);
    }
	
    TokenClass(Enum.tokenType type, float val){
	tokentype = type;
	value = Float.toString(val);
    }

    public boolean isValue(String e){
	return (value.equals(e)) ? true : false;
    }

    public boolean isType(Enum.tokenType e){
	return (tokentype == e) ? true : false;
    }

    public Enum.tokenType getType(){
	return tokentype;
    }

    public String getValue(){
	return value;
    }    

}
