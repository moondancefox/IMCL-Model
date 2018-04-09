package per.juli.staticAnalysis;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import per.juli.parser.IMCLBaseVisitor;
import per.juli.parser.IMCLLexer;
import per.juli.parser.IMCLParser;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by juli on 2017/3/3.
 */



public class AST extends IMCLBaseVisitor<String>
{

    public static Set<String> SensorsSet = new HashSet<>();
    public static Set<String> DeviceSet = new HashSet<>();

    public static Map<String, ASTNode> mapASTs = new HashMap<>();

    public static Map<String, Set<String>>  mapVars = new HashMap<>();     // 每个process的变量集合

    public static Map<String, Set<String>>  constraintMap = new HashMap<>();


    public static ASTNode subASTNode = new ASTNode();


    public static String mainProgram = new String();


    public static List<String> capacityCU = new ArrayList<>();



    public static void printTree(ASTNode astNode)     // level 是表示代码的层级
    {
        String out = "";

        out += "line: " + Integer.toString(astNode.lineNumber) + "\tlevel: " + Integer.toString(astNode.level) + "\t";

        for (int i = 0; i < astNode.level; ++i)
        {
            out += "\t";
        }

        out += astNode.sliceCode;

        System.out.println(out);

        out = "DEF / REF :\t";
        out += astNode.DEF.toString();
        out += astNode.REF.toString();
        out += "\n";
        System.out.println(out);

        for (ASTNode node : astNode.Nexts)
        {
            printTree(node);
        }
    }

    /// 设置代码行号，方便后续代码定位研究

    public static int setLineNumberAndLevel(ASTNode astNode, int lineNumber, int level)
    {
        astNode.level = level;
        astNode.lineNumber = lineNumber;

        ++level;
        ++lineNumber;
        for (ASTNode node : astNode.Nexts)
        {
            lineNumber = setLineNumberAndLevel(node, lineNumber, level);
        }

        return lineNumber;
    }


    @Override
    public String visitLanguageIMCL(IMCLParser.LanguageIMCLContext ctx)
    {
        for (int i = 0; i < ctx.codeBody().size(); ++i)
        {
            visit(ctx.codeBody(i));
        }

        // 设置代码行号，方便后续代码定位研究
        for (String key : mapASTs.keySet())
        {
            setLineNumberAndLevel(mapASTs.get(key), 0, 0);
        }

        return "";
    }

    @Override
    public String visitCodeBody(IMCLParser.CodeBodyContext ctx)
    {
        for (int i = 0; i < ctx.getChildCount(); ++i)
        {
            visit(ctx.getChild(i));
        }
        return "";
    }

    @Override
public String visitResourceDefine(IMCLParser.ResourceDefineContext ctx)
{

    for (int i = 0; i < ctx.varAtom().size(); ++i)
    {
        if (ctx.getChild(0).toString().equals("SENSOR"))
        {
            SensorsSet.add(ctx.varAtom(i).getText());
        }
        else if (ctx.getChild(0).toString().equals("DEVICE"))
        {
            DeviceSet.add(ctx.varAtom(i).getText());
        }
    }

    return "";
}


    @Override
    public String visitProcessDefine(IMCLParser.ProcessDefineContext ctx)
    {
        ASTNode processNode = new ASTNode();

        if (ctx.getChild(0).getText().equals("program"))
        {
            mainProgram = new String(ctx.getChild(2).toString());
        }

        processNode.sliceCode = ctx.getChild(2).toString();
        if (ctx.varDefine().size() == 2)
        {
            processNode.sliceCode += "(" + ctx.varDefine(0).getText() + ")";
        }
        else
        {
            processNode.sliceCode += "()";
        }
        processNode.label = ctx.getChild(0).toString();

        // 求 每个process里的变量列表
        Set<String> processVariable = new HashSet<>();

        // varDefine最多有两个
        if (ctx.varDefine().size() == 2)
        {
            // 求 REF：被引用的变量列表

            visit(ctx.varDefine(0));
            processNode.REF.addAll(new ArrayList<>(subASTNode.REF));
            processVariable.addAll(new ArrayList<>(subASTNode.REF));

            visit(ctx.varDefine(1));
            processVariable.addAll(new ArrayList<>(subASTNode.REF));


        }
        else if ( ctx.varDefine().size() == 1)
        {

            visit(ctx.varDefine(0));
            processVariable.addAll(new ArrayList<>(subASTNode.REF));
        }


        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
            processNode.Nexts.add(subASTNode);
        }

