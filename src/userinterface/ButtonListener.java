package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.List;
import java.util.ArrayList;
import fotoslideshow.objects.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;

public class ButtonListener implements ActionListener {

    private JTextField textField;
    private JPanel panel;
    private int numberOfLabels;
    private UserInterface ui;
    private Folder folder;

    public ButtonListener(UserInterface ui, JTextField textArea, JPanel panel) {
        this.ui = ui;
        this.textField = textArea;
        this.panel = panel;
    }

    /**
     * actions performed so far: gets the folder, gets number of objects in the
     * images list, transfers number to the user interface calls the method that
     * rebuilds the UI panel with the appropriate number of labels
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        this.folder = new Folder(this.ui.getTextField());
        this.numberOfLabels = this.folder.getFolderNumberOfImages();
        this.ui.setNumberOfLabels(numberOfLabels);
        this.ui.addToListOfLinks(this.folder.getListImagesOnly());
        //line of code above doesn't add the files as expected, still have to test it
        this.ui.createVisualizationArea3();
    }

    public int getImagesNumber() {
        return this.numberOfLabels;
    }

}
