import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import lexer.RecSPLLexer;
import lexer.Token;
import syntaxTree.SyntaxTreeNode;

class Main {

    public static void main(String[] args) throws Exception {

        // Read the text file into a string
        BufferedReader reader = new BufferedReader(new FileReader("Example Programs/Program 1/recSplProgram.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        String fileContent = stringBuilder.toString();
        reader.close();

        // Pass the string to the RecSPLLexer to convert into a List of Tokens
        List<Token> tokenStream = RecSPLLexer.lex(fileContent);

        // Pass the List of Tokens to the RecSPLParser to parse into a syntax tree
        SyntaxTreeNode tree = RecSPLParser.parse(tokenStream);

        // Output the syntax tree into an XML file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Example Programs/Program 1/tree.xml"));
        bufferedWriter.write(tree.toString());
        bufferedWriter.close();

    }

}