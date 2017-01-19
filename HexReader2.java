package com.java21days;
                            // reads two digit hexadecimal sequences from a text file
import java.io.*;           // and displays their decimal equivalents.

class HexReader2 {
    
    public HexReader2() {
        FileReader file;
        try {
            file = new FileReader("hexfile.txt");           // reading input
            BufferedReader buff = new BufferedReader(file);
            
            boolean eof = false;
            while (!eof) {
                String line = buff.readLine();
                if (line == null) {
                    eof = true;
                } else {
                    readLine(line);
                }
            }
            buff.close();
        } catch (IOException ex) {
            System.out.println("IO error " + ex.getMessage());
        }
    }
    
    private void readLine(String code) {
        try {
            for (int j = 0; j + 1 < code.length(); j += 2) {
                String sub = code.substring(j, j + 2);
                int num = Integer.parseInt(sub, 16);
                if (num == 255) {
                    return;
                }
                System.out.print(num + " ");
            }
        } finally {
            System.out.println("**");
        }
    }
       
    public static void main(String[] arguments) {
        new HexReader2();
    }
    
}
