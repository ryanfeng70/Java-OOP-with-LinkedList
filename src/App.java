
public class App { 
    public static void main(String[] args) {    
        Controller controller = new Controller();
        DrugSchedule si = new DrugSchedule(controller.get_sdc_object_in_Controller());
        //M08-A01 Instantiate the class containing the LinkedList in the main method.
    }
}
