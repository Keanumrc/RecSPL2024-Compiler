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

    public String getLabel(){
        return this.label;
    }

    public List<SyntaxTreeNode> getChildren(){
        return this.children;
    }

    @Override
    public String toString(){

        String printedLabel = "";

        if(label == "<"){
            printedLabel = "&lt;";
        }
        else{
            printedLabel = label;
        }

        String output = "<node>\n<label>" + printedLabel + "</label>\n";

        for(SyntaxTreeNode child : children){
            output += child.toString();
        }

        return output + "</node>\n";

    }
    
}