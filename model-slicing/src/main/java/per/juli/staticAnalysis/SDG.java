package per.juli.staticAnalysis;

import java.util.*;

/**
 * Created by juli on 2017/3/6.
 */
public class SDG
{
    public static List<Statement> SDGraphList = new ArrayList<>();

    public static Map<String, Set<Integer>> InterSDG = new HashMap<>();    // 用来记录程序块之间的映射：<"main:function1", {1, 3, 4}>


    public SDG()
    {
        this.SDGraphList = new ArrayList<>();

    }

    public SDG (SDG sfg)
    {
        this.SDGraphList = new ArrayList<>();
        for (Statement statement : sfg.SDGraphList)
        {
            this.SDGraphList.add(new Statement(statement));
        }
    }


    public static void printSDG(List<Statement> graphList)
    {
        for (Statement statement : graphList)
        {
            String out = "";

            out += "line: " + Integer.toString(statement.lineNumber) + "\tlevel: " + Integer.toString(statement.level) + "\t";

            out += "\t\t\t";
            for (int i = 0; i < statement.level; ++i)
            {
                out += "\t";
            }

            out += statement.sliceCode;
            out +="\t-->\t";
            out += statement.label;
            out += "\n";

            out += "DEF / REF :\t";
            out += statement.DEF.toString();
            out += statement.REF.toString();
            out += "\n";

            out += "CFGNexts :\t";
            out += statement.CFGNexts.toString();
            out += "\n";

            out += "CFGBefores :\t";
            out += statement.CFGBefores.toString();
            out += "\n";

            out += "DFGNexts :\t";
            out += statement.DFGNexts.toString();
            out += "\n";

            out += "DFGBefores :\t";
            out += statement.DFGBefores.toString();
            out += "\n";

            System.out.println(out);
        }
    }




    public static Map<String, Set<Integer>> combinedPDGs(Map<String, List<Statement>> mapPDGs)
    {
        /** 放在后续合并两个程序块时候 */
//        // 修改每个list的第一行，即把有返回值的程序块，标记出来放到第一行。
//        for (String key : mapPDGs.keySet())
//        {
//            List<Statement> pdgList = mapPDGs.get(key);
//            List<Integer> CFGNexts = pdgList.get(0).CFGNexts;
//
//            int line = CFGNexts.get(CFGNexts.size() - 1);
//            if (pdgList.get(line).label.equals("RETURN"))
//            {
//                pdgList.get(0).DEF.addAll(pdgList.get(line).DEF);
//                System.out.println("含有Return的程序: " + pdgList.get(0).sliceCode);
//                System.out.println("含有Return代码  : " + pdgList.get(line).sliceCode);
//            }
//        }


        // 在程序块中找调用其他程序块的行数。   // Map : <from_to, {...}>
        Set<String> names = mapPDGs.keySet();
        for (String from : names)
        {
            List<Statement> interList = mapPDGs.get(from);

            for (int i = 0; i < interList.size(); ++i)
            {
                if (interList.get(i).label.equals("AssignFunction"))
                {
                    String to = interList.get(i).sliceCode;
                    String[] str = to.split(":=");
                    if (str.length > 1)
                    {
                        to = str[1].split("\\(")[0];
                    }
                    else
                    {
                        to = str[0].split("\\(")[0];
                    }


                    if (names.contains(to))
                    {
                        if (InterSDG.keySet().contains(from + "-" +to))
                        {
                            InterSDG.get(from + "-" +to).add(i);
                        }
                        else
                        {
                            Set<Integer> set = new HashSet<>();
                            set.add(i);
                            InterSDG.put(from + "-" +to, set);
                        }

                    }
                }
            }

        }

        return InterSDG;
    }

}
