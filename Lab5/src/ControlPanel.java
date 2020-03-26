import javax.swing.*;
public class ControlPanel extends JPanel {
    final private CatalogFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton openBtn = new JButton("Open");
    JButton reportBtn = new JButton("Report");

    public ControlPanel(CatalogFrame frame) {
        this.frame=frame;
        init();
    }

    private void init() {
        this.add(loadBtn);
        this.add(saveBtn);
        this.add(openBtn);
        this.add(reportBtn);
    }
}