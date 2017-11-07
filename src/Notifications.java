
public class Notifications { 
    private int Number_of_Notifications;
    private Boolean Notification_Sent;
    //Future needs: data type for computer notifications
    
    public Notifications(int newNumber_of_Notifications, Boolean newNotification_Sent){
        this.Number_of_Notifications = newNumber_of_Notifications;
        this.Notification_Sent = newNotification_Sent;
 
    }
    
    public int getNumber_of_Notifications(){
        return Number_of_Notifications;
    }
    public void setNumber_of_Notifications(int newNumber_of_Notifications){
        this.Number_of_Notifications = newNumber_of_Notifications;
    }
    public Boolean getNotification_Sent(){
        return Notification_Sent;
    }
    public void setNotification_Sent(Boolean newNotification_Sent){
        this.Notification_Sent = newNotification_Sent;
    }
}
