public abstract class Action {

    public enum ActionType {
        SHIFT,
        REDUCE,
        GOTO,
        ACCEPT
    }

    private ActionType actionType;

    public Action(ActionType actionType){
        this.actionType = actionType;
    }

    public ActionType getActionType(){
        return this.actionType;
    }
    
}