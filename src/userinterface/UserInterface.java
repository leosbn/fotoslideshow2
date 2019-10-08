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
import fotoslideshow.objects.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private final int WIDTH;
    private final int HEIGHT;
    private JLabel label;
    private JTextField textField;
    private JButton button;

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
        container.add(createVisualizationArea(), BorderLayout.CENTER);
    }

    public JPanel createSearchArea() {
        GridLayout gridSearch = new GridLayout(1, 2);
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(gridSearch);
        this.textField = new JTextField();
        searchPanel.add(this.textField);
        this.button = new JButton("Check current folder");
        searchPanel.add(button);
        button.addActionListener(new ButtonListener(this, textField, label));
        return searchPanel;
    }

    public JPanel createVisualizationArea() {
        JPanel visualizationPanel = new JPanel();
        this.label = new JLabel();
        visualizationPanel.add(label);
        return visualizationPanel;
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
}
