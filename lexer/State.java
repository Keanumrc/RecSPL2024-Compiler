package lexer;
import java.util.HashMap;
import java.util.Map;

public class State {

    private String label;
    private boolean accepting;
    private Map<Character, State> transitionFunction;
    private String tokenClass;

    public State(String label, boolean accepting, String tokenClass){
        this.label = label;
        this.accepting = accepting;
        this.tokenClass = tokenClass;
        this.transitionFunction = new HashMap<Character, State>();
    }

    public String getLabel(){
        return this.label;
    }

    public String getTokenClass(){
        return this.tokenClass;
    }

    public void addTransition(char symbol, State toState){
        this.transitionFunction.put(symbol, toState);
    }

    public void addTransitions(String symbols, State toState){
        
        for(int i = 0; i < symbols.length(); i++){
            this.transitionFunction.put(symbols.charAt(i), toState);
        }

    }

    public State getNextState(char symbol){
        return this.transitionFunction.get(symbol);
    }

    public boolean isAccepting(){
        return this.accepting;
    }
    
}