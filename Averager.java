package com.java21days;

class Averager {
    public static void main(String[] arguments) {
        int sum = 0;
        
        if (arguments.length > 0) {
            for (int i = 0; i < arguments.length; i++) {
                sum += Integer.parseInt(arguments[i]);
            }
            System.out.println("Sum is: " + sum);
            System.out.println("Average is: "  + (float) sum / arguments.length);
        }
    }
    
}

// NetBeans command line arguments passed to the application as string objects
// in Project Configuation Customized arguments
