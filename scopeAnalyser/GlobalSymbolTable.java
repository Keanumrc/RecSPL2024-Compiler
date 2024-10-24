package scopeAnalyser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GlobalSymbolTable {

    private Map<String, Data> table;
    private int numberOfVariables;
    private boolean variable;

    public GlobalSymbolTable(boolean variable){
        this.table = new HashMap<String, Data>();
        this.numberOfVariables = 0;
        this.variable = variable;
    }

    public String bind(String userDefinedName){

        String newUniqueVariableName = "";
        
        if(variable){
            newUniqueVariableName += "V" + numberOfVariables;
        }
        else{
            newUniqueVariableName += "F" + numberOfVariables;
        }

        this.table.put(newUniqueVariableName, new Data(userDefinedName, '?', "0 "));

        numberOfVariables++;

        return newUniqueVariableName;

    }

    public void setType(String name, char type){

        if(this.table.get(name) != null){
            this.table.get(name).type = type;
        }

    }

    public String lookupUserDefinedName(String name){

        return this.table.get(name).userDefinedName;

    }

    public char lookupType(String name){

        return this.table.get(name).type;

    }

    public void setStartLineNumber(String name, String startLineNumber){

        if(this.table.get(name) != null){
            this.table.get(name).startLineNumber = startLineNumber;
        }

    }

    public String lookupStartLineNumber(String name){

        return this.table.get(name).startLineNumber;

    }

    public Set<String> getAllNames(){

        return this.table.keySet();

    }

    @Override
    public String toString(){

        String output = "";

        for (Map.Entry<String, Data> entry : table.entrySet()) {
            output +=  "Unique name: " + entry.getKey() + "\t" + "Type: " + entry.getValue().type + "\t\t" + "User-defined Name: " + entry.getValue().userDefinedName + "\n";
        }

        return output;

    }

    private class Data {

        private String userDefinedName;
        private char type;
        //applicable to functions
        private String startLineNumber;

        public Data(String userDefinedName, char type, String startLineNumber){

            this.userDefinedName = userDefinedName;
            this.type = type;
            this.startLineNumber = startLineNumber;

        }

    }
    
}