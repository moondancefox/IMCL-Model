package per.juli.cooperation;

import per.juli.codegeneration.PowePC;
import per.juli.staticAnalysis.*;


import java.util.*;

/**
 * Created by juli on 2017/2/23.
 */
public class DecomposeNtoN
{

    public static int channelCDMessage = 1;


    public static Map<String, List<Statement>>  mapDFGs;
    public static AST ast;

    public static List<Statement> mainGraphList;

    public DecomposeNtoN()
    {
        this.channelCDMessage = 1;
        this.mapDFGs = new HashMap<>();
        this.ast = new AST();
        this.mainGraphList = new ArrayList<>();
    }


    // 毕业设计做模型分解与协作用的
    public static void print(Map<String, List<DecomposeStruct>> mapDecompose)
    {
        for (String key : mapDecompose.keySet())
        {
            System.out.println("key == " + key);
            System.out.print("line:00\tlevel:1tcode:\t");
            System.out.println("program:" + key + "()[]");
            List<DecomposeStruct> decomposeStructList = mapDecompose.get(key);
            for (DecomposeStruct decompose : decomposeStructList)
            {
                String kong = "\t";
                for (int i = 0; i < decompose.level; ++i)
                {
                    kong += "\t";
                }
                System.out.print("line:" + decompose.lineInSDG + "\tlevel:" + decompose.level + "\tcode:");
                System.out.println(kong + decompose.code);
            }
        }
    }


    // 做代码生成的时候用的
    public static List<String> outCode2GenList = new ArrayList<>();     //生成的多个子模型代码作为接下去代码生成的输入数据
    public static List<String> outCode2Gen(Map<String, List<DecomposeStruct>> mapDecompose)      // 输出带花括号的标准子模型代码 (层级多的时候新问题...)
    {

        outCode2GenList = new ArrayList<>();
        for (String key : mapDecompose.keySet())
        {
            System.out.println("---------------------  key == " + key);
            String codesInKey = "";
            //System.out.print("line:00\tlevel:1tcode:\t");
            System.out.println("program:" + key + "()[]");
            codesInKey += ("program:" + key + "()[]");
            Stack<Integer> levelStack = new Stack<>();    // levelStack 记录目前缩进的累计级别个数，相当于入栈
            levelStack.push(0);    // 初始的第一个是0，即program对应的一行
            List<DecomposeStruct> decomposeStructList = mapDecompose.get(key);
            for (DecomposeStruct decompose : decomposeStructList)
            {
                int currentLevel = decompose.level;
                String kong = "";
                for (int i = 0; i < levelStack.peek(); ++i)
                {
                    kong += "\t";
                }
                if (currentLevel < levelStack.peek())
                {
                    while (currentLevel < levelStack.peek())
                    {
                        kong = "";
                        for (int i = 0; i < levelStack.peek(); ++i)
                        {
                            kong += "\t";
                        }
                        //System.out.print("line:右\tlevel:" + levelStack.peek() + "\tcode:");
                        System.out.println(kong + "}");
                        codesInKey += (kong + "}");
                        levelStack.pop();
                    }

                }
                else if (currentLevel > levelStack.peek())
                {
                    //System.out.print("line:左\tlevel:" + levelStack.peek() + "\tcode:");
                    System.out.println(kong + "{");
                    codesInKey += (kong + "{");
                    levelStack.push(currentLevel);
                }

                kong += "\t";
                //System.out.print("line:" + decompose.lineInSDG + "\tlevel:" + currentLevel + "\tcode:");
                System.out.println(kong +  decompose.code);
                codesInKey += (kong + decompose.code);

            }

            while (levelStack.peek() > 0)
            {
                String kong = "";
                for (int i = 0; i < levelStack.peek(); ++i)
                {
                    kong += "\t";
                }
                //System.out.print("line:右\tlevel:" + levelStack.peek() + "\tcode:");
                System.out.println(kong +  "}");
                codesInKey += (kong + "}");
                levelStack.pop();
            }


            try
            {
                System.out.println("codesInKey = " + codesInKey);
                outCode2GenList.add(codesInKey);

            }
            catch (Exception e)
            {
                System.out.println("代码生成的输入样本有错误！");
            }

        }

        return  outCode2GenList;
    }



