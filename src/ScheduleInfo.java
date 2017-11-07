
public class ScheduleInfo { 
    private SerializedDataCollection sdc; 
    private int datePriority;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String drugName;
    private int currentView;
    
    
    public ScheduleInfo(SerializedDataCollection newsdc, int newCurrentView){
        //Fixed glitch where entry data was blank because we were creating a new entry object instead of communicating between classes
        this.sdc = newsdc;
        this.currentView = newCurrentView; //Fixed glitch where currentview was set to 0 (first entry) at startup
        
        this.drugName = sdc.getEntryListObject().getEntryList().get(currentView).getDrugName();
        this.month = sdc.getEntryListObject().getEntryList().get(currentView).getMonth_as_Int();
        this.day = sdc.getEntryListObject().getEntryList().get(currentView).getDay_as_Int();
        this.hour = sdc.getEntryListObject().getEntryList().get(currentView).getHour_as_Int();
        this.minute = sdc.getEntryListObject().getEntryList().get(currentView).getMinute_as_Int();
        
    }
    
    public int getDatePriority() {return this.datePriority;}
    public void setDatePriority(int newPriority){ this.datePriority = newPriority;}
    
    public String getDrugName()                 {return drugName;}
    public void setDrugName(String newdrugname) {this.drugName = newdrugname;}
    
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
