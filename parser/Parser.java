import java.util.List;
import java.util.Stack;

import lexer.Token;
import syntaxTree.SyntaxTreeNode;

public class Parser {

    private Stack<State> stack;
    private Stack<SyntaxTreeNode> treeStack;
    private State startState;

    public Parser(State startState){
        this.startState = startState;
        stack = new Stack<State>();
        treeStack = new Stack<SyntaxTreeNode>();
    }

    public SyntaxTreeNode parse(List<Token> tokens) throws Exception{

        //append an end-of-file token to the end of the tokenstream
        tokens.add(new Token("$", "$"));

        //push the start state onto the stack
        stack.push(this.startState);

        //create an index to iterate through the tokens
        int i = 0;

        //get the first token
        Token token = tokens.get(i);

        //get the state on top of the stack
        State topState = stack.peek();

        //get the next action based on the top state
        Action nextAction = topState.getNextAction(token.getTokenClass());

        while(nextAction != null && nextAction.getActionType() != Action.ActionType.ACCEPT){

            //if the next action is a shift action, push the next state onto the stack and read an input token
            if(nextAction.getActionType() == Action.ActionType.SHIFT){
                stack.push(((ShiftAction)nextAction).getNextState());
                treeStack.push(new SyntaxTreeNode(token.getWord()));
                i++;
            }
            //otherwise if the next action is a reduce action,
            else if(nextAction.getActionType() == Action.ActionType.REDUCE){

                //get the action's production
                Production actionProduction = ((ReduceAction)nextAction).getProduction();

                //prepare an array to hold the SyntaxTreeNodes that will be popped off treeStack
                SyntaxTreeNode[] nodes = new SyntaxTreeNode[actionProduction.getRhs().length];

                //pop the same number of states from the stack as there are tokens on the rhs of the action's production
                for(int j = 0; j < actionProduction.getRhs().length; j++){
                    stack.pop();
                    nodes[actionProduction.getRhs().length-1-j] = treeStack.pop();
                }

                //get the production's lhs
                String lhs = actionProduction.getLhs();

                //cross-reference the new state on top of the stack and lhs to get the goto action that is next
                State newStackTop = stack.peek();
                GotoAction gotoAction = (GotoAction)newStackTop.getNextAction(lhs);

                //push a new SyntaxTreeNode onto treeStack
                treeStack.push(new SyntaxTreeNode(lhs, nodes));

                //use the GotoAction to push a new state on top of the stack
                stack.push(gotoAction.getNextState());

            }

            // get the next token
            token = tokens.get(i);

            // get the state on top of the stack
            topState = stack.peek();

            // get the next action based on the top state
            nextAction = topState.getNextAction(token.getTokenClass());

        }

        if(nextAction == null){
            throw new Exception("Syntax Error: Was trying to get action for state " + stack.peek().getLabel() + " on " + token.getTokenClass());
        }
        else{
            return treeStack.peek();
        }

    }
    
}