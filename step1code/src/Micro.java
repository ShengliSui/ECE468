import org.antlr.v4.runtime.*;

public class Micro{
    public static void main(String[] args) throws Exception{
	try{
	    //get our lexer
	    //lexer is of type 'TokenSource'
	    MicroLexer lexer = new MicroLexer(new ANTLRFileStream(args[0]));
	    //alternative:
	    //MicroLexer lexer = new MicroLexer(new ANTLRInputStream(/* a string */);

	    //get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);

	    for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()){
		switch(token.getType()){
		case 3: System.out.println("token type: IDEntifier"); break;
		}
		if(token.getType() != 7 && token.getType() != 9){
		    System.out.println("Value: " + token.getText());
		}
	    }

	} catch (RuntimeException e){
	    System.out.println("Error!");
	}
	
    }
}