import javax.swing.*;
import java.awt.*;

public class CatalogFrame extends JFrame {
     GraphForm form=new GraphForm(this);
     CatalogList list=new CatalogList();
     ControlPanel control=new ControlPanel(this);

    public CatalogFrame() {
        super("Visual Graph Manager");
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(600,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(form,BorderLayout.NORTH);
        this.add(list,BorderLayout.CENTER);
        this.add(control, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
