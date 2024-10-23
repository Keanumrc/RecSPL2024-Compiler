package typeChecker;

import syntaxTree.CompositeNode;
import syntaxTree.LeafNode;
import syntaxTree.SyntaxTreeNode;

public class TypeChecker {

    // PROG -> main GLOBVARS ALGO FUNCTIONS
    public static boolean typeCheckProg(CompositeNode syntaxTreeNode) {

        // type check GLOBVARS (child index 1)
        // all results need to be true for this method to return true
        boolean result = typeCheckGlobVars((CompositeNode) syntaxTreeNode.getChildren().get(1));

        // type check ALGO (child index 2)
        result = result && typeCheckAlgo((CompositeNode) syntaxTreeNode.getChildren().get(2));

        // type check FUNCTIONS (child index 3)
        result = result && typeCheckFunctions((CompositeNode) syntaxTreeNode.getChildren().get(3));

        return result;

    }

    // GLOBVARS -> nullable
    // GLOBVARS -> VTYP VNAME, GLOBVARS
    private static boolean typeCheckGlobVars(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // GLOBVARS -> nullable
        if (syntaxTreeNode.getChildren().size() == 0) {
            // recursive base case - return true
            return true;
        }
        // GLOBVARS -> VTYP VNAME, GLOBVARS
        else {

            // TODO
            // bind VNAME to VTYP in the symbol table

            // typecheck the rest of the GLOBVARS (child index 3)
            return typeCheckGlobVars((CompositeNode) syntaxTreeNode.getChildren().get(3));

        }

    }

    // VTYP -> num
    // VTYP -> text
    private static char typeOfVtyp(CompositeNode syntaxTreeNode) {

        String firstChildLabel = ((LeafNode) syntaxTreeNode.getChildren().get(0)).getWord();

        // firstly, differentiate between the two productions based on the label of the
        // first child
        // VTYP -> num
        if (firstChildLabel.equals("num")) {
            return 'n';
        }
        // VTYP -> text
        else {
            return 't';
        }

    }

    // VNAME -> V
    private static char typeOfVName(CompositeNode syntaxTreeNode) {

        // TODO
        // get type from symbol table

    }

    // ALGO -> begin INSTRUC end
    private static boolean typeCheckAlgo(CompositeNode syntaxTreeNode) {

        // type check the INSTRUC (child index 1)
        return typeCheckInstruc((CompositeNode) syntaxTreeNode.getChildren().get(1));

    }

    // INSTRUC -> nullable
    // INSTRUC -> COMMAND; INSTRUC
    private static boolean typeCheckInstruc(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // INSTRUC -> nullable
        if (syntaxTreeNode.getChildren().size() == 0) {
            // recursive base case - return true
            return true;
        }
        // INSTRUC -> COMMAND; INSTRUC
        else {

            // type check the COMMAND (child index 0)
            boolean result = typeCheckCommand((CompositeNode) syntaxTreeNode.getChildren().get(0));

            // type check the INSTRUC (child index 2)
            result = result && typeCheckInstruc((CompositeNode) syntaxTreeNode.getChildren().get(2));

            return result;

        }

    }

    // COMMAND -> skip
    // COMMAND -> halt
    // COMMAND -> print ATOMIC
    // COMMAND -> return ATOMIC
    // COMMAND -> ASSIGN
    // COMMAND -> CALL
    // COMMAND -> BRANCH
    private static boolean typeCheckCommand(CompositeNode syntaxTreeNode) {

        SyntaxTreeNode firstChild = syntaxTreeNode.getChildren().get(0);

        // firstly, differentiate between the seven productions based on the first child

        // COMMAND -> ASSIGN
        // COMMAND -> CALL
        // COMMAND -> BRANCH
        if (firstChild instanceof CompositeNode) {

            String firstChildLabel = ((CompositeNode) firstChild).getNonTerminal();

            // COMMAND -> ASSIGN
            if (firstChildLabel.equals("ASSIGN")) {

                // type check ASSIGN (child index 0)
                return typeCheckAssign((CompositeNode) syntaxTreeNode.getChildren().get(0));

            }
            // COMMAND -> CALL
            else if (firstChildLabel.equals("CALL")) {

                // check that this is a call to a void function
                return (typeOfCall((CompositeNode) syntaxTreeNode.getChildren().get(0)) == 'v');

            }
            // COMMAND -> BRANCH
            else if (firstChildLabel.equals("BRANCH")) {

                // type check the BRANCH (child index 0)
                return typeCheckBranch((CompositeNode) syntaxTreeNode.getChildren().get(0));

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
                return true;
            }
            // COMMAND -> halt
            else if (firstChildLabel.equals("halt")) {
                return true;
            }
            // COMMAND -> print ATOMIC
            else if (firstChildLabel.equals("print")) {

                // can only print numbers or text
                // so check that ATOMIC (child index 1) is of type 'n' or 't'
                CompositeNode atomic = (CompositeNode) syntaxTreeNode.getChildren().get(1);
                return (typeOfAtomic(atomic) == 'n' || typeOfAtomic(atomic) == 't');

            }
            // COMMAND -> return ATOMIC
            else {

                // TODO
                // check that typeOf Atomic == type the function returns == 'n'

            }

        }

    }

