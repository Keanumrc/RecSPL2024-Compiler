public class ShiftAction extends Action {

    private State nextState;

    public ShiftAction(State nextState) {

        super(Action.ActionType.SHIFT);
        this.nextState = nextState;

    }

    public State getNextState(){
        return this.nextState;
    }
    
}