import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import codeGenerator.CodeGenerator;
import lexer.RecSPLLexer;
import lexer.Token;
import scopeAnalyser.FunctionScopeAnalyser;
import scopeAnalyser.GlobalSymbolTable;
import scopeAnalyser.VariableScopeAnalyser;
import syntaxTree.CompositeNode;
import syntaxTree.SyntaxTreeNode;
import typeChecker.TypeChecker;

class Main {

    public static void main(String[] args){

        try{

            // String filePath = "Example Programs/ScriptGenerated/";
            // String fileName = "main_008.txt.txt";

            String fileName = args[0];
    
            // Read the text file into a string
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            String fileContent = stringBuilder.toString();
            reader.close();
    
            // Pass the string to the RecSPLLexer to convert into a List of Tokens
            List<Token> tokenStream = RecSPLLexer.lex(fileContent);

            // Output the list of tokens into an XML file
            BufferedWriter bufferedWriter0 = new BufferedWriter(new FileWriter("tokens.xml"));
            bufferedWriter0.write("<tokenstream>");
            for(Token token : tokenStream){
                bufferedWriter0.write(token.toString());
            }
            bufferedWriter0.write("</tokenstream>");
            bufferedWriter0.close();
    
            // Pass the List of Tokens to the RecSPLParser to parse into a syntax tree
            SyntaxTreeNode tree = RecSPLParser.parse(tokenStream);
    
            // Output the syntax tree into an XML file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tree.xml"));
            bufferedWriter.write(tree.toString());
            bufferedWriter.close();
    
            //Pass the tree to the FunctionScopeAnalyser
            GlobalSymbolTable globalFunctionTable = FunctionScopeAnalyser.analyseProg((CompositeNode)tree);
            System.out.println("Variable and Function tables after scope analysis");
            System.out.println(globalFunctionTable);
    
            //Pass the tree to the VariableScopeAnalyser
            GlobalSymbolTable globalVariableTable = VariableScopeAnalyser.analyseProg((CompositeNode)tree);
            System.out.println(globalVariableTable);
    
            //Pass the tree to the TypeChecker
            TypeChecker typeChecker = new TypeChecker(globalVariableTable, globalFunctionTable);
            boolean result = typeChecker.typeCheckProg((CompositeNode)tree);
            System.out.println("Program correctly typed: " + result);
    
            System.out.println("Variable and Function tables after type checking");
            System.out.println(globalFunctionTable);
            System.out.println(globalVariableTable);
    
            //Pass the tree to the CodeGenerator
            CodeGenerator codeGenerator = new CodeGenerator(globalVariableTable, globalFunctionTable);
            String code = codeGenerator.generateProgCode((CompositeNode)tree);
    
            // Output the code into a text file
            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("out.txt"));
            bufferedWriter3.write(code);
            bufferedWriter3.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}