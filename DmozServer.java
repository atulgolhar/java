package com.java21days;

import java.io.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.*;
import org.apache.xmlrpc.webserver.*;

public class DmozServer {
    public static void main(String[] arguments) {
        try {
            startServer();
        } catch (IOException ioe) {
            System.out.println("Server error: " + ioe.getMessage());
        } catch (XmlRpcException xre) {
            System.out.println("XML-RPC error: " + xre.getMessage());
        }
    }
    
    public static void startServer() throws IOException, XmlRpcException {
        
        // create the server
        System.out.println("Starting Dmoz server ...");
        WebServer server = new WebServer(4413);               // create web server at port 4413
        XmlRpcServer xmlRpcServer = server.getXmlRpcServer(); // associate that server with XML-RPC
        PropertyHandlerMapping phm = new PropertyHandlerMapping();
        
        // register the handler
        phm.addHandler("dmoz", DmozHandlerImpl.class);  // add handler and give name
        xmlRpcServer.setHandlerMapping(phm);
        
        // start the server
        server.start();     // begin listening for requests
        System.out.println("Accepting requests ...");
    }
}
