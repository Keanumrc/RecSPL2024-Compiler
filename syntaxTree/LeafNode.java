package syntaxTree;

public class LeafNode implements SyntaxTreeNode {

    private String tokenClass;
    private String word;

    public LeafNode(String tokenClass, String word){

        this.tokenClass = tokenClass;
        this.word = word;

    }

    public String getTokenClass(){
        return this.tokenClass;
    }

    public String getWord(){
        return this.word;
    }

    //used to override variables with unique names
    public void setWord(String word){
        this.word = word;
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

        String output = "<leafNode>\n"; 
        
        output += "<tokenClass>" + tokenClass + "</tokenClass>\n";
        output += "<word>" + outputWord + "</word>\n";

        return output + "</leafNode>\n";

    }
    
}