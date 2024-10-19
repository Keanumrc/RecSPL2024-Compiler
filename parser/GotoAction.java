public class GotoAction extends Action {

    private State nextState;

    public GotoAction(State nextState){

        super(Action.ActionType.GOTO);
        this.nextState = nextState;

    }

    public State getNextState(){
        return this.nextState;
    }
    
}