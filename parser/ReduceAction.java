public class ReduceAction extends Action {

    private Production production;

    public ReduceAction(Production production) {

        super(Action.ActionType.REDUCE);
        this.production = production;

    }

    public Production getProduction(){
        return this.production;
    }
    
}