    // 为下一个算法运行做环境计算准备
    public  void decomposeModelNtoN(AST ast, Map<String, List<Statement>> mapDFGs)
    {
        this.channelCDMessage = 1;
        this.ast = ast;
        this.mapDFGs = mapDFGs;
        this.mainGraphList = mapDFGs.get(ast.mainProgram);

        /**
         constraint : A { PATHSET, pathSensor};
         constraint : B { SREAD1, SWRITE1, sensor1};
         constraint : C { SREAD2, SWRITE2, sensor2};
         constraint : D { SORTSET, SCANNER, sortSensor};
         */

        // 判断给定constraint是否包括所有资源信息，即: ast.constraint |= (ast.SensorsSet, ast.DeviceSet)

        Map<String, Set<String>> constraintMap = ast.constraintMap; // 从ast.constraintMap 提取所有的资源 constraintSet
        Set<String> constraintSet = new HashSet<>();
        for (String cu : constraintMap.keySet())
        {
            constraintSet.addAll(constraintMap.get(cu));
        }


        Map<String, Set<String>> mapResToCUs = new HashMap<>();    // 每个资源可以被使用的cu集合。eg.. <'Sensor1', {A, B, C}>
        for (String sensor : ast.SensorsSet)
        {
            if (! constraintSet.contains(sensor))
            {
                System.out.println("资源约束缺少资源：" + sensor + "，不能分解");
                return;
            }

            Set<String> initSet = new HashSet<>();
            mapResToCUs.put(sensor, initSet);
        }

        for (String device : ast.DeviceSet)
        {
            if (! constraintSet.contains(device))
            {
                System.out.println("资源约束缺少资源：" + device + "，不能分解");
                return;
            }
            Set<String> initSet = new HashSet<>();
            mapResToCUs.put(device, initSet);
        }

        for (String cu : constraintMap.keySet())
        {
            Set<String> resSet  = constraintMap.get(cu);
            for (String res : resSet)
            {
                mapResToCUs.get(res).add(cu);
            }
        }


        // TODO: 将资源mapResToCUs重新分配（排列组合，保证每个资源只有一个处理器控制）(该算法，待做)
        List<Map<String, String>> listMapResToCU = new ArrayList<>();
        Map<String, String> initMap = new HashMap<>(); // map关系是：<res, cu>
        listMapResToCU.add(initMap);


        System.out.println("mapResToCUs.keySet()：" + mapResToCUs.keySet().toString());
        for (String res :  mapResToCUs.keySet())
        {
            Set<String> setCUs = mapResToCUs.get(res);   // 每个资源对应多个CU

            System.out.println("res " + res + "\t:setCUs = " + setCUs.toString());

            List<Map<String, String>> newlistMap = new ArrayList<>();   // 记录每个res对应多个CU时产生的分配
            for (String cu : setCUs)
            {
                for (Map<String, String> map : listMapResToCU)
                {
                    Map<String, String> newMap = new HashMap<>(map);
                    newMap.put(res, cu);
                    newlistMap.add(newMap);
                }
            }
            listMapResToCU = newlistMap;
        }

//        System.out.println("分配情况：");
//        for (int i = 0; i < listMapResToCU.size(); ++i)
//        {
//            System.out.println("-----: " + i);
//            Map<String, String> map = listMapResToCU.get(i);
//            for (String str : map.keySet())
//            {
//                System.out.println(str + " - " + map.get(str));
//            }
//        }

        List<Map<String, List<DecomposeStruct>>> listMapDecompose = new ArrayList<>();      // listMapDecompose存放所有的实验结果
        for (int i = 0; i < listMapResToCU.size(); ++i)     // 考虑不同分解可能的情况
        {
            channelCDMessage = 1;

            Map<String, String> resToCU = listMapResToCU.get(i);

            System.out.println("\n----------------\nSolution: ****************************************************************************");
            System.out.println("分配情况：");
            System.out.println("-----: " + i);
            for (String str : resToCU.keySet())
            {
                System.out.println(str + " - " + resToCU.get(str));
            }

            listMapDecompose.add(algorithmNtoN(resToCU, ast.mainProgram));
        }

    }

