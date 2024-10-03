class Main {

    public static void main(String[] args) {

        String[] tokens = {"MAIN", "NUM", "V", ",", "NUM", "V", ",", "BEGIN", "SKIP", ";", "V", "<", "INPUT", ";", "V", "=", "DIV", "(", "ADD", "(", "V", ",", "N", ")", ",", "SUB", "(", "N", ",", "MUL", "(", "V", ",", "N", ")", ")", ")", ";", "END", "$"};

        RecSPLParser.parse(tokens);

    }
    
}