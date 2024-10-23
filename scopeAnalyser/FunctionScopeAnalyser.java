package scopeAnalyser;

import java.util.HashMap;
import java.util.Map;

import syntaxTree.CompositeNode;
import syntaxTree.LeafNode;
import syntaxTree.SyntaxTreeNode;

public class FunctionScopeAnalyser {

    //PROG -> main GLOBVARS ALGO FUNCTIONS
    public static GlobalSymbolTable analyseProg(CompositeNode syntaxTreeNode) throws Exception{

        //create a new GlobalSymbolTable
        GlobalSymbolTable globalFunctionTable = new GlobalSymbolTable(false);

        //the main program can be considered almost like a function called 'main'
        
        //since we are opening a new scope, create an empty function table for this scope
        Map<String, String> functionTable = new HashMap<String, String>();

        //since recursive calls are not allowed to 'main', do not bind 'main' into the function table

        //analyse the FUNCTIONS (child index 3) to bind all of their names into the function table
        analyseFunctions((CompositeNode)syntaxTreeNode.getChildren().get(3), functionTable, globalFunctionTable);

        //analyse the ALGO (child index 2)
        //pass through the function table so we can check all function calls are legal etc.
        analyseAlgo(syntaxTreeNode.getChildren().get(2), functionTable, globalFunctionTable);

        return globalFunctionTable;

    }

    private static void analyseAlgo(SyntaxTreeNode syntaxTreeNode, Map<String, String> functionTable, GlobalSymbolTable globalFunctionTable) throws Exception{

        //handle CompositeNode and LeafNode differently
        if(syntaxTreeNode instanceof CompositeNode){

            CompositeNode compositeNode = (CompositeNode)syntaxTreeNode;

            //check if we are dealing with a function call
            //CALL -> FNAME(ATOMIC, ATOMIC, ATOMIC)
            if(compositeNode.getNonTerminal().equals("CALL")){

                //check that the call calls a function already bound into the function table
                String calledFunctionName = ((LeafNode)((CompositeNode)compositeNode.getChildren().get(0)).getChildren().get(0)).getWord();

                if(functionTable.get(calledFunctionName) != null){
                    //Here we have a use of a function - rename the function uniquely
                    ((LeafNode)((CompositeNode)compositeNode.getChildren().get(0)).getChildren().get(0)).setWord(functionTable.get(calledFunctionName));
                    return;
                }
                else{
                    throw new Exception("Function " + calledFunctionName + " has not been declared in this scope");
                }

            }

            //simply call this same function on all children
            for(SyntaxTreeNode child : compositeNode.getChildren()){
                analyseAlgo(child, functionTable, globalFunctionTable);
            }

        }
        else{

            return;

        }

    }

    //FUNCTIONS -> nullable
    //FUNCTIONS -> DECL FUNCTIONS
    private static void analyseFunctions(CompositeNode syntaxTreeNode, Map<String, String> functionTable, GlobalSymbolTable globalFunctionTable) throws Exception{

        //firstly, differentiate between the two productions
        //FUNCTIONS -> nullable
        if(syntaxTreeNode.getChildren().size() == 0){
            //recursive base case - do nothing
            return;
        }
        //FUNCTIONS -> DECL FUNCTIONS
        else{

            //analyse the first DECL, passing through the functionTable so that it can be added to
            analyseDecl((CompositeNode)syntaxTreeNode.getChildren().get(0), functionTable, globalFunctionTable);

            //analyse the rest of the functions
            analyseFunctions((CompositeNode)syntaxTreeNode.getChildren().get(1), functionTable, globalFunctionTable);

        }

    }

    // DECL -> HEADER BODY
    private static void analyseDecl(CompositeNode syntaxTreeNode, Map<String, String> parentFunctionTable, GlobalSymbolTable globalFunctionTable) throws Exception {

        // analyse the HEADER (child index 0) to get the function name
        String functionName = analyseHeader((CompositeNode)syntaxTreeNode.getChildren().get(0), globalFunctionTable);

        //bind into the global function table
        String uniqueName = globalFunctionTable.bind(functionName);

        //replace the user-defined name in the syntax tree with the unique name
        ((LeafNode)((CompositeNode)((CompositeNode)syntaxTreeNode.getChildren().get(0)).getChildren().get(1)).getChildren().get(0)).setWord(uniqueName);

        //add the function name to the parent scope's function table
        if(parentFunctionTable.get(functionName) == null){
            parentFunctionTable.put(functionName, uniqueName);
        }
        else{
            throw new Exception("Function " + functionName + " has already been declared in this scope");
        }

        // since we are opening a new scope, create an empty function table for this
        // scope
        Map<String, String> functionTable = new HashMap<String, String>();

        // bind the name of the function into the table
        if(functionTable.get(functionName) == null){
            functionTable.put(functionName, uniqueName);
        }
        else{
            throw new Exception("Function " + functionName + " has already been declared in this scope");
        }

        // analyse the BODY (child index 1) to check all function calls are legal etc.
        // pass through the created functionTable
        analyseBody((CompositeNode)syntaxTreeNode.getChildren().get(1), functionTable, globalFunctionTable);

    }

    //HEADER -> FTYPE FNAME(VNAME, VNAME, VNAME)
    private static String analyseHeader(CompositeNode syntaxTreeNode, GlobalSymbolTable globalFunctionTable){

        //get the name of the function and return it
        CompositeNode fnameChild = (CompositeNode)syntaxTreeNode.getChildren().get(1);
        return ((LeafNode)fnameChild.getChildren().get(0)).getWord();

    }

    //BODY -> PROLOG LOCVARS ALGO EPILOG SUBFUNCS end
    private static void analyseBody(CompositeNode syntaxTreeNode, Map<String, String> functionTable, GlobalSymbolTable globalFunctionTable) throws Exception{

        //firstly bind all the SUBFUNCS (child index 4) to the functionTable so function calls can be checked etc. later
        analyseSubfuncs((CompositeNode)syntaxTreeNode.getChildren().get(4), functionTable, globalFunctionTable);

        //secondly check that all function calls in the ALGO (child index 2) are legal
        analyseAlgo(syntaxTreeNode.getChildren().get(2), functionTable, globalFunctionTable);

    }

    //SUBFUNCS -> FUNCTIONS
    private static void analyseSubfuncs(CompositeNode syntaxTreeNode, Map<String, String> functionTable, GlobalSymbolTable globalFunctionTable) throws Exception{

        analyseFunctions((CompositeNode)syntaxTreeNode.getChildren().get(0), functionTable, globalFunctionTable);

    }
    
}