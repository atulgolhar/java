package com.java21days;
                            // application reads and outputs any source text file via Buffer
import java.io.*;

public class SourceReader {
    public static void main(String[] arguments) {
        try (
            FileReader file = new FileReader("SourceReader.java"); // FileReader object is associated with file SourceReader.java
                                                                   // note any file can be read here
            BufferedReader buff = new BufferedReader(file)) {      // Buffering filter is associated with input source
            
                boolean eof = false;
                while (!eof) {                          // while not false readLine into buffer
                    String line = buff.readLine();
                    if (line == null) {
                        eof = true;             // triggers while loop end
                    } else {
                        System.out.println(line);
                    }
                }
                buff.close();
                
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