        // TODO：求解下列RETUEN过程，可以当到求解 DFG 之后。（后续思考）
        // process 求 DEF：被改变的变量集合，表示进程的返回输出列表
        // ！！！（注意：process的DEF和一般sliceCode不一样，此处表示的是输出，与具体的变量名字也没关系，关键看变量输出返回的顺序）
//        ASTNode returnNode = processNode.Nexts.get(processNode.Nexts.size() - 1);
//        if (returnNode.label.equals("RETURN"))
//        {
//            processNode.DEF .addAll(new ArrayList<>(returnNode.REF));
//        }

        subASTNode = new ASTNode();

        // System.out.println("变量：" + processNode.sliceCode + processNode.REF.toString() + processVariable.toString());

        mapASTs.put(processNode.sliceCode.split("\\(")[0], processNode);
        mapVars.put(processNode.sliceCode.split("\\(")[0], processVariable);
        return "";
    }

    @Override
    public String visitCodeBlock(IMCLParser.CodeBlockContext ctx)
    {
        visit(ctx.getChild(0));

        return "";
    }

    @Override
    public String visitTriggerDefine(IMCLParser.TriggerDefineContext ctx)
    {
        ASTNode astNode = new ASTNode();

        astNode.sliceCode = ctx.getText().toString().split("\\{")[0];
        astNode.label = "TRIGGER";

        // 获取condition表达式的 REF 和 DEF；
        // 求REF
        visit(ctx.conditionExpr());
        astNode.REF.addAll(new ArrayList<>(subASTNode.REF));

        // Trigger中没有DEF(无)


        ASTNode tmp = astNode;
        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
            astNode.Nexts.add(subASTNode);
        }

        subASTNode = tmp;

        return "";
    }


    @Override
    public String visitChannelDefine(IMCLParser.ChannelDefineContext ctx)
    {
        // TODO

        return "";
    }


    @Override
    public String visitWhileDefine(IMCLParser.WhileDefineContext ctx)
    {
        ASTNode astNode = new ASTNode();


        astNode.sliceCode = ctx.getText().toString().split("\\{")[0];
        astNode.label = "WHILE";

        // 获取condition表达式的 REF 和 DEF；

        // 求REF
//        Pattern pattern = Pattern.compile("[-]?(([0-9]+[.])?[0-9]+)");
//        for (int i = 0; i < ctx.conditionExpr().varAtom().size(); ++i)
//        {
//            String tmp = ctx.conditionExpr().varAtom(i).getText();
//            Matcher matcher = pattern.matcher(tmp);
//            // System.out.println(tmp + " " + (matcher.matches() ? "是数字" : "不是数字"));
//            if (! tmp.startsWith("'") && ! matcher.matches())  // 不是字符串，也不是数字
//            {
//                astNode.REF.add(tmp);
//            }
//        }

        visit(ctx.conditionExpr());
        astNode.REF.addAll(new ArrayList<>(subASTNode.REF));

        // DEF (无)

        ASTNode tmp = astNode;
        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
            astNode.Nexts.add(subASTNode);
        }

        subASTNode = tmp;
        return "";
    }

    @Override
    public String visitIfDefine(IMCLParser.IfDefineContext ctx)
    {

        /** IF 和 ELSIF、ELSE是依此递进层次式算法 */

        ASTNode ifASTNode = new ASTNode();
        ifASTNode.sliceCode = "IF(" + ctx.conditionExpr().getText() + ")";
        ifASTNode.label = "IF";

        visit(ctx.conditionExpr());
        ifASTNode.REF.addAll(new ArrayList<>(subASTNode.REF));

        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
            ifASTNode.Nexts.add(subASTNode);
        }

        if (ctx.elsifDefine().size() > 0)       // 存在 elseif
        {
            ASTNode beforeNode = new ASTNode();
            for (int i = 0; i < ctx.elsifDefine().size(); ++i)
            {
                // elsif
                visit(ctx.elsifDefine(i));
                if (i == 0)
                {
                    Iterator<String> iter = ifASTNode.REF.iterator();
                    while(iter.hasNext())
                    {
                        String newvar = iter.next();
                        if (! subASTNode.REF.contains(newvar))
                        {
                            subASTNode.REF.add(newvar);
                        }
                    }

                    ifASTNode.Nexts.add(subASTNode);
                    beforeNode = subASTNode;
                }
                else
                {
                    Iterator<String> iter = beforeNode.REF.iterator();
                    while(iter.hasNext())
                    {
                        String newvar = iter.next();
                        if (! subASTNode.REF.contains(newvar))
                        {
                            subASTNode.REF.add(newvar);
                        }
                    }

                    beforeNode.Nexts.add(subASTNode);
                    beforeNode = subASTNode;
                }

                // else
                if (i == ctx.elsifDefine().size() - 1)
                {
                    if (ctx.elseDefine().size() == 1)
                    {
                        visit(ctx.elseDefine(0));

                        Iterator<String> iter = beforeNode.REF.iterator();
                        while(iter.hasNext())
                        {
                            String newvar = iter.next();
                            if (! subASTNode.REF.contains(newvar))
                            {
                                subASTNode.REF.add(newvar);
                            }
                        }

                        beforeNode.Nexts.add(subASTNode);
                    }
                }
            }
        }
        else // if (ctx.elsifDefine().size() == 0)  // 不存在 elseif
        {
            if (ctx.elseDefine().size() == 1)
            {
                visit(ctx.elseDefine(0));

                Iterator<String> iter = ifASTNode.REF.iterator();
                while(iter.hasNext())
                {
                    String newvar = iter.next();
                    if (! subASTNode.REF.contains(newvar))
                    {
                        subASTNode.REF.add(newvar);
                    }
                }

                ifASTNode.Nexts.add(subASTNode);
            }
        }


        subASTNode = ifASTNode;


        return "";
    }

    @Override public String visitElsifDefine(IMCLParser.ElsifDefineContext ctx)
    {
        ASTNode astNode = new ASTNode();

        astNode.sliceCode = "ELSIF(" + ctx.conditionExpr().getText() + ")";
        astNode.label = "ELSIF";

        // 获取condition表达式的 REF 和 DEF；

        // 求REF
        visit(ctx.conditionExpr());
        astNode.REF.addAll(subASTNode.REF);

        // 求DEF (无)


        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
            astNode.Nexts.add(subASTNode);
        }

        subASTNode = astNode;

        return "";

    }


    @Override public String visitElseDefine(IMCLParser.ElseDefineContext ctx)
    {
        ASTNode astNode = new ASTNode();

        astNode.sliceCode = "ELSE";
        astNode.label = "ELSE";

        // 获取condition表达式的 REF 和 DEF；

        // 求 REF (由上一层决定)
        // 求 DEF (无)

        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
            astNode.Nexts.add(subASTNode);
        }

        subASTNode = astNode;

        return "";
    }


    @Override public String visitVarDefine(IMCLParser.VarDefineContext ctx)
    {

        ASTNode astNode = new ASTNode();
        astNode.sliceCode = ctx.getText();
        astNode.label = "VarDefine";

        for (int i = 0; i < ctx.varAtom().size(); ++i)
        {
            astNode.REF.add(ctx.varAtom(i).getText());
        }

        subASTNode = astNode;
        return "";
    }


    @Override
    public String visitAssignVariable(IMCLParser.AssignVariableContext ctx)
    {
        ASTNode astNode = new ASTNode();


        astNode.sliceCode = ctx.getText();
        astNode.label = "AssignVariable";

        // 求 REF
        visit(ctx.conditionExpr());
        astNode.REF = new HashSet<>(subASTNode.REF);
        // 求 DEF
        astNode.DEF.add(ctx.varAtom().getText());

        subASTNode = astNode;
        return "";
    }

    @Override
    public String visitAssignFunction(IMCLParser.AssignFunctionContext ctx)
    {
        ASTNode astNode = new ASTNode();


        astNode.sliceCode = ctx.getText();
        astNode.label = "AssignFunction";

        // 求 REF
        visit(ctx.functionExpr());
        astNode.REF = new HashSet<>(subASTNode.REF);
        // 求 DEF
        for (int i = 0; i < ctx.varAtom().size(); ++i)
        {
            astNode.DEF.add(ctx.varAtom(i).getText());
        }


        subASTNode = astNode;

        return "";
    }

    @Override
    public String visitAssignInvoke(IMCLParser.AssignInvokeContext ctx)
    {
        ASTNode astNode = new ASTNode();

        astNode.sliceCode = ctx.getText();
        astNode.label = "AssignInvoke";

        // REF 和 DEF
        String left = ctx.getChild(0).getText();
        String right = ctx.getChild(2).getText();

        Pattern pattern = Pattern.compile("[-]?(([0-9]+[.])?[0-9]+)");

        if (ctx.getChild(1).getText().endsWith("<<"))   // 判断是不是 "<<" 符号
        {
            Matcher matcher = pattern.matcher(left);
            // System.out.println(left + " " + (matcher.matches() ? "是数字" : "不是数字"));
            if (! left.startsWith("'") && ! matcher.matches())  // 不是字符串，也不是数字
            {
                astNode.DEF.add(left);
            }

            matcher = pattern.matcher(right);
            // System.out.println(right + " " + (matcher.matches() ? "是数字" : "不是数字"));
            if (! right.startsWith("'") && ! matcher.matches())  // 不是字符串，也不是数字
            {
                astNode.REF.add(right);
            }

        }
        else
        {
            Matcher matcher = pattern.matcher(left);
            // System.out.println(left + " " + (matcher.matches() ? "是数字" : "不是数字"));
            if (! left.startsWith("'") && ! matcher.matches())  // 不是字符串，也不是数字
            {
                astNode.REF.add(left);
            }

            matcher = pattern.matcher(right);
            // System.out.println(right + " " + (matcher.matches() ? "是数字" : "不是数字"));
            if (! right.startsWith("'") && ! matcher.matches())  // 不是字符串，也不是数字
            {
                astNode.DEF.add(right);
            }
        }

        subASTNode = astNode;
        return "";
    }

    @Override
    public String visitAssignReturn(IMCLParser.AssignReturnContext ctx)
    {
        ASTNode astNode = new ASTNode();


        astNode.sliceCode = ctx.getText();
        astNode.label = "RETURN";

        // 求 REF
        for ( int i = 2; i < ctx.getChildCount();)
        {
            astNode.REF.add(ctx.getChild(i).getText());
            i += 2;
        }
        // 求 DEF (无)

        subASTNode = astNode;
        return "";
    }

    @Override
    public String visitAssignStop(IMCLParser.AssignStopContext ctx)
    {
        ASTNode astNode = new ASTNode();


        astNode.sliceCode = ctx.getText();
        astNode.label = "STOP";

        // 求 REF (无)
        // 求 DEF (无)

        subASTNode = astNode;
        return "";
    }

    @Override
    public String visitConditionExpr(IMCLParser.ConditionExprContext ctx)   // conditionExpr不直接记录整个图中
    {
        ASTNode astNode = new ASTNode();

        astNode.sliceCode = ctx.getText();
        astNode.label = "ConditionExpr";

        // 求 REF
        for (int i = 0; i < ctx.varAtom().size(); ++i)
        {
            String str = ctx.varAtom(i).getText();

            if (!str.equals("TRUE") && !str.equals("FALSE"))
            {
                astNode.REF.add(str);     //  str对 astNode 是REF，其实是 astNode 作为其他的调用的时候要具体分析
            }
        }
        // 求 DEF (无)

        // System.out.println("conditionExpr : " + subASTNode.REF.toString());

        subASTNode = astNode;

        return "";
    }

    @Override
    public String visitFunctionExpr(IMCLParser.FunctionExprContext ctx)
    {
        ASTNode astNode = new ASTNode();

        astNode.sliceCode = ctx.getText();
        astNode.label = "FunctionExpr";

        // 求 REF
        for (int i = 2; i < ctx.getChildCount() - 1;)
        {
            astNode.REF.add(ctx.getChild(i).getText());       // functionExpr里的变量，实数都作为REF
            i += 2;
        }
        // 求 DEF (无)

        subASTNode = astNode;
        return "";
    }

    @Override
    public String visitVarAtom(IMCLParser.VarAtomContext ctx)
    {
        return ctx.getText();
    }


    @Override
    public String visitValueAtom(IMCLParser.ValueAtomContext ctx)
    {
        return ctx.getText();
    }



    @Override
    public String visitChannel(IMCLParser.ChannelContext ctx)
    {
        // TODO
        return "";
    }

    @Override
    public String visitConstraintDefine(IMCLParser.ConstraintDefineContext ctx)
    {
        Set<String> set = new HashSet<>();
        for (int i = 1; i < ctx.varAtom().size(); ++i)
        {
            set.add(ctx.varAtom(i).getText());
        }
        constraintMap.put(ctx.varAtom(0).getText(), set);
        capacityCU.add(ctx.varAtom(0).getText());

        return "";
    }

    public static Map<String, ASTNode> genAST(String fileName) throws IOException {
        // antlr 4.6读文件方式
        // ANTLRInputStream input = nutStream(codes);

        CharStream input = CharStreams.fromFileName(fileName);


        IMCLLexer imclLexer = new IMCLLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(imclLexer);
//tokens.fill();

        IMCLParser parser = new IMCLParser(tokens);

        ParseTree tree = parser.languageIMCL();

        AST ast = new AST();

        ast.visit(tree);

        return mapASTs;
    }


    public static void main(String[] args) throws IOException
    {

        long startTime=System.currentTimeMillis();


        // 解析语法文件
        String fileName = "resources/input.imc";
        AST parser = new AST();
        Map<String, ASTNode> ast = parser.genAST(fileName);


        long midTime=System.currentTimeMillis();

        System.out.println("ast.sixe() : " + ast.size());
        for (String key : ast.keySet())
        {
            System.out.println("\n- - - - - -\n");
            ASTNode node = ast.get(key);
            printTree(node);
        }

        // RESOURCE
        System.out.println("RESOUECE:");
        for (String str : SensorsSet)
        {
            System.out.println('\t' + str);
        }

        // DEVICE
        System.out.println("DEVICE:");
        for (String str : DeviceSet)
        {
            System.out.println('\t' + str);
        }
        long endTime=System.currentTimeMillis();


        // process vars
        System.out.println("Process Vars:");
        for (String s : mapVars.keySet())
        {
            System.out.println(mapVars.get(s).toString());
        }

        // constraint
        System.out.println("Constraints");
        for (String s : constraintMap.keySet())
        {
            System.out.println(s + "\t: " + constraintMap.get(s).toString());
        }

        System.out.println("StartTime (ms): " + startTime);
        System.out.println("MidTime   (ms): " + midTime);
        System.out.println("The time GenAST (ms): " + (midTime - startTime));
        System.out.println("EndTime   (ms): " + endTime);
        System.out.println("The time Print  (ms): " + (endTime - midTime));
    }
}



/**

    Pattern pattern = Pattern.compile("[-]?(([0-9]+[.])?[0-9]+)");
    for (int i = 0; i < ctx.conditionExpr().varAtom().size(); ++i)
    {
        String tmp = ctx.conditionExpr().varAtom(i).getText();
        Matcher matcher = pattern.matcher(tmp);
        // System.out.println(tmp + " " + (matcher.matches() ? "是数字" : "不是数字"));
        if (! matcher.matches() && ! matcher.equals("TRUE") && ! matcher.equals("FALSE"))  // 不是字符串，也不是数字
        {
            ASTNode.REF.add(tmp);
        }
    }
 */