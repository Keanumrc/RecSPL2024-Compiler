package codeGenerator;

import scopeAnalyser.GlobalSymbolTable;
import syntaxTree.CompositeNode;
import syntaxTree.LeafNode;
import syntaxTree.SyntaxTreeNode;

public class CodeGenerator {

    private int currentLineNumber;
    private int currentTempNumericVariable;
    private int currentTempStringVariable;
    private GlobalSymbolTable globalVariableTable;
    private GlobalSymbolTable globalFunctionTable;

    public CodeGenerator(GlobalSymbolTable globalVariableTable, GlobalSymbolTable globalFunctionTable) {
        this.currentLineNumber = 0;
        this.currentTempNumericVariable = 0;
        this.currentTempStringVariable = 0;
        this.globalVariableTable = globalVariableTable;
        this.globalFunctionTable = globalFunctionTable;
    }

    // PROG -> main GLOBVARS ALGO FUNCTIONS
    public String generateProgCode(CompositeNode compositeNode) {

        // initialise current line number to 1
        currentLineNumber = 0;
        currentTempNumericVariable = 0;
        currentTempStringVariable = 0;

        String code = "";

        // ignore main
        // ignore GLOBVARS

        // translate ALGO (child index 2)
        code += generateAlgoCode((CompositeNode) compositeNode.getChildren().get(2));

        // stop the main program before FUNCTIONS are reached
        code += getLineNumber() + "STOP\n";

        // translate FUNCTIONS (child index 3)
        code += generateFunctionsCode((CompositeNode) compositeNode.getChildren().get(3));

        return code;

    }

    // ALGO -> begin INSTRUC end
    private String generateAlgoCode(CompositeNode compositeNode) {

        String code = "";

        // ignore begin

        // translate INSTRUC (child index 1)
        code += generateInstrucCode((CompositeNode) compositeNode.getChildren().get(1));

        // ignore end

        return code;

    }

    // INSTRUC -> nullable
    // INSTRUC -> COMMAND; INSTRUC
    private String generateInstrucCode(CompositeNode compositeNode) {

        String code = "";

        // firstly, differentiate between the two productions
        // INSTRUC -> nullable
        if (compositeNode.getChildren().size() == 0) {

            code += getLineNumber() + "REM END\n";

        }
        // INSTRUC -> COMMAND; INSTRUC
        else {

            // translate COMMAND (child index 0)
            code += generateCommandCode((CompositeNode) compositeNode.getChildren().get(0));

            // translate INSTRUC (child index 2)
            code += generateInstrucCode((CompositeNode) compositeNode.getChildren().get(2));

        }

        return code;

    }

    // COMMAND -> skip
    // COMMAND -> halt
    // COMMAND -> print ATOMIC
    // COMMAND -> return ATOMIC
    // COMMAND -> ASSIGN
    // COMMAND -> CALL
    // COMMAND -> BRANCH
    private String generateCommandCode(CompositeNode compositeNode) {

        String code = "";

        SyntaxTreeNode firstChild = compositeNode.getChildren().get(0);

        // firstly, differentiate between the seven productions based on the first child

        // COMMAND -> ASSIGN
        // COMMAND -> CALL
        // COMMAND -> BRANCH
        if (firstChild instanceof CompositeNode) {

            String firstChildLabel = ((CompositeNode) firstChild).getNonTerminal();

            // COMMAND -> ASSIGN
            if (firstChildLabel.equals("ASSIGN")) {

                code += generateAssignCode((CompositeNode) compositeNode.getChildren().get(0));

            }
            // COMMAND -> CALL
            else if (firstChildLabel.equals("CALL")) {

                code += generateCallCode((CompositeNode) compositeNode.getChildren().get(0));

            }
            // COMMAND -> BRANCH
            else {

                code += generateBranchCode((CompositeNode) compositeNode.getChildren().get(0));

            }

        }
        // COMMAND -> skip
        // COMMAND -> halt
        // COMMAND -> print ATOMIC
        // COMMAND -> return ATOMIC
        else {

            String firstChildLabel = ((LeafNode) firstChild).getWord();

            // COMMAND -> skip
            if (firstChildLabel.equals("skip")) {

                code += getLineNumber() + "REM DO NOTHING\n";

            }
            // COMMAND -> halt
            else if (firstChildLabel.equals("halt")) {

                code += getLineNumber() + "STOP\n";

            }
            // COMMAND -> print ATOMIC
            else if (firstChildLabel.equals("print")) {

                code += getLineNumber() + "PRINT "
                        + generateAtomicCode((CompositeNode) compositeNode.getChildren().get(1)) + "\n";

            }
            // COMMAND -> return ATOMIC
            else {

                // TODO

            }

        }

        return code;

    }

