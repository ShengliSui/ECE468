// Generated from Micro.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, IDENTIFIER=2, INTLITERAL=3, FLOATLITERAL=4, STRINGLITERAL=5, 
		COMMENT=6, WHITESPACE=7, OPERATOR=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ANY_LETTER", "ANY_DIGIT", "COMMENT_BEGIN", "KEYWORD", "IDENTIFIER", "INTLITERAL", 
		"FLOATLITERAL", "STRINGLITERAL", "COMMENT", "WHITESPACE", "OPERATOR"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"COMMENT", "WHITESPACE", "OPERATOR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MicroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u00c2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5\u0082\n\5\3\6\3\6\3\6\6\6\u0087\n\6\r\6\16\6\u0088\5\6"+
		"\u008b\n\6\3\7\6\7\u008e\n\7\r\7\16\7\u008f\3\b\7\b\u0093\n\b\f\b\16\b"+
		"\u0096\13\b\3\b\3\b\6\b\u009a\n\b\r\b\16\b\u009b\3\t\3\t\7\t\u00a0\n\t"+
		"\f\t\16\t\u00a3\13\t\3\t\3\t\3\n\3\n\7\n\u00a9\n\n\f\n\16\n\u00ac\13\n"+
		"\3\n\3\n\3\13\6\13\u00b1\n\13\r\13\16\13\u00b2\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c1\n\f\2\2\r\3\2\5\2\7\2\t\3\13\4\r"+
		"\5\17\6\21\7\23\b\25\t\27\n\3\2\t\4\2C\\c|\3\2\62;\3\2$$\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\6\2,-//\61\61??\6\2*+..=>@@\u00df\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\u0081\3\2\2\2"+
		"\13\u0083\3\2\2\2\r\u008d\3\2\2\2\17\u0094\3\2\2\2\21\u009d\3\2\2\2\23"+
		"\u00a6\3\2\2\2\25\u00b0\3\2\2\2\27\u00c0\3\2\2\2\31\32\t\2\2\2\32\4\3"+
		"\2\2\2\33\34\t\3\2\2\34\6\3\2\2\2\35\36\7/\2\2\36\37\7/\2\2\37\b\3\2\2"+
		"\2 !\7R\2\2!\"\7T\2\2\"#\7Q\2\2#$\7I\2\2$%\7T\2\2%&\7C\2\2&\u0082\7O\2"+
		"\2\'(\7D\2\2()\7G\2\2)*\7I\2\2*+\7K\2\2+\u0082\7P\2\2,-\7G\2\2-.\7P\2"+
		"\2.\u0082\7F\2\2/\60\7H\2\2\60\61\7W\2\2\61\62\7P\2\2\62\63\7E\2\2\63"+
		"\64\7V\2\2\64\65\7K\2\2\65\66\7Q\2\2\66\u0082\7P\2\2\678\7T\2\289\7G\2"+
		"\29:\7C\2\2:\u0082\7F\2\2;<\7Y\2\2<=\7T\2\2=>\7K\2\2>?\7V\2\2?\u0082\7"+
		"G\2\2@A\7K\2\2A\u0082\7H\2\2BC\7G\2\2CD\7N\2\2DE\7U\2\2EF\7K\2\2F\u0082"+
		"\7H\2\2GH\7G\2\2HI\7P\2\2IJ\7F\2\2JK\7K\2\2K\u0082\7H\2\2LM\7F\2\2M\u0082"+
		"\7Q\2\2NO\7Y\2\2OP\7J\2\2PQ\7K\2\2QR\7N\2\2R\u0082\7G\2\2ST\7E\2\2TU\7"+
		"Q\2\2UV\7P\2\2VW\7V\2\2WX\7K\2\2XY\7P\2\2YZ\7W\2\2Z\u0082\7G\2\2[\\\7"+
		"D\2\2\\]\7T\2\2]^\7G\2\2^_\7C\2\2_\u0082\7M\2\2`a\7T\2\2ab\7G\2\2bc\7"+
		"V\2\2cd\7W\2\2de\7T\2\2e\u0082\7P\2\2fg\7K\2\2gh\7P\2\2h\u0082\7V\2\2"+
		"ij\7X\2\2jk\7Q\2\2kl\7K\2\2l\u0082\7F\2\2mn\7U\2\2no\7V\2\2op\7T\2\2p"+
		"q\7K\2\2qr\7P\2\2r\u0082\7I\2\2st\7H\2\2tu\7N\2\2uv\7Q\2\2vw\7C\2\2w\u0082"+
		"\7V\2\2xy\7V\2\2yz\7T\2\2z{\7W\2\2{\u0082\7G\2\2|}\7H\2\2}~\7C\2\2~\177"+
		"\7N\2\2\177\u0080\7U\2\2\u0080\u0082\7G\2\2\u0081 \3\2\2\2\u0081\'\3\2"+
		"\2\2\u0081,\3\2\2\2\u0081/\3\2\2\2\u0081\67\3\2\2\2\u0081;\3\2\2\2\u0081"+
		"@\3\2\2\2\u0081B\3\2\2\2\u0081G\3\2\2\2\u0081L\3\2\2\2\u0081N\3\2\2\2"+
		"\u0081S\3\2\2\2\u0081[\3\2\2\2\u0081`\3\2\2\2\u0081f\3\2\2\2\u0081i\3"+
		"\2\2\2\u0081m\3\2\2\2\u0081s\3\2\2\2\u0081x\3\2\2\2\u0081|\3\2\2\2\u0082"+
		"\n\3\2\2\2\u0083\u008a\5\3\2\2\u0084\u0087\5\3\2\2\u0085\u0087\5\5\3\2"+
		"\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0086\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\f\3\2\2\2\u008c\u008e\5\5\3\2\u008d\u008c\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\16"+
		"\3\2\2\2\u0091\u0093\5\5\3\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0099\7\60\2\2\u0098\u009a\5\5\3\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\20\3\2\2"+
		"\2\u009d\u00a1\7$\2\2\u009e\u00a0\n\4\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u00a5\7$\2\2\u00a5\22\3\2\2\2\u00a6\u00aa\5\7\4\2"+
		"\u00a7\u00a9\n\5\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad"+
		"\u00ae\b\n\2\2\u00ae\24\3\2\2\2\u00af\u00b1\t\6\2\2\u00b0\u00af\3\2\2"+
		"\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b5\b\13\2\2\u00b5\26\3\2\2\2\u00b6\u00b7\7<\2\2\u00b7"+
		"\u00c1\7?\2\2\u00b8\u00c1\t\7\2\2\u00b9\u00ba\7#\2\2\u00ba\u00c1\7?\2"+
		"\2\u00bb\u00c1\t\b\2\2\u00bc\u00bd\7>\2\2\u00bd\u00c1\7?\2\2\u00be\u00bf"+
		"\7@\2\2\u00bf\u00c1\7?\2\2\u00c0\u00b6\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0"+
		"\u00b9\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c1\30\3\2\2\2\16\2\u0081\u0086\u0088\u008a\u008f\u0094\u009b\u00a1"+
		"\u00aa\u00b2\u00c0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}