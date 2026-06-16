package roleplay;

import com.formdev.flatlaf.FlatDarculaLaf;
import roleplay.gui.WorkbenchLayout;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        FlatDarculaLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Couldn't set look and feel.");
        }

        super("Roleplay");

        try {
            this.setIconImage(new ImageIcon("res/icon.svg").getImage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        JPanel test = new JPanel();

        {
            test.add(new JLabel("WWWWWW"));
            test.add(new JTextField());
            test.add(new JLabel("Test 2"));
            test.add(new JTextField());

            test.setLayout(new WorkbenchLayout());
        }

        JPanel entityPanel = new JPanel();

        {
            JTextField entityNameInput = new JTextField(10);
            entityNameInput.setName("entity.name");
            entityNameInput.setPreferredSize(new Dimension(100, 20));

            entityPanel.add(new JLabel("Name"));
            entityPanel.add(entityNameInput);
        }

        JPanel attributePanel = new JPanel();

        {
            JTextField attributeNameInput = new JTextField(10);
            attributeNameInput.setName("attribute.name");

            JTextField attributeValueInput = new JTextField(5);
            attributeValueInput.setName("attribute.value");

            attributePanel.add(new JLabel("Attribute"));
            attributePanel.add(attributeNameInput);
            attributePanel.add(new JLabel("Value"));
            attributePanel.add(attributeValueInput);
        }

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        {
            tabbedPane.addTab("Entity", entityPanel);
            tabbedPane.addTab("Attribute", attributePanel);
            tabbedPane.addTab("Test", test);
            tabbedPane.setSelectedIndex(0);
        }

        this.add(tabbedPane);
        this.pack();

        this.setVisible(true);
    }
}