    // ATOMIC -> VNAME
    // ATOMIC -> CONST
    private String generateAtomicCode(CompositeNode compositeNode) {

        String code = "";

        // firstly, differentiate between the two productions based on the first child's
        // label
        String firstChildLabel = ((CompositeNode) compositeNode.getChildren().get(0)).getNonTerminal();
        // ATOMIC -> VNAME
        if (firstChildLabel.equals("VNAME")) {

            code += generateVNameCode((CompositeNode) compositeNode.getChildren().get(0));

        }
        // ATOMIC -> CONST
        else {

            code += generateConstCode((CompositeNode) compositeNode.getChildren().get(0));

        }

        return code;

    }

    // VNAME -> V
    private String generateVNameCode(CompositeNode compositeNode) {

        String code = "";

        LeafNode vNode = (LeafNode) compositeNode.getChildren().get(0);
        code += vNode.getWord();

        //if it is a string variable, append a '$' on the end
        if(globalVariableTable.lookupType(vNode.getWord()) == 't'){
            code += "$";
        }

        return code;

    }

    // CONST -> N
    // CONST -> T
    private String generateConstCode(CompositeNode compositeNode) {

        String code = "";

        LeafNode child = (LeafNode) compositeNode.getChildren().get(0);

        code += child.getWord();

        return code;

    }

    // ASSIGN -> VNAME < input
    // ASSIGN -> VNAME = TERM
    private String generateAssignCode(CompositeNode compositeNode) {

        String code = "";

        String secondChildLabel = ((LeafNode) compositeNode.getChildren().get(1)).getTokenClass();

        // firstly differentiate the productions based on the second child's label
        // ASSIGN -> VNAME < input
        if (secondChildLabel.equals("STREAM")) {

            code += getLineNumber() + "INPUT " + generateVNameCode((CompositeNode) compositeNode.getChildren().get(0))
                    + "\n";

        }
        // ASSIGN -> VNAME = TERM
        else {

            //first determine the type of VNAME
            String variableName = ((LeafNode)((CompositeNode)compositeNode.getChildren().get(0)).getChildren().get(0)).getWord();
            char type = globalVariableTable.lookupType(variableName);
            String place;

            if(type == 't'){

                //generate a place for the TERM result
                place = getTempStringVariable();

            }
            else{

                //generate a place for the TERM result
                place = getTempNumericVariable();

            }

            //generate the TERM code
            String termCode = generateTermCode((CompositeNode) compositeNode.getChildren().get(2), place);

            code += termCode;
            code += getLineNumber();
            code += "LET " + generateVNameCode((CompositeNode) compositeNode.getChildren().get(0));
            code += " = " + place + "\n";

        }

        return code;

    }

    // TERM -> ATOMIC
    // TERM -> CALL
    // TERM -> OP
    private String generateTermCode(CompositeNode compositeNode, String place) {

        String code = "";

        String firstChildLabel = ((CompositeNode) compositeNode.getChildren().get(0)).getNonTerminal();

        // differentiate between the three productions based on the first child's label
        // TERM -> ATOMIC
        if (firstChildLabel.equals("ATOMIC")) {
            code += getLineNumber();
            code += "LET " + place + " = " + generateAtomicCode((CompositeNode)compositeNode.getChildren().get(0));
            code += "\n";
        }
        // TERM -> CALL
        else if (firstChildLabel.equals("CALL")) {
            code += generateCallCode((CompositeNode)compositeNode.getChildren().get(0));
        }
        // TERM -> OP
        else {
            code += generateOpCode((CompositeNode)compositeNode.getChildren().get(0), place);
        }

        return code;

    }
  
