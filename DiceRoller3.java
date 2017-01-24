package com.java21days;
                            // DiceRoller3 now monitors action events using closures
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class DiceRoller3 extends JFrame {
    JTextField[] total = new JTextField[16];    // table for dice-roll results
    JButton roll;                               // the "Roll" button
    JTextField quantity;                        // the number of times to roll
    class DiceWorker extends SwingWorker {      // the Swing worker
        int timesToRoll;
        
        DiceWorker(int timesToRoll) {            // setup the Swing worker
            super();
            this.timesToRoll = timesToRoll;
        }
        
        protected int[] doInBackground() {  // define the task the worker performs
            int[] result = new int[16];
            for (int i = 0; i < timesToRoll; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    sum += Math.floor(Math.random() * 6);
                }
                result[sum] = result[sum] + 1;
            }
            return result;              // transmit the result
        }
    } 
    
    DiceRoller3.DiceWorker worker;
    
    public DiceRoller3() {
        super("Dice Roller 3");
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
                                        
        // new closure block
        PropertyChangeListener prop = (event) -> {
            try {
                int[] result = (int[]) worker.get();    // get the worker's dice roll results
                for (int i = 0; i < result.length; i++) {   // store results in text fields
                    total[i].setText("" + result[i]);
                }
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };
        ActionListener act = (event) -> {
            int timesToRoll;
            try {
                timesToRoll = Integer.parseInt(quantity.getText()); // turn off the button
                roll.setEnabled(false);
                worker = new DiceWorker(timesToRoll);   // set up the worker that will roll the dice
                worker.addPropertyChangeListener(prop); // add a listener that monitors the worker
                worker.execute();           // start the worker
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
        };
        
        roll.addActionListener(act);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);
        
        GridLayout frameGrid = new GridLayout(2, 1);    // set up frame
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);
        setVisible(true);
    }

/*  using closuer means code block is not needed 
    
    public void actionPerformed(ActionEvent event) {    // responsd when "Roll" button is clicked
        int timesToRoll;
        try {
            timesToRoll = Integer.parseInt(quantity.getText()); // turn off button
            roll.setEnabled(false);
            worker = new DiceRoller3.DiceWorker(timesToRoll);   // set up the worker that will roll the dice
            worker.addPropertyChangeListener(this);     // add listener that monitors worker
            worker.execute();       // start the worker
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
    
    public void propertyChange(PropertyChangeEvent event) { // respond when the worker's task is complete
        try {
            int[] result = (int[]) worker.get();    // get worker's dice roll results
            for (int i = 0; i < result.length; i++) {
                total[i].setText("" + result[i]);
            }
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
 */ 
    
    private static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Couldn't use the system look and feel: " + e);
        }
    }
    
    public static void main(String[] arguments) {
        DiceRoller3.setLookAndFeel();
        new DiceRoller3();
    }
    
}