    // ATOMIC -> VNAME
    // ATOMIC -> CONST
    private static char typeOfAtomic(CompositeNode syntaxTreeNode) {

        String firstChildLabel = ((CompositeNode) syntaxTreeNode.getChildren().get(0)).getNonTerminal();

        // firstly, differentiate between the two productions based on the first child's
        // label
        // ATOMIC -> VNAME
        if (firstChildLabel.equals("VNAME")) {

            // get the type of the VNAME (child index 0)
            return typeOfVName((CompositeNode) syntaxTreeNode.getChildren().get(0));

        }
        // ATOMIC -> CONST
        else {

            // get the type of the CONST (child index 0)
            return typeOfConst((CompositeNode) syntaxTreeNode.getChildren().get(0));

        }

    }

    // CONST -> N
    // CONST -> T
    private static char typeOfConst(CompositeNode syntaxTreeNode) {

        // TODO
        // incorporate token class into syntax tree nodes

    }

    // ASSIGN -> VNAME < input
    // ASSIGN -> VNAME = TERM
    private static boolean typeCheckAssign(CompositeNode syntaxTreeNode) {

        String secondChildLabel = ((LeafNode) syntaxTreeNode.getChildren().get(1)).getTokenClass();

        // firstly differentiate the productions based on the second child's label
        // ASSIGN -> VNAME < input
        if (secondChildLabel.equals("STREAM")) {

            // only numeric user inputs are allowed
            // so check that the typeOf VNAME (child index 0) is 'n'
            return (typeOfVName((CompositeNode) syntaxTreeNode.getChildren().get(0)) == 'n');

        }
        // ASSIGN -> VNAME = TERM
        else {

            // can only assign terms to variables of the same type
            // so check that the typeOf TERM (child index 2) is the same as the typeof VNAME
            // (child index 0)
            return (typeOfVName((CompositeNode) syntaxTreeNode.getChildren().get(0)) == typeOfTerm(
                    (CompositeNode) syntaxTreeNode.getChildren().get(2)));

        }

    }

    // TERM -> ATOMIC
    // TERM -> CALL
    // TERM -> OP
    private static char typeOfTerm(CompositeNode syntaxTreeNode) {

        String firstChildLabel = ((CompositeNode) syntaxTreeNode.getChildren().get(0)).getNonTerminal();

        // always return the type of the only child
        // differentiate between the three productions based on the first child's label
        // TERM -> ATOMIC
        if (firstChildLabel.equals("ATOMIC")) {
            return typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }
        // TERM -> CALL
        else if (firstChildLabel.equals("CALL")) {
            return typeOfCall((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }
        // TERM -> OP
        else {
            return typeOfOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }

    }

    // CALL -> FNAME(ATOMIC, ATOMIC, ATOMIC)
    private static char typeOfCall(CompositeNode syntaxTreeNode) {

        // all three parameters must be numeric
        // so check that typeOf ATOMIC (child index 2), ATOMIC (child index 4) and
        // ATOMIC (child index 6)
        // are all numeric
        char firstType = typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(2));
        char secondType = typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(4));
        char thirdType = typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(6));

