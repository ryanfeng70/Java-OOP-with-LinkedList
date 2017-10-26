import java.awt.*;
import javax.swing.*;

public class InitialPanel extends JPanel {
    private InfoPanel ip;
    private ButtonPanel bp;
    
    public InitialPanel(InfoPanel newip, ButtonPanel newbp)
    {
        super();
        
        this.ip = newip;
        this.bp = newbp;
        
        setBackground(Color.gray);
        setLayout(new BorderLayout());
        
        add(bp, BorderLayout.SOUTH);
        add(ip, BorderLayout.CENTER);

    }
    
    public InfoPanel getInfoPanel(){
        return this.ip;
    }
    public ButtonPanel getButtonPanel(){
        return this.bp;
    }
}