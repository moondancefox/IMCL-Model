package per.juli.codegeneration;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import per.juli.parser.IMCLBaseVisitor;
import per.juli.parser.IMCLLexer;
import per.juli.parser.IMCLParser;


import java.io.IOException;
import java.util.*;


public class PowePC extends IMCLBaseVisitor<String>
{
    public static List<String> listGen = new ArrayList<>();     // 记录每个输入模型最终转换成的代码，以结构化文本的形式展示（以代码节点为单位进行翻译）

    public static Map<String, String> map = new HashMap<>();

    @Override
    public String visitLanguageIMCL(IMCLParser.LanguageIMCLContext ctx)
    {
        listGen = new ArrayList<>();
        System.out.println("\nStarting ... ");
        for (int i = 0; i < ctx.codeBody().size(); ++i)
        {
            //System.out.println("LanguageIMCL == " + ctx.codeBody().get(i).getText());
            visit(ctx.codeBody(i));
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
    public String visitProcessDefine(IMCLParser.ProcessDefineContext ctx)
    {
        // 求 每个process里的变量列表
        Set<String> processVariable = new HashSet<>();

        // varDefine最多有两个
        if (ctx.varDefine().size() == 2)
        {
            // 求 REF：被引用的变量列表
            visit(ctx.varDefine(0));
            visit(ctx.varDefine(1));
        }
        else if ( ctx.varDefine().size() == 1)
        {
            visit(ctx.varDefine(0));
        }

        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
        }

        return "";
    }



    @Override
    public String visitCodeBlock(IMCLParser.CodeBlockContext ctx)
    {
        return visit(ctx.getChild(0));
    }


    @Override
    public String visitTriggerDefine(IMCLParser.TriggerDefineContext ctx)
    {

        // 获取condition表达式的 REF 和 DEF；
        // 求REF
        visit(ctx.conditionExpr());

        // Trigger中没有DEF(无)

        for (int i = 0; i < ctx.codeBlock().size(); ++i)
        {
            visit(ctx.codeBlock(i));
        }

        return "";
    }


    @Override
    public String visitChannelDefine(IMCLParser.ChannelDefineContext ctx)
    {
        visit(ctx.channel());

        return "";
    }

    @Override public String visitVarDefine(IMCLParser.VarDefineContext ctx)
    {
        for (int i = 0; i < ctx.varAtom().size(); ++i)
        {
            ctx.varAtom(i).getText();
        }

        return "";
    }

    @Override
    public String visitAssignVariable(IMCLParser.AssignVariableContext ctx)
    {
        // 求 等式右边
        String right = ctx.conditionExpr().getText();
        // 求 等式左边
        String left = ctx.varAtom().getText();

        String _code = left + " = " + right + ";";
        System.out.println(_code);
        listGen.add(_code);
        return "";
    }

    @Override
    public String visitAssignInvoke(IMCLParser.AssignInvokeContext ctx)
    {
        // REF 和 DEF
        String left = ctx.getChild(0).getText();
        String right = ctx.getChild(2).getText();

        String _code = "";
        if (ctx.getChild(1).getText().endsWith(">>"))   // 判断是不是 "<<" 符号
        {
            _code = "print(" + left + ");";
        }
        listGen.add(_code);
        System.out.println(_code);
        return "";
    }

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

        if (ctx.getChild(0).getText().equals("CHANNEL.CD."))
        {
            if (ctx.getChild(1).getText().equals("!"))
            {

            }
            else // 接收消息 "?"
            {

            }
        }
        else
        {
            if (ctx.getChild(1).getText().equals("!"))  // 发送消息
            {
                String _code = "sentData (" + ctx.getChild(2).getText() + ", " + ctx.getChild(4).getText() + ");";
                listGen.add(_code);
                System.out.println(_code);
            }
            else // 接收消息 "?"
            {
                String _code = "revCallBack (" + ctx.getChild(2).getText() + ", " + ctx.getChild(4).getText() + ")";
                listGen.add(_code);
                System.out.println(_code);
            }
        }

        return "";
    }


    public static List<String> genCodePowerPCFromFile(String fileName) throws IOException
    {
        // antlr 4.6读文件方式
        // ANTLRInputStream input = nutStream(codes);

        CharStream input = CharStreams.fromFileName(fileName);
        // input = CharStreams.fromString("DEVICE: x, y, z, Scream;");
        IMCLLexer imclLexer = new IMCLLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(imclLexer);

        IMCLParser parser = new IMCLParser(tokens);

        ParseTree tree = parser.languageIMCL();

        PowePC power = new PowePC();

        power.visit(tree);

        return listGen;
    }


    public static List<String> genCodePowerPCFromString(String codeString) throws IOException
    {
        // antlr 4.6 读文件方式
        // ANTLRInputStream input = nutStream(codes);

        CharStream input = CharStreams.fromString(codeString);
        IMCLLexer imclLexer = new IMCLLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(imclLexer);

        IMCLParser parser = new IMCLParser(tokens);

        ParseTree tree = parser.languageIMCL();

        PowePC power = new PowePC();

        power.visit(tree);

        return listGen;
    }

    public static void main(String[] args) throws IOException
    {
        String fileName = "resources/stm32_powerpc.imc";

        //List<String> genedCodes = PowePC.genCodePowerPCFromFile(fileName);
        List<String> genedCodes = PowePC.genCodePowerPCFromString("SENSOR: pathSensor, sensor1, sensor2, sortSensor;");

        for (String code : genedCodes)
        {
            System.out.println("code");
        }
    }


}