        if (firstType == 'n' && secondType == 'n' && thirdType == 'n') {
            return typeOfFName((CompositeNode) syntaxTreeNode.getChildren().get(0));
        } else {
            // return an undefined type
            return 'u';
        }

    }

    // OP -> UNOP(ARG)
    // OP -> BINOP(ARG, ARG)
    private static char typeOfOp(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // OP -> UNOP(ARG)
        if (syntaxTreeNode.getChildren().size() == 4) {

            // get the types of UNOP (child index 0) and ARG (child index 2)
            char unOpType = typeOfUnOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
            char argType = typeOfArg((CompositeNode) syntaxTreeNode.getChildren().get(2));

            if ((unOpType == argType) && (argType == 'b')) {
                return 'b';
            } else if ((unOpType == argType) && (argType == 'n')) {
                return 'n';
            } else {
                return 'u';
            }

        }
        // OP -> BINOP(ARG, ARG)
        else {

            // get the types of BINOP (child index 0) and ARG (child index 2) and ARG (child
            // index 4)
            char binOpType = typeOfBinOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
            char arg1Type = typeOfArg((CompositeNode) syntaxTreeNode.getChildren().get(2));
            char arg2Type = typeOfArg((CompositeNode) syntaxTreeNode.getChildren().get(4));

            if ((binOpType == arg1Type) && (arg1Type == arg2Type) && (arg2Type == 'b')) {
                return 'b';
            } else if ((binOpType == arg1Type) && (arg1Type == arg2Type) && (arg2Type == 'n')) {
                return 'n';
            } else if ((binOpType == 'c') && (arg1Type == arg2Type) && (arg2Type == 'n')) {
                return 'b';
            } else {
                return 'u';
            }

        }

    }

    // ARG -> ATOMIC
    // ARG -> OP
    private static char typeOfArg(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // ARG -> ATOMIC
        if (((CompositeNode) syntaxTreeNode.getChildren().get(0)).getNonTerminal().equals("ATOMIC")) {
            return typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }
        // ARG -> OP
        else {
            return typeOfOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }

    }

    // UNOP -> not
    // UNOP -> sqrt
    private static char typeOfUnOp(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // UNOP -> not
        if (((LeafNode) syntaxTreeNode.getChildren().get(0)).getWord().equals("not")) {
            return 'b';
        }
        // UNOP -> sqrt
        else {
            return 'n';
        }

    }

    // BINOP -> or
    // BINOP -> and
    // BINOP -> eq
    // BINOP -> grt
    // BINOP -> add
    // BINOP -> sub
    // BINOP -> mul
    // BINOP -> div
    private static char typeOfBinOp(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the productions based on the first child's
        // label
        String firstChildLabel = ((LeafNode) syntaxTreeNode.getChildren().get(0)).getWord();
        // BINOP -> or
        // BINOP -> and
        if (firstChildLabel.equals("or") || firstChildLabel.equals("and")) {
            return 'b';
        }
        // BINOP -> eq
        // BINOP -> grt
        else if (firstChildLabel.equals("eq") || firstChildLabel.equals("grt")) {
            return 'c';
        }
        // BINOP -> add
        // BINOP -> sub
        // BINOP -> mul
        // BINOP -> div
        else {
            return 'n';
        }

    }

    // BRANCH -> if COND then ALGO else ALGO
    private static boolean typeCheckBranch(CompositeNode syntaxTreeNode) {

        // COND (child index 1) has to be a boolean
        // and then both ALGOs (child index 3 and child index 5) have to be correctly
        // typed
        char condType = typeOfCond((CompositeNode) syntaxTreeNode.getChildren().get(1));
        boolean typeCheckAlgo1 = typeCheckAlgo((CompositeNode) syntaxTreeNode.getChildren().get(3));
        boolean typeCheckAlgo2 = typeCheckAlgo((CompositeNode) syntaxTreeNode.getChildren().get(5));

        return ((condType == 'b') && typeCheckAlgo1 && typeCheckAlgo2);

    }

    // COND -> SIMPLE
    // COND -> COMPOSIT
    private static char typeOfCond(CompositeNode syntaxTreeNode) {

        // firstly differentiate between the two productions
        // COND -> SIMPLE
        if (((CompositeNode) syntaxTreeNode.getChildren().get(0)).getNonTerminal().equals("SIMPLE")) {
            return typeOfSimple((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }
        // COND -> COMPOSIT
        else {
            return typeOfComposit((CompositeNode) syntaxTreeNode.getChildren().get(0));
        }

    }

    // SIMPLE -> BINOP(ATOMIC, ATOMIC)
    private static char typeOfSimple(CompositeNode syntaxTreeNode) {

        // get the types of BINOP (child index 0) and ATOMIC (child index 2) and ATOMIC
        // (child index 4)
        char binOpType = typeOfBinOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
        char atomic1Type = typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(2));
        char atomic2Type = typeOfAtomic((CompositeNode) syntaxTreeNode.getChildren().get(4));

        if ((binOpType == atomic1Type) && (atomic1Type == atomic2Type) && (atomic2Type == 'b')) {
            return 'b';
        } else if ((binOpType == 'c') && (atomic1Type == atomic2Type) && (atomic2Type == 'n')) {
            return 'b';
        } else {
            return 'u';
        }

    }

    // COMPOSIT -> BINOP(SIMPLE, SIMPLE)
    // COMPOSIT -> UNOP(SIMPLE)
    private static char typeOfComposit(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // COMPOSIT -> BINOP(SIMPLE, SIMPLE)
        if (((CompositeNode) syntaxTreeNode.getChildren().get(0)).getNonTerminal().equals("BINOP")) {

            // BINOP (child index 0) and both SIMPLEs (child index 2 and child index 4)
            // must all be booleans
            char binOpType = typeOfBinOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
            char simple1Type = typeOfSimple((CompositeNode) syntaxTreeNode.getChildren().get(2));
            char simple2Type = typeOfSimple((CompositeNode) syntaxTreeNode.getChildren().get(4));

            if ((binOpType == 'b') && (simple1Type == 'b') && (simple2Type == 'b')) {
                return 'b';
            } else {
                return 'u';
            }

        }
        // COMPOSIT -> UNOP(SIMPLE)
        else {

            // UNOP (child index 0) and SIMPLE (child index 2)
            // must both be booleans
            char unOpType = typeOfUnOp((CompositeNode) syntaxTreeNode.getChildren().get(0));
            char simpleType = typeOfSimple((CompositeNode) syntaxTreeNode.getChildren().get(2));

            if ((unOpType == 'b') && (simpleType == 'b')) {
                return 'b';
            } else {
                return 'u';
            }

        }

    }

    // FNAME -> F
    private static char typeOfFName(CompositeNode syntaxTreeNode) {
        // TODO
        // Look up type of name F in the symbol table
    }

    // FUNCTIONS -> nullable
    // FUNCTIONS -> DECL FUNCTIONS
    private static boolean typeCheckFunctions(CompositeNode syntaxTreeNode) {

        // firstly differentiate between the two productions
        // FUNCTIONS -> nullable
        if (syntaxTreeNode.getChildren().size() == 0) {
            return true;
        }
        // FUNCTIONS -> DECL FUNCTIONS
        else {
            // ensure that both DECL (child index 0) and FUNCTIONS (child index 1) are
            // correctly typed
            boolean result = typeCheckDecl((CompositeNode) syntaxTreeNode.getChildren().get(0));
            result = result && typeCheckFunctions((CompositeNode) syntaxTreeNode.getChildren().get(1));
            return result;
        }

    }

    // DECL -> HEADER BODY
    private static boolean typeCheckDecl(CompositeNode syntaxTreeNode) {

        // ensure that both HEADER (child index 0) and BODY (child index 1) are
        // correctly typed
        boolean result = typeCheckHeader((CompositeNode) syntaxTreeNode.getChildren().get(0));
        result = result && typeCheckBody((CompositeNode) syntaxTreeNode.getChildren().get(1));
        return result;

    }

    // HEADER -> FTYP FNAME(VNAME, VNAME, VNAME)
    private static boolean typeCheckHeader(CompositeNode syntaxTreeNode) {

        // TODO
        // bind FNAME to FTYPE in symbol table

    }

    // FTYP -> num
    // FTYP -> void
    private static char typeOfFType(CompositeNode syntaxTreeNode) {

        // firstly, differentiate between the two productions
        // FTYP -> num
        if (((LeafNode) syntaxTreeNode.getChildren().get(0)).getWord().equals("num")) {
            return 'n';
        }
        // FTYP -> void
        else {
            return 'v';
        }

    }

    // BODY -> PROLOG LOCVARS ALGO EPILOG SUBFUNCS end
    private static boolean typeCheckBody(CompositeNode syntaxTreeNode) {

        // LOCVARS (child index 1), ALGO (child index 2) and SUBFUNCS (child index 4)
        // must all be correctly typed
        boolean result = typeCheckLocVars((CompositeNode) syntaxTreeNode.getChildren().get(1));
        result = result && typeCheckAlgo((CompositeNode) syntaxTreeNode.getChildren().get(2));
        result = result && typeCheckSubfuncs((CompositeNode) syntaxTreeNode.getChildren().get(4));
        return result;

    }

    // LOCVARS -> VTYP VNAME, VTYP VNAME, VTYP VNAME
    private static boolean typeCheckLocVars(CompositeNode syntaxTreeNode) {

        // TODO
        // bind all VTYP to VNAME

    }

    // SUBFUNCS -> FUNCTIONS
    private static boolean typeCheckSubfuncs(CompositeNode syntaxTreeNode) {

        return typeCheckFunctions((CompositeNode) syntaxTreeNode.getChildren().get(0));

    }

}