    /**
     mapDFGs: 系统控制图
     mainProgram: 名字
     resToCU: 例如：resToCU.put("sensor2", "B");
     capacityCU: 例如：["A","B"]
     */
    public static Map<String, List<DecomposeStruct>> mapDecompose = new HashMap<>();    // 存放单个方案的结果
    public static Map<String, List<DecomposeStruct>> algorithmNtoN(Map<String, String> resToCU, String mainProgram)
    {
        // N-N 算法
        // 根据资源约束，对main程序进行初步插桩
        List<Statement> mainGraphList = new ArrayList<>(mapDFGs.get(mainProgram));
        List<String> pileMainList = new ArrayList<>();
        // （1) 对main程序进行初步插，并根据插桩资源点的数据依赖关系扩充插桩（即DEF）
        for (int i = 0; i < mainGraphList.size(); ++i)
        {
            pileMainList.add("/");
            for (String res : resToCU.keySet())
            {
                if (mainGraphList.get(i).REF.contains(res) || mainGraphList.get(i).DEF.contains(res))
                {
                    pileMainList.set(i, resToCU.get(res));
                }
            }
        }

        pileMainList.set(0, ast.capacityCU.get(0));
        // 扩充插桩, 根据数据依赖关系，使用向前切片
        for (int i = 0; i < mainGraphList.size(); ++i)
        {
            for (int k : mainGraphList.get(i).DFGBefores)
            {
                // 如果向前数据依赖的节点没有被标记处理器信息
                if (pileMainList.get(k).equals("/"))
                {
                    pileMainList.set(k, pileMainList.get(i));
                }
            }
        }
        System.out.println("pileList 1 = " + pileMainList.toString());
        // 在pileList对程序的所有节点插桩
        pileSD(0, pileMainList, mainGraphList);
        System.out.println("pileList 2 = " + pileMainList.toString());

        for (String  cu : ast.capacityCU)
        {
            System.out.print(cu + ": ");
            for(int f = 1; f < pileMainList.size(); ++f)
            {
                if (pileMainList.get(f).equals(cu))
                {
                    System.out.print(f + ",");
                }
            }
            System.out.print("\n");
        }

        mapDecompose = new HashMap<>();
        for (String cu : ast.capacityCU)
        {
            List<DecomposeStruct> decompose = new ArrayList<>();
            mapDecompose.put(cu, decompose);
        }
        decomposeProgramNtoN(0, mapDecompose, pileMainList);


        Cooperation cooperation = new Cooperation();
        mapDecompose = cooperation.cooperationProgram(mapDecompose, mapDFGs, mainProgram, pileMainList);        // 在mapDecompose基础上添加数据依赖的内容

        System.out.println("数据控制协作通信个数：" + (channelCDMessage - 1));
        System.out.println("数据依赖协作通信个数：" + (cooperation.channelDDMessage - 1));
        System.out.println("数据共享协作通信个数：" + (cooperation.syncMessage - 1));

        print(mapDecompose);
        return  mapDecompose;
    }


