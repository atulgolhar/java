package com.java21days;     // creates server socket on port 4415
                            // when client connects, PrintWriter object is constructed from
import java.io.*;           // a buffered output stream so that a string -- the current time
import java.net.*;          // can be sent to the client. After the string has been sent
import java.util.*;         // writer's flush() and close() methods end the data exchange.
                            // and close the socket to await new connections.
public class TimeServer extends Thread {
    private ServerSocket sock;
    
    public TimeServer() {
        super();
        try {
            sock = new ServerSocket(4415);      // creates socket here
            System.out.println("TimeServer running ...");
        } catch (IOException e) {
            System.out.println("Error: couldn't create socket.");
            System.exit(1);
        }
    }
    
    public void run() {
        Socket client = null;
        
        while (true) {
            if (sock == null)
                return;
            try {
                client = sock.accept();
                BufferedOutputStream bb = new BufferedOutputStream(client.getOutputStream());
                PrintWriter os = new PrintWriter(bb, false);
                String outLine;
                
                Date now = new Date();
                os.println(now);
                os.flush();
                
                os.close();
                client.close();
            } catch (IOException e) {
                System.out.println("Error: couldn't connect.");
                System.exit(1);
            }
        }
    }
    
    public static void main(String[] arguments) {
        TimeServer server = new TimeServer();
        server.start();
    }
    
}
