import org.antlr.v4.runtime.*;

public class Micro{
    public static void main(String[] args) throws Exception{
	try{
	    //get our lexer(type: TokenSource)
	    //alternative: MicroLexer lexer = new MicroLexer(new ANTLRInputStream(/* a string */);
	    MicroLexer lexer = new MicroLexer(new ANTLRFileStream(args[0]));

	    //get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);

	    MicroParser parser = new MicroParser(tokens);

	    //set error handler
	    ANTLRErrorStrategy es = new ANTLRErrorStrategy();
	    parser.setErrorHandler(es);

	    

	    /*
	    //get Vocabulary using matched tokens, which is used to determine symbolic token type
	    Vocabulary vocabulary = lexer.getVocabulary(); 

	    for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()){
		//getSymbolicName method returns symbolic token type. Input to the method is integer token type
		System.out.println("Token Type: " + vocabulary.getSymbolicName(token.getType()));
		//print literal value
		System.out.println("Value: " + token.getText());
	    }
	    */

	} catch (RuntimeException e){
	    System.out.println("Error!");
	}
	
    }
}
