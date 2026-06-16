package roleplay.gui;

import javax.swing.*;

public class WorkbenchTextField extends JTextField {
    public static final int PREFERRED_HEIGHT = 28;

    public WorkbenchTextField(String idenfier) {
        super();
        this.setName(idenfier);

        this.setSize(0, PREFERRED_HEIGHT);
    }
}
