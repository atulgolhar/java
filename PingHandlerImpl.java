package com.java21days;

import java.util.*;

public class PingHandlerImpl implements PingHandler {
    public HashMap ping(String siteName, String url) {
        HashMap<String, Object> response = new HashMap<>();
        if ((siteName.equals("")) | (url.equals(""))) {
            response.put("message", "Bad ping");
            boolean flError = true;
            response.put("flerror", flError);
        } else {
            response.put("message", "Thanks for the ping");
            boolean flError = false;
            response.put("flerror", flError);
            System.out.println("Ping received from " + siteName + ", " + url);
        }
        return response;
    }
}
