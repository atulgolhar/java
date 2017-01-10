package com.java21days;

import javax.swing.*;

public class SimpleFrameB extends JFrame {
    public SimpleFrameB() {
        super("My Own Frame Title");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
    
    public static void main(String[] arguments) {
        setLookAndFeel();
        SimpleFrameB sf = new SimpleFrameB();       // testing code
        sf.setVisible(true);                        // testing code
    }
}
