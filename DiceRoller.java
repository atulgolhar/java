package com.java21days;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller extends JFrame implements ActionListener,
    PropertyChangeListener {

    JTextField[] total = new JTextField[16];    // the table for dice-roll results
    JButton roll;                               // the "Roll" button
    JTextField quantity;                        // number of times to roll
    DiceWorker worker;                          // Swing worker

    public DiceRoller() {
        super("Dice Roller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(850, 145);

        JPanel topPane = new JPanel();          // set up top row
        GridLayout paneGrid = new GridLayout(1, 16);
        topPane.setLayout(paneGrid);
        for (int i = 0; i < 16; i++) {
            total[i] = new JTextField("0", 4);  // create textfield and label
            JLabel label = new JLabel((i + 3) + ": ");
            JPanel cell = new JPanel();         // create this cell in the grid
            cell.add(label);
            cell.add(total[i]);
            topPane.add(cell);                  // add the cell to the top row
        }

        JPanel bottomPane = new JPanel();       // set up bottom row
        JLabel quantityLabel = new JLabel("Times to Roll: ");
        quantity = new JTextField("0", 5);
        roll = new JButton("Roll");
        roll.addActionListener(this);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        GridLayout frameGrid = new GridLayout(2, 1);    // set up frame
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {        // respond with Roll button is clicked
        int timesToRoll;
        try {
            timesToRoll = Integer.parseInt(quantity.getText()); // turn off the button
            roll.setEnabled(false);
            worker = new DiceWorker(timesToRoll);       // set up the worker that will roll the dice
            worker.addPropertyChangeListener(this);     // add a listener that monitors the worker
            worker.execute();                           // start the worker
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }

    public void propertyChange(PropertyChangeEvent event) {         // response when workers task is complete
        try {
            int[] result = (int[]) worker.get();        // get worker's dice roll results
            for (int i = 0; i < result.length; i++) {   // store the results in text fields
                total[i].setText("" + result[i]);
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
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
        new DiceRoller();
    }
}