    // OP -> UNOP(ARG)
    // OP -> BINOP(ARG, ARG)
    private String generateOpCode(CompositeNode compositeNode, String place) {

        String code = "";

        // firstly, differentiate between the two productions
        // OP -> UNOP(ARG)
        if (compositeNode.getChildren().size() == 4) {

            //generate a place1
            String place1;
            //check if place is a string or numeric variable
            //string
            if(place.contains("$")){
                place1 = getTempStringVariable();
            }
            //numeric
            else{
                place1 = getTempNumericVariable();
            }

            //generate the ARG (child index 2) code
            String argCode = generateArgCode((CompositeNode)compositeNode.getChildren().get(2), place1);

            //generate the UNOP (child index 0) code
            String operator = generateUnOpCode((CompositeNode)compositeNode.getChildren().get(0));

            code += argCode;
            code += getLineNumber();
            code += "LET " + place + " = " + operator + "(" + place1 + ")\n";

        }
        // OP -> BINOP(ARG, ARG)
        else {

            //generate a place1 and a place2
            String place1;
            String place2;
            //check if place is a string or numeric variable
            //string
            if(place.contains("$")){
                place1 = getTempStringVariable();
                place2 = getTempStringVariable();
            }
            //numeric
            else{
                place1 = getTempNumericVariable();
                place2 = getTempNumericVariable();
            }     
            
            //generate the ARG (child index 2 and 4) code  
            String argCode1 = generateArgCode((CompositeNode)compositeNode.getChildren().get(2), place1); 
            String argCode2 = generateArgCode((CompositeNode)compositeNode.getChildren().get(4), place2);   
            
            //generate the BINOP (child index 0) code
            String operator = generateBinOpCode((CompositeNode)compositeNode.getChildren().get(0));

            code += argCode1;
            code += argCode2;
            code += getLineNumber();
            code += "LET " + place + " = " + place1 + " " + operator + " " + place2;
            code += "\n";

        }

        return code;

    }

    // UNOP -> not
    // UNOP -> sqrt
    private String generateUnOpCode(CompositeNode compositeNode) {

        String code = "";

        // firstly, differentiate between the two productions
        // UNOP -> not
        if (((LeafNode) compositeNode.getChildren().get(0)).getWord().equals("not")) {
            //TODO
        }
        // UNOP -> sqrt
        else {
            code += "SQR";
        }

        return code;

    }

    // BINOP -> or
    // BINOP -> and
    // BINOP -> eq
    // BINOP -> grt
    // BINOP -> add
    // BINOP -> sub
    // BINOP -> mul
    // BINOP -> div
    private String generateBinOpCode(CompositeNode compositeNode){

        String code = "";

        // firstly, differentiate between the productions based on the first child's
        // label
        String firstChildLabel = ((LeafNode) compositeNode.getChildren().get(0)).getWord();

        // BINOP -> or
        if(firstChildLabel.equals("or")){
            //TODO
        }
        // BINOP -> and
        else if(firstChildLabel.equals("and")){
            //TODO
        }
        // BINOP -> eq
        else if(firstChildLabel.equals("eq")){
            code += "=";
        }
        // BINOP -> grt
        else if(firstChildLabel.equals("grt")){
            code += ">";
        }
        // BINOP -> add
        else if(firstChildLabel.equals("add")){
            code += "+";
        }
        // BINOP -> sub
        else if(firstChildLabel.equals("sub")){
            code += "-";
        }
        // BINOP -> mul
        else if(firstChildLabel.equals("mul")){
            code += "*";
        }
        // BINOP -> div  
        else{
            code += "/";
        }      

        return code;

    }

    // ARG -> ATOMIC
    // ARG -> OP
    private String generateArgCode(CompositeNode compositeNode, String place){

        String code = "";

        // firstly, differentiate between the two productions
        // ARG -> ATOMIC
        if (((CompositeNode) compositeNode.getChildren().get(0)).getNonTerminal().equals("ATOMIC")) {
            code += getLineNumber();
            code += "LET " + place + " = " + generateAtomicCode((CompositeNode)compositeNode.getChildren().get(0));
            code += "\n";
        }
        // ARG -> OP
        else {
            code += generateOpCode((CompositeNode)compositeNode.getChildren().get(0), place);
        }

        return code;

    }

    private String generateCallCode(CompositeNode compositeNode) {

        //TODO
        String code = "";

        return code;

    }

    private String generateBranchCode(CompositeNode compositeNode) {

        //TODO
        String code = "";

        return code;

    }

    private String generateFunctionsCode(CompositeNode compositeNode) {

        //TODO
        String code = "";

        return code;

    }

    // helper function to generate line numbers followed by a space for BASIC code
    private String getLineNumber() {
        String output = currentLineNumber + " ";
        currentLineNumber++;
        return output;
    }

    //helper function to generate temp numeric variables
    private String getTempNumericVariable(){
        String output = "T" + currentTempNumericVariable;
        currentTempNumericVariable++;
        return output;
    }

    //helper function to generate temp string variables
    private String getTempStringVariable(){
        String output = "T" + currentTempStringVariable + "$";
        currentTempStringVariable++;
        return output;
    }

}