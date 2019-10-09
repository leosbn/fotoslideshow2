package userinterface;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.util.List;
import java.util.ArrayList;
import fotoslideshow.objects.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private final int WIDTH;
    private final int HEIGHT;
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private int labelsToBeCreatedNumber;
    private List<JLabel> labelsToBeCreated;

    public UserInterface() {
        WIDTH = 1200;
        HEIGHT = 900;
    }

    public void run() {
        this.frame = new JFrame("FotoSlideShow");
        this.frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.createComponents(this.frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        //JTextField textField = new JTextField();
        //JButton button = new JButton("Check current folder");
        //JLabel label = new JLabel();
        //button.addActionListener(new ButtonListener(textField, label));
        container.add(createSearchArea(), BorderLayout.NORTH);
        container.add(createVisualizationArea2(), BorderLayout.CENTER);
    }

    public JPanel createSearchArea() {
        GridLayout gridSearch = new GridLayout(1, 2);
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(gridSearch);
        this.textField = new JTextField();
        searchPanel.add(this.textField);
        this.button = new JButton("Check current folder");
        searchPanel.add(button);
        button.addActionListener(new ButtonListener(this, textField, createVisualizationArea2()));
        return searchPanel;
    }

    public JPanel createVisualizationArea() {
        JPanel visualizationPanel = new JPanel();
        this.label = new JLabel();
        visualizationPanel.add(label);
        return visualizationPanel;
    }
    
    public JPanel createVisualizationArea2(){
        JPanel visualizationPanel2 = new JPanel();
        //this.labelsToBeCreated = new ArrayList<JLabel>();
        for(int i=0;i<this.labelsToBeCreatedNumber;i++){
            JLabel label1 = new JLabel("a");
            visualizationPanel2.add(label1);
            //this.labelsToBeCreated.add(label);
        }
        return visualizationPanel2;
    }

    public JLabel createLabel() {
        this.label = new JLabel();
        return label;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public String getTextField() {
        return this.textField.getText();
    }

    public JLabel setLabel(String text) {
        this.label.setText(text);
        return this.label;
    }

    public void setNumberOfLabels(int number) {
        this.labelsToBeCreatedNumber = number;
    }

    public int getNumberOfLabels() {
        return this.labelsToBeCreatedNumber;
    }
}
