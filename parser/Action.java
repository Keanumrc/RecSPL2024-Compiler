public class Action {

    public enum ActionType {
        SHIFT,
        REDUCE,
        GOTO,
        ACCEPT
    }

    private ActionType actionType;
    private State nextState;

    public Action(ActionType actionType, State nextState){
        this.actionType = actionType;
        this.nextState = nextState;
    }

    public ActionType getActionType(){
        return this.actionType;
    }

    public State getNextState(){
        return this.nextState;
    }
    
}