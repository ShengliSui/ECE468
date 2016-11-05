// Generated from Micro.g4 by ANTLR 4.5.3

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, INTLITERAL=19, FLOATLITERAL=20, STRINGLITERAL=21, IDENTIFIER=22, 
		COMMENT=23, WHITESPACE=24, ADD=25, SUB=26, MULT=27, DIV=28, LP=29, RP=30, 
		SCOLON=31, COMMA=32, ASSIGN=33, COMPOP=34;
	public static final int
		RULE_program = 0, RULE_id = 1, RULE_pgm_body = 2, RULE_decl = 3, RULE_string_decl = 4, 
		RULE_str = 5, RULE_var_decl = 6, RULE_var_type = 7, RULE_any_type = 8, 
		RULE_id_list = 9, RULE_id_tail = 10, RULE_param_decl_list = 11, RULE_param_decl = 12, 
		RULE_param_decl_tail = 13, RULE_func_declarations = 14, RULE_func_decl = 15, 
		RULE_func_body = 16, RULE_stmt_list = 17, RULE_stmt = 18, RULE_base_stmt = 19, 
		RULE_assign_stmt = 20, RULE_assign_expr = 21, RULE_read_stmt = 22, RULE_write_stmt = 23, 
		RULE_return_stmt = 24, RULE_expr = 25, RULE_expr_prefix = 26, RULE_factor = 27, 
		RULE_factor_prefix = 28, RULE_postfix_expr = 29, RULE_call_expr = 30, 
		RULE_expr_list = 31, RULE_expr_list_tail = 32, RULE_primary = 33, RULE_addop = 34, 
		RULE_mulop = 35, RULE_if_stmt = 36, RULE_else_part = 37, RULE_cond = 38, 
		RULE_compop = 39, RULE_do_while_stmt = 40;
	public static final String[] ruleNames = {
		"program", "id", "pgm_body", "decl", "string_decl", "str", "var_decl", 
		"var_type", "any_type", "id_list", "id_tail", "param_decl_list", "param_decl", 
		"param_decl_tail", "func_declarations", "func_decl", "func_body", "stmt_list", 
		"stmt", "base_stmt", "assign_stmt", "assign_expr", "read_stmt", "write_stmt", 
		"return_stmt", "expr", "expr_prefix", "factor", "factor_prefix", "postfix_expr", 
		"call_expr", "expr_list", "expr_list_tail", "primary", "addop", "mulop", 
		"if_stmt", "else_part", "cond", "compop", "do_while_stmt"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PROGRAM'", "'BEGIN'", "'END'", "'STRING'", "'FLOAT'", "'INT'", 
		"'VOID'", "'FUNCTION'", "'READ'", "'WRITE'", "'RETURN'", "'IF'", "'ENDIF'", 
		"'ELSIF'", "'TRUE'", "'FALSE'", "'DO'", "'WHILE'", null, null, null, null, 
		null, null, "'+'", "'-'", "'*'", "'/'", "'('", "')'", "';'", "','", "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "INTLITERAL", "FLOATLITERAL", 
		"STRINGLITERAL", "IDENTIFIER", "COMMENT", "WHITESPACE", "ADD", "SUB", 
		"MULT", "DIV", "LP", "RP", "SCOLON", "COMMA", "ASSIGN", "COMPOP"
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

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		//step2
		int blockCount = 0;
		String cat;
		public SymbolTable st = new SymbolTable();

		//step4
		public ShuntingYardStructure sy = new ShuntingYardStructure();
		TokenClass token;
		int assignFlag = 0;

	public MicroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Pgm_bodyContext pgm_body() {
			return getRuleContext(Pgm_bodyContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__0);
			setState(83);
			id();
			setState(84);
			match(T__1);
			setState(85);
			pgm_body();
			setState(86);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public String iden;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(MicroParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			((IdContext)_localctx).IDENTIFIER = match(IDENTIFIER);

				((IdContext)_localctx).iden =  (((IdContext)_localctx).IDENTIFIER!=null?((IdContext)_localctx).IDENTIFIER.getText():null);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pgm_bodyContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Func_declarationsContext func_declarations() {
			return getRuleContext(Func_declarationsContext.class,0);
		}
		public Pgm_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pgm_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPgm_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPgm_body(this);
		}
	}

	public final Pgm_bodyContext pgm_body() throws RecognitionException {
		Pgm_bodyContext _localctx = new Pgm_bodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pgm_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			decl();
			setState(92);
			func_declarations();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public String_declContext string_decl() {
			return getRuleContext(String_declContext.class,0);
		}
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			setState(101);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				string_decl();
				setState(95);
				decl();
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				var_decl();
				setState(98);
				decl();
				}
				break;
			case T__2:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__16:
			case T__17:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_declContext extends ParserRuleContext {
		public IdContext id;
		public StrContext str;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MicroParser.ASSIGN, 0); }
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public String_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterString_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitString_decl(this);
		}
	}

	public final String_declContext string_decl() throws RecognitionException {
		String_declContext _localctx = new String_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__3);
			setState(104);
			((String_declContext)_localctx).id = id();
			setState(105);
			match(ASSIGN);
			setState(106);
			((String_declContext)_localctx).str = str();
			setState(107);
			match(SCOLON);

				st.addField(((String_declContext)_localctx).id.iden,"STRING",((String_declContext)_localctx).str.strLit);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrContext extends ParserRuleContext {
		public String strLit;
		public Token STRINGLITERAL;
		public TerminalNode STRINGLITERAL() { return getToken(MicroParser.STRINGLITERAL, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStr(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((StrContext)_localctx).STRINGLITERAL = match(STRINGLITERAL);

				((StrContext)_localctx).strLit =  (((StrContext)_localctx).STRINGLITERAL!=null?((StrContext)_localctx).STRINGLITERAL.getText():null);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Var_typeContext var_type;
		public Id_listContext id_list;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			((Var_declContext)_localctx).var_type = var_type();
			setState(114);
			((Var_declContext)_localctx).id_list = id_list();
			setState(115);
			match(SCOLON);

				st.addField(((Var_declContext)_localctx).id_list.idList,(((Var_declContext)_localctx).var_type!=null?_input.getText(((Var_declContext)_localctx).var_type.start,((Var_declContext)_localctx).var_type.stop):null));

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_typeContext extends ParserRuleContext {
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterVar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitVar_type(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Any_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Any_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAny_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAny_type(this);
		}
	}

	public final Any_typeContext any_type() throws RecognitionException {
		Any_typeContext _localctx = new Any_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_any_type);
		try {
			setState(122);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				var_type();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public ArrayList<String> idList;
		public IdContext id;
		public Id_tailContext tail;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tailContext id_tail() {
			return getRuleContext(Id_tailContext.class,0);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_list(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_id_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			((Id_listContext)_localctx).id = id();
			setState(125);
			((Id_listContext)_localctx).tail = id_tail();

				((Id_listContext)_localctx).idList =  ((Id_listContext)_localctx).tail.idList;
				_localctx.idList.add(0,((Id_listContext)_localctx).id.iden);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_tailContext extends ParserRuleContext {
		public ArrayList<String> idList;
		public IdContext id;
		public Id_tailContext tail;
		public TerminalNode COMMA() { return getToken(MicroParser.COMMA, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Id_tailContext id_tail() {
			return getRuleContext(Id_tailContext.class,0);
		}
		public Id_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterId_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitId_tail(this);
		}
	}

	public final Id_tailContext id_tail() throws RecognitionException {
		Id_tailContext _localctx = new Id_tailContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_id_tail);
		try {
			setState(134);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(COMMA);
				setState(129);
				((Id_tailContext)_localctx).id = id();
				setState(130);
				((Id_tailContext)_localctx).tail = id_tail();

					((Id_tailContext)_localctx).idList =  ((Id_tailContext)_localctx).tail.idList;
					_localctx.idList.add(0,(((Id_tailContext)_localctx).id!=null?_input.getText(((Id_tailContext)_localctx).id.start,((Id_tailContext)_localctx).id.stop):null));

				}
				break;
			case RP:
			case SCOLON:
				enterOuterAlt(_localctx, 2);
				{

					((Id_tailContext)_localctx).idList =  new ArrayList<String>();

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_listContext extends ParserRuleContext {
		public Param_declContext param_decl;
		public Param_decl_tailContext param_decl_tail;
		public Param_declContext param_decl() {
			return getRuleContext(Param_declContext.class,0);
		}
		public Param_decl_tailContext param_decl_tail() {
			return getRuleContext(Param_decl_tailContext.class,0);
		}
		public Param_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl_list(this);
		}
	}

	public final Param_decl_listContext param_decl_list() throws RecognitionException {
		Param_decl_listContext _localctx = new Param_decl_listContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param_decl_list);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				((Param_decl_listContext)_localctx).param_decl = param_decl();
				setState(137);
				((Param_decl_listContext)_localctx).param_decl_tail = param_decl_tail();

					((Param_decl_listContext)_localctx).param_decl_tail.pdt.get(0).add(0,((Param_decl_listContext)_localctx).param_decl.paramDecl[0]);
					((Param_decl_listContext)_localctx).param_decl_tail.pdt.get(1).add(0,((Param_decl_listContext)_localctx).param_decl.paramDecl[1]);	
					st.addField(((Param_decl_listContext)_localctx).param_decl_tail.pdt.get(0),((Param_decl_listContext)_localctx).param_decl_tail.pdt.get(1));	

				}
				break;
			case RP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_declContext extends ParserRuleContext {
		public String[] paramDecl;
		public Var_typeContext var_type;
		public IdContext id;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Param_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl(this);
		}
	}

	public final Param_declContext param_decl() throws RecognitionException {
		Param_declContext _localctx = new Param_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_param_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((Param_declContext)_localctx).var_type = var_type();
			setState(144);
			((Param_declContext)_localctx).id = id();

				((Param_declContext)_localctx).paramDecl =  new String[]{((Param_declContext)_localctx).id.iden,(((Param_declContext)_localctx).var_type!=null?_input.getText(((Param_declContext)_localctx).var_type.start,((Param_declContext)_localctx).var_type.stop):null)};

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_decl_tailContext extends ParserRuleContext {
		public ArrayList<ArrayList<String>> pdt;
		public Param_declContext param_decl;
		public Param_decl_tailContext tail;
		public TerminalNode COMMA() { return getToken(MicroParser.COMMA, 0); }
		public Param_declContext param_decl() {
			return getRuleContext(Param_declContext.class,0);
		}
		public Param_decl_tailContext param_decl_tail() {
			return getRuleContext(Param_decl_tailContext.class,0);
		}
		public Param_decl_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_decl_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterParam_decl_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitParam_decl_tail(this);
		}
	}

	public final Param_decl_tailContext param_decl_tail() throws RecognitionException {
		Param_decl_tailContext _localctx = new Param_decl_tailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param_decl_tail);
		try {
			setState(153);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(COMMA);
				setState(148);
				((Param_decl_tailContext)_localctx).param_decl = param_decl();
				setState(149);
				((Param_decl_tailContext)_localctx).tail = param_decl_tail();

					((Param_decl_tailContext)_localctx).pdt =  ((Param_decl_tailContext)_localctx).tail.pdt;
					_localctx.pdt.get(0).add(0,((Param_decl_tailContext)_localctx).param_decl.paramDecl[0]);
					_localctx.pdt.get(1).add(0,((Param_decl_tailContext)_localctx).param_decl.paramDecl[1]);	

				}
				break;
			case RP:
				enterOuterAlt(_localctx, 2);
				{

					((Param_decl_tailContext)_localctx).pdt =  new ArrayList<ArrayList<String>>();
					_localctx.pdt.add(new ArrayList<String>());
					_localctx.pdt.add(new ArrayList<String>());	

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declarationsContext extends ParserRuleContext {
		public Func_declContext func_decl() {
			return getRuleContext(Func_declContext.class,0);
		}
		public Func_declarationsContext func_declarations() {
			return getRuleContext(Func_declarationsContext.class,0);
		}
		public Func_declarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_declarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_declarations(this);
		}
	}

	public final Func_declarationsContext func_declarations() throws RecognitionException {
		Func_declarationsContext _localctx = new Func_declarationsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_func_declarations);
		try {
			setState(159);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				func_decl();
				setState(156);
				func_declarations();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declContext extends ParserRuleContext {
		public IdContext id;
		public Any_typeContext any_type() {
			return getRuleContext(Any_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public Param_decl_listContext param_decl_list() {
			return getRuleContext(Param_decl_listContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_decl(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_func_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__7);
			setState(162);
			any_type();
			setState(163);
			((Func_declContext)_localctx).id = id();

				st.addScope(((Func_declContext)_localctx).id.iden);

			setState(165);
			match(LP);
			setState(166);
			param_decl_list();
			setState(167);
			match(RP);
			setState(168);
			match(T__1);
			setState(169);
			func_body();
			setState(170);
			match(T__2);

				st.removeScope();

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_bodyContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFunc_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFunc_body(this);
		}
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_func_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			decl();
			setState(174);
			stmt_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt_list(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmt_list);
		try {
			setState(180);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__16:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				stmt();
				setState(177);
				stmt_list();
				}
				break;
			case T__2:
			case T__12:
			case T__13:
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Do_while_stmtContext do_while_stmt() {
			return getRuleContext(Do_while_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stmt);
		try {
			setState(185);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				base_stmt();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				if_stmt();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				do_while_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_stmtContext extends ParserRuleContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Write_stmtContext write_stmt() {
			return getRuleContext(Write_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Base_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterBase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitBase_stmt(this);
		}
	}

	public final Base_stmtContext base_stmt() throws RecognitionException {
		Base_stmtContext _localctx = new Base_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_base_stmt);
		try {
			setState(191);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				assign_stmt();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				read_stmt();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				write_stmt();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			assign_expr();
			setState(194);
			match(SCOLON);

				if(assignFlag == 1){
				     token = sy.peekOperatorStack();
				     while(token!=null && (token.isType(Enum.tokenType.BINARY_OP) ||(token.isType(Enum.tokenType.BINARY_OP) && !token.isValue(":=")))){
				          sy.pushOperand(sy.popOperator());
					  token = sy.peekOperatorStack();
				     }
				     if(token != null){
				          sy.pushOperand(sy.popOperator());
				     }
				     assignFlag =0;
				}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_exprContext extends ParserRuleContext {
		public IdContext id;
		public Token ASSIGN;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MicroParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAssign_expr(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			((Assign_exprContext)_localctx).id = id();

				sy.pushOperand(new TokenClass(Enum.tokenType.VAR, ((Assign_exprContext)_localctx).id.iden));

			setState(199);
			((Assign_exprContext)_localctx).ASSIGN = match(ASSIGN);

				assignFlag = 1;
				sy.pushOperator(new TokenClass(Enum.tokenType.BINARY_OP, (((Assign_exprContext)_localctx).ASSIGN!=null?((Assign_exprContext)_localctx).ASSIGN.getText():null)));

			setState(201);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_stmtContext extends ParserRuleContext {
		public Token LP;
		public Id_listContext id_list;
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitRead_stmt(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__8);

				sy.pushOperator(new TokenClass(Enum.tokenType.IO,"READ"));

			setState(205);
			((Read_stmtContext)_localctx).LP = match(LP);

				sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((Read_stmtContext)_localctx).LP!=null?((Read_stmtContext)_localctx).LP.getText():null)));

			setState(207);
			((Read_stmtContext)_localctx).id_list = id_list();

				for(String item : ((Read_stmtContext)_localctx).id_list.idList){
					sy.pushOperand(new TokenClass(Enum.tokenType.VAR,item));	
				}

			setState(209);
			match(RP);

				token = sy.peekOperatorStack();
				while(!token.isValue("(") && !token.isValue(":=")){
					sy.pushOperand(sy.popOperator());
					token = sy.peekOperatorStack();
				}
				sy.popOperator();
				token = sy.peekOperatorStack();
				if(token.getType() == Enum.tokenType.IO){
					sy.pushOperand(sy.popOperator());
				}

			setState(211);
			match(SCOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_stmtContext extends ParserRuleContext {
		public Token LP;
		public Id_listContext id_list;
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public Write_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterWrite_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitWrite_stmt(this);
		}
	}

	public final Write_stmtContext write_stmt() throws RecognitionException {
		Write_stmtContext _localctx = new Write_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_write_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__9);

				sy.pushOperator(new TokenClass(Enum.tokenType.IO,"WRITE"));

			setState(215);
			((Write_stmtContext)_localctx).LP = match(LP);

				sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((Write_stmtContext)_localctx).LP!=null?((Write_stmtContext)_localctx).LP.getText():null)));

			setState(217);
			((Write_stmtContext)_localctx).id_list = id_list();

				for(String item : ((Write_stmtContext)_localctx).id_list.idList){
					sy.pushOperand(new TokenClass(Enum.tokenType.VAR,item));	
				}

			setState(219);
			match(RP);

				token = sy.peekOperatorStack();
				while(!token.isValue("(") && !token.isValue(":=")){
					sy.pushOperand(sy.popOperator());
					token = sy.peekOperatorStack();
				}
				sy.popOperator();
				token = sy.peekOperatorStack();
				if(token.isType(Enum.tokenType.IO)){
					sy.pushOperand(sy.popOperator());
				}

			setState(221);
			match(SCOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__10);
			setState(224);
			expr();
			setState(225);
			match(SCOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Expr_prefixContext expr_prefix() {
			return getRuleContext(Expr_prefixContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			expr_prefix(0);
			setState(228);
			factor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_prefixContext extends ParserRuleContext {
		public Expr_prefixContext expr_prefix() {
			return getRuleContext(Expr_prefixContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public Expr_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_prefix(this);
		}
	}

	public final Expr_prefixContext expr_prefix() throws RecognitionException {
		return expr_prefix(0);
	}

	private Expr_prefixContext expr_prefix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_prefixContext _localctx = new Expr_prefixContext(_ctx, _parentState);
		Expr_prefixContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr_prefix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_prefixContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_prefix);
					setState(231);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(232);
					factor();
					setState(233);
					addop();
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public Factor_prefixContext factor_prefix() {
			return getRuleContext(Factor_prefixContext.class,0);
		}
		public Postfix_exprContext postfix_expr() {
			return getRuleContext(Postfix_exprContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			factor_prefix(0);
			setState(241);
			postfix_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Factor_prefixContext extends ParserRuleContext {
		public Factor_prefixContext factor_prefix() {
			return getRuleContext(Factor_prefixContext.class,0);
		}
		public Postfix_exprContext postfix_expr() {
			return getRuleContext(Postfix_exprContext.class,0);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public Factor_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterFactor_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitFactor_prefix(this);
		}
	}

	public final Factor_prefixContext factor_prefix() throws RecognitionException {
		return factor_prefix(0);
	}

	private Factor_prefixContext factor_prefix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Factor_prefixContext _localctx = new Factor_prefixContext(_ctx, _parentState);
		Factor_prefixContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_factor_prefix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Factor_prefixContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_factor_prefix);
					setState(244);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(245);
					postfix_expr();
					setState(246);
					mulop();
					}
					} 
				}
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Postfix_exprContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public Postfix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPostfix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPostfix_expr(this);
		}
	}

	public final Postfix_exprContext postfix_expr() throws RecognitionException {
		Postfix_exprContext _localctx = new Postfix_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_postfix_expr);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				call_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_exprContext extends ParserRuleContext {
		public IdContext id;
		public Token LP;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCall_expr(this);
		}
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_call_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			((Call_exprContext)_localctx).id = id();

				sy.pushOperand(new TokenClass(Enum.tokenType.VAR, ((Call_exprContext)_localctx).id.iden));

			setState(259);
			((Call_exprContext)_localctx).LP = match(LP);

				sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((Call_exprContext)_localctx).LP!=null?((Call_exprContext)_localctx).LP.getText():null)));

			setState(261);
			expr_list();
			setState(262);
			match(RP);

				token = sy.peekOperatorStack();
				while(!token.isValue("(") && !token.isValue(":=")){
					sy.pushOperand(sy.popOperator());
					token = sy.peekOperatorStack();
				}
				sy.popOperator();
				token = sy.peekOperatorStack();
				if(token.isType(Enum.tokenType.IO)){
					sy.popOperator();
				}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_expr_list);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				expr();
				setState(266);
				expr_list_tail();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_list_tailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(MicroParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public Expr_list_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpr_list_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpr_list_tail(this);
		}
	}

	public final Expr_list_tailContext expr_list_tail() throws RecognitionException {
		Expr_list_tailContext _localctx = new Expr_list_tailContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_list_tail);
		try {
			setState(276);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				match(COMMA);
				setState(272);
				expr();
				setState(273);
				expr_list_tail();
				}
				break;
			case RP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public Token LP;
		public IdContext id;
		public Token INTLITERAL;
		public Token FLOATLITERAL;
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode INTLITERAL() { return getToken(MicroParser.INTLITERAL, 0); }
		public TerminalNode FLOATLITERAL() { return getToken(MicroParser.FLOATLITERAL, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_primary);
		try {
			setState(291);
			switch (_input.LA(1)) {
			case LP:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				((PrimaryContext)_localctx).LP = match(LP);

					sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((PrimaryContext)_localctx).LP!=null?((PrimaryContext)_localctx).LP.getText():null)));

				setState(280);
				expr();
				setState(281);
				match(RP);

					token = sy.peekOperatorStack();
					while(!token.isValue("(") && !token.isValue(":=")){
						sy.pushOperand(sy.popOperator());
						token = sy.peekOperatorStack();
					}
					sy.popOperator();
					token = sy.peekOperatorStack();
					if(token.isType(Enum.tokenType.IO)){
						sy.popOperator();
					}

				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				((PrimaryContext)_localctx).id = id();

					sy.pushOperand(new TokenClass(Enum.tokenType.VAR, ((PrimaryContext)_localctx).id.iden));

				}
				break;
			case INTLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				((PrimaryContext)_localctx).INTLITERAL = match(INTLITERAL);

					sy.pushOperand(new TokenClass(Enum.tokenType.CONST_I, Integer.valueOf((((PrimaryContext)_localctx).INTLITERAL!=null?((PrimaryContext)_localctx).INTLITERAL.getText():null))));

				}
				break;
			case FLOATLITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(289);
				((PrimaryContext)_localctx).FLOATLITERAL = match(FLOATLITERAL);

					sy.pushOperand(new TokenClass(Enum.tokenType.CONST_F, Float.valueOf((((PrimaryContext)_localctx).FLOATLITERAL!=null?((PrimaryContext)_localctx).FLOATLITERAL.getText():null))));

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddopContext extends ParserRuleContext {
		public Token ADD;
		public Token SUB;
		public TerminalNode ADD() { return getToken(MicroParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MicroParser.SUB, 0); }
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitAddop(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_addop);
		try {
			setState(297);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				((AddopContext)_localctx).ADD = match(ADD);

					token = sy.peekOperatorStack();

					while((token.isType(Enum.tokenType.BINARY_OP)) & (token.isValue("+") || token.isValue("-") || token.isValue("*") || token.isValue("/"))){
						sy.pushOperand(sy.popOperator());
						token = sy.peekOperatorStack();	
					}
					sy.pushOperator(new TokenClass(Enum.tokenType.BINARY_OP,(((AddopContext)_localctx).ADD!=null?((AddopContext)_localctx).ADD.getText():null)));

				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				((AddopContext)_localctx).SUB = match(SUB);

					token = sy.peekOperatorStack();
					while(token.isType(Enum.tokenType.BINARY_OP) && (token.isValue("+") || token.isValue("-") || token.isValue("*") || token.isValue("/"))){
						sy.pushOperand(sy.popOperator());
						token = sy.peekOperatorStack();	
					}
					sy.pushOperator(new TokenClass(Enum.tokenType.BINARY_OP,(((AddopContext)_localctx).SUB!=null?((AddopContext)_localctx).SUB.getText():null)));

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public Token MULT;
		public Token DIV;
		public TerminalNode MULT() { return getToken(MicroParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MicroParser.DIV, 0); }
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_mulop);
		try {
			setState(303);
			switch (_input.LA(1)) {
			case MULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				((MulopContext)_localctx).MULT = match(MULT);

					token = sy.peekOperatorStack();
					while(token.isType(Enum.tokenType.BINARY_OP) && (token.isValue("*") || token.isValue("/"))){
						sy.pushOperand(sy.popOperator());
						token = sy.peekOperatorStack();	
					}
					sy.pushOperator(new TokenClass(Enum.tokenType.BINARY_OP,(((MulopContext)_localctx).MULT!=null?((MulopContext)_localctx).MULT.getText():null)));

				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				((MulopContext)_localctx).DIV = match(DIV);

					token = sy.peekOperatorStack();
					while(token.isType(Enum.tokenType.BINARY_OP) && (token.isValue("*") || token.isValue("/"))){
						sy.pushOperand(sy.popOperator());
						token = sy.peekOperatorStack();	
					}
					sy.pushOperator(new TokenClass(Enum.tokenType.BINARY_OP,(((MulopContext)_localctx).DIV!=null?((MulopContext)_localctx).DIV.getText():null)));

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public Token LP;
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Else_partContext else_part() {
			return getRuleContext(Else_partContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__11);

				sy.pushOperator(new TokenClass(Enum.tokenType.BRANCH,"IF"));

			setState(307);
			((If_stmtContext)_localctx).LP = match(LP);

				sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((If_stmtContext)_localctx).LP!=null?((If_stmtContext)_localctx).LP.getText():null)));	

			setState(309);
			cond();
			setState(310);
			match(RP);

				blockCount++;
				cat = "BLOCK "+Integer.toString(blockCount);
				st.addScope(cat);

				token = sy.peekOperatorStack();
				while(!token.isValue("(")){
					sy.pushOperand(sy.popOperator());
					token = sy.peekOperatorStack();
				}
				sy.popOperator();
				token = sy.peekOperatorStack();
				if(token.isType(Enum.tokenType.BRANCH)){
					sy.pushOperand(sy.popOperator());
				}

			setState(312);
			decl();
			setState(313);
			stmt_list();
			setState(314);
			else_part();
			setState(315);
			match(T__12);

				st.removeScope();

				sy.pushOperand(new TokenClass(Enum.tokenType.BRANCH,"ENDIF"));

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_partContext extends ParserRuleContext {
		public Token LP;
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Else_partContext else_part() {
			return getRuleContext(Else_partContext.class,0);
		}
		public Else_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterElse_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitElse_part(this);
		}
	}

	public final Else_partContext else_part() throws RecognitionException {
		Else_partContext _localctx = new Else_partContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_else_part);
		try {
			setState(330);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(T__13);

					sy.pushOperator(new TokenClass(Enum.tokenType.BRANCH,"ELSIF"));

				setState(320);
				((Else_partContext)_localctx).LP = match(LP);

					sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((Else_partContext)_localctx).LP!=null?((Else_partContext)_localctx).LP.getText():null)));	

				setState(322);
				cond();
				setState(323);
				match(RP);

					st.removeScope();
					blockCount++;
					cat = "BLOCK "+Integer.toString(blockCount);	
					st.addScope(cat);

					token = sy.peekOperatorStack();
					while(!token.isValue("(")){
						sy.pushOperand(sy.popOperator());
						token = sy.peekOperatorStack();
					}
					sy.popOperator();
					token = sy.peekOperatorStack();
					if(token.isType(Enum.tokenType.BRANCH)){
						sy.pushOperand(sy.popOperator());
					}

				setState(325);
				decl();
				setState(326);
				stmt_list();
				setState(327);
				else_part();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompopContext compop() {
			return getRuleContext(CompopContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_cond);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				expr();
				setState(333);
				compop();
				setState(334);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				match(T__14);

					sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP,"TRUE"));

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				match(T__15);

					sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP,"FALSE"));

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompopContext extends ParserRuleContext {
		public Token COMPOP;
		public TerminalNode COMPOP() { return getToken(MicroParser.COMPOP, 0); }
		public CompopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterCompop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitCompop(this);
		}
	}

	public final CompopContext compop() throws RecognitionException {
		CompopContext _localctx = new CompopContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_compop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			((CompopContext)_localctx).COMPOP = match(COMPOP);

				sy.pushOperator(new TokenClass(Enum.tokenType.BINARY_OP,(((CompopContext)_localctx).COMPOP!=null?((CompopContext)_localctx).COMPOP.getText():null)));

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Do_while_stmtContext extends ParserRuleContext {
		public Token LP;
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode LP() { return getToken(MicroParser.LP, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RP() { return getToken(MicroParser.RP, 0); }
		public TerminalNode SCOLON() { return getToken(MicroParser.SCOLON, 0); }
		public Do_while_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterDo_while_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitDo_while_stmt(this);
		}
	}

	public final Do_while_stmtContext do_while_stmt() throws RecognitionException {
		Do_while_stmtContext _localctx = new Do_while_stmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_do_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(T__16);

				blockCount++;
				cat = "BLOCK "+Integer.toString(blockCount);		
				st.addScope(cat);

				sy.pushOperand(new TokenClass(Enum.tokenType.BRANCH,"DO"));

			setState(347);
			decl();
			setState(348);
			stmt_list();
			setState(349);
			match(T__17);

				sy.pushOperator(new TokenClass(Enum.tokenType.BRANCH,"WHILE"));

			setState(351);
			((Do_while_stmtContext)_localctx).LP = match(LP);

				sy.pushOperator(new TokenClass(Enum.tokenType.UNARY_OP, (((Do_while_stmtContext)_localctx).LP!=null?((Do_while_stmtContext)_localctx).LP.getText():null)));	

			setState(353);
			cond();
			setState(354);
			match(RP);

				st.removeScope();

				token = sy.peekOperatorStack();
				while(!token.isValue("(")){
					sy.pushOperand(sy.popOperator());
					token = sy.peekOperatorStack();
				}
				sy.popOperator();
				token = sy.peekOperatorStack();
				if(token.isType(Enum.tokenType.BRANCH)){
					sy.pushOperand(sy.popOperator());
				}

			setState(356);
			match(SCOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return expr_prefix_sempred((Expr_prefixContext)_localctx, predIndex);
		case 28:
			return factor_prefix_sempred((Factor_prefixContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_prefix_sempred(Expr_prefixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean factor_prefix_sempred(Factor_prefixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3$\u0169\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5h\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\5\n}\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u0089\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u0090\n\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u009c\n\17\3\20\3\20\3\20\3\20\5\20\u00a2"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00b7\n\23\3\24\3\24\3\24\5\24\u00bc"+
		"\n\24\3\25\3\25\3\25\3\25\5\25\u00c2\n\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u00ee\n\34\f\34\16\34\u00f1"+
		"\13\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\7\36\u00fb\n\36\f\36\16"+
		"\36\u00fe\13\36\3\37\3\37\5\37\u0102\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\5!\u0110\n!\3\"\3\"\3\"\3\"\3\"\5\"\u0117\n\"\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\5#\u0126\n#\3$\3$\3$\3$\5$\u012c\n$\3%\3%\3%\3"+
		"%\5%\u0132\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u014d\n\'\3(\3(\3(\3(\3(\3(\3(\3(\5"+
		"(\u0157\n(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\2\4\66:"+
		"+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF"+
		"HJLNPR\2\3\3\2\7\b\u0159\2T\3\2\2\2\4Z\3\2\2\2\6]\3\2\2\2\bg\3\2\2\2\n"+
		"i\3\2\2\2\fp\3\2\2\2\16s\3\2\2\2\20x\3\2\2\2\22|\3\2\2\2\24~\3\2\2\2\26"+
		"\u0088\3\2\2\2\30\u008f\3\2\2\2\32\u0091\3\2\2\2\34\u009b\3\2\2\2\36\u00a1"+
		"\3\2\2\2 \u00a3\3\2\2\2\"\u00af\3\2\2\2$\u00b6\3\2\2\2&\u00bb\3\2\2\2"+
		"(\u00c1\3\2\2\2*\u00c3\3\2\2\2,\u00c7\3\2\2\2.\u00cd\3\2\2\2\60\u00d7"+
		"\3\2\2\2\62\u00e1\3\2\2\2\64\u00e5\3\2\2\2\66\u00e8\3\2\2\28\u00f2\3\2"+
		"\2\2:\u00f5\3\2\2\2<\u0101\3\2\2\2>\u0103\3\2\2\2@\u010f\3\2\2\2B\u0116"+
		"\3\2\2\2D\u0125\3\2\2\2F\u012b\3\2\2\2H\u0131\3\2\2\2J\u0133\3\2\2\2L"+
		"\u014c\3\2\2\2N\u0156\3\2\2\2P\u0158\3\2\2\2R\u015b\3\2\2\2TU\7\3\2\2"+
		"UV\5\4\3\2VW\7\4\2\2WX\5\6\4\2XY\7\5\2\2Y\3\3\2\2\2Z[\7\30\2\2[\\\b\3"+
		"\1\2\\\5\3\2\2\2]^\5\b\5\2^_\5\36\20\2_\7\3\2\2\2`a\5\n\6\2ab\5\b\5\2"+
		"bh\3\2\2\2cd\5\16\b\2de\5\b\5\2eh\3\2\2\2fh\3\2\2\2g`\3\2\2\2gc\3\2\2"+
		"\2gf\3\2\2\2h\t\3\2\2\2ij\7\6\2\2jk\5\4\3\2kl\7#\2\2lm\5\f\7\2mn\7!\2"+
		"\2no\b\6\1\2o\13\3\2\2\2pq\7\27\2\2qr\b\7\1\2r\r\3\2\2\2st\5\20\t\2tu"+
		"\5\24\13\2uv\7!\2\2vw\b\b\1\2w\17\3\2\2\2xy\t\2\2\2y\21\3\2\2\2z}\5\20"+
		"\t\2{}\7\t\2\2|z\3\2\2\2|{\3\2\2\2}\23\3\2\2\2~\177\5\4\3\2\177\u0080"+
		"\5\26\f\2\u0080\u0081\b\13\1\2\u0081\25\3\2\2\2\u0082\u0083\7\"\2\2\u0083"+
		"\u0084\5\4\3\2\u0084\u0085\5\26\f\2\u0085\u0086\b\f\1\2\u0086\u0089\3"+
		"\2\2\2\u0087\u0089\b\f\1\2\u0088\u0082\3\2\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\27\3\2\2\2\u008a\u008b\5\32\16\2\u008b\u008c\5\34\17\2\u008c\u008d\b"+
		"\r\1\2\u008d\u0090\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008a\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\31\3\2\2\2\u0091\u0092\5\20\t\2\u0092\u0093\5\4\3"+
		"\2\u0093\u0094\b\16\1\2\u0094\33\3\2\2\2\u0095\u0096\7\"\2\2\u0096\u0097"+
		"\5\32\16\2\u0097\u0098\5\34\17\2\u0098\u0099\b\17\1\2\u0099\u009c\3\2"+
		"\2\2\u009a\u009c\b\17\1\2\u009b\u0095\3\2\2\2\u009b\u009a\3\2\2\2\u009c"+
		"\35\3\2\2\2\u009d\u009e\5 \21\2\u009e\u009f\5\36\20\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009d\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\37\3\2\2\2\u00a3\u00a4\7\n\2\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\5\4\3"+
		"\2\u00a6\u00a7\b\21\1\2\u00a7\u00a8\7\37\2\2\u00a8\u00a9\5\30\r\2\u00a9"+
		"\u00aa\7 \2\2\u00aa\u00ab\7\4\2\2\u00ab\u00ac\5\"\22\2\u00ac\u00ad\7\5"+
		"\2\2\u00ad\u00ae\b\21\1\2\u00ae!\3\2\2\2\u00af\u00b0\5\b\5\2\u00b0\u00b1"+
		"\5$\23\2\u00b1#\3\2\2\2\u00b2\u00b3\5&\24\2\u00b3\u00b4\5$\23\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b5\3\2"+
		"\2\2\u00b7%\3\2\2\2\u00b8\u00bc\5(\25\2\u00b9\u00bc\5J&\2\u00ba\u00bc"+
		"\5R*\2\u00bb\u00b8\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\'\3\2\2\2\u00bd\u00c2\5*\26\2\u00be\u00c2\5.\30\2\u00bf\u00c2\5\60\31"+
		"\2\u00c0\u00c2\5\62\32\2\u00c1\u00bd\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2)\3\2\2\2\u00c3\u00c4\5,\27\2"+
		"\u00c4\u00c5\7!\2\2\u00c5\u00c6\b\26\1\2\u00c6+\3\2\2\2\u00c7\u00c8\5"+
		"\4\3\2\u00c8\u00c9\b\27\1\2\u00c9\u00ca\7#\2\2\u00ca\u00cb\b\27\1\2\u00cb"+
		"\u00cc\5\64\33\2\u00cc-\3\2\2\2\u00cd\u00ce\7\13\2\2\u00ce\u00cf\b\30"+
		"\1\2\u00cf\u00d0\7\37\2\2\u00d0\u00d1\b\30\1\2\u00d1\u00d2\5\24\13\2\u00d2"+
		"\u00d3\b\30\1\2\u00d3\u00d4\7 \2\2\u00d4\u00d5\b\30\1\2\u00d5\u00d6\7"+
		"!\2\2\u00d6/\3\2\2\2\u00d7\u00d8\7\f\2\2\u00d8\u00d9\b\31\1\2\u00d9\u00da"+
		"\7\37\2\2\u00da\u00db\b\31\1\2\u00db\u00dc\5\24\13\2\u00dc\u00dd\b\31"+
		"\1\2\u00dd\u00de\7 \2\2\u00de\u00df\b\31\1\2\u00df\u00e0\7!\2\2\u00e0"+
		"\61\3\2\2\2\u00e1\u00e2\7\r\2\2\u00e2\u00e3\5\64\33\2\u00e3\u00e4\7!\2"+
		"\2\u00e4\63\3\2\2\2\u00e5\u00e6\5\66\34\2\u00e6\u00e7\58\35\2\u00e7\65"+
		"\3\2\2\2\u00e8\u00ef\b\34\1\2\u00e9\u00ea\f\4\2\2\u00ea\u00eb\58\35\2"+
		"\u00eb\u00ec\5F$\2\u00ec\u00ee\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ee\u00f1"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\67\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\5:\36\2\u00f3\u00f4\5<\37\2\u00f49\3\2\2\2"+
		"\u00f5\u00fc\b\36\1\2\u00f6\u00f7\f\4\2\2\u00f7\u00f8\5<\37\2\u00f8\u00f9"+
		"\5H%\2\u00f9\u00fb\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd;\3\2\2\2\u00fe\u00fc\3\2\2\2"+
		"\u00ff\u0102\5D#\2\u0100\u0102\5> \2\u0101\u00ff\3\2\2\2\u0101\u0100\3"+
		"\2\2\2\u0102=\3\2\2\2\u0103\u0104\5\4\3\2\u0104\u0105\b \1\2\u0105\u0106"+
		"\7\37\2\2\u0106\u0107\b \1\2\u0107\u0108\5@!\2\u0108\u0109\7 \2\2\u0109"+
		"\u010a\b \1\2\u010a?\3\2\2\2\u010b\u010c\5\64\33\2\u010c\u010d\5B\"\2"+
		"\u010d\u0110\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010b\3\2\2\2\u010f\u010e"+
		"\3\2\2\2\u0110A\3\2\2\2\u0111\u0112\7\"\2\2\u0112\u0113\5\64\33\2\u0113"+
		"\u0114\5B\"\2\u0114\u0117\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0111\3\2"+
		"\2\2\u0116\u0115\3\2\2\2\u0117C\3\2\2\2\u0118\u0119\7\37\2\2\u0119\u011a"+
		"\b#\1\2\u011a\u011b\5\64\33\2\u011b\u011c\7 \2\2\u011c\u011d\b#\1\2\u011d"+
		"\u0126\3\2\2\2\u011e\u011f\5\4\3\2\u011f\u0120\b#\1\2\u0120\u0126\3\2"+
		"\2\2\u0121\u0122\7\25\2\2\u0122\u0126\b#\1\2\u0123\u0124\7\26\2\2\u0124"+
		"\u0126\b#\1\2\u0125\u0118\3\2\2\2\u0125\u011e\3\2\2\2\u0125\u0121\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0126E\3\2\2\2\u0127\u0128\7\33\2\2\u0128\u012c"+
		"\b$\1\2\u0129\u012a\7\34\2\2\u012a\u012c\b$\1\2\u012b\u0127\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012cG\3\2\2\2\u012d\u012e\7\35\2\2\u012e\u0132\b%\1\2"+
		"\u012f\u0130\7\36\2\2\u0130\u0132\b%\1\2\u0131\u012d\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0132I\3\2\2\2\u0133\u0134\7\16\2\2\u0134\u0135\b&\1\2\u0135"+
		"\u0136\7\37\2\2\u0136\u0137\b&\1\2\u0137\u0138\5N(\2\u0138\u0139\7 \2"+
		"\2\u0139\u013a\b&\1\2\u013a\u013b\5\b\5\2\u013b\u013c\5$\23\2\u013c\u013d"+
		"\5L\'\2\u013d\u013e\7\17\2\2\u013e\u013f\b&\1\2\u013fK\3\2\2\2\u0140\u0141"+
		"\7\20\2\2\u0141\u0142\b\'\1\2\u0142\u0143\7\37\2\2\u0143\u0144\b\'\1\2"+
		"\u0144\u0145\5N(\2\u0145\u0146\7 \2\2\u0146\u0147\b\'\1\2\u0147\u0148"+
		"\5\b\5\2\u0148\u0149\5$\23\2\u0149\u014a\5L\'\2\u014a\u014d\3\2\2\2\u014b"+
		"\u014d\3\2\2\2\u014c\u0140\3\2\2\2\u014c\u014b\3\2\2\2\u014dM\3\2\2\2"+
		"\u014e\u014f\5\64\33\2\u014f\u0150\5P)\2\u0150\u0151\5\64\33\2\u0151\u0157"+
		"\3\2\2\2\u0152\u0153\7\21\2\2\u0153\u0157\b(\1\2\u0154\u0155\7\22\2\2"+
		"\u0155\u0157\b(\1\2\u0156\u014e\3\2\2\2\u0156\u0152\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157O\3\2\2\2\u0158\u0159\7$\2\2\u0159\u015a\b)\1\2\u015aQ\3"+
		"\2\2\2\u015b\u015c\7\23\2\2\u015c\u015d\b*\1\2\u015d\u015e\5\b\5\2\u015e"+
		"\u015f\5$\23\2\u015f\u0160\7\24\2\2\u0160\u0161\b*\1\2\u0161\u0162\7\37"+
		"\2\2\u0162\u0163\b*\1\2\u0163\u0164\5N(\2\u0164\u0165\7 \2\2\u0165\u0166"+
		"\b*\1\2\u0166\u0167\7!\2\2\u0167S\3\2\2\2\25g|\u0088\u008f\u009b\u00a1"+
		"\u00b6\u00bb\u00c1\u00ef\u00fc\u0101\u010f\u0116\u0125\u012b\u0131\u014c"+
		"\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}