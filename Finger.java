package com.java21days;         // Finger application for rudimentary user information

import java.io.*;
import java.net.*;
import java.util.*;

public class Finger {
    public static void main(String[] args) {
        String user;
        String host;
        if ((args.length == 1) && (args[0].indexOf("@") > -1)) {
           StringTokenizer split = new StringTokenizer(args[0], "@");
           user = split.nextToken();
           host = split.nextToken();
        } else {
            System.out.println("Usage: java Finger user@host");
            return;
        }
        try (Socket digit = new Socket(host, 79);           // port 79 traditionally reserved for Finger services 
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(digit.getInputStream()));
                ) {
            digit.setSoTimeout(20000);
            PrintStream out = new PrintStream(digit.getOutputStream());
            out.print(user + "\015\012");   // \015 = carriage return and \012 = linefeed
            
            boolean eof = false;
            while (!eof) {
                String line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                } else {
                    eof = true;
                }
            }
            digit.close();
        } catch (IOException e) {
            System.out.println("IO Error:" + e.getMessage());
        }
    }
}

/* 
declaring socket and reader within the try statement parentheses ensures that 
both of these resources will be closed even when the connection fails with
an exception.
*/
