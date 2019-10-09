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
    private JPanel panelWithLabels;

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
        container.add(createVisualizationArea2(), BorderLayout.CENTER);
        container.add(createSearchArea(), BorderLayout.NORTH);
    }

    /**
     * this method creates the search area, with the TextField and the button
     *
     * @return
     */
    public JPanel createSearchArea() {
        GridLayout gridSearch = new GridLayout(1, 2);
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(gridSearch);
        this.textField = new JTextField();
        searchPanel.add(this.textField);
        this.button = new JButton("Check current folder");
        searchPanel.add(button);
        button.addActionListener(new ButtonListener(this, textField, this.panelWithLabels));
        return searchPanel;
    }

    /**
     * this method creates the visualization panel: it should create an empty
     * panel that gets populated, after being updated by the call made to
     * ButtonListener with a number of JLabels that matches the one of the
     * variable int labelsToBeCreatedNumber.
     *
     * @return
     */
    public JPanel createVisualizationArea2() {
        this.panelWithLabels = new JPanel();
        for (int i = 0; i < this.labelsToBeCreatedNumber; i++) {
            JLabel label1 = new JLabel("a");
            this.panelWithLabels.add(label1);
        }
        return this.panelWithLabels;
    }

    public JPanel createVisualizationArea3() {
        this.panelWithLabels.updateUI();
        for (int i = 0; i < this.labelsToBeCreatedNumber; i++) {
            JLabel label1 = new JLabel("a");
            this.panelWithLabels.add(label1);
        }
        return this.panelWithLabels;
    }

    /**
     * this getter is used by the listener to be able to get the current
     * instance of this userinterface
     *
     * @return
     */
    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * this getter is used by the listener to be able to get the textfield text
     * content when triggered by the button
     *
     * @return
     */
    public String getTextField() {
        return this.textField.getText();
    }

    public void setNumberOfLabels(int number) {
        this.labelsToBeCreatedNumber = number;
    }

    public JPanel getPanelWithMultipleLabels() {
        return this.panelWithLabels;
    }
}
