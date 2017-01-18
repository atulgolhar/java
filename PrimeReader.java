package com.java21days;
                            // this just reads integers froma file using a data input stream
import java.io.*;

public class PrimeReader {
    public static void main(String[] arguments) {
        try (FileInputStream file = new FileInputStream("400primes.dat");
                BufferedInputStream buff = new BufferedInputStream(file);
                DataInputStream data = new DataInputStream(buff)) {
                try {
                    while (true) {                  // endles loop
                        int in = data.readInt();        // loading data here from stream
                        System.out.print(in + " ");
                    }
                } catch (EOFException eof) {        // closes endless loop with automatic exception
                    buff.close();                       // ensures proper close when no longer needed
                }
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}