    public static Map<String, List<DecomposeStruct>> decomposeProgramNtoN
            (int current, Map<String, List<DecomposeStruct>> mapDecompose, List<String> pileList)
    {
        Map<String, List<DecomposeStruct>> subMapDecompose = new HashMap<>();   // 记录current所有子代码结构
        for (String cu : ast.capacityCU)
        {
            List<DecomposeStruct> decompose = new ArrayList<>();
            subMapDecompose.put(cu, decompose);
        }

        List<Integer> currentNexts = mainGraphList.get(current).CFGNexts;

        for (int i = 0; i < currentNexts.size(); ++i)
        {
            int index = currentNexts.get(i);

            Statement statement = mainGraphList.get(index);

            if (statement.label.equals("VarDefine") || statement.label.equals("AssignVariable")
                    || statement.label.equals("AssignFunction") || statement.label.equals("AssignInvoke")
                    || statement.label.equals("RETURN") || statement.label.equals("STOP"))
            {

                String assignPileCU = pileList.get(index);
                subMapDecompose.get(assignPileCU).add(new DecomposeStruct(index, mainGraphList.get(index).level, mainGraphList.get(index).sliceCode));

            }
            else if (statement.label.equals("WHILE"))
            {

            }
            else if (statement.label.equals("IF") )
            {
                List<Integer> listIf = computeIfStruct(mainGraphList, index);
                for (int subIf : listIf)
                {
                    String subIfPileCU = pileList.get(subIf);
                    subMapDecompose.get(subIfPileCU).add(
                            new DecomposeStruct(index, mainGraphList.get(subIf).level, mainGraphList.get(subIf).sliceCode));

                    Map<String, List<DecomposeStruct>> subIfDecompose = decomposeProgramNtoN(subIf, mapDecompose,  pileList);
                    for (String cu : subIfDecompose.keySet())
                    {
                        if (subIfDecompose.get(cu).size() == 0)
                        {
                            continue;
                        }

                        if (cu.equals(subIfPileCU))
                        {
                            subMapDecompose.get(cu).addAll(subIfDecompose.get(cu));
                        }
                        else
                        {

                            subMapDecompose.get(subIfPileCU).add(
                                    new DecomposeStruct(-2, mainGraphList.get(subIf).level + 1, "CHANNEL.CD.!" + Integer.toString(channelCDMessage) + ";"));

//                            mapDecompose.get(cu).add(0,
//                                    new DecomposeStruct(-1, 1, "TRIGGER(TRUE)"));
//                            mapDecompose.get(cu).add(1,
//                                    new DecomposeStruct(-2, 2, "// CHANNEL?" + Integer.toString(channelCDMessage)));
//                            mapDecompose.get(cu).addAll(2, subIfDecompose.get(cu));

                            mapDecompose.get(cu).add(0,
                                    new DecomposeStruct(-2, 1, "TRIGGER(CHANNEL.CD.?" + Integer.toString(channelCDMessage) + ")"));


                            mapDecompose.get(cu).addAll(1, subIfDecompose.get(cu));

                            channelCDMessage++;

                            // 处理分割到其他cu的子程序完成后同步

                            subMapDecompose.get(subIfPileCU).add(
                                    new DecomposeStruct(-2, mainGraphList.get(subIf).level + 1, "CHANNEL.CD.?" + Integer.toString(channelCDMessage) + ";"));
                            mapDecompose.get(cu).add(subIfDecompose.get(cu).size() + 1,         // TODO: ""subIfDecompose.get(cu).size() + 1""可能有问题
                                    new DecomposeStruct(-2, 2, "CHANNEL.CD.!" + Integer.toString(channelCDMessage)));
                            channelCDMessage++;
                        }
                    }
                }
            }
            else if (statement.label.equals("ELSIF") || statement.label.equals("ELSE"))
            {
                continue;
            }
            else if (statement.label.equals("TRIGGER"))
            {
                String triggerPileCU = pileList.get(index);    // 获取当前是A，B，C，D......
                mapDecompose.get(triggerPileCU).add(new DecomposeStruct(index, 1, mainGraphList.get(index).sliceCode));

                Map<String, List<DecomposeStruct>> triggerDecompose = decomposeProgramNtoN(index, mapDecompose, pileList);

                for (String cu : triggerDecompose.keySet())
                {
                    if (triggerDecompose.get(cu).size() == 0)
                    {
                        continue;
                    }

                    if (cu.equals(triggerPileCU))
                    {
                        subMapDecompose.get(triggerPileCU).addAll(triggerDecompose.get(cu));
                    }
                    else
                    {
                        subMapDecompose.get(triggerPileCU).add(0,
                                new DecomposeStruct(-2, 2, "CHANNEL.CD.!" + Integer.toString(channelCDMessage) + ";"));

//                        mapDecompose.get(cu).add(0,
//                                new DecomposeStruct(-1, 1, "TRIGGER(TRUE)"));
//                        mapDecompose.get(cu).add(1,
//                                new DecomposeStruct(-2, 2, "// CHANNEL?" + Integer.toString(channelCDMessage)));
//                        mapDecompose.get(cu).addAll(2, triggerDecompose.get(cu));

                        mapDecompose.get(cu).add(0,
                                new DecomposeStruct(-2, 1, "TRIGGER(CHANNEL.CD.?" + Integer.toString(channelCDMessage) + ")"));

                        mapDecompose.get(cu).addAll(1, triggerDecompose.get(cu));
                        channelCDMessage++;


//                        subMapDecompose.get(triggerPileCU).add(
//                                new DecomposeStruct(-2, 2, "--CHANNEL?" + Integer.toString(channelCDMessage)));
//                        mapDecompose.get(cu).add(
//                                new DecomposeStruct(-2, 2, "--CHANNEL!" + Integer.toString(channelCDMessage)));
//                        channelCDMessage++;
                    }
                }

//                channelCDMessage++;
                mapDecompose.get(triggerPileCU).addAll(subMapDecompose.get(triggerPileCU));


                subMapDecompose = new HashMap<>();   // 记录current所有子代码结构
                for (String cu : ast.capacityCU)
                {
                    List<DecomposeStruct> decompose = new ArrayList<>();
                    subMapDecompose.put(cu, decompose);
                }
            }
            else
            {

            }

        }


        return subMapDecompose;
    }


    public static List<Integer> computeIfStruct(List<Statement> mainGraphList, int if_line)
    {
        List<Integer> listIf = new ArrayList<>();
        listIf.add(if_line);
        while (true)
        {
            List<Integer> nexts = mainGraphList.get(if_line).CFGNexts;
            if_line = nexts.get(nexts.size() - 1);
            String tmplabel = mainGraphList.get(if_line).label;
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


    /**
     - 根据控制流向后插桩
     * var 表示当前节点所分配的处理器
     * current 表示当前节点
     * pileMainList 表示当前程序的插桩标记
     * mainGraphList 表示当前进程的图
     */
    public static void pileSD(int current, List<String> pileMainList, List<Statement> mainGraphList)
    {
        List<Integer> currentNexts = mainGraphList.get(current).CFGNexts;
        for (int next : currentNexts)
        {
            if (pileMainList.get(next).equals("/"))
            {
                pileMainList.set(next, pileMainList.get(current));
            }
            pileSD(next, pileMainList, mainGraphList);
        }
    }

    public static void main(String[] args)
    {

//        decomposeModel();

        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }
}
