import org.antlr.v4.runtime.*;

class ParserErrorStrategy extends DefaultErrorStrategy{
    ParserErrorStrategy(){
	super();
    }

    @Override
    public void reportError(Parser recognizer, RecognitionException e) throws RuntimeException{
	throw e;
	/*
	RuntimeException re = new RuntimeException();
	throw re;
	*/
    }

}
