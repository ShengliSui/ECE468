import java.util.*;
import org.antlr.v4.runtime.*;

public class Micro{

    public static void main(String[] args) throws Exception{
	    //get our lexer(type: TokenSource)
	    //alternative: MicroLexer lexer = new MicroLexer(new ANTLRInputStream(/* a string */);
	//	try{
	    MicroLexer lexer = new MicroLexer(new ANTLRFileStream(args[0]));
	    
	    //get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);

	    MicroParser parser = new MicroParser(tokens);

	    //set error handler
	    ANTLRErrorStrategy es = new ParserErrorStrategy();
	    parser.setErrorHandler(es);

	    ParserRuleContext pp = parser.program();

	    //parser.st.printSymbolTable();
	    parser.sy.initializeST(parser.st);
	    parser.sy.writeResults();
	    /*
	}catch (RuntimeException e){
	    System.out.println("Not Accepted");
	    }*/
    }
}

