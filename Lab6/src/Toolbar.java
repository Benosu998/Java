import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel {
    final DrawingFrame frame;
    protected JTextField textField = new JTextField();
    private JButton black = new JButton("Black");
    private JButton red = new JButton("Red");
    private JButton white = new JButton("White");


    Toolbar(DrawingFrame frame) {
        this.frame=frame;
        init();
    }
    private void init(){
        textField.setPreferredSize(new Dimension(100,30));
        this.add(textField);
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.canvas.color=Color.BLACK;
            }
        });
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.canvas.color=Color.RED;
            }
        });
        white.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.canvas.color=Color.WHITE;
            }
        });
        this.add(black);
        this.add(red);
        this.add(white);

    }
}
