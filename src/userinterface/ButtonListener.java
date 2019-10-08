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
    private JLabel label;
    private int numberOfLabels;
    private UserInterface ui;
    private Folder folder;

    public ButtonListener(UserInterface ui, JTextField textArea, JLabel label) {
        this.ui = ui;
        this.textField = textArea;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.folder=new Folder(this.ui.getTextField());
        this.numberOfLabels = this.folder.getFolderNumberOfImages();
        this.ui.setLabel(Integer.toString(numberOfLabels));
    }

    public int getImagesNumber() {
        return this.numberOfLabels;
    }

}
