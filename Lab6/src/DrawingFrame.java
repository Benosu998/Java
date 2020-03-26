import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {
    Toolbar toolbar = new Toolbar(this);
    Canvas canvas = new Canvas(this);
    ControlPanel control=new ControlPanel(this);

    public DrawingFrame() {
        super("Visual Graph Manager");
        init();
    }
    public DrawingFrame(String name){
        super(name);
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(toolbar,BorderLayout.NORTH);
        this.add(canvas,BorderLayout.CENTER);
        this.add(control,BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}