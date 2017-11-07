import java.io.Serializable;

//Formerly called "Model" class. Still functions like a Model class.
public class Entry implements Serializable {
    private String firstName;
    private String lastName;
    private String drugName;
    private String instructions;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private boolean drugtaken;
            
    public Entry(String newFirstName, String newLastName, String newDrugName, String newInstructions, int newMonth, int newDay, int newHour, int newMinute, boolean newDrugTaken){
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.drugName = newDrugName;
        this.instructions = newInstructions;
        this.month = newMonth;
        this.day = newDay;
        this.hour = newHour;
        this.minute = newMinute;
        this.drugtaken = newDrugTaken;

    }
    
    public String getFirstName()                  {return firstName;}
    public void setFirstName(String newfirstname) {this.firstName = newfirstname;}
    
    public String getLastName()                 {return lastName;}
    public void setLastName(String newlastname) {this.lastName = newlastname;}
    
    public String getDrugName()                 {return drugName;}
    public void setDrugName(String newdrugname) {this.drugName = newdrugname;}
    
    public String getInstructions()                     {return this.instructions;}
    public void setInstructions(String newinstructions) {this.instructions = newinstructions;}
    
    public Boolean getDrugtaken_as_Boolean()       {return drugtaken;}
    public void setDrugTaken(Boolean newdrugtaken) {this.drugtaken = newdrugtaken;}
    
    public String getDrugTaken_as_String(){
        String temp = "";
        
        if(this.drugtaken == true){ temp = "true"; }
        if(this.drugtaken == false) {temp = "false"; }
        
        return temp;
    }   

    public void setDrugTaken_with_String(String newtaken){
        if(newtaken.contains("true")){
            this.drugtaken = true;
        }
        if(newtaken.contains("false")){
            this.drugtaken = false;
        }
    }
    
    public int getMonth_as_Int()       {return this.month;}
    public void setMonth(int newmonth) {this.month = newmonth;}
    
    public String getMonth_as_String(){
        String temp = this.month+"";
        return temp;
    }
    
    public int getDay_as_Int()     {return this.day;}   
    public void setDay(int newday) {this.day = newday;
    }
    public String getDay_as_String(){
        String temp = this.day+"";
        return temp;
    }
    
    public int getHour_as_Int()      {return this.hour;}   
    public void setHour(int newhour) {this.hour = newhour;}
    
    public String getHour_as_String(){
        String temp = this.hour+"";
        return temp;
    }
    
    public int getMinute_as_Int()        {return this.minute;}   
    public void setMinute(int newminute) {this.minute = newminute;}
        
    public String getMinute_as_String(){
        String temp = this.minute+"";
        return temp;
    }   

}
