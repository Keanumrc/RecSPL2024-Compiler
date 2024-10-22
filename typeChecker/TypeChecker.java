package typeChecker;

import syntaxTree.SyntaxTreeNode;

public class TypeChecker {

    //PROG -> main GLOBVARS ALGO FUNCTIONS
    public static boolean typeCheckProg(SyntaxTreeNode syntaxTreeNode){

        //type check GLOBVARS (child index 1)
        //all results need to be true for this method to return true
        boolean result = typeCheckGlobVars(syntaxTreeNode.getChildren().get(1));

        //type check ALGO (child index 2)
        result = result && typeCheckAlgo(syntaxTreeNode.getChildren().get(2));

        //type check FUNCTIONS (child index 3)
        result = result && typeCheckFunctions(syntaxTreeNode.getChildren().get(3));

        return result;

    }

    //GLOBVARS -> nullable
    //GLOBVARS -> VTYP VNAME, GLOBVARS
    private static boolean typeCheckGlobVars(SyntaxTreeNode syntaxTreeNode){

        //firstly, differentiate between the two productions
        //GLOBVARS -> nullable
        if(syntaxTreeNode.getChildren().size() == 0){
            //recursive base case - return true
            return true;
        }
        //GLOBVARS -> VTYP VNAME, GLOBVARS
        else{

            //TODO
            //bind VNAME to VTYP in the symbol table

            //typecheck the rest of the GLOBVARS (child index 3)
            return typeCheckGlobVars(syntaxTreeNode.getChildren().get(3));

        }        

    }

    //VTYP -> num
    //VTYP -> text
    private static char typeOfVtyp(SyntaxTreeNode syntaxTreeNode){

        String firstChildLabel = syntaxTreeNode.getChildren().get(0).getLabel();

        //firstly, differentiate between the two productions based on the label of the first child
        //VTYP -> num
        if(firstChildLabel.equals("num")){
            return 'n';
        }
        //VTYP -> text
        else{
            return 't';
        }

    }

    //VNAME -> V
    private static char typeOfVName(SyntaxTreeNode syntaxTreeNode){

        //TODO
        //get type from symbol table

    }

    //ALGO -> begin INSTRUC end
    private static boolean typeCheckAlgo(SyntaxTreeNode syntaxTreeNode){

        //type check the INSTRUC (child index 1)
        return typeCheckInstruc(syntaxTreeNode.getChildren().get(1));

    }

    //INSTRUC -> nullable
    //INSTRUC -> COMMAND; INSTRUC
    private static boolean typeCheckInstruc(SyntaxTreeNode syntaxTreeNode){

        //firstly, differentiate between the two productions
        //INSTRUC -> nullable
        if(syntaxTreeNode.getChildren().size() == 0){
            //recursive base case - return true
            return true;
        }
        //INSTRUC -> COMMAND; INSTRUC
        else{

            //type check the COMMAND (child index 0)
            boolean result = typeCheckCommand(syntaxTreeNode.getChildren().get(0));

            //type check the INSTRUC (child index 2)
            result = result && typeCheckInstruc(syntaxTreeNode.getChildren().get(2));

            return result;

        }

    }

    //COMMAND -> skip
    //COMMAND -> halt
    //COMMAND -> print ATOMIC
    //COMMAND -> return ATOMIC
    //COMMAND -> ASSIGN
    //COMMAND -> CALL
    //COMMAND -> BRANCH
    private static boolean typeCheckCommand(SyntaxTreeNode syntaxTreeNode){

        String firstChildLabel = syntaxTreeNode.getChildren().get(0).getLabel();

        //firstly, differentiate between the seven productions based on the first child's label
        //COMMAND -> skip    
        if(firstChildLabel.equals("skip")){
            return true;
        }            
        //COMMAND -> halt
        else if(firstChildLabel.equals("halt")){
            return true;
        }
        //COMMAND -> print ATOMIC
        else if(firstChildLabel.equals("print")){
            
            //can only print numbers or text
            //so check that ATOMIC (child index 1) is of type 'n' or 't'
            SyntaxTreeNode atomic = syntaxTreeNode.getChildren().get(1);
            return (typeOfAtomic(atomic) == 'n' || typeOfAtomic(atomic) == 't');

        }
        //COMMAND -> return ATOMIC
        else if(firstChildLabel.equals("return")){

            //TODO
            //check that typeOf Atomic == type the function returns == 'n'

        }
        //COMMAND -> ASSIGN
        else if(firstChildLabel.equals("ASSIGN")){

            //type check ASSIGN (child index 0)
            return typeCheckAssign(syntaxTreeNode.getChildren().get(0));

        }
        //COMMAND -> CALL
        else if(firstChildLabel.equals("CALL")){
            
            //check that this is a call to a void function
            return (typeOfCall(syntaxTreeNode.getChildren().get(0)) == 'v');

        }
        //COMMAND -> BRANCH
        else if(firstChildLabel.equals("BRANCH")){
            
            //type check the BRANCH (child index 0)
            return typeCheckBranch(syntaxTreeNode.getChildren().get(0));

        }

    }

