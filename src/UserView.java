import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

//M06 - A01 A view to display the list of items (e.g., InstrumentListUI in Vintage Sounds).
public class UserView extends JFrame {
    private InitialFrame iframe;
    private DetailsView dv;
    private JPanel buttons;
    private JPanel jp ;
    private ModelList ml;
    private JTable jt;
    private JScrollPane jpane;
    private DefaultTableModel tableModel;
    private JButton details;
    private JButton add;
    private JButton delete;
    private Object[] columnNames = {"Name", "Drug", "Taken?"};
    
    public UserView(){
        super("User View");
        this.dv = new DetailsView(iframe);
        this.ml = new ModelList();
        this.buttons = new JPanel();
        this.tableModel = new DefaultTableModel(columnNames, 0);
        this.details = new JButton("details");
        this.add = new JButton("add");
        this.delete = new JButton("delete");
        
        createUserPanel(ml);
                
        buttons.setBackground(Color.gray);
        buttons.add(details);
        buttons.add(add);
        buttons.add(delete);
        add(buttons, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (800, 700);
        setVisible(true);     

        
    }
    
    //M06-A01 The user can select a model object from the list and view its details in a separate detail view.
    public void createUserPanel(ModelList model){
        //Creates panel with initial data from model  
        for(int i=0; i<model.getModelList().size(); i++){
            String firstname = model.getModelList().get(i).getUser().getFirstName();
            String drugname = model.getModelList().get(i).getDrugInfo().getDrugName();
            String drugtaken = model.getModelList().get(i).getScheduleInfo().getDrugTaken_as_String();
            
            Object[] data = {firstname, drugname, drugtaken};
            tableModel.addRow(data);
        }

        this.jt = new JTable(tableModel);
        this.jpane = new JScrollPane(jt);
        this.jp = new JPanel();
        jp.setSize(700,600);
        jp.add(jpane);
        add(new JScrollPane(jp));
        setVisible(true);

    }
    
    public void updateUserPanel(ModelList model){
        //deleting old rows in table
        int rowcount = tableModel.getRowCount();
        for(int i = rowcount - 1; i >= 0; i--){
            tableModel.removeRow(i);
        }
        model.setCurrentView(0);
        
        //populating table with new rows
        for(int i=0; i<model.getModelList().size(); i++){
            String firstname = model.getModelList().get(i).getUser().getFirstName();
            String drugname = model.getModelList().get(i).getDrugInfo().getDrugName();
            String drugtaken = model.getModelList().get(i).getScheduleInfo().getDrugTaken_as_String();
            
            Object[] data = {firstname, drugname, drugtaken};
            tableModel.addRow(data);
        }

        JTable jt = new JTable(tableModel);
        JScrollPane jpane = new JScrollPane(jt);
        JPanel jp = new JPanel();
        jp.setSize(700,600);
        jp.add(jpane);
        add(new JScrollPane(jp));
        setVisible(true);

    }
    
    public InitialFrame createDetailView(){
        ButtonPanel bp = new ButtonPanel();
        InfoPanel ip = new InfoPanel();
        InitialPanel iPanel = new InitialPanel(ip, bp);
        dv.setIframe(new InitialFrame(iPanel));
        dv.getIframe().setSize(800, 700);
        dv.getIframe().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dv.getIframe().setVisible(true);
        
        return dv.getIframe();
    }
    
    public InitialFrame getInitialFrame(){
        return this.iframe;
    }
    public void setInitialFrame(InitialFrame newiframe){
        this.iframe = newiframe;
    }
    
    public JTable getJT(){
        return this.jt;
    }
    public void setJT(JTable newjt){
        jt = newjt;
    }
    
    public JPanel getJP(){
        return this.jp;
    }
    public void setJP(JPanel newjp){
        this.jp = newjp;
    }
    
    public JButton getDetails(){
        return this.details;
    }
    
    public JButton getAdd(){
        return this.add;
    }
    
    public JButton getDelete() {
        return this.delete;
    }
    
    public DetailsView getDetailsView(){
        return this.dv;
    }
    
}
