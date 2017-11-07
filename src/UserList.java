import java.io.Serializable;
import java.util.ArrayList;

//M07 - A02 A second model list, which is a data field in a class called SerializedDataCollection.
public class UserList implements Serializable {
    private ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
    
    UserList(){

    }
    
    public ArrayList<UserInfo> getUserList() { return this.userList;}
    public void setUserList(ArrayList<UserInfo> newUserList) { this.userList = newUserList; }
    
    
}
