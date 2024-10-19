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
    
}