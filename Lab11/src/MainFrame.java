
import javax.swing.*;

import java.awt.*;


public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame() {
        super("Swing Designer");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel=new ControlPanel(this);
        designPanel= new DesignPanel(this);
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(designPanel,BorderLayout.CENTER);
        pack();
    }
    //create the main method
    public static void main(String[] args)
    {
        MainFrame mf =new MainFrame();
        mf.setVisible(true);
    }
}