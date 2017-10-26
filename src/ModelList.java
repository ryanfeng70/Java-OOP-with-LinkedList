import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModelList {
    //Paramatizing Arraylist to Model Type (ArrayList<Model>) got rid of compiler warnings
    private ArrayList<Model> ModelList = new ArrayList<Model>();
    private Model BobInfo;
    private Model RyanInfo;
    private Model MaryInfo;
    private Model JamesInfo;
    private int currentview;
    
    public ModelList(){
        //M05-A01 When the view class is first shown, it should display data from the object in the first position of the ArrayList.
        currentview = 0;
        
        //retrive from json file
        
        BobInfo = new Model("Bob", "Lopez", "Tylenol", "Take once per day with water", 9, 30, 3, 00, false);
        RyanInfo = new Model("Ryan", "Feng", "Oxytocin", "Take twice per week after food", 9, 15, 1, 30, false);
        MaryInfo = new Model("Mary", "Jane", "Claritin", "Take once every morning", 10, 2, 11, 00, false);
        JamesInfo = new Model("James", "Madison", "Prozac", "Take once every other day with water", 5, 23, 1, 15, false);
        
        //add to json file
        
        ModelList.add(BobInfo);
        ModelList.add(RyanInfo);
        ModelList.add(MaryInfo);
        ModelList.add(JamesInfo);
    }
    
    public void delete(){
        try{
            ModelList.remove(currentview);
            
            //Avoiding ArrayList out of bounds error if you delete the first item
            if(currentview == ModelList.size()){ 
                scrollPrev(); 
            }
            //Avoiding ArrayList out of bounds error if you delete the last item on the list
            if(currentview > ModelList.size()){
                currentview = ModelList.size()-1;
            }
        }
        catch(Exception e){ //Fixed out of bounds exception when an entry is not selected
            if(ModelList.isEmpty()){
                JOptionPane.showMessageDialog(null, "No entries to delete. Please add a new entry");
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select an entry to be deleted");
            }
        }
            
    }
    
    public void addNewObject(){
        //declaring new Model object and adding to ModelList
        Model NewInfo = new Model("enter first name here","enter last name here","enter drug name here","enter drug instructions here",0,0,0,0,false);
        ModelList.add(NewInfo);
        currentview = ModelList.size()-1;
    }
    
    public ArrayList<Model> getModelList(){
        return this.ModelList;
    }
    
    public void setModelList(ArrayList<Model> newModelList){
        this.ModelList = newModelList;
    }
    
    public int getCurrentView(){
        return this.currentview;
    }
    public void setCurrentView(int newcurrentview){
        this.currentview = newcurrentview;
    }
    
    public void scrollNext(){
        currentview = currentview + 1;
    }
    public void scrollPrev(){
        currentview = currentview - 1;
    }
    
    
}
