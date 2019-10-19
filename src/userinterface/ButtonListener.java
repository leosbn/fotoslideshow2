package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JPanel;
import fotoslideshow.objects.*;

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
        try {
            this.folder = new Folder(this.ui.getTextField());
            this.numberOfLabels = this.folder.getListImagesOnly().size();
            this.ui.setNumberOfLabels(numberOfLabels);
            this.ui.addToListOfLinks(this.folder.getListImagesOnly());
            this.ui.createVisualizationArea3();
        } catch (Exception ex) {
            this.ui.createVisualizationArea4();
//System.out.println("file not found or non valid");
        }
    }

    public int getImagesNumber() {
        return this.numberOfLabels;
    }

}
