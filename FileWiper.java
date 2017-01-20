package com.java21days;
                            // reads specific file to determine byte size then
                            // overwrites that file with all "0"
import java.io.*;

public class FileWiper {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new FileInputStream("junkfile.dat");
            boolean eof = false;
            int size = 0;
            while (!eof) {
                int input = file.read(); 
                if (input == -1) {
                    eof = true;
                } else {
                    size++;
                }
            }
            file.close();
            FileOutputStream outFile = new FileOutputStream("junkfile.dat");
            for (int i = 1; i < size; i++) {
                outFile.write( (byte) 0 );
            }
            outFile.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
 
