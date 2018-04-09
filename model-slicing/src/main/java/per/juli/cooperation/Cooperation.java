package per.juli.cooperation;

import per.juli.staticAnalysis.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by juli on 2017/3/16.
 */
public class Cooperation
{
    // 输入：(1) mapDecompose；
    // 输入：(2) DFG中的mainProgram对应的dfg

    public static int channelDDMessage = 1;
    public static int syncMessage = 1;

    public Cooperation()
    {
        this.channelDDMessage = 1;
        this.syncMessage = 1;
    }

    public static Map<String, List<DecomposeStruct>> cooperationProgram(Map<String, List<DecomposeStruct>> mapDecompose
            , Map<String, List<Statement>> mapDFGs, String mainProgram, List<String> pileList)
    {
        channelDDMessage = 1;
        syncMessage = 1;

        List<Statement> listDD = mapDFGs.get(mainProgram);

        // 求mapDecompose里多个计算单元执行程序的数据依赖关系
        for (String baseCU : mapDecompose.keySet())     // 当前待处理的CU
        {
            List<DecomposeStruct> listBaseCU = mapDecompose.get(baseCU);    // 当前待处理的CU的代码

            for (int i = 0; i < listBaseCU.size(); ++i)     // baseCU当前待验证的行代码：判断该行代码是否由向前的数据依赖
            {
                int baseLineInSDG = listBaseCU.get(i).lineInSDG;
                if (baseLineInSDG < 0)      //小于0表示非原始代码，而是添加的TRIGGER(TRUE), CHANNEL等
                {
                    continue;
                }
                Set<Integer> DFGbefores = listDD.get(baseLineInSDG).DFGBefores;
                if (DFGbefores.size() > 0)
                {

                    for (int before : DFGbefores)
                    {
                        boolean isDDInOtherCU = false;
                        boolean isSYNCInOtherCU = false;
                        for (String otherCU : mapDecompose.keySet())     // 待做匹配查找的cu, 即在otherCU代码中查找before所表示的依赖
                        {
                            List<DecomposeStruct> listOtherCU = mapDecompose.get(otherCU);

                            for (int j = 0; j < listOtherCU.size(); ++j)
                            {
                                if (before == listOtherCU.get(j).lineInSDG) // baseCU中第i 行代码 和 otherCU中第j行代码有数据依赖。
                                {

                                    // 判断 i、j 是否在mapDecompose里的同一个cu的同一trigger中。(判断方法：向上找到第一个level为1的就是所属trigger)
                                    if (baseCU.equals(otherCU)) // 在分解代码的同一个cu的同一个trigger中
                                    {
                                        if (whetherInSameDecomposeTrigger(listBaseCU, listOtherCU, i, j))
                                        {
                                            continue;
                                        }

                                    }
                                    // 在分解代码的同一个cu的不同trigger中。
                                    String synVar = getSyncVar(listDD, baseLineInSDG, before);

                                    if (whetherInSameOriginalTrigger(listDD, baseLineInSDG, before))
                                    {
                                        System.out.println(synVar + " 在原始程序同一个trigger里");
                                        int type = getChannelPlaceType(listDD, baseLineInSDG, before);
                                        if (type == 0)
                                        {
                                            System.out.println("before in DFGBefores : " + before);
                                            listBaseCU.add(i, new DecomposeStruct(-3, listBaseCU.get(i).level
                                                    , "CHANNEL.DD.?" + Integer.toString(channelDDMessage) + ":" + synVar + ";"));
                                            listOtherCU.add(j + 1, new DecomposeStruct(-3, listOtherCU.get(j).level
                                                    , "CHANNEL.DD.!" + Integer.toString(channelDDMessage) + ":" + synVar + ";"));
                                            ++i;
                                            isDDInOtherCU = true;
                                            break;
                                        }
                                        else if (type == 1) // 待查找的向前数据依赖的公共父层节点，向下查找到if
                                        {
                                            listBaseCU.add(i, new DecomposeStruct(-4, listBaseCU.get(i).level
                                                    , "SYNC.DATA." + Integer.toString(channelDDMessage) + ":" + synVar + ";"));
                                            ++i;
                                            isSYNCInOtherCU = true;
                                            break;
                                        }
                                        else if (type == 2)
                                        {

                                        }
//                                    else if (type == -1)  // -1 表示：如果两个变量在原始程序的一个trigger中(即可以向上遍历到同样的trigger节点)，则跳过
//                                    {
//                                        break;
//                                    }
                                        else
                                        {
                                            // 不会发生的。type 只能为0，1，2
                                        }
                                    }
                                    else
                                    {
                                        listBaseCU.add(i, new DecomposeStruct(-4, listBaseCU.get(i).level
                                                , "SYNC.DATA." + Integer.toString(channelDDMessage) + ":" + synVar + ";"));
                                        ++i;
                                        isSYNCInOtherCU = true;
                                        break;
                                    }

                                }
                            }
                        }
                        channelDDMessage += (isDDInOtherCU ? 1 : 0);
                        syncMessage += (isSYNCInOtherCU ? 1 : 0);
                    }
                }
            }

        }

        return mapDecompose;
    }

