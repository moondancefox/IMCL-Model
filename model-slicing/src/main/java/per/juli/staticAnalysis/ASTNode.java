package per.juli.staticAnalysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by juli on 2017/3/5.
 */
public class ASTNode
{
    public String sliceCode;    // 节点代码, 如：x := x + 1;  y := fun(3);
    public String label;        // 记录节点代码的属性：如表示""

    public int lineNumber;
    public int level;

    /** REF 和 DEF */
    public Set<String> REF;    // 每个状态中被使用的变量 ：即":="的右边
    public Set<String> DEF;    // 每个状态中被修改的变量 ：即":="的左边

    public List<ASTNode> Nexts;

    public ASTNode()
    {

        this.lineNumber = -1;
        this.level = -1;

        this.sliceCode = new String();
        this.label = new String();

        this.REF = new HashSet<>();
        this.DEF = new HashSet<>();

        this.Nexts = new ArrayList<>();
    }


    public ASTNode(ASTNode node)
    {
        this.lineNumber = node.lineNumber;
        this.level = node.level;

        this.sliceCode = new String(node.sliceCode);
        this.label = new String(node.label);

        this.DEF = new HashSet<>(node.DEF);
        this.REF = new HashSet<>(node.REF);

        // ......

        this.Nexts = new ArrayList<>();
        for (ASTNode snode : node.Nexts)
        {
            this.Nexts.add(new ASTNode(snode));
        }
    }

    public static void main(String[] args)
    {
        System.out.println("ASTNode.");
    }
}
