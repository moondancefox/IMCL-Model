// Generated from E:/MyGit/workspace/model-slicing/src/grammar\IMCL.g4 by ANTLR 4.7
package per.juli.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IMCLParser}.
 */
public interface IMCLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IMCLParser#languageIMCL}.
	 * @param ctx the parse tree
	 */
	void enterLanguageIMCL(IMCLParser.LanguageIMCLContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#languageIMCL}.
	 * @param ctx the parse tree
	 */
	void exitLanguageIMCL(IMCLParser.LanguageIMCLContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#codeBody}.
	 * @param ctx the parse tree
	 */
	void enterCodeBody(IMCLParser.CodeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#codeBody}.
	 * @param ctx the parse tree
	 */
	void exitCodeBody(IMCLParser.CodeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#resourceDefine}.
	 * @param ctx the parse tree
	 */
	void enterResourceDefine(IMCLParser.ResourceDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#resourceDefine}.
	 * @param ctx the parse tree
	 */
	void exitResourceDefine(IMCLParser.ResourceDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#processDefine}.
	 * @param ctx the parse tree
	 */
	void enterProcessDefine(IMCLParser.ProcessDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#processDefine}.
	 * @param ctx the parse tree
	 */
	void exitProcessDefine(IMCLParser.ProcessDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(IMCLParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(IMCLParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#channelDefine}.
	 * @param ctx the parse tree
	 */
	void enterChannelDefine(IMCLParser.ChannelDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#channelDefine}.
	 * @param ctx the parse tree
	 */
	void exitChannelDefine(IMCLParser.ChannelDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#triggerDefine}.
	 * @param ctx the parse tree
	 */
	void enterTriggerDefine(IMCLParser.TriggerDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#triggerDefine}.
	 * @param ctx the parse tree
	 */
	void exitTriggerDefine(IMCLParser.TriggerDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#whileDefine}.
	 * @param ctx the parse tree
	 */
	void enterWhileDefine(IMCLParser.WhileDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#whileDefine}.
	 * @param ctx the parse tree
	 */
	void exitWhileDefine(IMCLParser.WhileDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#ifDefine}.
	 * @param ctx the parse tree
	 */
	void enterIfDefine(IMCLParser.IfDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#ifDefine}.
	 * @param ctx the parse tree
	 */
	void exitIfDefine(IMCLParser.IfDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#elsifDefine}.
	 * @param ctx the parse tree
	 */
	void enterElsifDefine(IMCLParser.ElsifDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#elsifDefine}.
	 * @param ctx the parse tree
	 */
	void exitElsifDefine(IMCLParser.ElsifDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#elseDefine}.
	 * @param ctx the parse tree
	 */
	void enterElseDefine(IMCLParser.ElseDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#elseDefine}.
	 * @param ctx the parse tree
	 */
	void exitElseDefine(IMCLParser.ElseDefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignVariable}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void enterAssignVariable(IMCLParser.AssignVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignVariable}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void exitAssignVariable(IMCLParser.AssignVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignFunction}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void enterAssignFunction(IMCLParser.AssignFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignFunction}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void exitAssignFunction(IMCLParser.AssignFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignInvoke}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void enterAssignInvoke(IMCLParser.AssignInvokeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignInvoke}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void exitAssignInvoke(IMCLParser.AssignInvokeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignReturn}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void enterAssignReturn(IMCLParser.AssignReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignReturn}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void exitAssignReturn(IMCLParser.AssignReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStop}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void enterAssignStop(IMCLParser.AssignStopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStop}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 */
	void exitAssignStop(IMCLParser.AssignStopContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionExpr(IMCLParser.ConditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionExpr(IMCLParser.ConditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#varDefine}.
	 * @param ctx the parse tree
	 */
	void enterVarDefine(IMCLParser.VarDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#varDefine}.
	 * @param ctx the parse tree
	 */
	void exitVarDefine(IMCLParser.VarDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#functionExpr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(IMCLParser.FunctionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#functionExpr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(IMCLParser.FunctionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#varAtom}.
	 * @param ctx the parse tree
	 */
	void enterVarAtom(IMCLParser.VarAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#varAtom}.
	 * @param ctx the parse tree
	 */
	void exitVarAtom(IMCLParser.VarAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#valueAtom}.
	 * @param ctx the parse tree
	 */
	void enterValueAtom(IMCLParser.ValueAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#valueAtom}.
	 * @param ctx the parse tree
	 */
	void exitValueAtom(IMCLParser.ValueAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#channel}.
	 * @param ctx the parse tree
	 */
	void enterChannel(IMCLParser.ChannelContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#channel}.
	 * @param ctx the parse tree
	 */
	void exitChannel(IMCLParser.ChannelContext ctx);
	/**
	 * Enter a parse tree produced by {@link IMCLParser#constraintDefine}.
	 * @param ctx the parse tree
	 */
	void enterConstraintDefine(IMCLParser.ConstraintDefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link IMCLParser#constraintDefine}.
	 * @param ctx the parse tree
	 */
	void exitConstraintDefine(IMCLParser.ConstraintDefineContext ctx);
}