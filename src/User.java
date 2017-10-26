
public class User {
    private String firstname ;
    private String lastname ;
    
    public User(String newfirstname, String newlastname){
        this.firstname = newfirstname;
        this.lastname = newlastname;
 
    }
    
    public String getFirstName(){
        return firstname;
    }
    public void setFirstName(String newfirstname){
        this.firstname = newfirstname;
    }
    public String getLastName(){
        return lastname;
    }
    public void setLastName(String newlastname){
        this.lastname = newlastname;
    }

    
}
