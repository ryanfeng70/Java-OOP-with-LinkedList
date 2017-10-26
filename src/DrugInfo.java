
public class DrugInfo {
    private String drugname;
    private String instructions;
    
    public DrugInfo(String newdrugname, String newinstructions){
        this.drugname = newdrugname;
        this.instructions = newinstructions;
    }
    
    public String getDrugName(){
        return drugname;
    }
    public void setDrugName(String newdrugname){
        this.drugname = newdrugname;
    }
    
    public String getInstructions(){
        return this.instructions;
    }
    public void setInstructions(String newinstructions){
        this.instructions = newinstructions;
    }
    
    
    
}
