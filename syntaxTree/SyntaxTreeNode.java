package syntaxTree;

import java.util.ArrayList;
import java.util.List;

public class SyntaxTreeNode {

    private List<SyntaxTreeNode> children;
    private String label;

    public SyntaxTreeNode(String label){

        this.label = label;
        this.children = new ArrayList<SyntaxTreeNode>();

    }

    public SyntaxTreeNode(String label, SyntaxTreeNode[] children){

        this.label = label;

        this.children = new ArrayList<SyntaxTreeNode>();

        for(SyntaxTreeNode child : children){
            this.children.add(child);
        }

    }

    @Override
    public String toString(){

        String output = "<>\n<label>" + label + "</label>\n";

        for(SyntaxTreeNode child : children){
            output += child.toString();
        }

        return output + "</>\n";

    }
    
}