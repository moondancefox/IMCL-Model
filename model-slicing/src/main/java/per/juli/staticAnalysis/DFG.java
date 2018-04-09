package per.juli.staticAnalysis;

import java.util.*;

/**
 * Created by juli on 2017/3/12.
 */
public class DFG
{

    public static List<Statement> DFGraphList = new ArrayList<>();


    public DFG()
    {
        this.DFGraphList = new ArrayList<>();

    }

    public DFG (DFG dfg)
    {
        this.DFGraphList = new ArrayList<>();
        for (Statement statement : dfg.DFGraphList)
        {
            this.DFGraphList.add(new Statement(statement));
        }

    }



    public static void printDFG(List<Statement> graphList)
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


    public static Set<Integer> analyzeIfDD(Set<Integer> baseSet, int if_line, String var)
    {
        List<Integer> listIf = new ArrayList<>();
        listIf.add(if_line);

        while (true)
        {
            List<Integer> nexts = DFGraphList.get(if_line).CFGNexts;

            if_line = nexts.get(nexts.size() - 1);

            String tmplabel = DFGraphList.get(if_line).label;
            if (tmplabel.equals("ELSIF")  || tmplabel.equals("ELSE"))
            {
                listIf.add(nexts.get(nexts.size() - 1));
            }
            else
            {
                break;
            }
        }

        Set<Integer> newSet = new HashSet<>();

        for (int subif  : listIf)
        {
            for (int base : baseSet)    // 求 IF、ELSIF、ELSE 的依赖
            {
                if (DFGraphList.get(subif).REF.contains(var))
                {
                    DFGraphList.get(base).DFGNexts.add(subif);
                }
            }
            newSet.addAll(analyzeDD(baseSet, subif, var));
        }

        return newSet;
    }

    public static List<Integer> computeIfStruct(int if_line)
    {
        List<Integer> listIf = new ArrayList<>();
        listIf.add(if_line);
        while (true)
        {
            List<Integer> nexts = DFGraphList.get(if_line).CFGNexts;
            if_line = nexts.get(nexts.size() - 1);
            String tmplabel = DFGraphList.get(if_line).label;
            if (tmplabel.equals("ELSIF")  || tmplabel.equals("ELSE"))
            {
                listIf.add(nexts.get(nexts.size() - 1));
            }
            else
            {
                break;
            }
        }
        return listIf;
    }


    public static Set<Integer> analyzeWhileDD(Set<Integer> baseSet, int while_line, String var)
    {
        for (int base : baseSet)    // 求 IF、ELSIF、ELSE 的依赖
        {
            if (DFGraphList.get(while_line).REF.contains(var))
            {
                DFGraphList.get(base).DFGNexts.add(while_line);
            }
        }
        Set<Integer> newSet = new HashSet<>();
        newSet.addAll(analyzeDD(baseSet, while_line, var));
        for (int base : baseSet)
        {
            if (DFGraphList.get(while_line).REF.contains(var))
            {
                DFGraphList.get(base).DFGNexts.add(while_line);
            }
        }

        return newSet;
    }



    public static List<Integer> analyzeTriggerStruct(int trigger_line, int current)
    {
        List<Integer> listTrigger = new ArrayList<>();


        List<Integer> nexts = DFGraphList.get(current).CFGNexts;
        for (int i = trigger_line; i <  nexts.size(); ++i)
        {
            if (DFGraphList.get(nexts.get(i)).label.equals("TRIGGER"))
            {
                listTrigger.add(nexts.get(i));
            }
            else
            {
                break;
            }
        }

        return listTrigger;
    }

    /**
     数据依赖实现算法:
     @ base : 是表示变量当前所定位的行号
     @ current : 是表示当前待判定的节点号
     @ var : 是表示当前求解的变量
     */

