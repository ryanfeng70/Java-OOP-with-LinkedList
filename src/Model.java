
public class Model {
    private String firstname;
    private String lastname;
    private String drugname;
    private String drugdirections;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private boolean drugtaken;
    
    private User user1;
    private DrugInfo drug1;
    private ScheduleInfo schedule1;
            
    public Model(String newfirstname, String newlastname, String newdrugname, String newdrugdirections, int newmonth, int newday, int newhour, int newminute, boolean newdrugtaken){
        this.firstname = newfirstname;
        this.lastname = newlastname;
        this.drugname = newdrugname;
        this.drugdirections = newdrugdirections;
        this.month = newmonth;
        this.day = newday;
        this.hour = newhour;
        this.minute = newminute;
        this.drugtaken = newdrugtaken;
        
        
        user1 = new User(firstname, lastname);
        drug1 = new DrugInfo(drugname, drugdirections);
        schedule1 = new ScheduleInfo(month, day, hour, minute, drugtaken);
    }
    
    public User getUser(){
        return this.user1;
    }
    public void setUser(User newuser){
        this.user1 = newuser;
    }
    
    public DrugInfo getDrugInfo(){
        return this.drug1;
    }
    public void setDrugInfo(DrugInfo newdruginfo){
        this.drug1 = newdruginfo;
    }
    
    public ScheduleInfo getScheduleInfo(){
        return this.schedule1;
    }
    public void setScheduleInfo(ScheduleInfo newscheduleinfo){
        this.schedule1 = newscheduleinfo;
    }
}
