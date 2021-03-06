package com.java21days;
                            // Creates AllCaps version of Buffered text file
import java.io.*;
import java.nio.file.*;

public class AllCapsDemo {
    public static void main(String[] arguments) {
        if (arguments.length < 1) {
            System.out.println("You must specify a filename");
            System.exit(-1);
        }
        AllCaps cap = new AllCaps(arguments[0]);
        cap.convert();
    }
}

class AllCaps {
    String sourceName;
    AllCaps(String sourceArg) {
        sourceName = sourceArg;
    }
    
    void convert() {
        try {
            FileSystem fs = FileSystems.getDefault();   // Create file objects
            Path source = fs.getPath(sourceName);
            Path temp = fs.getPath("tmp_" + sourceName);
            
            FileReader fr = new FileReader(source.toFile()); // Create input stream
            BufferedReader in = new BufferedReader(fr); 
            
            FileWriter fw = new FileWriter(temp.toFile());  // Create output stream
            BufferedWriter out = new BufferedWriter(fw);
            
            boolean eof = false;
            int inChar;
            do {
                inChar = in.read();
                if (inChar != -1) {
                    char outChar = Character.toUpperCase((char) inChar);
                    out.write(outChar);
                } else
                    eof = true;
            } while (!eof);
            in.close();
            out.close();
            
            Files.delete(source);
            Files.move(temp, source);
        } catch (IOException|SecurityException se) {
            System.out.println("Error -- " + se.toString());
        }
    }
}
