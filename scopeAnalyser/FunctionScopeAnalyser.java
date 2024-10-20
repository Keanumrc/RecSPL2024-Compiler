package scopeAnalyser;

import java.util.ArrayList;
import java.util.List;

import syntaxTree.SyntaxTreeNode;

public class FunctionScopeAnalyser {

    //PROG -> main GLOBVARS ALGO FUNCTIONS
    public static void analyseProg(SyntaxTreeNode syntaxTreeNode) throws Exception{

        //the main program can be considered almost like a function called 'main'
        
        //since we are opening a new scope, create an empty function table for this scope
        List<String> functionTable = new ArrayList<String>();

        //since recursive calls are not allowed to 'main', do not bind 'main' into the function table

        //analyse the FUNCTIONS (child index 3) to bind all of their names into the function table
        analyseFunctions(syntaxTreeNode.getChildren().get(3), functionTable);

        //analyse the ALGO (child index 2)
        //pass through the function table so we can check all function calls are legal etc.
        analyseAlgo(syntaxTreeNode.getChildren().get(2), functionTable);

    }

    public static void analyseAlgo(SyntaxTreeNode syntaxTreeNode, List<String> functionTable) throws Exception{

        //check if we are dealing with a function call
        //CALL -> FNAME(ATOMIC, ATOMIC, ATOMIC)
        if(syntaxTreeNode.getLabel().equals("CALL")){

            //check that the call calls a function already bound into the function table
            String calledFunctionName = syntaxTreeNode.getChildren().get(0).getChildren().get(0).getLabel();

            if(functionTable.contains(calledFunctionName)){
                return;
            }
            else{
                throw new Exception("Function " + calledFunctionName + " has not been declared in this scope");
            }

        }

        //simply call this same function on all children
        for(SyntaxTreeNode child : syntaxTreeNode.getChildren()){
            analyseAlgo(child, functionTable);
        }

    }

    //FUNCTIONS -> nullable
    //FUNCTIONS -> DECL FUNCTIONS
    public static void analyseFunctions(SyntaxTreeNode syntaxTreeNode, List<String> functionTable) throws Exception{

        //firstly, differentiate between the two productions
        //FUNCTIONS -> nullable
        if(syntaxTreeNode.getChildren().size() == 0){
            //recursive base case - do nothing
            return;
        }
        //FUNCTIONS -> DECL FUNCTIONS
        else{

            //analyse the first DECL, passing through the functionTable so that it can be added to
            analyseDecl(syntaxTreeNode.getChildren().get(0), functionTable);

            //analyse the rest of the functions
            analyseFunctions(syntaxTreeNode.getChildren().get(1), functionTable);

        }

    }

    // DECL -> HEADER BODY
    public static void analyseDecl(SyntaxTreeNode syntaxTreeNode, List<String> parentFunctionTable) throws Exception {

        // analyse the HEADER (child index 0) to get the function name
        String functionName = analyseHeader(syntaxTreeNode.getChildren().get(0));

        //add the function name to the parent scope's function table
        if(!parentFunctionTable.contains(functionName)){
            parentFunctionTable.add(functionName);
        }
        else{
            throw new Exception("Function " + functionName + " has already been declared in this scope");
        }

        // since we are opening a new scope, create an empty function table for this
        // scope
        List<String> functionTable = new ArrayList<String>();

        // bind the name of the function into the table
        if(!functionTable.contains(functionName)){
            functionTable.add(functionName);
        }
        else{
            throw new Exception("Function " + functionName + " has already been declared in this scope");
        }

        // analyse the BODY (child index 1) to check all function calls are legal etc.
        // pass through the created functionTable
        analyseBody(syntaxTreeNode.getChildren().get(1), functionTable);

    }

    //HEADER -> FTYPE FNAME(VNAME, VNAME, VNAME)
    public static String analyseHeader(SyntaxTreeNode syntaxTreeNode){

        //get the name of the function and return it
        SyntaxTreeNode fnameChild = syntaxTreeNode.getChildren().get(1);
        return fnameChild.getChildren().get(0).getLabel();

    }

    //BODY -> PROLOG LOCVARS ALGO EPILOG SUBFUNCS end
    public static void analyseBody(SyntaxTreeNode syntaxTreeNode, List<String> functionTable) throws Exception{

        //firstly bind all the SUBFUNCS (child index 4) to the functionTable so function calls can be checked etc. later
        analyseSubfuncs(syntaxTreeNode.getChildren().get(4), functionTable);

        //secondly check that all function calls in the ALGO (child index 2) are legal
        analyseAlgo(syntaxTreeNode.getChildren().get(2), functionTable);

    }

    //SUBFUNCS -> FUNCTIONS
    public static void analyseSubfuncs(SyntaxTreeNode syntaxTreeNode, List<String> functionTable) throws Exception{

        analyseFunctions(syntaxTreeNode.getChildren().get(0), functionTable);

    }
    
}