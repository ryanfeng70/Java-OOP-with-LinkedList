import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller {
    private SerializedDataCollection sdc;
    private UserView v1; 
    
    public Controller() {
        this.sdc = new SerializedDataCollection();
        this.v1 = new UserView();
        
        buttonListener();     
    }
    
    public void buttonListener() { 
        v1.getJT().getSelectionModel().addListSelectionListener( new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                sdc.getEntryListObject().setCurrentView(v1.getJT().getSelectedRow());
            }
        });
        
        //Next 3 actionlisteners are exlusively for the view window
        //details button logic
        v1.getDetails().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                InitialFrame iframe = v1.createDetailView(); 
                put_model_data_into_detail_view(iframe);       
        
        //save button logic
        iframe.getInitialPanel().getButtonPanel().getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                put_form_data_into_model_fields(iframe);
                v1.updateUserPanel(sdc.getEntryListObject());
                sdc.writeFile();
                v1.getDetailsView().getIframe().dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });
        
        //delete button logic
        iframe.getInitialPanel().getButtonPanel().getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                sdc.getEntryListObject().delete();
                v1.updateUserPanel(sdc.getEntryListObject());
                sdc.writeFile();
                iframe.dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });  
        
            }
        }); //button logic for detais-view window ends here       
        
        //Next 3 actionlisteners are exclusively for the data input window       
        //add button logic 
        v1.getAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sdc.getEntryListObject().addNewObject();
                InitialFrame iframe = v1.createDetailView();
                put_model_data_into_detail_view(iframe);
                
                //changing delete button text to cancel so user understands its function better
                iframe.getInitialPanel().getButtonPanel().getDelete().setText("cancel"); 
                
        //delete (cancel) button logic within the input data window
        iframe.getInitialPanel().getButtonPanel().getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                sdc.getEntryListObject().delete();
                sdc.writeFile();
                iframe.dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });        
                
        //save button logic within the input data window
        iframe.getInitialPanel().getButtonPanel().getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                put_form_data_into_model_fields(iframe);
                v1.updateUserPanel(sdc.getEntryListObject());
                sdc.writeFile();
                v1.getDetailsView().getIframe().dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });        
                
            } 
        }); 
        
        //Button logic for add-window ends here
        v1.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                sdc.getEntryListObject().delete();
                v1.updateUserPanel(sdc.getEntryListObject());
                sdc.writeFile(); 
            }    
        });


    }
    
    public void put_model_data_into_detail_view(InitialFrame frame){
        frame.getInitialPanel().getInfoPanel().getFirstName().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getFirstName());
        frame.getInitialPanel().getInfoPanel().getLastName().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getLastName());
        frame.getInitialPanel().getInfoPanel().getDrugName().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getDrugName());
        frame.getInitialPanel().getInfoPanel().getDirections().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getInstructions());
        frame.getInitialPanel().getInfoPanel().getMonth().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getMonth_as_String());
        frame.getInitialPanel().getInfoPanel().getDay().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getDay_as_String());
        frame.getInitialPanel().getInfoPanel().getHour().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getHour_as_String());
        frame.getInitialPanel().getInfoPanel().getMinute().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getMinute_as_String());
        frame.getInitialPanel().getInfoPanel().getDrugTaken().setText(sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).getDrugTaken_as_String());          
  
        }

    public void put_form_data_into_model_fields(InitialFrame frame){
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setFirstName(frame.getInitialPanel().getInfoPanel().getFirstName().getText());
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setLastName(frame.getInitialPanel().getInfoPanel().getLastName().getText());
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setDrugName(frame.getInitialPanel().getInfoPanel().getDrugName().getText());
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setInstructions(frame.getInitialPanel().getInfoPanel().getDirections().getText());
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setMonth(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getMonth().getText()));
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setDay(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getDay().getText()));
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setHour(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getHour().getText()));
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setMinute(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getMinute().getText()));
        sdc.getEntryListObject().getEntryList().get(sdc.getEntryListObject().getCurrentView()).setDrugTaken_with_String(frame.getInitialPanel().getInfoPanel().getDrugTaken().getText());      
                        
    }
    
    //Allows linkedlist class (DrugSchedule) to access model data in SerializedDataCollection class
    public SerializedDataCollection get_sdc_object_in_Controller(){
        return this.sdc;
    }

}
