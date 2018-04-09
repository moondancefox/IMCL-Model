package per.juli.staticAnalysis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juli on 2017/3/5.
 */
public class PDG
{
    public static List<Statement> PDGraphList = new ArrayList<>();


    public PDG()
    {
        this.PDGraphList = new ArrayList<>();

    }

    public PDG (PDG pdg)
    {
        this.PDGraphList = new ArrayList<>();
        for (Statement statement : pdg.PDGraphList)
        {
            this.PDGraphList.add(new Statement(statement));
        }

    }

    public static void printPDG(List<Statement> graphList)
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


    public List<Statement> getPDGformDFG(List<Statement> dfgList)
    {
        PDGraphList = new ArrayList<>();

        for (Statement statement : dfgList)
        {
            PDGraphList.add(new Statement(statement));
        }

        return PDGraphList;
    }
}
