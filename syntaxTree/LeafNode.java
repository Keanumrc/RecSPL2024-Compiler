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

    @Override
    public String toString(){

        String output = "<leafNode>\n"; 
        
        output += "<tokenClass>" + tokenClass + "</tokenClass>\n";
        output += "<word>" + word + "</word>\n";

        return output + "</leafNode>\n";

    }
    
}