package syntaxTree;

import java.util.ArrayList;
import java.util.List;

public class CompositeNode implements SyntaxTreeNode {

    private String nonTerminal;
    private List<SyntaxTreeNode> children;

    public CompositeNode(String nonTerminal, SyntaxTreeNode[] children){

        this.nonTerminal = nonTerminal;

        this.children = new ArrayList<SyntaxTreeNode>();

        for(SyntaxTreeNode child : children){
            this.children.add(child);
        }

    }

    public String getNonTerminal(){
        return this.nonTerminal;
    }

    public List<SyntaxTreeNode> getChildren(){
        return this.children;
    }

    @Override
    public String toString(){

        String output = "<compositeNode>\n<nonTerminal>" + nonTerminal + "</nonTerminal>\n";

        for(SyntaxTreeNode child : children){
            output += child.toString();
        }

        return output + "</compositeNode>\n";

    }
    
}