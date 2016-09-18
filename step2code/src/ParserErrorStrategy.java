import org.antlr.v4.runtime.*;

class ParserErrorStrategy extends DefaultErrorStrategy{
    ParserErrorStrategy(){
	super();
    }

    @Override
    public void reportError(Parser recognizer, RecognitionException e) throws RuntimeException{
	
	Token token = e.getOffendingToken();
	String description = String.format("line %d:%d: ",token.getLine(), token.getCharPositionInLine());
	String tokenText = token.getText();
	/*
	if(tokenText == null){
	    System.out.print(String.format("%s %s",description,"error: end of input"));
	}else{
	    System.out.print(String.format("%s %s",description,tokenText));
	}
	*/
	throw e;
	/*
	RuntimeException re = new RuntimeException();
	throw re;
	*/
    }

}
