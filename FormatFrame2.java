package com.java21days;         // creates app with noneditable
                                // combo box and user choose one of four options
import javax.swing.*;

public class FormatFrame2 extends JFrame {       
    String[] formats = { "Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0" };  // string array
    JComboBox formatBox = new JComboBox(formats);  

    public FormatFrame2() {
        super("Choose a Format");
        setSize(220, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel formatLabel = new JLabel("Output formats:");
        pane.add(formatLabel);
        pane.add(formatBox);
        add(pane);
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
    
    public static void main(String[] arguments) {
        FormatFrame2.setLookAndFeel();
        FormatFrame2 ff = new FormatFrame2();
    }
}
