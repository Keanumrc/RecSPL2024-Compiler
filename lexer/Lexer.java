package lexer;
import java.util.ArrayList;
import java.util.List;

public class Lexer {

    //the DFA that the Lexer controls to detect lexical categories
    private DFA dfa;

    //constructor
    public Lexer(DFA dfa){
        this.dfa = dfa;
    }

    public List<Token> lex(String text) throws Exception{

        //append an end of file (EOF) symbol at the end of text to detect when we have reached the end
        text += '$';

        //initialisation
        List<Token> output = new ArrayList<Token>();
        int tokenID = 1;
        ArrayList<State> previousStates = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        State state;

        //the main loop that iterates over the characters of the text
        while(endIndex < text.length()-1){

            //reset for the next token
            previousStates.clear();
            dfa.reset();
            state = dfa.getCurrentState();
            startIndex = endIndex;

            //loop whilst transitions are defined on the symbols
            do{

                //add the state to previousStates - the first state will always be the non-accepting start state
                previousStates.add(state);
                //get the next symbol
                char symbol = text.charAt(endIndex);
                //get the nextState based on that symbol
                state = dfa.move(symbol);
                //increment endIndex
                endIndex++;

            }while(state != null);

            //look for a prior token, by backtracking to the last accepting state
            do{

                //remove the last state so we can test it
                state = previousStates.remove(previousStates.size()-1);
                //keep endIndex in sync
                endIndex--;

            }while((previousStates.size() > 0) && !state.isAccepting());

            //now we have either found the last accepting state, or state is the start state

            //if state is the last accepting state, then output a token for it
            if(state.isAccepting()){

                //the token is the substring of the text from startIndex till endIndex
                String token = text.substring(startIndex, endIndex);

                //the actual token class is the token class of the the last accepting state
                String tokenClass = state.getTokenClass();

                output.add(new Token(tokenClass, token));

                //increment the tokenID for the next token
                tokenID++;

            }
            //otherwise, we couldn't find a last accepting state on this run of the DFA
            //so we have either encountered the end of file, white space, or a lexical error
            //white space
            else if(text.charAt(endIndex) == ' ' || text.charAt(endIndex) == '\t' || text.charAt(endIndex) == '\n' || text.charAt(endIndex) == '\r'){
                //increment endIndex to skip over the white space
                endIndex++;
            }
            //end report a lexical error
            else{
                throw new Exception("Lexical error at position " + endIndex);
            }

        }

        return output;

    }
    
}