    //ATOMIC -> VNAME
    //ATOMIC -> CONST
    private static char typeOfAtomic(SyntaxTreeNode syntaxTreeNode){

        String firstChildLabel = syntaxTreeNode.getChildren().get(0).getLabel();

        //firstly, differentiate between the two productions based on the first child's label
        //ATOMIC -> VNAME
        if(firstChildLabel.equals("VNAME")){
            
            //get the type of the VNAME (child index 0)
            return typeOfVName(syntaxTreeNode.getChildren().get(0));

        }
        //ATOMIC -> CONST
        else if(firstChildLabel.equals("CONST")){

            //get the type of the CONST (child index 0)
            return typeOfConst(syntaxTreeNode.getChildren().get(0));

        }

    }

    //CONST -> N
    //CONST -> T
    private static char typeOfConst(SyntaxTreeNode syntaxTreeNode){

        //TODO - incorporate token class into syntax tree nodes

    }

    //ASSIGN -> VNAME < input
    //ASSIGN -> VNAME = TERM
    private static boolean typeCheckAssign(SyntaxTreeNode syntaxTreeNode){

        String thirdChildLabel = syntaxTreeNode.getChildren().get(2).getLabel();

        //firstly differentiate the productions based on the third child's label
        //ASSIGN -> VNAME < input
        if(thirdChildLabel.equals("input")){

            //only numeric user inputs are allowed
            //so check that the typeOf VNAME (child index 0) is 'n'
            return (typeOfVName(syntaxTreeNode.getChildren().get(0)) == 'n');

        }
        //ASSIGN -> VNAME = TERM
        else if(thirdChildLabel.equals("TERM")){

            //can only assign terms to variables of the same type
            //so check that the typeOf TERM (child index 2) is the same as the typeof VNAME (child index 0)
            return (typeOfVName(syntaxTreeNode.getChildren().get(0)) == typeOfTerm(syntaxTreeNode.getChildren().get(2)));

        }

    }

    //TERM -> ATOMIC
    //TERM -> CALL
    //TERM -> OP
    private static char typeOfTerm(SyntaxTreeNode syntaxTreeNode){

        String firstChildLabel = syntaxTreeNode.getChildren().get(0).getLabel();

        //always return the type of the only child
        //differentiate between the three productions based on the first child's label
        //TERM -> ATOMIC
        if(firstChildLabel.equals("ATOMIC")){
            return typeOfAtomic(syntaxTreeNode.getChildren().get(0));
        }
        //TERM -> CALL
        else if(firstChildLabel.equals("CALL")){
            return typeOfCall(syntaxTreeNode.getChildren().get(0));
        }
        //TERM -> OP
        else if(firstChildLabel.equals("OP")){
            return typeOfOp(syntaxTreeNode.getChildren().get(0));
        }

    }

    //CALL -> FNAME(ATOMIC, ATOMIC, ATOMIC)
    private static char typeOfCall(SyntaxTreeNode syntaxTreeNode){



    }

    //OP -> UNOP(ARG)
    //OP -> BINOP(ARG, ARG)

    //ARG -> ATOMIC
    //ARG -> OP

    //UNOP -> not
    //UNOP -> sqrt

    //BINOP -> or
    //BINOP -> and
    //BINOP -> eq
    //BINOP -> grt
    //BINOP -> add
    //BINOP -> sub
    //BINOP -> mul
    //BINOP -> div

    //BRANCH -> if COND then ALGO else ALGO

    //COND -> SIMPLE
    //COND -> COMPOSIT

    //SIMPLE -> BINOP(ATOMIC, ATOMIC)

    //COMPOSIT -> BINOP(SIMPLE, SIMPLE)
    //COMPOSIT -> UNOP(SIMPLE)

    //FNAME -> F

    //FUNCTIONS -> nullable
    //FUNCTIONS -> DECL FUNCTIONS

    //DECL -> HEADER BODY

    //HEADER -> FTYP FNAME(VNAME, VNAME, VNAME)

    //FTYP -> num
    //FTYP -> void

    //BODY -> PROLOG LOCVARS ALGO EPILOG SUBFUNCS end

    //PROLOG -> {

    //EPILOG -> }

    //LOCVARS -> VTYP VNAME, VTYP VNAME, VTYP VNAME

    //SUBFUNCS -> FUNCTIONS
    
}