    public static Set<Integer> analyzeDD(Set<Integer> baseSet, int current, String var)
    {
        List<Integer> currentNexts = DFGraphList.get(current).CFGNexts;

        for (int i = 0; i < currentNexts.size(); ++i)
        {
//            System.out.println("current Label: " + DFGraphList.get(index).label);

            int index = currentNexts.get(i);
            Statement statement = DFGraphList.get(index);

            if (statement.label.equals("VarDefine") || statement.label.equals("AssignVariable")
                    || statement.label.equals("AssignFunction") || statement.label.equals("AssignInvoke")
                    || statement.label.equals("RETURN") || statement.label.equals("STOP"))
            {
                Set<Integer> newSet = new HashSet<>();
                for (int base : baseSet)
                {
                    // ----------
                    // System.out.println(DFGraphList.get(index).REF.toString() + " 包含 " + var + " ?");
                    // System.out.println("var >>> " + statement.REF.contains(var));
                    // -----------

                    if (DFGraphList.get(index).REF.contains(var))
                    {
//                        System.out.println("...");
                        DFGraphList.get(base).DFGNexts.add(index);
                    }

                    if (DFGraphList.get(index).DEF.contains(var))
                    {
                        newSet.add(index);
                    }
                    else
                    {
                        newSet.add(base);
                    }
                }
                baseSet = newSet;
            }
            else if (statement.label.equals("IF"))
            {
                List<Integer> listIf  = computeIfStruct(index);

                Set<Integer> newSet = new HashSet<>();

                for (int subif  : listIf)
                {
                    for (int base : baseSet)    // 求 IF、ELSIF、ELSE 的依赖
                    {
                        if (DFGraphList.get(subif).REF.contains(var))
                        {
                            DFGraphList.get(base).DFGNexts.add(subif);

                        }
                    }
                    newSet.addAll(analyzeDD(baseSet, subif, var));
                }
                baseSet = newSet;

//                baseSet = analyzeIfDD(baseSet, index, var);

            }

            else if (statement.label.equals("ELSIF") || statement.label.equals("ELSE"))
            {
                continue;
            }

            else if (statement.label.equals("WHILE"))
            {
                for (int base : baseSet)    // 求 IF、ELSIF、ELSE 的依赖
                {
                    if (DFGraphList.get(index).REF.contains(var))
                    {
                        DFGraphList.get(base).DFGNexts.add(index);
                    }
                }
                Set<Integer> newSet = new HashSet<>();
                newSet.addAll(analyzeDD(baseSet, index, var));
                baseSet = newSet;
                for (int base : baseSet)
                {
                    if (DFGraphList.get(index).REF.contains(var))
                    {
                        DFGraphList.get(base).DFGNexts.add(index);
                    }
                }
//                baseSet = analyzeWhileDD(baseSet, index, var);

            }
            else if (statement.label.equals("TRIGGER"))
            {
                Map<Integer, Set<Integer>> mapTriggerBaseSet = new HashMap<>();

                List<Integer> listTrigger = analyzeTriggerStruct(i, current);
//                System.out.println("listTrigger == " + listTrigger.toString());

                for (int subTrigger : listTrigger)
                {
                    Set<Integer> newSet = new HashSet<>();
                    for (int base : baseSet)
                    {
                        if (DFGraphList.get(subTrigger).REF.contains(var))
                        {
                            DFGraphList.get(base).DFGNexts.add(subTrigger);
                        }
                    }
                    newSet = (analyzeDD(baseSet, subTrigger, var));
                    mapTriggerBaseSet.put(subTrigger, newSet);
                }

                // 求 TRIGGER 之间的相互影响；
                for (int tmpTrigger : mapTriggerBaseSet.keySet())
                {
                    Set<Integer> tmpBase = mapTriggerBaseSet.get(tmpTrigger);
                    for (int tmpTrigger2 : mapTriggerBaseSet.keySet())
                    {
                        analyzeDD(tmpBase, tmpTrigger2, var);
                    }

                }

                // 实际上，在program，即main函数中，全是TRIGGER事件。 所以 i 其实是可以直接结束
                i += listTrigger.size() - 1;
            }
            else
            {
                continue;
            }

        }

        return new HashSet<>(baseSet);

    }



    // 从 CFG 和相关变量，计算出 数据依赖，生成 DFG
    public List<Statement> getDFGbaseCFGandVars(List<Statement> cfgList, Set<String> vars)
    {
        // 将 DFGraphList 初始化
        DFGraphList = new ArrayList<>();

        for (Statement statement : cfgList)
        {
            DFGraphList.add(new Statement(statement));
        }

        // TODO: 在 DFGraohList 基础上添加数据流依赖关系
//        System.out.println("VARs :\t" + vars.toString() + "\n");

        for (String var : vars)
        {
            Set<Integer> baseSet = new HashSet<>();
            baseSet.add(0);
            analyzeDD(baseSet, 0, var);
        }

        getBefores();

        return DFGraphList;
    }


    // 获取 DFGraphList 的 CFGBefores 和 DFGBefores
    public void getBefores()
    {
        for (int i = 0; i < DFGraphList.size(); ++i)
        {
            List<Integer> CFGNexts = DFGraphList.get(i).CFGNexts;
            for (int j : CFGNexts)
            {
                DFGraphList.get(j).CFGBefores.add(i);
            }
        }

        for (int i = 0; i < DFGraphList.size(); ++i)
        {
            Set<Integer> DFGNexts = DFGraphList.get(i).DFGNexts;
            for (int j : DFGNexts)
            {
                DFGraphList.get(j).DFGBefores.add(i);
            }
        }
    }

}
