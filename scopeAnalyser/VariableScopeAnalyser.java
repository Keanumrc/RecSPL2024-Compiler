package scopeAnalyser;

import java.util.ArrayList;
import java.util.List;

import syntaxTree.CompositeNode;
import syntaxTree.LeafNode;
import syntaxTree.SyntaxTreeNode;

public class VariableScopeAnalyser {

    //PROG -> main GLOBVARS ALGO FUNCTIONS
    public static void analyseProg(CompositeNode syntaxTreeNode) throws Exception{

        //since we are opening a new scope, create an empty variable table for this scope
        List<String> variableTable = new ArrayList<String>();

        //analyse the GLOBVARS (child index 1) to bind all of their names into the variable table
        analyseGlobVars((CompositeNode)syntaxTreeNode.getChildren().get(1), variableTable);

        //analyse the ALGO (child index 2) to check that all variable use is legal
        analyseAlgo(syntaxTreeNode.getChildren().get(2), variableTable);

        //analyse the FUNCTIONS (child index 3)
        analyseFunctions((CompositeNode)syntaxTreeNode.getChildren().get(3), variableTable);

    }

    private static void analyseAlgo(SyntaxTreeNode syntaxTreeNode, List<String> variableTable) throws Exception{

        //handle CompositeNode and LeafNode differently
        if(syntaxTreeNode instanceof CompositeNode){

            CompositeNode compositeNode = (CompositeNode)syntaxTreeNode;

            //check if we are dealing with a VNAME
            //VNAME -> V
            if(compositeNode.getNonTerminal().equals("VNAME")){

                //get the variable name
                String variableName = ((LeafNode)compositeNode.getChildren().get(0)).getWord();

                //check that the variable name is bound in the variable table
                if(variableTable.contains(variableName)){
                    return;
                }
                else{
                    throw new Exception("Variable " + variableName + " has not been declared in this scope");            
                }

            }
            //otherwise simply call analyseAlgo on all children
            else{

                for(SyntaxTreeNode child : compositeNode.getChildren()){
                    analyseAlgo(child, variableTable);
                }

            }

        }
        else{
            return;
        }

    }

    //GLOBVARS -> nullable
    //GLOBVARS -> VTYP VNAME, GLOBVARS
    private static void analyseGlobVars(CompositeNode syntaxTreeNode, List<String> variableTable) throws Exception{

        //firstly, differentiate between the two productions
        //GLOBVARS -> nullable
        if(syntaxTreeNode.getChildren().size() == 0){
            //recursive base case - do nothing
            return;
        }
        //GLOBVARS -> VTYP VNAME, GLOBVARS
        else{

            //bind the first VNAME into the variable table
            //get the variableName
            String variableName = ((LeafNode)((CompositeNode)syntaxTreeNode.getChildren().get(1)).getChildren().get(0)).getWord();

            //bind the variableName
            if(!variableTable.contains(variableName)){
                variableTable.add(variableName);
            }
            else{
                throw new Exception("Variable " + variableName + " has already been declared in this scope");                
            }

            //analyse the rest of the GLOBVARS
            analyseGlobVars((CompositeNode)syntaxTreeNode.getChildren().get(3), variableTable);
            
        }

    }

    //FUNCTIONS -> nullable
    //FUNCTIONS -> DECL FUNCTIONS
    private static void analyseFunctions(CompositeNode syntaxTreeNode, List<String> variableTable) throws Exception{

        //firstly, differentiate between the two productions
        //FUNCTIONS -> nullable
        if(syntaxTreeNode.getChildren().size() == 0){
            //recursive base case - do nothing
            return;
        }        
        //FUNCTIONS -> DECL FUNCTIONS
        else{

            //analyse the first DECL
            analyseDecl((CompositeNode)syntaxTreeNode.getChildren().get(0), variableTable);

            //analyse the rest of the FUNCTIONS
            analyseFunctions((CompositeNode)syntaxTreeNode.getChildren().get(1), variableTable);            

        }

    }