    public static boolean whetherInSameOriginalTrigger(List<Statement> listDD, int i, int j)
    {
        int index1 = -1;
        for (int k = i; k >= 0; --k)
        {
            if (listDD.get(k).label.equals("TRIGGER"))
            {
                index1 = k;
                break;
            }
        }

        int index2 = -2;
        for (int k = j; k >= 0; --k)
        {
            if (listDD.get(k).label.equals("TRIGGER"))
            {
                index2 = k;
                break;
            }
        }

        return index1 == index2;

    }

    // 判断分解后的两行代码是都在分解后程序的同一个cu的同一个trigger。
    public static boolean whetherInSameDecomposeTrigger(List<DecomposeStruct> listbaseCU, List<DecomposeStruct> listOtherCU, int i, int j)
    {
        int index1 = -1;
        for (int k = i; k >= 0; --k)
        {
            if (listbaseCU.get(k).level == 1)
            {
                index1 = k;
                break;
            }
        }

        int index2 = -2;
        for (int k = i; k >= 0; --k)
        {
            if (listOtherCU.get(k).level == 1)
            {
                index2 = k;
                break;
            }
        }

        return index1 == index2;
    }

    // 确定添加通信的位置。在原始程序中向上遍历求的层次路径，自下而上匹配公共点。
    public static int getChannelPlaceType(List<Statement> listDD, int baseLineInSDG, int before)
    {
        List<Integer> listUpBeforeCULines = new ArrayList<>();
        List<Integer> listUpBaseCULines = new ArrayList<>();
        int beforeCuLine = before;
        int baseCuLine = baseLineInSDG;

        // 自下而上，寻找父层路径。父层顺序从list的0-n倒叙放置。eg.. [9, 4, 3, 0]
        while (beforeCuLine != 0)
        {
            listUpBeforeCULines.add(beforeCuLine);
            beforeCuLine =  listDD.get(beforeCuLine).CFGBefores.get(0);
        }

        while (baseCuLine != 0)
        {
            listUpBaseCULines.add(baseCuLine);
            baseCuLine =  listDD.get(baseCuLine).CFGBefores.get(0);
        }

        System.out.println("listUpBaseCULines   = " + listUpBaseCULines.toString());
        System.out.println("listUpBeforeCULines = " + listUpBeforeCULines.toString());

//        if (listUpBaseCULines.get(listUpBaseCULines.size() - 1)
//                == listUpBeforeCULines.get(listUpBeforeCULines.size() - 1))
//        {
//            return -1;
//        }

        int bothParentLineIndex = -1;
        // 找出第一个共同的父层交点
        for (int i =  0; i < listUpBaseCULines.size(); ++i)
        {
            for (int j = 0; j < listUpBeforeCULines.size(); ++j)
            {
                if (listUpBaseCULines.get(i) == listUpBeforeCULines.get(j))
                {
                    // 找到共同点。listUpBeforeCU
//                    bothParentLine = listUpBeforeCU.get(j);
                    bothParentLineIndex = j;
                }
            }
        }


        // 找出其中的if／while点

        for (int m = 0; m < bothParentLineIndex; ++m)
        {
            int k = listUpBeforeCULines.get(m);
            if (listDD.get(k).label.equals("IF") || listDD.get(k).label.equals("ELSIF") || listDD.get(k).label.equals("ELSE"))
            {
                return 1;
            }
            else if (listDD.get(k).label.equals("WHILE"))
            {
                return 2;
            }
        }

        // 从公共的父点向下遍历，没有if／while
        return 0;
    }

    public static  String getSyncVar(List<Statement> listDD, int baseLineInSDG, int before)
    {

        Set<String> REF = listDD.get(baseLineInSDG).REF;
        Set<String> DEF = listDD.get(before).DEF;

        for (String str1 : REF)
        {
            for (String str2 : DEF)
            {
                if (str1.equals(str2))
                {
                    return str1;
                }
            }
        }

        return "No Message Var";
    }
}

