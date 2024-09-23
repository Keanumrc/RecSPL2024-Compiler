public class DFA {

    private State startState;
    private State currentState;

    public DFA(State startState){
        this.startState = startState;
        this.currentState = startState;
    }

    public void reset(){
        this.currentState = startState;
    }

    public State move(char symbol){
        return(this.currentState = this.currentState.getNextState(symbol));
    }

    public boolean run(String stringToRun){

        State runCurrentState = this.startState;

        int totalStringLength = stringToRun.length();
        int stringIndex = 0;

        while(stringIndex < totalStringLength && runCurrentState != null){
            char currentChar = stringToRun.charAt(stringIndex);
            runCurrentState = runCurrentState.getNextState(currentChar);
            stringIndex++;
        }

        return ((runCurrentState != null) && (runCurrentState.isAccepting()));

    }

    public String getTokenClass(String stringToRun){

        State getTokenClassCurrentState = this.startState;

        int totalStringLength = stringToRun.length();
        int stringIndex = 0;

        while(stringIndex < totalStringLength && getTokenClassCurrentState != null){
            char currentChar = stringToRun.charAt(stringIndex);
            getTokenClassCurrentState = getTokenClassCurrentState.getNextState(currentChar);
            stringIndex++;
        }

        if(getTokenClassCurrentState == null || !getTokenClassCurrentState.isAccepting()){
            return "LEXICAL ERROR";
        }
        else{
            return getTokenClassCurrentState.getTokenClass();
        }

    }
    
}