    //DECL -> HEADER BODY
    private static void analyseDecl(CompositeNode syntaxTreeNode, List<String> parentVariableTable) throws Exception{

        //Since we are opening a new scope, create a new variable table, and copy all variable names over
        //from the parentVariableTable since these can be used in descendent scopes
        List<String> variableTable = new ArrayList<String>(parentVariableTable);

        //Create an empty list to hold only local variable names
        List<String> localVariables = new ArrayList<String>();

        //analyse the HEADER (child index 0) to get all the parameter names as a list
        //and add the parameters to the local variable names
        localVariables.addAll(analyseHeader((CompositeNode)syntaxTreeNode.getChildren().get(0)));

        //analyse the BODY (child index 1)
        //pass through localVariables so it can add to it
        //also pass through the variableTable so it can use ancestor variables
        analyseBody((CompositeNode)syntaxTreeNode.getChildren().get(1), variableTable, localVariables);

    }

    //HEADER -> FTYP FNAME(VNAME, VNAME, VNAME)
    private static List<String> analyseHeader(CompositeNode syntaxTreeNode) throws Exception{

        List<String> parameterNames = new ArrayList<String>();

        //extract the three VNAMEs (child indices 3, 5, 7)
        for(int i = 3; i <= 7; i+=2){

            //get the variable name
            String variableName = ((LeafNode)((CompositeNode)syntaxTreeNode.getChildren().get(i)).getChildren().get(0)).getWord();
            
            if(!parameterNames.contains(variableName)){
                parameterNames.add(variableName);
            }
            else{
                throw new Exception("Variable " + variableName + " has already been declared in this scope");                 
            }

        }

        return parameterNames;

    }

    //BODY -> PROLOG LOCVARS ALGO EPILOG SUBFUNCS end
    private static void analyseBody(CompositeNode syntaxTreeNode, List<String> variableTable, List<String> localVariables) throws Exception{

        //first analyse LOCVARS (child index 1) to add all local variables to the localVariables list
        analyseLocVars((CompositeNode)syntaxTreeNode.getChildren().get(1), localVariables);

        //now add all the local variables to the variableTable
        //replace any variables that are already in the list to implement variable hiding
        for(String localVariable : localVariables){
            
            if(!variableTable.contains(localVariable)){
                variableTable.add(localVariable);
            }
            else{
                //TODO: if implementation changes, actually replace
            }

        }

        //now analyse the ALGO (child index 2) to make sure all variable use is legal
        analyseAlgo(syntaxTreeNode.getChildren().get(2), variableTable);

        //now analyse SUBFUNCS (child index 4)
        //pass through variableTable as the parentVariableTable
        analyseSubfuncs((CompositeNode)syntaxTreeNode.getChildren().get(4), variableTable);

    }

    //LOCVARS -> VTYP VNAME, VTYP VNAME, VTYP VNAME
    private static void analyseLocVars(CompositeNode syntaxTreeNode, List<String> localVariables) throws Exception{

        //for each VNAME (child indices 1, 4, 7) add the variable name to the localVariables list
        for(int i = 1; i <= 7; i+=3){

            //get the variable name
            String variableName = ((LeafNode)((CompositeNode)syntaxTreeNode.getChildren().get(i)).getChildren().get(0)).getWord();
            
            if(!localVariables.contains(variableName)){
                localVariables.add(variableName);
            }
            else{
                throw new Exception("Variable " + variableName + " has already been declared in this scope");                  
            }

        }

    }

    //SUBFUNCS -> FUNCTIONS
    private static void analyseSubfuncs(CompositeNode syntaxTreeNode, List<String> parentVariableTable) throws Exception{

        //call analyse FUNCTIONS (child index 0)
        analyseFunctions((CompositeNode)syntaxTreeNode.getChildren().get(0), parentVariableTable);

    }
    
}