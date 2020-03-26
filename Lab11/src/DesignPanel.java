import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class DesignPanel extends JPanel {
    public static final int W = 800, H = 600;
    private final MainFrame frame;
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
    }
    public void addAtRandomLocation(JComponent comp) {
        int x =  ThreadLocalRandom.current().nextInt(0, W);//create a random integer between 0 and W-1
        int y = ThreadLocalRandom.current().nextInt(0, H);//create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
}