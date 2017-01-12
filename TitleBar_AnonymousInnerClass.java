package com.java21days;             // explains why an anonymous inner class is beneficial/more efficient
                                    // create frame with two buttons used to change the text on frame's title bar
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TitleBar extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;
    
    public TitleBar() {
        super("Title Bar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        b1 = new JButton("Rosencrantz");
        b2 = new JButton("Guildenstern");
        b1.addActionListener(this);                 // could use anonymous inner class here
        b2.addActionListener(this);                 // could use anonymous inner class here
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(b1);
        add(b2);
        pack();
        setVisible(true);
    }
    
    /*
    JButton b1;                                             // new anonymous inner class object
    b1.addActionListener(new ActionListener() {             // that implements the ActionListener interface.
        public void actionPerformed(ActionEvent evt) {      // method is overridden
            setTitle("Rosencrantz");                        // to set the frame's title
        }
    });
    JButton b2;                                             // new anonymous inner class object
    b2.addActionListener(new ActionListener() {             // that implements the ActionListener interface.
        public void actionPerformed(ActionEvent evt) {      // method is overridden
            setTitle("Guildenstern");                       // to set the frame's title
        }
    });
       
    so here the anonymous inner class becomes the argument to the button's addActionListener() method
    as you can see in both examples.
    The anonymous inner class is an object that implements the ActionListener interface.
    The objects actionPerformed() method is overridden to set the frame's title when the 
    corresponding button is clicked. Because each button has its own listener, it's simplier
    than using one listener for multiple components. 
    
    (ATUL if is have 50 component then can be confusing to keep track of how that one object
    is used across the 50 componets, but if have code that spells exactly what is being overridden then
    its much easier to track what is being overridden b/c the code spells it out for you!
    
    anonymous inner class is an object = b1
    anonymous inner class is an object = b2
    
    
    */
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == b1) {
            setTitle("Rosencrantz");
        } else if (source == b2) {
            setTitle("Guildenstern");
        }
        repaint();          // frame is redrawn after any title change that
    }                       // might have occurred in the method
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel (
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception exc) {
            System.err.println("Couldn't use the system " + 
                    "look and feel: " + exc);
        }
    }
    
    public static void main(String[] arguments) {
        TitleBar frame = new TitleBar();
    }
}
