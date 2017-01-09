package com.java21days;

import javax.swing.*;

public class DVR extends JFrame {           // generic DVR dialong box
    JButton play = new JButton("Play");
    JButton stopEject = new JButton("Stop/Eject");
    JButton rewind = new JButton("Rewind");
    JButton fastForward = new JButton("Fast Forward"):
    JButton pause = new JButton("Pause");
    
    public DVR() {
        super("DVR");
        setSize(540,80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.add(play);
        pane.add(stopEject);
        pane.add(rewind);
        pane.add(fastForward);
        pane.add(pause);
        setContentPane(pane);
        setVisible(true);
    }
    
    public static void main(String[] arguments) {
        DVR dvr = new DVR();
    }
}
