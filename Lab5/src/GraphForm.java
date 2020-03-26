import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphForm extends JPanel {
    //name, type, path of the definition file, path of the image file, number of vertices and number of nodes
    private final CatalogFrame frame;
    private JTextField textField = new JTextField();
    private JComboBox type;
    private JTextField defPath = new JTextField();
    private JTextField filePath = new JTextField();
    private JSpinner verticesField = new JSpinner();
    private JSpinner nodesField = new JSpinner();
    private JButton addButton = new JButton("Add");

    GraphForm(CatalogFrame frame) {
        init();
        this.frame=frame;
    }

    private void init() {
        String[] choices = {"simple", "directed"};
        type = new JComboBox(choices);
        textField.setPreferredSize(new Dimension(80, 30));
        defPath.setPreferredSize(new Dimension(80, 30));
        filePath.setPreferredSize(new Dimension(80, 30));
        verticesField.setPreferredSize(new Dimension(50, 30));
        nodesField.setPreferredSize(new Dimension(50, 30));
        addButton.setPreferredSize(new Dimension(80, 30));
        this.add(textField);
        this.add(type);
        this.add(defPath);
        this.add(filePath);
        this.add(verticesField);
        this.add(nodesField);
        this.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String graph=textField.getText()+" "+
                        type.getSelectedItem()+" "+
                        defPath.getText()+" "+
                        filePath.getText()+" "+
                        verticesField.getValue()+" "+
                        nodesField.getValue()+" ";
                addGraph(graph);
            }
        });
    }

    public JComboBox getType() {
        return type;
    }

    public JSpinner getNodesField() {
        return nodesField;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextField getFilePath() {
        return filePath;
    }

    public JTextField getDefPath() {
        return defPath;
    }

    public JSpinner getVerticesField() {
        return verticesField;
    }


    private void addGraph(String graph) {
        frame.list.addGraph(graph);
    }
}