import javax.swing.*;

public class ControlPanel extends JPanel {
    final private DrawingFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(DrawingFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        this.add(loadBtn);
        this.add(saveBtn);
        this.add(resetBtn);
        resetBtn.addActionListener((e -> frame.canvas.clear()));
    }
}
