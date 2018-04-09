package per.juli.utils;

import per.juli.staticAnalysis.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by juli on 2017/3/7.
 */
public class Graphviz
{

    public static void transformSDGToDot(Map<String, List<Statement>> mapSDG, Map<String, Set<Integer>> mapInters)
    {
        StringBuffer graphvizCode = new StringBuffer();
        graphvizCode.append("digraph G");
        graphvizCode.append("\n{");
//        graphvizCode.append("size = \"15, 8\"");

        // 绘制PDGS图，后续再绘制程序间关系，最终形成一个SDG
        for (String name : mapSDG.keySet())
        {
            List<Statement> graphList = mapSDG.get(name);
            for (int i = 0; i < graphList.size(); ++i)
            {
                List<Integer> CFGNexts = graphList.get(i).CFGNexts;
                for (int k : CFGNexts)
                {

                    graphvizCode.append("\n\"Statement " + Integer.toString(i) + ": " + graphList.get(i).sliceCode
                            + "\"->\"Statement " + Integer.toString(k) + ": " + graphList.get(k).sliceCode + "\"");
                }
            }
            for (int i = 0; i < graphList.size(); ++i)
            {
                Set<Integer> DFGNexts = graphList.get(i).DFGNexts;
                for (int k : DFGNexts)
                {
                    graphvizCode.append("\n\"Statement " + Integer.toString(i) + ": " + graphList.get(i).sliceCode
                            + "\"->\"Statement " + Integer.toString(k) + ": " + graphList.get(k).sliceCode + "\"[style=dotted]");
                }
            }
        }

        // 绘制程序间的依赖关系
        for (String keyname : mapInters.keySet() )
        {
            String from = keyname.split("-")[0];
            String to = keyname.split("-")[1];

            List<Statement> graphListFrom = mapSDG.get(from);

            Set<Integer> inters = mapInters.get(keyname);

            System.out.println("inters : " + inters.toString());
            System.out.println("graphListFrom : " + graphListFrom.size());

            List<Statement> graphListTo = mapSDG.get(to);

            for (int i : inters)
            {
                // 添加from程序块点 i 的子点
                String fromCode = graphListFrom.get(i).sliceCode;
                List<String> fromREF = new ArrayList<>();
                List<String> fromDEF = new ArrayList<>();


                String[] tmp = fromCode.split(":=");    // eg:   (x, y :=)? check(a, 1);
                if (tmp.length == 1) // eg:  check(a, 1);
                {
                    // fromDEF 为空， fromREF为括号里内容
                    String[] fromSplit = tmp[0].substring(tmp[0].indexOf("(") + 1, tmp[0].indexOf(")")).split(",");
                    for (String var : fromSplit)
                    {
                        fromREF.add(var);
                    }
                }
                else        // eg:   x, y := check(a, 1);
                {
                    // fromREF为括号里内容
                    String[] fromREFsplit = tmp[1].substring(tmp[1].indexOf("(") + 1, tmp[1].indexOf(")")).split(",");
                    for (String var : fromREFsplit)
                    {
                        fromREF.add(var);
                    }
                    // fromDEF为":="左边内容
                    String[] fromDEFsplit = tmp[0].split(",");
                    for (String var : fromDEFsplit)
                    {
                        fromDEF.add(var);
                    }
                }


                // 添加to程序块 始节点 的子点
                String toCode = graphListTo.get(0).sliceCode;
                List<String> toREF = new ArrayList<>();
                List<String> toDEF = new ArrayList<>();

                String[] toREFsplit = toCode.substring(toCode.indexOf(":") + 1, toCode.indexOf(")")).split(",");
                for (String var : toREFsplit)
                {
                    toREF.add(var);
                }

                List<Integer> CFGNexts = graphListTo.get(0).CFGNexts;

                int Statement = CFGNexts.get(CFGNexts.size() - 1);
                if (graphListTo.get(Statement).label.equals("RETURN"))
                {
                    toDEF.addAll(graphListTo.get(Statement).REF);
                    System.out.println("含有Return的程序: " + graphListTo.get(0).sliceCode + " - " + graphListTo.get(Statement).sliceCode);
                }

                // 连接两者的子点
                System.out.println("程序间关系 REF：" + fromREF.toString() + " - " + toREF.toString());
                System.out.println("程序间关系 DEF：" + fromDEF.toString() + " - " + toDEF.toString());
                if (fromREF.size() == toREF.size() && fromDEF.size() == toDEF.size())
                {
                    System.out.println("程序间关系解析正常。");
                }

                // from 绘制子点
                for (String sub : fromREF)
                {
                    String tmpgraphviz = "\n\"Statement " + Integer.toString(i) + ": " + graphListFrom.get(i).sliceCode
                            + "\"->\"Statement " + Integer.toString(i) + " [Out]: " + sub + "\"";
                    if (graphvizCode.indexOf(tmpgraphviz) < 0)
                    {
                        graphvizCode.append(tmpgraphviz);
                    }

                }
                for (String sub : fromDEF)
                {
                    String tmpgraphviz = "\n\"Statement " + Integer.toString(i) + ": " + graphListFrom.get(i).sliceCode
                            + "\"->\"Statement " + Integer.toString(i) + " [In]: " + sub + "\"";
                    if (graphvizCode.indexOf(tmpgraphviz) < 0)
                    {
                        graphvizCode.append(tmpgraphviz);
                    }
                }

                // to 绘制子点
                for (String sub : toREF)
                {
                    String tmpgraphviz = "\n\"Statement " + Integer.toString(0) + ": " + graphListTo.get(0).sliceCode
                            + "\"->\"Statement " + Integer.toString(0) + " [In]: " + sub + "\"";
                    if (graphvizCode.indexOf(tmpgraphviz) < 0)
                    {
                        graphvizCode.append(tmpgraphviz);
                    }
                }
                for (String sub : toDEF)
                {
                    String tmpgraphviz = "\n\"Statement " + Integer.toString(0) + ": " + graphListTo.get(0).sliceCode
                            + "\"->\"Statement " + Integer.toString(0) + " [Out]: " + sub + "\"";
                    if (graphvizCode.indexOf(tmpgraphviz) < 0)
                    {
                        graphvizCode.append(tmpgraphviz);
                    }
                }

                // 绘制 from -> to
                System.out.println("from - to " + fromREF.size() + " - " + toREF.size());
                for (int k = 0; k < fromREF.size(); ++k)
                {
                    graphvizCode.append("\n\"Statement " + Integer.toString(i) + " [Out]: " + fromREF.get(k) +
                            "\"->\"Statement " + Integer.toString(0) + " [In]: " + toREF.get(k) + "\"[style=dotted]");
                }

                System.out.println("from - to " + fromDEF.size() + " - " + toDEF.size());
                for (int k = 0; k < fromDEF.size(); ++k)
                {
                    graphvizCode.append("\n\"Statement " + Integer.toString(0) + " [Out]: "+ toDEF.get(k) +
                            "\"->\"Statement " + Integer.toString(i) + " [In]: "  + fromDEF.get(k) + "\"[style=dotted]");
                }

            }
        }


        graphvizCode.append("\n}");

        StreamFile.writeFile(graphvizCode.toString(), ("resources/dot/SDG.dot"));

    }


