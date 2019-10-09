package fotoslideshow;

import javax.swing.SwingUtilities;
import userinterface.*;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }

}
