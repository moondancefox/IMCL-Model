package per.juli.cooperation;

/**
 * Created by juli on 2017/3/21.
 */
public class DecomposeStruct
{
    int lineInSDG;        // 对应SDG中行号
    int level;          // 代码位置层级
    String code;        // SDG中行号表示代码

    public DecomposeStruct()
    {
        this.lineInSDG = -1;
        this.code = new String();
    }

    public DecomposeStruct(int lineInSDG, int level, String code)
    {
        this.lineInSDG = lineInSDG;
        this.level = level;
        this.code = new String (code);
    }

}
