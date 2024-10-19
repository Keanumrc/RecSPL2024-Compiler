import java.util.HashMap;
import java.util.Map;

public class State {

    private int label;
    private Map<String, Action> transitionFunction;

    public State(int label){
        this.label = label;
        this.transitionFunction = new HashMap<String, Action>();
    }

    public int getLabel(){
        return this.label;
    }

    public Action getNextAction(String token){
        return this.transitionFunction.get(token);
    }

    public void addTransition(String token, Action action){
        this.transitionFunction.put(token, action);
    }
    
}