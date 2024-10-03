public class Production {

    private String lhs;
    private String[] rhs = {};

    Production(String productionString){

        String[] split = productionString.split(" -> ");
        this.lhs = split[0];
        if(split.length > 1){
            this.rhs = split[1].split(" ");
        }

    }

    public String getLhs(){
        return this.lhs;
    }

    public String[] getRhs(){
        return this.rhs;
    }
    
}