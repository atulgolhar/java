package com.java21days;
                                        // application that ...
import java.awt.*;                     
import java.awt.event.*;
import javax.swing.*;

public class KeyChecker2 extends JFrame {
    JLabel keyLabel = new JLabel("Hit any key");
    
    public KeyChecker2() {
        super("Hit a Key");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));  
        
      //KeyMonitor monitor = new KeyMonitor(this);          // change this
        
        KeyAdapter monitor = new KeyAdapter() {
            public void keyTyped(KeyEvent event) {
                keyLabel.setText("" + event.getKeyChar());
                repaint();
            }
        };
        
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }
   
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.err.println("Couldn't use the system " +
                    "look and feel: " + exc);
        }
    }
    
    public static void main(String[] arguments) {
        KeyChecker2.setLookAndFeel();
        new KeyChecker2();
    }
}
   

// From KeyChecker class

/* old code

class KeyMonitor extends KeyAdapter {
    KeyChecker2 display;

    KeyMonitor(KeyChecker display) {
        this.display = display;
    }

    public void keyTyped(KeyEvent event) {                  // keyTyped method overrides 
        display.keyLabel.setText("" + event.getKeyChar());  // the same method in KeyAdapter
        display.repaint();                                  // which does nothing
    }
}


Note getKeyChar() line 47 captures the key. This key becomes the text of
keyLabel line 47 from KeyChecker class line 40.

*/
