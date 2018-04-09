// Generated from E:/MyGit/workspace/model-slicing/src/grammar\IMCL.g4 by ANTLR 4.7
package per.juli.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IMCLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IMCLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IMCLParser#languageIMCL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguageIMCL(IMCLParser.LanguageIMCLContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#codeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBody(IMCLParser.CodeBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#resourceDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceDefine(IMCLParser.ResourceDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#processDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessDefine(IMCLParser.ProcessDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(IMCLParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#channelDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelDefine(IMCLParser.ChannelDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#triggerDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggerDefine(IMCLParser.TriggerDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#whileDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileDefine(IMCLParser.WhileDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#ifDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfDefine(IMCLParser.IfDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#elsifDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElsifDefine(IMCLParser.ElsifDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#elseDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseDefine(IMCLParser.ElseDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignVariable}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVariable(IMCLParser.AssignVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignFunction}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignFunction(IMCLParser.AssignFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignInvoke}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignInvoke(IMCLParser.AssignInvokeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignReturn}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignReturn(IMCLParser.AssignReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStop}
	 * labeled alternative in {@link IMCLParser#assignDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStop(IMCLParser.AssignStopContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(IMCLParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#varDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefine(IMCLParser.VarDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#functionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpr(IMCLParser.FunctionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#varAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAtom(IMCLParser.VarAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#valueAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueAtom(IMCLParser.ValueAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#channel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannel(IMCLParser.ChannelContext ctx);
	/**
	 * Visit a parse tree produced by {@link IMCLParser#constraintDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintDefine(IMCLParser.ConstraintDefineContext ctx);
}