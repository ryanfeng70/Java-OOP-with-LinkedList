import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

class ButtonPanel extends JPanel {
    private JButton save;
    private JButton delete;
    
    public ButtonPanel()
    {
        super();
        setBackground(Color.gray);
        save = new JButton("save");
        delete = new JButton("delete");
        
        add(save);
        add(delete);
    }
    
    
    public JButton getSave() {
        return this.save;
    }
    
    public JButton getDelete() {
        return this.delete;
    }
    
}
