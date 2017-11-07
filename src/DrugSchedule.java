import java.util.Collections;
import java.util.LinkedList;

public class DrugSchedule {
    private LinkedList<ScheduleInfo> drugList = new LinkedList<>();
    private SerializedDataCollection sdc;   
    
    public DrugSchedule(SerializedDataCollection newsdc){
        //Fixed glitch where entry data was blank because it was creating a new entry object instead of communicating between classes
        sdc = newsdc;
        
        //M08-A01:The constructor in the LinkedList class should call a method to build a list of test data. These should be added to the LinkedList in sorted order.
        buildData();
        //M08-A01: the constructor should call a method to print the items in the list to the command line.        
        printItems();   
        
        System.out.println(" \nAdding a new ScheduleInfo object to LinkedList...");
        //Duplicating last object in the modellist for the new object to be added to the linkedlist
        ScheduleInfo add = new ScheduleInfo(sdc, sdc.getEntryListObject().getEntryList().size()-1);
        addItem(add);
        printItems();
        
        //M08-A01: LinkedList class includes the method - removeItem(Object objectToRemove)
        System.out.println(" \nRemoving a ScheduleInfo object from the LinkedList...");
        removeItem(add);
        printItems();
        
        //M08-A01 Five points deducted if you don't implement a case for removeItem() that fails to find an item in the list to be removed.
        System.out.println(" \nFailing to remove a new ScheduleInfo object from the LinkedList...");
        ScheduleInfo error = new ScheduleInfo(sdc, sdc.getEntryListObject().getEntryList().size()-1);
        removeItem(error);
        
        //M08-A01: LinkedList class includes the method - getItem(String searchTerm)
        System.out.println(" \nGetting a ScheduleInfo object in LinkedList...");
        getItem("Tylenol");
        
        //M08-A01: Five points deducted if you don't implement a case for getItem() that fails to find an item in the list to be got.
        System.out.println(" \nFailing to get a ScheduleInfo object in LinkedList...");
        getItem("Adderall");
    }
    
    //M08-A01:The constructor in the LinkedList class should call a method to build a list of test data. These should be added to the LinkedList in sorted order.    
    public void buildData(){
        System.out.println("Building a list of drug schedule data...");
                
        for(int i=0; i<sdc.getEntryListObject().getEntryList().size(); i++){
            ScheduleInfo si = new ScheduleInfo(sdc, i);
            addItem(si);     
        }
        Collections.sort(drugList, new CompareTo()); //sorts list
        
    }
    
    //M08-A01 Method to print the items to the command line
    public void printItems(){
        System.out.println("Printing current objects in LinkedList...");
        
        for(int i=0; i<drugList.size(); i++){
            System.out.println(
            "[date: " + drugList.get(i).getMonth_as_Int() + "/" + drugList.get(i).getDay_as_Int() + "; " +
            "time: "+ drugList.get(i).getHour_as_Int() + ":" + drugList.get(i).getMinute_as_Int() + "], " + 
            "[drug name: " + drugList.get(i).getDrugName() + "]"
            );
        }
    }
    
    //M08-A01: LinkedList class includes the method - addItem(Object newObject)
    public void addItem(Object newObject){
        ScheduleInfo si = (ScheduleInfo)newObject;
        System.out.println("Adding " + si.getDrugName() + "...");
        
        drugList.add(si);
        Collections.sort(drugList, new CompareTo()); //sorts list
        
        System.out.println(si.getDrugName() + " was successfully added");
    }
    
    //M08-A01: LinkedList class includes the method - removeItem(Object objectToRemove)
    public void removeItem(Object objectToRemove){
        ScheduleInfo si = (ScheduleInfo)objectToRemove;
        
        if(drugList.contains(si)) { //Checking if object to be removed exists in linked list
            drugList.remove((ScheduleInfo)objectToRemove);
            Collections.sort(drugList, new CompareTo()); //sorts list
            
            System.out.println(si.getDrugName() + " was successfully removed");
        }
        else{ //M08-A01 Five points deducted if you don't implement a case for removeItem() that fails to find an item in the list to be removed.
            System.out.println("The drug you want to remove does not exist");
        }
    }
    
    //M08-A01: LinkedList class includes the method - getItem(String searchTerm)
    public void getItem(String searchTerm){
        System.out.println("Searching for " + searchTerm + "...");
        try{
            for(int i=0; i<=drugList.size(); i++){
                if(drugList.get(i).getDrugName().equals(searchTerm)){
                    System.out.println(searchTerm + " was found at index " + i + " in the LinkedList");
                    break;
                }            
            }
        }   //M08-A01: Five points deducted if you don't implement a case for getItem() that fails to find an item in the list to be got.
            catch(Exception e){
                System.out.println(searchTerm + " not found");
            }
        
    }
    
}
