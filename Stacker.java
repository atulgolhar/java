package com.java21days;

import java.awt.*;
import javax.swing.*;

public class Stacker extends JFrame {
    
    public Stacker() {
        super("Stacker");
        setSize(430, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        
        JPanel commandPane = new JPanel();      // create top panel container
        BoxLayout horizontal = new BoxLayout(commandPane, BoxLayout.X_AXIS); // buttons in horizontal layout
      //BoxLayout horizontal = new BoxLayout(commandPane, BoxLayout.Y_AXIS); // buttons in vertical layout
        commandPane.setLayout(horizontal);      // set new top panel layout
        JButton subscribe = new JButton("Subscribe");
        JButton unsubscribe = new JButton("Unsubscribe");
        JButton refresh = new JButton("Refresh");
        JButton save = new JButton("Save");
        commandPane.add(subscribe);
        commandPane.add(unsubscribe);
        commandPane.add(refresh);
        commandPane.add(save);
        
        JPanel textPane = new JPanel();         // create bottom panel
        JTextArea text = new JTextArea(4, 70);
        JScrollPane scrollPane = new JScrollPane(text);
        
        FlowLayout flow = new FlowLayout();     // put them together
        setLayout(flow);
        add(commandPane);
        add(scrollPane);
        setVisible(true);        
    }
   
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Couldn't use the system " +
                    "look and feel: " + exc);
        }
    }
    
    public static void main(String[] arguments) {
        Stacker st = new Stacker();
    }
}
