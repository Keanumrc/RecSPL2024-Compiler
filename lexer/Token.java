package lexer;

public class Token {

    private String tokenClass;
    private String word;

    public Token(String tokenClass, String word){
        this.tokenClass = tokenClass;
        this.word = word;
    }

    public String getTokenClass(){
        return this.tokenClass;
    }

    public String getWord(){
        return this.word;
    }

    @Override
    public String toString(){

        String outputWord;

        if(word.equals("<")){
            outputWord = "&lt;";
        }
        else{
            outputWord = word;
        }

        String output = "<token>\n";
        output += "<tokenClass>" + tokenClass + "</tokenClass>\n";
        output += "<word>" + outputWord + "</word>\n";
        output += "</token>\n";
        return output;
    }
    
}