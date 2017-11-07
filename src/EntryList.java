import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.*;

//Formerly called "ModelList" class. Still functions like a ModelList.
public class EntryList implements Serializable {
    private ArrayList<Entry> EntryList = new ArrayList<Entry>();
    private int currentview;
    
    public EntryList(){
        currentview = 0;        
        
    }

    
    public void delete(){
        try{
            EntryList.remove(currentview);
            currentview = 0; //Fixes glitch where the details button does not work after deleting an entry
        }
        catch(Exception e){ //Fixed out of bounds exception when the details button is clicked without selecting anything
            if(EntryList.isEmpty()){
                JOptionPane.showMessageDialog(null, "No entries to delete. Please add a new entry");
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select an entry to be deleted");
            }
        }
            
    }
    
    public void addNewObject(){
        //declaring new Entry object and adding to EntryList
        Entry NewInfo = new Entry("enter first name here","enter last name here","enter drug name here","enter drug instructions here",0,0,0,0,false);
        EntryList.add(NewInfo);
        currentview = EntryList.size()-1;
    }
    
    public void scrollNext(){
        currentview = currentview + 1;
    
    }
    public void scrollPrev(){
        currentview = currentview - 1;
    }    
        
    public ArrayList<Entry> getEntryList()                  {return this.EntryList;}
    public void setEntryList(ArrayList<Entry> newEntryList) {this.EntryList = newEntryList;}
    
    public int getCurrentView()                    {return this.currentview;}
    public void setCurrentView(int newcurrentview) {this.currentview = newcurrentview;}
    
}
