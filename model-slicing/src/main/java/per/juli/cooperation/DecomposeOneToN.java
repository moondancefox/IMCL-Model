package per.juli.cooperation;

/**
 * Created by juli on 2017/3/23.
 */
public class DecomposeOneToN
{


//
//    public static void decomposeProgramNtoN2(int current ,List<Statement> mainGraphList, List<String> pileList
//            , Map<String, List<DecomposeStruct>> mapDecompose, String currentCU)
//    {
//        List<Integer> currentNexts = mainGraphList.get(current).CFGNexts;
////        System.out.println(current + ":\tcurrentNexts.toString() = " + currentNexts.toString());
//
//        for (int i = 0; i < currentNexts.size(); ++i)
//        {
//            int index = currentNexts.get(i);
//
//            Statement statement = mainGraphList.get(index);
//
////            System.out.println("\t\tlabel = " + mainGraphList.get(currentNexts.get(i)).label);
//
//            if (statement.label.equals("VarDefine") || statement.label.equals("AssignVariable")
//                    || statement.label.equals("AssignFunction") || statement.label.equals("AssignInvoke")
//                    || statement.label.equals("RETURN") || statement.label.equals("STOP"))
//            {
//                // if／elsif／else的子代码块需要和if／elsif／else所分配的计算单元进行参照。
//                // 如果一样，则直接保留子代码块，如果不一样，则使用新的trigger放置子代码块
//                String assignPileCU = pileList.get(index);
//
//                if (assignPileCU.equals(pileList.get(current)))      // 和父层的 pile 比较
//                {
//                    // TODO 直接把if添加到根trigger上
//                    mapDecompose.get(assignPileCU).add(new DecomposeStruct(index, mainGraphList.get(index).level, mainGraphList.get(index).sliceCode));
//
//                }
//                else
//                {
//
//                    // 添加一行"TRIGGER(TRUE)"
//                    mapDecompose.get(assignPileCU).add(new DecomposeStruct(-1, 1,"TRIGGER(TRUE)"));
//                    // 添加一行"CHANNEL(?)"表示接受
//                    mapDecompose.get(assignPileCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level, "// CHANNEL?" + Integer.toString(countMessage)));
//                    mapDecompose.get(currentCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level, "// CHANNEL!" + Integer.toString(countMessage)));
//                    countMessage++;
//
//                    // 直接把if添加到新Trigger上
//                    mapDecompose.get(assignPileCU).add(new DecomposeStruct(index, mainGraphList.get(index).level, mainGraphList.get(index).sliceCode));
//
////                    // 添加一行"CHANNEL(!)"表示结束
////                    mapDecompose.get(assignPileCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level, "// CHANNEL!" + Integer.toString(countMessage)));
////                    mapDecompose.get(currentCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level, "// CHANNEL?" + Integer.toString(countMessage)));
////                    countMessage++;
//                }
//
//
//            }
//            else if (statement.label.equals("WHILE"))
//            {
//
//            }
//
//            else if (statement.label.equals("IF") || statement.label.equals("ELSIF") || statement.label.equals("ELSE"))
//            {
//                String ifPileCU = pileList.get(index);
//                if (ifPileCU.equals(pileList.get(current)))      // if/elsif/else 和 父层的pile比较
//                {
//                    // TODO 直接把if添加到根trigger上
//                    mapDecompose.get(ifPileCU).add(new DecomposeStruct(index, mainGraphList.get(index).level, mainGraphList.get(index).sliceCode));
//
//                    decomposeProgramNtoN2(index, mainGraphList, pileList, mapDecompose, currentCU);
//                }
//                else    // 添加新 trigger
//                {
//
//                    // 添加一行"TRIGGER(TRUE)"
//                    mapDecompose.get(ifPileCU).add(new DecomposeStruct(-1, 1, "TRIGGER(TRUE)"));
//
//                    // 添加一行"CHANNEL(?)"表示trigger接受
//                    mapDecompose.get(ifPileCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level,"// CHANNEL?"+ Integer.toString(countMessage)));
//                    mapDecompose.get(currentCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level,"// CHANNEL!" + Integer.toString(countMessage)));
//                    countMessage++;
//
//                    // 直接把if添加到新Trigger上
//                    mapDecompose.get(ifPileCU).add(new DecomposeStruct(index, mainGraphList.get(index).level,mainGraphList.get(index).sliceCode));
//
//                    decomposeProgramNtoN2(index, mainGraphList, pileList, mapDecompose, currentCU);
//
////                    // 添加一行"CHANNEL(!)"表示trigger结束
////                    mapDecompose.get(ifPileCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level,"// CHANNEL!" + Integer.toString(countMessage)));
////                    mapDecompose.get(currentCU).add(new DecomposeStruct(-1, mainGraphList.get(index).level,"// CHANNEL?" + Integer.toString(countMessage)));
////                    countMessage++;
//                }
//
//            }
//
//            else if (statement.label.equals("TRIGGER"))
//            {
//                String triggerPileCU = pileList.get(index);    // 获取当前是A，B，C，D......
//
//                mapDecompose.get(triggerPileCU).add(new DecomposeStruct(index, 1, mainGraphList.get(index).sliceCode));
//
//                // 把trigger作为下一个current， triggerPileCU作为 CU
//                decomposeProgramNtoN2(index, mainGraphList, pileList, mapDecompose, triggerPileCU);
//
//            }
//            else
//            {
//
//            }
//        }
//
//    }
//


}
