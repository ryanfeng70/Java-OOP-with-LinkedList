
public class ScheduleInfo {
    private Boolean drugtaken;
    private int day;
    private int month;
    private int hour;
    private int minute;

    
    public ScheduleInfo(int newmonth, int newday, int newhour, int newminute, Boolean newdrugtaken){
        this.drugtaken = newdrugtaken;
        this.day = newday;
        this.month = newmonth;
        this.hour = newhour;
        this.minute = newminute;   
    }

    public Boolean getDrugtaken_as_Boolean(){
        return drugtaken;
    }
    public String getDrugTaken_as_String(){
        String temp = "";
        
        if(this.drugtaken == true){ temp = "true"; }
        if(this.drugtaken == false) {temp = "false"; }
        
        return temp;
    }
    
    public void setDrugTaken(Boolean newdrugtaken){
        this.drugtaken = newdrugtaken;
    }
    public void setDrugTaken_with_String(String newtaken){
        if(newtaken.contains("true")){
            this.drugtaken = true;
        }
        if(newtaken.contains("false")){
            this.drugtaken = false;
        }
    }
    
    public int getMonth_as_Int(){
        return this.month;
    }
    public String getMonth_as_String(){
        String temp = this.month+"";
        return temp;
    }
    public void setMonth(int newmonth){
        this.month = newmonth;
    }
    
    public int getDay_as_Int() {
        return this.day;
    }   
    public String getDay_as_String(){
        String temp = this.day+"";
        return temp;
    }
    public void setDay(int newday){
        this.day = newday;
    }
    
    public int getHour_as_Int() {
        return this.hour;
    }   
    public String getHour_as_String(){
        String temp = this.hour+"";
        return temp;
    }
    public void setHour(int newhour){
        this.hour = newhour;
    }
    
    public int getMinute_as_Int() {
        return this.minute;
    }   
    public String getMinute_as_String(){
        String temp = this.minute+"";
        return temp;
    }
    public void setMinute(int newminute){
        this.minute = newminute;
    }
    

    

}
