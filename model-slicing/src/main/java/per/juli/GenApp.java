package per.juli;

import per.juli.codegeneration.PowePC;
import per.juli.cooperation.DecomposeNtoN;
import per.juli.staticAnalysis.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenApp
{
    public static void main_Decompose() throws IOException
    {
        //String fileName = "resources/input.imc";
        String fileName = "resources/stm32_powerpc.imc";

        AST ast = new AST();
        Map<String, ASTNode> mapAst = ast.genAST(fileName);
        Map<String, Set<String>> mapvars  = ast.mapVars;

        CFG cfg = new CFG();
        Map<String, List<Statement>> mapCFGs = new HashMap<>();
        for (String key : mapAst.keySet())
        {
            mapCFGs.put(key, cfg.getCFGfromAST(mapAst.get(key)));
        }

        DFG dfg = new DFG();
        Map<String, List<Statement>> mapDFGs = new HashMap<>();
        for (String key : mapAst.keySet())
        {
            mapDFGs.put(key, dfg.getDFGbaseCFGandVars(mapCFGs.get(key), mapvars.get(key)));
        }

        PDG pdg = new PDG();
        Map<String, List<Statement>> mapPDGs = new HashMap<>();
        for (String key : mapAst.keySet())
        {
            mapPDGs.put(key, pdg.getPDGformDFG(mapDFGs.get(key)));
        }


        SDG sdg = new SDG();
        sdg.combinedPDGs(mapPDGs);

        Map<String, List<Statement>> mapSDG = mapDFGs;
        Map<String, Set<Integer>> mapInterSDG  = sdg.combinedPDGs(mapPDGs);

        System.out.println("mainProcess: " + ast.mainProgram + "\n");

        System.out.println("输出 SDG :" + mapSDG.size());
        for (String key : mapSDG.keySet())
        {
            System.out.println("\nSDG ---------- " + key + "\n");

            sdg.printSDG(mapSDG.get(key));
        }


        DecomposeNtoN decomposeNtoN = new DecomposeNtoN();
        decomposeNtoN.decomposeModelNtoN(ast, mapPDGs);
        List<String> outCode2GenList = decomposeNtoN.outCode2Gen(DecomposeNtoN.mapDecompose);

        for (String modelcode : outCode2GenList)
        {
            List<String> modelGenedCode = PowePC.genCodePowerPCFromString(modelcode);
        }


        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );

    }

    public static void main( String[] args ) throws IOException
    {
        main_Decompose();
    }
}
