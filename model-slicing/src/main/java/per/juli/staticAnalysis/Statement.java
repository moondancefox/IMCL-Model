package per.juli.staticAnalysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by juli on 2017/3/7.
 */
public class Statement
{
    public String sliceCode;    // 节点代码, 如：x := x + 1;  y := fun(3);
    public String label;        // 记录节点代码的属性：如表示""

    public int lineNumber;
    public int level;

    // 控制流图节点关系（前驱、后继）
    public List<Integer> CFGNexts;
    public List<Integer> CFGBefores;


    // 数据流图节点关系（前驱、后继）
    public Set<Integer> DFGNexts;
    public Set<Integer> DFGBefores;

    /** REF 和 DEF */
    public Set<String>  REF;    // 每个状态中被使用的变量 ：即":="的右边
    public Set<String> DEF;    // 每个状态中被修改的变量 ：即":="的左边


    public Statement()
    {
        this.sliceCode = new String();
        this.label = new String();
        this.lineNumber = -1;
        this.level = -1;

        this.CFGNexts = new ArrayList<>();
        this.CFGBefores = new ArrayList<>();

        this.DFGNexts = new HashSet<>();
        this.DFGBefores = new HashSet<>();

        this.REF = new HashSet<>();
        this.DEF = new HashSet<>();
    }


    public Statement(Statement statement)
    {
        this.sliceCode = new String(statement.sliceCode);
        this.label = new String(statement.label);
        this.lineNumber = statement.lineNumber;
        this.level = statement.level;

        this.CFGNexts = new ArrayList<>(statement.CFGNexts);
        this.CFGBefores = new ArrayList<>(statement.CFGBefores);

        this.DFGNexts = new HashSet<>(statement.DFGNexts);
        this.DFGBefores = new HashSet<>(statement.DFGBefores);

        this.REF = new HashSet<>(statement.REF);
        this.DEF = new HashSet<>(statement.DEF);

    }
}
