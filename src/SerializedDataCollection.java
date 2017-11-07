import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedDataCollection implements Serializable {
    private String fileName = "fileName.ser";
    //M07 - A02 SerializedDataCollection should include instances of least two list model classes.
    private EntryList ml;
    private UserList ul;
    
    public SerializedDataCollection(){
        //M07 - A02 All model object lists should be data fields in a class called SerializedDataCollection.
        this.ml = new EntryList();
        this.ul = new UserList();
        
        setUp();
    }
    
    public void setUp(){
        File f1 = new File(fileName);
        
        if(f1.exists()){ //If file exists, then get objects in file and put them into objects here
            readFile();
        }
        
        else if(!f1.exists()) { //If file does not exists, create new objects, add it to lists, and create a file with those lists
            //Creating example Entry objects
            Entry BobInfo = new Entry("Bob", "Lopez", "Tylenol", "Take once per day with water", 10, 30, 3, 00, false);
            Entry RyanInfo = new Entry("Ryan", "Feng", "Oxytocin", "Take twice per week after food", 2, 15, 1, 30, false);
            Entry MaryInfo = new Entry("Mary", "Jane", "Claritin", "Take once every morning", 8, 2, 11, 00, false);
            Entry JamesInfo = new Entry("James", "Madison", "Prozac", "Take once every other day with water", 4, 23, 1, 15, false);
        
            ml.getEntryList().add(BobInfo);
            ml.getEntryList().add(RyanInfo);
            ml.getEntryList().add(MaryInfo);
            ml.getEntryList().add(JamesInfo);
            
            //Creating example UserInfo objects
            UserInfo u1 = new UserInfo("Ryan", "Feng");
            UserInfo u2 = new UserInfo("Barack", "Obama");
            UserInfo u3 = new UserInfo("Kevin", "Hart");
            UserInfo u4 = new UserInfo("Seth", "Rogan");
        
            ul.getUserList().add(u1);
            ul.getUserList().add(u2);
            ul.getUserList().add(u3);
            ul.getUserList().add(u4);
            
            writeFile();
        }    
    }
    
    public void writeFile(){ //Object Serialization
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            
            //M07-A02 2 Entry objects persisted between application runs
            out.writeObject(ml);
            out.writeObject(ul);
            
            out.close();
        }
        catch(IOException ex){ ex.printStackTrace(); }
    }
    
    public void readFile(){ //Object Deserialization
        FileInputStream fis = null;
        ObjectInputStream in = null;
        
        try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            
            //M07-A02 2 Entry objects persisted between application runs
            this.setEntryListObject((EntryList)in.readObject());
            this.setUserList((UserList)in.readObject());
            
            in.close();   
        }
        catch(IOException ex) { ex.printStackTrace(); }
        catch(ClassNotFoundException ex) { ex.printStackTrace(); }
    }
    
    public EntryList getEntryListObject()           {return this.ml;}
    public void setEntryListObject(EntryList newML) {this.ml = newML;}
    
    public UserList getUserList()           {return this.ul;}
    public void setUserList(UserList newUL) {this.ul = newUL;}
    
    public String getFileName()             {return this.fileName;}
    public void setFileName(String newName) {this.fileName = newName;}
    
}
