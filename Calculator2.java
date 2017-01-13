package com.java21days;             // calculator that adds or subtracts the contents of two text fields
                                    // whenever the appropriate button is clicked, displaying the result
import java.awt.event.*;            // as a new label.
import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;

public class Calculator2 extends JFrame implements ActionListener {
    JTextField one = new JTextField("0", 5);
    JButton plusOrMinus = new JButton("+");
    JTextField two = new JTextField("0", 5);
    JButton equals = new JButton("=");
    JLabel result = new JLabel("");
    
    public Calculator2() {
        super("Add or Subtract Two Numbers");
        setSize(400, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        plusOrMinus.addActionListener(this);
        equals.addActionListener(this);
        add(one);                            // add components
        add(plusOrMinus);
        add(two);
        add(equals);
        add(result);
        setVisible(true);
    }
    
    private static void setLookAndFeel() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { 
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Couldn't use the system look and feel: " + e);
        }
    }
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == equals) {
            try {
                int value1 = Integer.parseInt(one.getText());
                int value2 = Integer.parseInt(two.getText());
                if (plusOrMinus.getText().equals("+")) {
                    result.setText("" + (value1 + value2));
                } else {
                    result.setText("" + (value1 - value2));
                }
            } catch (NumberFormatException exc) {
                one.setText("0");
                two.setText("0");
                result.setText("0");
            }
        }
        if (evt.getSource() == plusOrMinus) {
            if (plusOrMinus.getText().equals("+")) {
                plusOrMinus.setText("-");
            } else {
                plusOrMinus.setText("+");
            }
        }
    }
    
    public static void main(String[] arguments) {
        Calculator2.setLookAndFeel();
        Calculator2 frame = new Calculator2();
    }
}
