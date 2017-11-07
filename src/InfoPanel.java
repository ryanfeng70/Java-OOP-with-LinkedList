import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

class InfoPanel extends JPanel  {
    private JTextField firstname;
    private JTextField lastname;
    private JTextField drugname;
    private JTextField drugdirections;
    private JTextField month;
    private JTextField day;
    private JTextField hour;
    private JTextField minute;
    private JTextField drugtaken;
    
    private JLabel firstname_fieldname = new JLabel("First Name");
    private JLabel lastname_fieldname = new JLabel("Last Name");
    private JLabel drugname_fieldname = new JLabel("Drug Name");
    private JLabel drugdirections_fieldname = new JLabel("Directions");
    private JLabel month_fieldname = new JLabel("Month");
    private JLabel day_fieldname = new JLabel("Day");
    private JLabel hour_fieldname = new JLabel("Hour");
    private JLabel minute_fieldname = new JLabel("Minute");
    private JLabel drugtaken_fieldname = new JLabel("Drug Taken?");
    
    public InfoPanel() {
        super();
        setBackground(Color.white);
        setLayout(new GridLayout(9, 2));
        
        firstname = new JTextField(70);
        lastname = new JTextField(70);
        drugname = new JTextField(70);
        drugdirections = new JTextField(200);
        month = new JTextField(10);
        day = new JTextField(10);
        hour = new JTextField(10);
        minute = new JTextField(10);
        drugtaken = new JTextField(10);
        
        add(firstname_fieldname);
        add(firstname);
        
        add(lastname_fieldname);
        add(lastname);
        
        add(drugname_fieldname);
        add(drugname);
        
        add(drugdirections_fieldname);
        add(drugdirections);
        
        add(month_fieldname);
        add(month);
        
        add(day_fieldname);
        add(day);
        
        add(hour_fieldname);
        add(hour);
        
        add(minute_fieldname);
        add(minute);
        
        add(drugtaken_fieldname);
        add(drugtaken);
    }
    
    
    
    public JTextField getFirstName(){
        return this.firstname;
    }
    public void setFirstName(JTextField newfirstname){
        this.firstname = newfirstname;    
    }
    public JTextField getLastName(){
        return this.lastname;
    }
    public void setLastName(JTextField newlastname){
        this.lastname = newlastname;    
    }
    public JTextField getDrugName(){
        return this.drugname;
    }
    public void setDrugName(JTextField newdrugname){
        this.drugname = newdrugname;    
    }
    public JTextField getDirections(){
        return this.drugdirections;
    }
    public void setDirections(JTextField newdirections){
        this.drugdirections = newdirections;    
    }
    public JTextField getMonth(){
        return this.month;
    }
    public void setMonth(JTextField newmonth){
        this.month = newmonth;    
    }
        public JTextField getDay(){
        return this.day;
    }
    public void setDay(JTextField newday){
        this.day = newday;    
    }
        public JTextField getHour(){
        return this.hour;
    }
    public void setHour(JTextField newhour){
        this.hour = newhour;    
    }
    public JTextField getMinute(){
        return this.minute;
    }
    public void setMinute(JTextField newminute){
        this.minute = newminute;    
    }
        public JTextField getDrugTaken(){
        return this.drugtaken;
    }
    public void setDrugTaken(JTextField newdrugtaken){
        this.drugtaken = newdrugtaken;    
    }
    
    
}
