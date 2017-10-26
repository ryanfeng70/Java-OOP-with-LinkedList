import javax.swing.*;

public class InitialFrame extends JFrame {
    private InitialPanel inp;
    private boolean opendetails = false;
    
	public InitialFrame(InitialPanel inp1){
            super ("Details View (change fields and click save to save changes)");
            LayoutSetupMAC();
            inp = inp1;
            add(inp);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize (1200, 900);
            setVisible(opendetails);
	}
        
    public InitialPanel getInitialPanel(){
        return this.inp;
    }
    public void setInitialPanel(InitialPanel newinp){
        this.inp = newinp;
    }
    public boolean getOpenDetails(){
        return this.opendetails;
    }
    public void setOpenDetails(boolean newopendetails){
        this.opendetails = newopendetails;
    }
    
        
    void LayoutSetupMAC()
    {
    // On some MACs it might be necessary to have the statement below 
    //for the background color of the button to appear    
       try 
        {
          UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
         } catch (Exception e) 
         {
                e.printStackTrace();
          }                
    //------------------------------------------------------           
    }

}
