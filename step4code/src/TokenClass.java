import java.util.*; 
import org.antlr.v4.runtime.*;

public class TokenClass{

    private TokenEnum tokentype = TokenEnum.VAR;
    private String stringValue = "";
    private int intValue = 0;
    private float floatValue = 0.0f;    

    TokenClass(TokenEnum type, String val){
	switch(type){
	case VAR:
	    tokentype = TokenEnum.VAR;
	    stringValue = val;
	    break;
	case BINARY_OP:
	    tokentype = TokenEnum.BINARY_OP;	    
	    stringValue = val;
	    break;
	case UNARY_OP:
	    tokentype = TokenEnum.UNARY_OP;	    
	    stringValue = val;
	    break;
	case IO:
	    tokentype = TokenEnum.IO;	    
	    stringValue = val;
	    break;
	}
    }

    TokenClass(int val){
	tokentype = TokenEnum.CONST_I;
	intValue = val;
    }
	
    TokenClass(float val){
	tokentype = TokenEnum.CONST_F;
	floatValue = val;
    }

    public TokenEnum getType(){
	return tokentype;
    }

    public String getString(){
	return stringValue;
    }    

    public int getInt(){
	return intValue;
    }

    public float getFloat(){
	return floatValue;
    }        
}
