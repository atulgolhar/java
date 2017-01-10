package com.java21days;

import java.awt.*;
import javax.swing.*;

public class ProgressMonitor2 extends JFrame {  // augments ProgressMonitor application
                                                // displays num variable in text field
    JProgressBar current;
    JTextField numField;
    JButton find;
    Thread runner;
    int num = 0;
    
    public ProgressMonitor2() {
        super("ProgressMonitor2");
        setLookAndFeel();
        setSize(220, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        numField = new JTextField("" + num, 8);
        pane.add(numField);
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        setContentPane(pane);
        setVisible(true);
    }
    
    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            numField.setText("" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("Couldn't use the system " +
                    "look and feel: " + e);
        }
    }
    
    public static void main(String[] arguments) {
        ProgressMonitor2 frame = new ProgressMonitor2();
        frame.iterate();
    }
}
