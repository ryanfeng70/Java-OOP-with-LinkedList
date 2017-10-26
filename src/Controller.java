import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller {
    //M06 - A01 A controller object instantiates and shows the list view containing a JTable of some model objects.
    private ModelList ml;
    private UserView v1; 
    
    public Controller() {
        this.ml = new ModelList();
        this.v1 = new UserView();
        
        buttonListener();     
    }
    
    public void buttonListener() { 
        //M06-A01 The user can select a model object from the list and view its details in a separate detail view.
        v1.getJT().getSelectionModel().addListSelectionListener( new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                ml.setCurrentView(v1.getJT().getSelectedRow());
            }
        });
        
        //**********************************************************************************************************************************/
        //M06-A01 It should allow the user to select an item from the list and display its details in a separate detail view class.
        //Next 3 actionlisteners are exlusively for the view window
        //**********************************************************************************************************************************/
        
        //details button logic
        v1.getDetails().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    
                InitialFrame iframe = v1.createDetailView();
                put_model_data_into_detail_view(iframe);
        
        //M06-A01 The user can change the data for a particular item using the detail view as the input data form.
        //Next 2 buttons are actionlisteners nested within the detail-view window         
        
        //save button logic
        iframe.getInitialPanel().getButtonPanel().getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                put_form_data_into_model_fields(iframe);
                v1.updateUserPanel(ml);
                v1.getDetailsView().getIframe().dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });
        
        //M06-A01 The user can delete items from the list.	
        //delete button logic
        iframe.getInitialPanel().getButtonPanel().getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            
                ml.delete();
                v1.updateUserPanel(ml);
                iframe.dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });
        
            }
        }); 
        //button logic for detais-view window ends here
        
        //M06 - A01 The user can add new items to the list using the detail view as the input data form.
        //Next 3 actionlisteners are exclusively for the input window
        
        //add button logic 
        v1.getAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ml.addNewObject();
                InitialFrame iframe = v1.createDetailView();
                iframe.getInitialPanel().getButtonPanel().getDelete().setText("cancel"); //changing delete button text to cancel so user understands its function better
                put_model_data_into_detail_view(iframe);
                
        //delete button logic within the input data window
        iframe.getInitialPanel().getButtonPanel().getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                ml.delete();
                iframe.dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });        
                
        //save button logic within the input data window
        iframe.getInitialPanel().getButtonPanel().getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                put_form_data_into_model_fields(iframe);
                v1.updateUserPanel(ml);
                v1.getDetailsView().getIframe().dispatchEvent(new WindowEvent(iframe, WindowEvent.WINDOW_CLOSING));
                }
            });        
                
            } 
        }); 
        //Button logic for add-window ends here
        
        v1.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ml.delete();
                v1.updateUserPanel(ml);
            }    
        });

    }
    
    public void put_model_data_into_detail_view(InitialFrame frame){
        frame.getInitialPanel().getInfoPanel().getFirstName().setText(ml.getModelList().get(ml.getCurrentView()).getUser().getFirstName());
        frame.getInitialPanel().getInfoPanel().getLastName().setText(ml.getModelList().get(ml.getCurrentView()).getUser().getLastName());
        frame.getInitialPanel().getInfoPanel().getDrugName().setText(ml.getModelList().get(ml.getCurrentView()).getDrugInfo().getDrugName());
        frame.getInitialPanel().getInfoPanel().getDirections().setText(ml.getModelList().get(ml.getCurrentView()).getDrugInfo().getInstructions());
        frame.getInitialPanel().getInfoPanel().getMonth().setText(ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().getMonth_as_String());
        frame.getInitialPanel().getInfoPanel().getDay().setText(ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().getDay_as_String());
        frame.getInitialPanel().getInfoPanel().getHour().setText(ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().getHour_as_String());
        frame.getInitialPanel().getInfoPanel().getMinute().setText(ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().getMinute_as_String());
        frame.getInitialPanel().getInfoPanel().getDrugTaken().setText(ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().getDrugTaken_as_String());          
  
        }

    public void put_form_data_into_model_fields(InitialFrame frame){
        ml.getModelList().get(ml.getCurrentView()).getUser().setFirstName(frame.getInitialPanel().getInfoPanel().getFirstName().getText());
        ml.getModelList().get(ml.getCurrentView()).getUser().setLastName(frame.getInitialPanel().getInfoPanel().getLastName().getText());
        ml.getModelList().get(ml.getCurrentView()).getDrugInfo().setDrugName(frame.getInitialPanel().getInfoPanel().getDrugName().getText());
        ml.getModelList().get(ml.getCurrentView()).getDrugInfo().setInstructions(frame.getInitialPanel().getInfoPanel().getDirections().getText());
        ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().setMonth(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getMonth().getText()));
        ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().setDay(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getDay().getText()));
        ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().setHour(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getHour().getText()));
        ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().setMinute(Integer.parseInt(frame.getInitialPanel().getInfoPanel().getMinute().getText()));
        ml.getModelList().get(ml.getCurrentView()).getScheduleInfo().setDrugTaken_with_String(frame.getInitialPanel().getInfoPanel().getDrugTaken().getText());      
                        
    }

}
