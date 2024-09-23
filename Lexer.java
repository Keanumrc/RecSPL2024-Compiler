import java.util.ArrayList;

public class Lexer {

    private DFA dfa;

    public Lexer(DFA dfa){
        this.dfa = dfa;
    }

    public String lex(String text){

        //append an eof symbol at end of text
        text += '$';

        String output = "<TOKENSTREAM>\n";

        int tokenID = 0;

        ArrayList<State> tokenStates = new ArrayList<>();
        String token = "";
        tokenID++;
        dfa.reset();

        for(int i = 0; i < text.length(); i++){

            char nextSymbol = text.charAt(i);
            State nextState = this.dfa.move(nextSymbol);

            //no transition defined on nextSymbol
            //try back track to last accepting state
            if(nextState == null){

                State lastAcceptingState = null;
                int lastIndex = 0;

                //iterate over the list in reverse and get the last accepting state
                for(int listIndex = tokenStates.size()-1; listIndex >= 0; listIndex--){
                    if(tokenStates.get(listIndex).isAccepting()){
                        lastAcceptingState = tokenStates.get(listIndex);
                        lastIndex = listIndex;
                        break;
                    }
                }

                if(lastAcceptingState != null){
                    //the actual token is the substring of token up to lastIndex+1
                    token = token.substring(0, lastIndex+1);

                    //the actual token class is the token class of the lastAcceptingState
                    String tokenClass = lastAcceptingState.getTokenClass();

                    output += "\t<TOK>\n";
                    output += "\t\t<ID>" + tokenID + "</ID>\n";
                    output += "\t\t<CLASS>" + tokenClass + "</CLASS>\n";
                    output += "\t\t<WORD>" + token + "</WORD>\n";
                    output += "\t</TOK>\n";

                    tokenStates.clear();
                    token = "";
                    tokenID++;
                    dfa.reset();

                    //reset back if not a whitespace character
                    //remove this code if has to be whitespace characters in between
                    if(nextSymbol != ' ' && nextSymbol != '\t' && nextSymbol != '\n'){
                        i--;
                    }
                    //skip to end of whitespace
                    else if(i < text.length()-1){
                        char nextNextSymbol = text.charAt(i+1);
                        while(i < text.length()-1 && (nextNextSymbol == ' ' || nextNextSymbol == '\t' || nextNextSymbol == '\n')){
                            i++;
                            nextNextSymbol = text.charAt(i+1);
                        }
                    }
                    
                }
                else{
                    if(nextSymbol == '$'){
                        break;
                    }
                    else if(nextSymbol == ' ' || nextSymbol == '\t' || nextSymbol == '\n'){
                        tokenStates.clear();
                        token = "";
                        tokenID++;
                        dfa.reset();
                    }
                    else{
                        output = "Lexical ERROR at position " + (i-2) + "\n";
                        output += new StringBuilder(text).insert(i-2, "!~>").toString();
                        return output;
                    }
                }

            }
            //transition defined on nextSymbol
            else{
                tokenStates.add(nextState);
                token += nextSymbol;
            }

        }

        return output + "</TOKENSTREAM>\n";

    }
    
}