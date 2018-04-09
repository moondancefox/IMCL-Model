package per.juli;

import per.juli.cooperation.DecomposeNtoN;
import per.juli.staticAnalysis.*;

import per.juli.utils.Graphviz;

import java.io.IOException;
import java.util.*;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main_AST() throws IOException
    {
        String fileName = "resources/input.imc";

        AST ast = new AST();
        Map<String, ASTNode> mapAst = ast.genAST(fileName);
        Map<String, Set<String>> mapvars  = ast.mapVars;

        System.out.println(mapAst.size());
        System.out.println(mapAst.size());

        System.out.println("ast.sixe() : " + mapAst.size());
        for (String key : mapAst.keySet())
        {
            System.out.println("\n- - - - - -\n");
            ASTNode node = mapAst.get(key);
            ast.printTree(node);
        }

        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }

    public static void main_CFG() throws IOException
    {
        String fileName = "resources/input.imc";

        AST ast = new AST();
        Map<String, ASTNode> mapAst = ast.genAST(fileName);
        Map<String, Set<String>> mapvars  = ast.mapVars;


        CFG cfg = new CFG();
        Map<String, List<Statement>> mapCFGs = new HashMap<>();
        for (String key : mapAst.keySet())
        {
            mapCFGs.put(key, cfg.getCFGfromAST(mapAst.get(key)));
        }

        System.out.println("输出 CFG :" + mapCFGs.size());
        for (String key : mapCFGs.keySet())
        {
            System.out.println("\nCFG ----------\n");

            cfg.printCFG(mapCFGs.get(key));
        }

        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }


    public static void main_DFG() throws IOException
    {
        String fileName = "resources/input.imc";

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

        System.out.println("输出 DFG :" + mapCFGs.size());
        for (String key : mapCFGs.keySet())
        {
            System.out.println("\nDFG ----------\n");

            dfg.printDFG(mapDFGs.get(key));
        }


        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }


    public static void main_PDG() throws IOException
    {
        String fileName = "resources/input.imc";

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


        System.out.println("mainProcess: " + ast.mainProgram + "\n");

        System.out.println("输出 PDG :" + mapCFGs.size());
        for (String key : mapPDGs.keySet())
        {
            System.out.println("\nPDG ---------- " + key + "\n");

            dfg.printDFG(mapPDGs.get(key));
            Graphviz.transformPDGToDot(mapPDGs.get(key), key);
        }


        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }


    public static void main_SDG() throws IOException
    {
        String fileName = "resources/input.imc";

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



        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }

    public static void main_Decompose() throws IOException
    {
        String fileName = "resources/input.imc";
        //String fileName = "resources/stm32_powerpc.imc";

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
        //decomposeNtoN.print(DecomposeNtoN.mapDecompose);


        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );

    }

    public static void main( String[] args ) throws IOException
    {
//        main_AST();
//        main_CFG();
//        main_DFG();
//        main_PDG();
//        main_SDG();

        main_Decompose();

    }


    public static void example_cars() throws IOException
    {
        String fileName = "resources/input.imc";

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


        System.out.println( "\nCopyright by JuLi. © 2016–2017.  NTESEC, Org." );
    }
}
