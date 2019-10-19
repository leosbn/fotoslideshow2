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
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Image;

public class UserInterface implements Runnable {

    private JFrame frame;
    private final int WIDTH;
    private final int HEIGHT;
    private JTextField textField;
    private JButton button;
    private int labelsToBeCreatedNumber;
    private JPanel panelWithLabels;
    //creating a list that can hold values from the original list in Folder
    private List<File> listOfLinks;

    public UserInterface() {
        WIDTH = 1200;
        HEIGHT = 900;
        this.listOfLinks = new ArrayList<>();
    }

    @Override
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
    
    public JPanel createVisualizationArea4() {
        this.panelWithLabels.updateUI();
        JLabel exceptionHandler = new JLabel("Please insert a valid path");
        this.panelWithLabels.add(exceptionHandler);
        return this.panelWithLabels;
    }

    /**
     * creates the second JPanel, the one with the appropriate number of labels
     * inside. perhaps with some work its functions can be transfered to the
     * first method so that this can be deleted
     *
     * @return
     */
    public JPanel createVisualizationArea3() {
        this.panelWithLabels.updateUI();
        for (int i = 0; i < this.labelsToBeCreatedNumber; i++) {
            ImageIcon img = new ImageIcon(this.listOfLinks.get(i).toString());
            //line below to be edited. i must find a ration to fit images in a flowlayout in the main jpanel
            ImageIcon img2 = new ImageIcon(img.getImage().getScaledInstance(img.getIconWidth()/this.listOfLinks.size(), img.getIconHeight()/this.listOfLinks.size(), Image.SCALE_SMOOTH));
            JLabel label1 = new JLabel(img2);
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

    /**
     * this method gets the information on how many labels have to be created
     * from the action call
     *
     * @param number
     */
    public void setNumberOfLabels(int number) {
        this.labelsToBeCreatedNumber = number;
    }

    /**
     * this method populates the list in this object with the instance of the
     * original Folder
     *
     * @param originalList
     */
    public void addToListOfLinks(List<File> originalList) {
        for (File each : originalList) {
            this.listOfLinks.add(each);
        }
    }

    public List<File> getList() {
        return this.listOfLinks;
    }
}
