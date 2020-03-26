import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    private final DrawingFrame frame;
    private Graphics2D graphics;
    private BufferedImage image;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width=800;
    private int height=600;
    Color color = Color.BLACK;

    Canvas(DrawingFrame frame) {
        this.frame=frame;
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(width,height));
        this.image=new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
        this.graphics=image.createGraphics();
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                drawNode(e.getX(), e.getY());
            }
        });
    }

    public void drawNode(int x, int y) {
        graphics.setColor(color);
        graphics.fill(new NodeShape(x,y,frame.toolbar.textField.getText().equals("")?50:Integer.parseInt(frame.toolbar.textField.getText())));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(image == null){
            image=new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D=image.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        }
        g.drawImage(image,0,0,null);
    }
    void clear(){
        super.paintComponent(graphics);
        repaint();
    }
}
