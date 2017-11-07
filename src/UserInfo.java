import java.io.Serializable;

public class UserInfo implements Serializable{
    private String firstName;
    private String lastName;
    
    UserInfo(String newFname, String newLname){
        this.firstName = newFname;
        this.lastName = newLname;
    }
    
    public String getFirstName()                  {return firstName;}
    public void setFirstName(String newfirstname) {this.firstName = newfirstname;}
    
    public String getLastName()                 {return lastName;}
    public void setLastName(String newlastname) {this.lastName = newlastname;}
    
}
