// Generated from Micro.g4 by ANTLR 4.5.3

import java.util.*;

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
		KEYWORD=1, INTLITERAL=2, FLOATLITERAL=3, STRINGLITERAL=4, IDENTIFIER=5, 
		COMMENT=6, WHITESPACE=7, ADD=8, SUB=9, MULT=10, DIV=11, LP=12, RP=13, 
		SCOLON=14, COMMA=15, ASSIGN=16, COMPOP=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"ANY_LETTER", "ANY_DIGIT", "COMMENT_BEGIN", "KEYWORD", "INTLITERAL", "FLOATLITERAL", 
		"STRINGLITERAL", "IDENTIFIER", "COMMENT", "WHITESPACE", "ADD", "SUB", 
		"MULT", "DIV", "LP", "RP", "SCOLON", "COMMA", "ASSIGN", "COMPOP"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", 
		"'('", "')'", "';'", "','", "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "IDENTIFIER", 
		"COMMENT", "WHITESPACE", "ADD", "SUB", "MULT", "DIV", "LP", "RP", "SCOLON", 
		"COMMA", "ASSIGN", "COMPOP"
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


		int blockCount = 0;
		String cat;
		public SymbolTable st = new SymbolTable();


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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u00e4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0094\n\5\3\6\6\6\u0097\n\6\r\6\16"+
		"\6\u0098\3\7\7\7\u009c\n\7\f\7\16\7\u009f\13\7\3\7\3\7\6\7\u00a3\n\7\r"+
		"\7\16\7\u00a4\3\b\3\b\7\b\u00a9\n\b\f\b\16\b\u00ac\13\b\3\b\3\b\3\t\3"+
		"\t\3\t\6\t\u00b3\n\t\r\t\16\t\u00b4\5\t\u00b7\n\t\3\n\3\n\7\n\u00bb\n"+
		"\n\f\n\16\n\u00be\13\n\3\n\3\n\3\13\6\13\u00c3\n\13\r\13\16\13\u00c4\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00e3\n\25\2\2\26\3\2\5\2\7\2\t\3\13\4\r\5\17\6\21\7\23\b\25\t\27\n\31"+
		"\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23\3\2\7\4\2C\\c|\3\2\62;\3\2$$"+
		"\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00ff\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7/\3\2"+
		"\2\2\t\u0093\3\2\2\2\13\u0096\3\2\2\2\r\u009d\3\2\2\2\17\u00a6\3\2\2\2"+
		"\21\u00af\3\2\2\2\23\u00b8\3\2\2\2\25\u00c2\3\2\2\2\27\u00c8\3\2\2\2\31"+
		"\u00ca\3\2\2\2\33\u00cc\3\2\2\2\35\u00ce\3\2\2\2\37\u00d0\3\2\2\2!\u00d2"+
		"\3\2\2\2#\u00d4\3\2\2\2%\u00d6\3\2\2\2\'\u00d8\3\2\2\2)\u00e2\3\2\2\2"+
		"+,\t\2\2\2,\4\3\2\2\2-.\t\3\2\2.\6\3\2\2\2/\60\7/\2\2\60\61\7/\2\2\61"+
		"\b\3\2\2\2\62\63\7R\2\2\63\64\7T\2\2\64\65\7Q\2\2\65\66\7I\2\2\66\67\7"+
		"T\2\2\678\7C\2\28\u0094\7O\2\29:\7D\2\2:;\7G\2\2;<\7I\2\2<=\7K\2\2=\u0094"+
		"\7P\2\2>?\7G\2\2?@\7P\2\2@\u0094\7F\2\2AB\7H\2\2BC\7W\2\2CD\7P\2\2DE\7"+
		"E\2\2EF\7V\2\2FG\7K\2\2GH\7Q\2\2H\u0094\7P\2\2IJ\7T\2\2JK\7G\2\2KL\7C"+
		"\2\2L\u0094\7F\2\2MN\7Y\2\2NO\7T\2\2OP\7K\2\2PQ\7V\2\2Q\u0094\7G\2\2R"+
		"S\7K\2\2S\u0094\7H\2\2TU\7G\2\2UV\7N\2\2VW\7U\2\2WX\7K\2\2X\u0094\7H\2"+
		"\2YZ\7G\2\2Z[\7P\2\2[\\\7F\2\2\\]\7K\2\2]\u0094\7H\2\2^_\7F\2\2_\u0094"+
		"\7Q\2\2`a\7Y\2\2ab\7J\2\2bc\7K\2\2cd\7N\2\2d\u0094\7G\2\2ef\7E\2\2fg\7"+
		"Q\2\2gh\7P\2\2hi\7V\2\2ij\7K\2\2jk\7P\2\2kl\7W\2\2l\u0094\7G\2\2mn\7D"+
		"\2\2no\7T\2\2op\7G\2\2pq\7C\2\2q\u0094\7M\2\2rs\7T\2\2st\7G\2\2tu\7V\2"+
		"\2uv\7W\2\2vw\7T\2\2w\u0094\7P\2\2xy\7K\2\2yz\7P\2\2z\u0094\7V\2\2{|\7"+
		"X\2\2|}\7Q\2\2}~\7K\2\2~\u0094\7F\2\2\177\u0080\7U\2\2\u0080\u0081\7V"+
		"\2\2\u0081\u0082\7T\2\2\u0082\u0083\7K\2\2\u0083\u0084\7P\2\2\u0084\u0094"+
		"\7I\2\2\u0085\u0086\7H\2\2\u0086\u0087\7N\2\2\u0087\u0088\7Q\2\2\u0088"+
		"\u0089\7C\2\2\u0089\u0094\7V\2\2\u008a\u008b\7V\2\2\u008b\u008c\7T\2\2"+
		"\u008c\u008d\7W\2\2\u008d\u0094\7G\2\2\u008e\u008f\7H\2\2\u008f\u0090"+
		"\7C\2\2\u0090\u0091\7N\2\2\u0091\u0092\7U\2\2\u0092\u0094\7G\2\2\u0093"+
		"\62\3\2\2\2\u00939\3\2\2\2\u0093>\3\2\2\2\u0093A\3\2\2\2\u0093I\3\2\2"+
		"\2\u0093M\3\2\2\2\u0093R\3\2\2\2\u0093T\3\2\2\2\u0093Y\3\2\2\2\u0093^"+
		"\3\2\2\2\u0093`\3\2\2\2\u0093e\3\2\2\2\u0093m\3\2\2\2\u0093r\3\2\2\2\u0093"+
		"x\3\2\2\2\u0093{\3\2\2\2\u0093\177\3\2\2\2\u0093\u0085\3\2\2\2\u0093\u008a"+
		"\3\2\2\2\u0093\u008e\3\2\2\2\u0094\n\3\2\2\2\u0095\u0097\5\5\3\2\u0096"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\f\3\2\2\2\u009a\u009c\5\5\3\2\u009b\u009a\3\2\2\2\u009c\u009f"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u00a0\u00a2\7\60\2\2\u00a1\u00a3\5\5\3\2\u00a2\u00a1\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\16\3\2\2\2\u00a6\u00aa\7$\2\2\u00a7\u00a9\n\4\2\2\u00a8\u00a7\3\2\2\2"+
		"\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7$\2\2\u00ae\20\3\2\2\2\u00af"+
		"\u00b6\5\3\2\2\u00b0\u00b3\5\3\2\2\u00b1\u00b3\5\5\3\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\22\3\2\2\2\u00b8\u00bc\5\7\4\2\u00b9\u00bb\n\5\2\2\u00ba\u00b9"+
		"\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\b\n\2\2\u00c0\24\3\2\2"+
		"\2\u00c1\u00c3\t\6\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\13\2\2"+
		"\u00c7\26\3\2\2\2\u00c8\u00c9\7-\2\2\u00c9\30\3\2\2\2\u00ca\u00cb\7/\2"+
		"\2\u00cb\32\3\2\2\2\u00cc\u00cd\7,\2\2\u00cd\34\3\2\2\2\u00ce\u00cf\7"+
		"\61\2\2\u00cf\36\3\2\2\2\u00d0\u00d1\7*\2\2\u00d1 \3\2\2\2\u00d2\u00d3"+
		"\7+\2\2\u00d3\"\3\2\2\2\u00d4\u00d5\7=\2\2\u00d5$\3\2\2\2\u00d6\u00d7"+
		"\7.\2\2\u00d7&\3\2\2\2\u00d8\u00d9\7<\2\2\u00d9\u00da\7?\2\2\u00da(\3"+
		"\2\2\2\u00db\u00e3\4>@\2\u00dc\u00dd\7#\2\2\u00dd\u00e3\7?\2\2\u00de\u00df"+
		"\7>\2\2\u00df\u00e3\7?\2\2\u00e0\u00e1\7@\2\2\u00e1\u00e3\7?\2\2\u00e2"+
		"\u00db\3\2\2\2\u00e2\u00dc\3\2\2\2\u00e2\u00de\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e3*\3\2\2\2\16\2\u0093\u0098\u009d\u00a4\u00aa\u00b2\u00b4\u00b6"+
		"\u00bc\u00c4\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}