    public static void transformPDGToDot(List<Statement> graphList, String processname)
    {
        StringBuffer graphvizCode  = new StringBuffer();
        graphvizCode.append("digraph G");
        graphvizCode.append("\n{");


        for (int i = 0; i < graphList.size(); ++i)
        {
            List<Integer> CFGNexts = graphList.get(i).CFGNexts;
            for (int k : CFGNexts)
            {

                graphvizCode.append("\n\"Statement " + Integer.toString(i) + ": " + graphList.get(i).sliceCode
                        + "\"->\"Statement " + Integer.toString(k) + ": " + graphList.get(k).sliceCode + "\"");
            }
        }

        for (int i = 0; i < graphList.size(); ++i)
        {
            Set<Integer> DFGNexts = graphList.get(i).DFGNexts;
            for (int k : DFGNexts)
            {
                graphvizCode.append("\n\"Statement " + Integer.toString(i) + ": " + graphList.get(i).sliceCode
                        + "\"->\"Statement " + Integer.toString(k) + ": " + graphList.get(k).sliceCode + "\"[style=dotted]");
            }
        }

        graphvizCode.append("\n}");

        StreamFile.writeFile(graphvizCode.toString(), ("resources/dot/" + processname + ".dot"));
    }

}


/**

dot -Tpng sorting.dot -o sorting.png
open sorting.png

dot -Tpng checkProduct.dot -o checkProduct.png
open checkProduct.png

dot -Tpng SDG.dot -o SDG.png
open SDG.png

 * */