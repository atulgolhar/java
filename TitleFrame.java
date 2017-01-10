package com.java21days;

import javax.swing.*;

public class TitleFrame extends JFrame {    // create input dialog box to set 
    public TitleFrame() {                   // frame title; 2 set boxes
        super("Title Frame");
        setLookAndFeel();
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String response = JOptionPane.showInputDialog(null,
                "Enter a Title for the Frame:");
        setTitle(response);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("Counldn't use the system " +
                    "look and feel: " + e);
        }
    }
    
    public static void main(String[] arguments) {
        JFrame frame = new TitleFrame();
    }
    
}
