import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SLRParseTableReader {

    public static void readTable(String filename) {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int lineNumber = 0;

            String headings = "main\r\n" + //
                    ",\r\n" + //
                    "num\r\n" + //
                    "text\r\n" + //
                    "V\r\n" + //
                    "begin\r\n" + //
                    "end\r\n" + //
                    ";\r\n" + //
                    "skip\r\n" + //
                    "halt\r\n" + //
                    "print\r\n" + //
                    "return\r\n" + //
                    "N\r\n" + //
                    "T\r\n" + //
                    "&lt;\r\n" + //
                    "input\r\n" + //
                    "=\r\n" + //
                    "(\r\n" + //
                    ")\r\n" + //
                    "if\r\n" + //
                    "then\r\n" + //
                    "else\r\n" + //
                    "not\r\n" + //
                    "sqrt\r\n" + //
                    "or\r\n" + //
                    "and\r\n" + //
                    "eq\r\n" + //
                    "grt\r\n" + //
                    "add\r\n" + //
                    "sub\r\n" + //
                    "mul\r\n" + //
                    "div\r\n" + //
                    "F\r\n" + //
                    "void\r\n" + //
                    "{\r\n" + //
                    "}\r\n" + //
                    "$\r\n" + //
                    "PROG\r\n" + //
                    "GLOBVARS\r\n" + //
                    "VTYP\r\n" + //
                    "VNAME\r\n" + //
                    "ALGO\r\n" + //
                    "INSTRUC\r\n" + //
                    "COMMAND\r\n" + //
                    "ATOMIC\r\n" + //
                    "CONST\r\n" + //
                    "ASSIGN\r\n" + //
                    "CALL\r\n" + //
                    "BRANCH\r\n" + //
                    "TERM\r\n" + //
                    "OP\r\n" + //
                    "ARG\r\n" + //
                    "COND\r\n" + //
                    "SIMPLE\r\n" + //
                    "COMPOSIT\r\n" + //
                    "UNOP\r\n" + //
                    "BINOP\r\n" + //
                    "FNAME\r\n" + //
                    "FUNCTIONS\r\n" + //
                    "DECL\r\n" + //
                    "HEADER\r\n" + //
                    "FTYP\r\n" + //
                    "BODY\r\n" + //
                    "PROLOG\r\n" + //
                    "EPILOG\r\n" + //
                    "LOCVARS\r\n" + //
                    "SUBFUNCS";

            String[] headingArray = headings.split("\r\n");

            while (lineNumber < 83) {
                // read next line
                line = reader.readLine();
                lineNumber++;
            }

            int rowNumber = -1;
            int columnNumber = 0;

            while (lineNumber >= 83 && line != null) {

                if (line.contains("<tr>")) {
                    rowNumber++;
                    columnNumber = -2;
                }else if (line.contains("acc")) {
                    System.out.println("s" + rowNumber + ".addTransition(\"" + headingArray[columnNumber].toUpperCase() + "\", new AcceptAction());" ); 
                } else if (line.contains("span") && columnNumber < 37) {
                    String[] arr = line.split("\">");
                    String[] arr2 = arr[1].split("<");
                    System.out.println("s" + rowNumber + ".addTransition(\"" + headingArray[columnNumber].toUpperCase() + "\", new ShiftAction(s" + arr2[0] + "));" );
                } else if (line.contains("span")) {
                    String[] arr = line.split("\">");
                    String[] arr2 = arr[1].split("<");
                    System.out.println("s" + rowNumber + ".addTransition(\"" + headingArray[columnNumber].toUpperCase() + "\", new GotoAction(s" + arr2[0] + "));" );
                } else if (line.contains("sub")) {
                    String[] arr = line.split("\">");
                    String[] arr2 = arr[1].split("<");
                    System.out.println("s" + rowNumber + ".addTransition(\"" + headingArray[columnNumber].toUpperCase() + "\", new ReduceAction(p" + arr2[0] + "));" );
                }
                lineNumber++;
                columnNumber++;
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}