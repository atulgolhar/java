package com.java21days;         // WebReader reads HTML web address as NetBeans project confirguation
                                // can Inspect Page in web browser to see matching HTML
import javax.swing.*;
import java.net.*;
import java.io.*;

public class WebReader extends JFrame {
    JTextArea box = new JTextArea("Getting data ...");
    
    public WebReader() {
        super("Get File Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        JScrollPane pane = new JScrollPane(box);
        add(pane);
        setVisible(true);
    }
    
    void getData(String address) throws MalformedURLException {
        setTitle(address);
        URL page = new URL(address);
        StringBuilder text = new StringBuilder();
        try {
           HttpURLConnection conn = (HttpURLConnection) page.openConnection();  // gets input stream from URL connection
           conn.connect();
           
           // additional code to display headers along with document text
           String key;
           String header;
           int i = 0;
           do {
               key = conn.getHeaderFieldKey(i);
               header = conn.getHeaderField(i);
               if (key == null) {
                   key = "";
               } else {
                   key = key + ": ";
               }
               if (header != null) {
                   text.append(key);
                   text.append(header);
                   text.append("\n");
               }
               i++;
           } while (header != null);
           text.append("\n");
           
           InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());   // uses getContent() method to create input stream reader
           BufferedReader buff = new BufferedReader(in);    // uses that input stream to create a new buffered input stream reader
           box.setText("Getting data ...");
           String line;
           do {
               line = buff.readLine();  // reads a line of text from the input stream and puts into a buffer
               text.append(line);       // appends each line to StringBuilder object
               text.append("\n");
           } while (line != null);      // end loop
           box.setText(text.toString());    // converts string builder object into a string and puts result into setText(String) method
        } catch (IOException ioe) {
            System.out.println("IO Error:" + ioe.getMessage());
        }
    }
    
    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("Usage: java WebReader url");
            System.exit(1);
        }
        try{
            WebReader app = new WebReader();
            app.getData(arguments[0]);
        } catch (MalformedURLException mue) {
            System.out.println("Bad URL: " + arguments[0]);
        }
    }
}
