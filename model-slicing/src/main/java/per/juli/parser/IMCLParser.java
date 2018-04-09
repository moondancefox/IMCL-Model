// Generated from E:/MyGit/workspace/model-slicing/src/grammar\IMCL.g4 by ANTLR 4.7
package per.juli.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IMCLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, ID=30, VALUE=31, BOOLEAN=32, 
		STRING=33, CALC=34, RELATION=35, INVOKE=36, WS=37;
	public static final int
		RULE_languageIMCL = 0, RULE_codeBody = 1, RULE_resourceDefine = 2, RULE_processDefine = 3, 
		RULE_codeBlock = 4, RULE_channelDefine = 5, RULE_triggerDefine = 6, RULE_whileDefine = 7, 
		RULE_ifDefine = 8, RULE_elsifDefine = 9, RULE_elseDefine = 10, RULE_assignDefine = 11, 
		RULE_conditionExpr = 12, RULE_varDefine = 13, RULE_functionExpr = 14, 
		RULE_varAtom = 15, RULE_valueAtom = 16, RULE_channel = 17, RULE_constraintDefine = 18;
	public static final String[] ruleNames = {
		"languageIMCL", "codeBody", "resourceDefine", "processDefine", "codeBlock", 
		"channelDefine", "triggerDefine", "whileDefine", "ifDefine", "elsifDefine", 
		"elseDefine", "assignDefine", "conditionExpr", "varDefine", "functionExpr", 
		"varAtom", "valueAtom", "channel", "constraintDefine"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'SENSOR'", "'DEVICE'", "':'", "','", "';'", "'program'", "'function'", 
		"'('", "')'", "'['", "']'", "'{'", "'}'", "'TRIGGER'", "'WHILE'", "'IF'", 
		"'ELSIF'", "'ELSE'", "':='", "'RETURN'", "'STOP'", "'PARAM'", "'VAR'", 
		"'CHANNEL.DD.'", "'!'", "'?'", "'CHANNEL.CD.'", "'DATA.SYNC.'", "'constraint'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "ID", "VALUE", "BOOLEAN", "STRING", 
		"CALC", "RELATION", "INVOKE", "WS"
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
	public String getGrammarFileName() { return "IMCL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IMCLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LanguageIMCLContext extends ParserRuleContext {
		public List<CodeBodyContext> codeBody() {
			return getRuleContexts(CodeBodyContext.class);
		}
		public CodeBodyContext codeBody(int i) {
			return getRuleContext(CodeBodyContext.class,i);
		}
		public LanguageIMCLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_languageIMCL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterLanguageIMCL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitLanguageIMCL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitLanguageIMCL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LanguageIMCLContext languageIMCL() throws RecognitionException {
		LanguageIMCLContext _localctx = new LanguageIMCLContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_languageIMCL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__5) | (1L << T__6) | (1L << T__28))) != 0)) {
				{
				{
				setState(38);
				codeBody();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class CodeBodyContext extends ParserRuleContext {
		public ProcessDefineContext processDefine() {
			return getRuleContext(ProcessDefineContext.class,0);
		}
		public ResourceDefineContext resourceDefine() {
			return getRuleContext(ResourceDefineContext.class,0);
		}
		public ConstraintDefineContext constraintDefine() {
			return getRuleContext(ConstraintDefineContext.class,0);
		}
		public CodeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterCodeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitCodeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitCodeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBodyContext codeBody() throws RecognitionException {
		CodeBodyContext _localctx = new CodeBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_codeBody);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				processDefine();
				}
				break;
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				resourceDefine();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				constraintDefine();
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

	public static class ResourceDefineContext extends ParserRuleContext {
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public ResourceDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterResourceDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitResourceDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitResourceDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceDefineContext resourceDefine() throws RecognitionException {
		ResourceDefineContext _localctx = new ResourceDefineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_resourceDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
			match(T__2);
			setState(51);
			varAtom();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(52);
				match(T__3);
				setState(53);
				varAtom();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(T__4);
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

	public static class ProcessDefineContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IMCLParser.ID, 0); }
		public List<VarDefineContext> varDefine() {
			return getRuleContexts(VarDefineContext.class);
		}
		public VarDefineContext varDefine(int i) {
			return getRuleContext(VarDefineContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public ProcessDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterProcessDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitProcessDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitProcessDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessDefineContext processDefine() throws RecognitionException {
		ProcessDefineContext _localctx = new ProcessDefineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_processDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(62);
			match(T__2);
			setState(63);
			match(ID);
			setState(64);
			match(T__7);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21 || _la==T__22) {
				{
				setState(65);
				varDefine();
				}
			}

			setState(68);
			match(T__8);
			setState(69);
			match(T__9);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21 || _la==T__22) {
				{
				setState(70);
				varDefine();
				}
			}

			setState(73);
			match(T__10);
			setState(74);
			match(T__11);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) {
				{
				{
				setState(75);
				codeBlock();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(T__12);
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

	public static class CodeBlockContext extends ParserRuleContext {
		public AssignDefineContext assignDefine() {
			return getRuleContext(AssignDefineContext.class,0);
		}
		public IfDefineContext ifDefine() {
			return getRuleContext(IfDefineContext.class,0);
		}
		public WhileDefineContext whileDefine() {
			return getRuleContext(WhileDefineContext.class,0);
		}
		public TriggerDefineContext triggerDefine() {
			return getRuleContext(TriggerDefineContext.class,0);
		}
		public ChannelDefineContext channelDefine() {
			return getRuleContext(ChannelDefineContext.class,0);
		}
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_codeBlock);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
			case ID:
			case VALUE:
			case BOOLEAN:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				assignDefine();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				ifDefine();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				whileDefine();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				triggerDefine();
				}
				break;
			case T__23:
			case T__26:
			case T__27:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				channelDefine();
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

	public static class ChannelDefineContext extends ParserRuleContext {
		public ChannelContext channel() {
			return getRuleContext(ChannelContext.class,0);
		}
		public ChannelDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterChannelDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitChannelDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitChannelDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelDefineContext channelDefine() throws RecognitionException {
		ChannelDefineContext _localctx = new ChannelDefineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_channelDefine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			channel();
			setState(91);
			match(T__4);
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

	public static class TriggerDefineContext extends ParserRuleContext {
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public TriggerDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterTriggerDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitTriggerDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitTriggerDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerDefineContext triggerDefine() throws RecognitionException {
		TriggerDefineContext _localctx = new TriggerDefineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_triggerDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__13);
			setState(94);
			match(T__7);
			setState(95);
			conditionExpr();
			setState(96);
			match(T__8);
			setState(97);
			match(T__11);
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				codeBlock();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0) );
			setState(103);
			match(T__12);
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

	public static class WhileDefineContext extends ParserRuleContext {
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public WhileDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterWhileDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitWhileDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitWhileDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileDefineContext whileDefine() throws RecognitionException {
		WhileDefineContext _localctx = new WhileDefineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__14);
			setState(106);
			match(T__7);
			setState(107);
			conditionExpr();
			setState(108);
			match(T__8);
			setState(109);
			match(T__11);
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(110);
				codeBlock();
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0) );
			setState(115);
			match(T__12);
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

	public static class IfDefineContext extends ParserRuleContext {
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public List<ElsifDefineContext> elsifDefine() {
			return getRuleContexts(ElsifDefineContext.class);
		}
		public ElsifDefineContext elsifDefine(int i) {
			return getRuleContext(ElsifDefineContext.class,i);
		}
		public List<ElseDefineContext> elseDefine() {
			return getRuleContexts(ElseDefineContext.class);
		}
		public ElseDefineContext elseDefine(int i) {
			return getRuleContext(ElseDefineContext.class,i);
		}
		public IfDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterIfDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitIfDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitIfDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDefineContext ifDefine() throws RecognitionException {
		IfDefineContext _localctx = new IfDefineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__15);
			setState(118);
			match(T__7);
			setState(119);
			conditionExpr();
			setState(120);
			match(T__8);
			setState(121);
			match(T__11);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) {
				{
				{
				setState(122);
				codeBlock();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__12);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(129);
				elsifDefine();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(135);
				elseDefine();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ElsifDefineContext extends ParserRuleContext {
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public ElsifDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsifDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterElsifDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitElsifDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitElsifDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsifDefineContext elsifDefine() throws RecognitionException {
		ElsifDefineContext _localctx = new ElsifDefineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elsifDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__16);
			setState(142);
			match(T__7);
			setState(143);
			conditionExpr();
			setState(144);
			match(T__8);
			setState(145);
			match(T__11);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) {
				{
				{
				setState(146);
				codeBlock();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			match(T__12);
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

	public static class ElseDefineContext extends ParserRuleContext {
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public ElseDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterElseDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitElseDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitElseDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseDefineContext elseDefine() throws RecognitionException {
		ElseDefineContext _localctx = new ElseDefineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__17);
			setState(155);
			match(T__11);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__26) | (1L << T__27) | (1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) {
				{
				{
				setState(156);
				codeBlock();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			match(T__12);
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

	public static class AssignDefineContext extends ParserRuleContext {
		public AssignDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignDefine; }
	 
		public AssignDefineContext() { }
		public void copyFrom(AssignDefineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignVariableContext extends AssignDefineContext {
		public VarAtomContext varAtom() {
			return getRuleContext(VarAtomContext.class,0);
		}
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public AssignVariableContext(AssignDefineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterAssignVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitAssignVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitAssignVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignFunctionContext extends AssignDefineContext {
		public FunctionExprContext functionExpr() {
			return getRuleContext(FunctionExprContext.class,0);
		}
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public AssignFunctionContext(AssignDefineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterAssignFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitAssignFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitAssignFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignReturnContext extends AssignDefineContext {
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public List<ValueAtomContext> valueAtom() {
			return getRuleContexts(ValueAtomContext.class);
		}
		public ValueAtomContext valueAtom(int i) {
			return getRuleContext(ValueAtomContext.class,i);
		}
		public AssignReturnContext(AssignDefineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterAssignReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitAssignReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitAssignReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignInvokeContext extends AssignDefineContext {
		public TerminalNode INVOKE() { return getToken(IMCLParser.INVOKE, 0); }
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public List<ValueAtomContext> valueAtom() {
			return getRuleContexts(ValueAtomContext.class);
		}
		public ValueAtomContext valueAtom(int i) {
			return getRuleContext(ValueAtomContext.class,i);
		}
		public AssignInvokeContext(AssignDefineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterAssignInvoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitAssignInvoke(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitAssignInvoke(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStopContext extends AssignDefineContext {
		public AssignStopContext(AssignDefineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterAssignStop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitAssignStop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitAssignStop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignDefineContext assignDefine() throws RecognitionException {
		AssignDefineContext _localctx = new AssignDefineContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignDefine);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new AssignVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				varAtom();
				setState(165);
				match(T__18);
				setState(166);
				conditionExpr();
				setState(167);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new AssignFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(169);
					varAtom();
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(170);
						match(T__3);
						setState(171);
						varAtom();
						}
						}
						setState(176);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(177);
					match(T__18);
					}
					break;
				}
				setState(181);
				functionExpr();
				setState(182);
				match(T__4);
				}
				break;
			case 3:
				_localctx = new AssignInvokeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(184);
					varAtom();
					}
					break;
				case VALUE:
				case BOOLEAN:
				case STRING:
					{
					setState(185);
					valueAtom();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(188);
				match(INVOKE);
				setState(191);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(189);
					varAtom();
					}
					break;
				case VALUE:
				case BOOLEAN:
				case STRING:
					{
					setState(190);
					valueAtom();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(193);
				match(T__4);
				}
				break;
			case 4:
				_localctx = new AssignReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(T__19);
				setState(196);
				match(T__2);
				setState(199);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(197);
					varAtom();
					}
					break;
				case VALUE:
				case BOOLEAN:
				case STRING:
					{
					setState(198);
					valueAtom();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(201);
					match(T__3);
					setState(204);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(202);
						varAtom();
						}
						break;
					case VALUE:
					case BOOLEAN:
					case STRING:
						{
						setState(203);
						valueAtom();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new AssignStopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				match(T__20);
				setState(214);
				match(T__4);
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

	public static class ConditionExprContext extends ParserRuleContext {
		public Token op;
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public List<ValueAtomContext> valueAtom() {
			return getRuleContexts(ValueAtomContext.class);
		}
		public ValueAtomContext valueAtom(int i) {
			return getRuleContext(ValueAtomContext.class,i);
		}
		public List<TerminalNode> CALC() { return getTokens(IMCLParser.CALC); }
		public TerminalNode CALC(int i) {
			return getToken(IMCLParser.CALC, i);
		}
		public List<TerminalNode> RELATION() { return getTokens(IMCLParser.RELATION); }
		public TerminalNode RELATION(int i) {
			return getToken(IMCLParser.RELATION, i);
		}
		public ChannelContext channel() {
			return getRuleContext(ChannelContext.class,0);
		}
		public ConditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterConditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitConditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_conditionExpr);
		int _la;
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case VALUE:
			case BOOLEAN:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(217);
					varAtom();
					}
					break;
				case VALUE:
				case BOOLEAN:
				case STRING:
					{
					setState(218);
					valueAtom();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CALC || _la==RELATION) {
					{
					{
					setState(221);
					((ConditionExprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==CALC || _la==RELATION) ) {
						((ConditionExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(224);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(222);
						varAtom();
						}
						break;
					case VALUE:
					case BOOLEAN:
					case STRING:
						{
						setState(223);
						valueAtom();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__23:
			case T__26:
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				channel();
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

	public static class VarDefineContext extends ParserRuleContext {
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public VarDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterVarDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitVarDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitVarDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefineContext varDefine() throws RecognitionException {
		VarDefineContext _localctx = new VarDefineContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(235);
			match(T__2);
			setState(236);
			varAtom();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(237);
				match(T__3);
				setState(238);
				varAtom();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FunctionExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IMCLParser.ID, 0); }
		public List<ValueAtomContext> valueAtom() {
			return getRuleContexts(ValueAtomContext.class);
		}
		public ValueAtomContext valueAtom(int i) {
			return getRuleContext(ValueAtomContext.class,i);
		}
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public FunctionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitFunctionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitFunctionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionExprContext functionExpr() throws RecognitionException {
		FunctionExprContext _localctx = new FunctionExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(ID);
			setState(245);
			match(T__7);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) {
				{
				setState(248);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VALUE:
				case BOOLEAN:
				case STRING:
					{
					setState(246);
					valueAtom();
					}
					break;
				case ID:
					{
					setState(247);
					varAtom();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(250);
					match(T__3);
					setState(253);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case VALUE:
					case BOOLEAN:
					case STRING:
						{
						setState(251);
						valueAtom();
						}
						break;
					case ID:
						{
						setState(252);
						varAtom();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(262);
			match(T__8);
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

	public static class VarAtomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IMCLParser.ID, 0); }
		public VarAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterVarAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitVarAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitVarAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAtomContext varAtom() throws RecognitionException {
		VarAtomContext _localctx = new VarAtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varAtom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(ID);
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

	public static class ValueAtomContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(IMCLParser.VALUE, 0); }
		public TerminalNode BOOLEAN() { return getToken(IMCLParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(IMCLParser.STRING, 0); }
		public ValueAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterValueAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitValueAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitValueAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueAtomContext valueAtom() throws RecognitionException {
		ValueAtomContext _localctx = new ValueAtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_valueAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VALUE) | (1L << BOOLEAN) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class ChannelContext extends ParserRuleContext {
		public VarAtomContext varAtom() {
			return getRuleContext(VarAtomContext.class,0);
		}
		public TerminalNode ID() { return getToken(IMCLParser.ID, 0); }
		public TerminalNode VALUE() { return getToken(IMCLParser.VALUE, 0); }
		public ChannelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterChannel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitChannel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitChannel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelContext channel() throws RecognitionException {
		ChannelContext _localctx = new ChannelContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_channel);
		int _la;
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(T__23);
				setState(269);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(270);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(271);
				match(T__2);
				setState(272);
				varAtom();
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(273);
					match(T__4);
					}
					break;
				}
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(T__26);
				setState(277);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(278);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(280);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(279);
					match(T__4);
					}
					break;
				}
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				match(T__27);
				setState(283);
				match(ID);
				setState(284);
				match(T__2);
				setState(285);
				varAtom();
				setState(287);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(286);
					match(T__4);
					}
					break;
				}
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

	public static class ConstraintDefineContext extends ParserRuleContext {
		public List<VarAtomContext> varAtom() {
			return getRuleContexts(VarAtomContext.class);
		}
		public VarAtomContext varAtom(int i) {
			return getRuleContext(VarAtomContext.class,i);
		}
		public ConstraintDefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintDefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).enterConstraintDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IMCLListener ) ((IMCLListener)listener).exitConstraintDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IMCLVisitor ) return ((IMCLVisitor<? extends T>)visitor).visitConstraintDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintDefineContext constraintDefine() throws RecognitionException {
		ConstraintDefineContext _localctx = new ConstraintDefineContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constraintDefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__28);
			setState(292);
			match(T__2);
			setState(293);
			varAtom();
			setState(294);
			match(T__11);
			setState(295);
			varAtom();
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(296);
				match(T__3);
				setState(297);
				varAtom();
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(303);
			match(T__12);
			setState(304);
			match(T__4);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0135\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\5\3\62\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\5\5E\n\5\3\5\3\5\3\5\5\5J\n\5\3\5\3\5\3\5\7\5O\n\5\f\5\16\5R\13\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6[\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\6\bf\n\b\r\b\16\bg\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\6\tr\n\t\r\t\16"+
		"\ts\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n~\n\n\f\n\16\n\u0081\13\n\3\n\3"+
		"\n\7\n\u0085\n\n\f\n\16\n\u0088\13\n\3\n\7\n\u008b\n\n\f\n\16\n\u008e"+
		"\13\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0096\n\13\f\13\16\13\u0099\13"+
		"\13\3\13\3\13\3\f\3\f\3\f\7\f\u00a0\n\f\f\f\16\f\u00a3\13\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00af\n\r\f\r\16\r\u00b2\13\r\3\r\3"+
		"\r\5\r\u00b6\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bd\n\r\3\r\3\r\3\r\5\r\u00c2"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ca\n\r\3\r\3\r\3\r\5\r\u00cf\n\r\7"+
		"\r\u00d1\n\r\f\r\16\r\u00d4\13\r\3\r\3\r\3\r\3\r\5\r\u00da\n\r\3\16\3"+
		"\16\5\16\u00de\n\16\3\16\3\16\3\16\5\16\u00e3\n\16\7\16\u00e5\n\16\f\16"+
		"\16\16\u00e8\13\16\3\16\5\16\u00eb\n\16\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u00f2\n\17\f\17\16\17\u00f5\13\17\3\20\3\20\3\20\3\20\5\20\u00fb\n\20"+
		"\3\20\3\20\3\20\5\20\u0100\n\20\7\20\u0102\n\20\f\20\16\20\u0105\13\20"+
		"\5\20\u0107\n\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0115\n\23\3\23\3\23\3\23\3\23\5\23\u011b\n\23\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u0122\n\23\5\23\u0124\n\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u012d\n\24\f\24\16\24\u0130\13\24\3\24\3\24\3\24\3\24"+
		"\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\t\3\2\3\4\3\2\b"+
		"\t\3\2$%\3\2\30\31\3\2!#\3\2\33\34\3\2 !\2\u014d\2+\3\2\2\2\4\61\3\2\2"+
		"\2\6\63\3\2\2\2\b?\3\2\2\2\nZ\3\2\2\2\f\\\3\2\2\2\16_\3\2\2\2\20k\3\2"+
		"\2\2\22w\3\2\2\2\24\u008f\3\2\2\2\26\u009c\3\2\2\2\30\u00d9\3\2\2\2\32"+
		"\u00ea\3\2\2\2\34\u00ec\3\2\2\2\36\u00f6\3\2\2\2 \u010a\3\2\2\2\"\u010c"+
		"\3\2\2\2$\u0123\3\2\2\2&\u0125\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+"+
		")\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-+\3\2\2\2.\62\5\b\5\2/\62\5\6\4\2\60\62"+
		"\5&\24\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63\64\t\2"+
		"\2\2\64\65\7\5\2\2\65:\5 \21\2\66\67\7\6\2\2\679\5 \21\28\66\3\2\2\29"+
		"<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\7\2\2>\7\3\2\2\2"+
		"?@\t\3\2\2@A\7\5\2\2AB\7 \2\2BD\7\n\2\2CE\5\34\17\2DC\3\2\2\2DE\3\2\2"+
		"\2EF\3\2\2\2FG\7\13\2\2GI\7\f\2\2HJ\5\34\17\2IH\3\2\2\2IJ\3\2\2\2JK\3"+
		"\2\2\2KL\7\r\2\2LP\7\16\2\2MO\5\n\6\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ"+
		"\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7\17\2\2T\t\3\2\2\2U[\5\30\r\2V[\5\22\n"+
		"\2W[\5\20\t\2X[\5\16\b\2Y[\5\f\7\2ZU\3\2\2\2ZV\3\2\2\2ZW\3\2\2\2ZX\3\2"+
		"\2\2ZY\3\2\2\2[\13\3\2\2\2\\]\5$\23\2]^\7\7\2\2^\r\3\2\2\2_`\7\20\2\2"+
		"`a\7\n\2\2ab\5\32\16\2bc\7\13\2\2ce\7\16\2\2df\5\n\6\2ed\3\2\2\2fg\3\2"+
		"\2\2ge\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\17\2\2j\17\3\2\2\2kl\7\21\2\2l"+
		"m\7\n\2\2mn\5\32\16\2no\7\13\2\2oq\7\16\2\2pr\5\n\6\2qp\3\2\2\2rs\3\2"+
		"\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\17\2\2v\21\3\2\2\2wx\7\22\2\2x"+
		"y\7\n\2\2yz\5\32\16\2z{\7\13\2\2{\177\7\16\2\2|~\5\n\6\2}|\3\2\2\2~\u0081"+
		"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177"+
		"\3\2\2\2\u0082\u0086\7\17\2\2\u0083\u0085\5\24\13\2\u0084\u0083\3\2\2"+
		"\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008c"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\5\26\f\2\u008a\u0089\3\2\2\2"+
		"\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\23"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\23\2\2\u0090\u0091\7\n\2\2"+
		"\u0091\u0092\5\32\16\2\u0092\u0093\7\13\2\2\u0093\u0097\7\16\2\2\u0094"+
		"\u0096\5\n\6\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009b\7\17\2\2\u009b\25\3\2\2\2\u009c\u009d\7\24\2\2\u009d\u00a1\7\16"+
		"\2\2\u009e\u00a0\5\n\6\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a4\u00a5\7\17\2\2\u00a5\27\3\2\2\2\u00a6\u00a7\5 \21\2\u00a7\u00a8"+
		"\7\25\2\2\u00a8\u00a9\5\32\16\2\u00a9\u00aa\7\7\2\2\u00aa\u00da\3\2\2"+
		"\2\u00ab\u00b0\5 \21\2\u00ac\u00ad\7\6\2\2\u00ad\u00af\5 \21\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7\25\2\2\u00b4\u00b6\3"+
		"\2\2\2\u00b5\u00ab\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\5\36\20\2\u00b8\u00b9\7\7\2\2\u00b9\u00da\3\2\2\2\u00ba\u00bd\5"+
		" \21\2\u00bb\u00bd\5\"\22\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00c1\7&\2\2\u00bf\u00c2\5 \21\2\u00c0\u00c2\5\""+
		"\22\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\7\7\2\2\u00c4\u00da\3\2\2\2\u00c5\u00c6\7\26\2\2\u00c6\u00c9\7"+
		"\5\2\2\u00c7\u00ca\5 \21\2\u00c8\u00ca\5\"\22\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00d2\3\2\2\2\u00cb\u00ce\7\6\2\2\u00cc\u00cf\5 "+
		"\21\2\u00cd\u00cf\5\"\22\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00cb\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d6\7\7\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d8\7\27\2\2\u00d8\u00da\7"+
		"\7\2\2\u00d9\u00a6\3\2\2\2\u00d9\u00b5\3\2\2\2\u00d9\u00bc\3\2\2\2\u00d9"+
		"\u00c5\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\31\3\2\2\2\u00db\u00de\5 \21"+
		"\2\u00dc\u00de\5\"\22\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"\u00e6\3\2\2\2\u00df\u00e2\t\4\2\2\u00e0\u00e3\5 \21\2\u00e1\u00e3\5\""+
		"\22\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00df\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00eb\5$\23\2\u00ea"+
		"\u00dd\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\33\3\2\2\2\u00ec\u00ed\t\5\2"+
		"\2\u00ed\u00ee\7\5\2\2\u00ee\u00f3\5 \21\2\u00ef\u00f0\7\6\2\2\u00f0\u00f2"+
		"\5 \21\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\35\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7 \2\2"+
		"\u00f7\u0106\7\n\2\2\u00f8\u00fb\5\"\22\2\u00f9\u00fb\5 \21\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u0103\3\2\2\2\u00fc\u00ff\7\6\2\2\u00fd"+
		"\u0100\5\"\22\2\u00fe\u0100\5 \21\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3"+
		"\2\2\2\u0100\u0102\3\2\2\2\u0101\u00fc\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2"+
		"\2\2\u0106\u00fa\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"\u0109\7\13\2\2\u0109\37\3\2\2\2\u010a\u010b\7 \2\2\u010b!\3\2\2\2\u010c"+
		"\u010d\t\6\2\2\u010d#\3\2\2\2\u010e\u010f\7\32\2\2\u010f\u0110\t\7\2\2"+
		"\u0110\u0111\t\b\2\2\u0111\u0112\7\5\2\2\u0112\u0114\5 \21\2\u0113\u0115"+
		"\7\7\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0124\3\2\2\2\u0116"+
		"\u0117\7\35\2\2\u0117\u0118\t\7\2\2\u0118\u011a\t\b\2\2\u0119\u011b\7"+
		"\7\2\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0124\3\2\2\2\u011c"+
		"\u011d\7\36\2\2\u011d\u011e\7 \2\2\u011e\u011f\7\5\2\2\u011f\u0121\5 "+
		"\21\2\u0120\u0122\7\7\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0124\3\2\2\2\u0123\u010e\3\2\2\2\u0123\u0116\3\2\2\2\u0123\u011c\3\2"+
		"\2\2\u0124%\3\2\2\2\u0125\u0126\7\37\2\2\u0126\u0127\7\5\2\2\u0127\u0128"+
		"\5 \21\2\u0128\u0129\7\16\2\2\u0129\u012e\5 \21\2\u012a\u012b\7\6\2\2"+
		"\u012b\u012d\5 \21\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0132\7\17\2\2\u0132\u0133\7\7\2\2\u0133\'\3\2\2\2&+\61:DIPZgs\177\u0086"+
		"\u008c\u0097\u00a1\u00b0\u00b5\u00bc\u00c1\u00c9\u00ce\u00d2\u00d9\u00dd"+
		"\u00e2\u00e6\u00ea\u00f3\u00fa\u00ff\u0103\u0106\u0114\u011a\u0121\u0123"+
		"\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}