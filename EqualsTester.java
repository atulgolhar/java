package com.java21days; // Day3

class EqualsTester {
    public static void main(String[] arguments) {
        String str1, str2;
        str1 = "Boy, that escalated quickly.";
        str2 = str1;
        
        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Same object? " + (str1 == str2)); // same pointer same value
        
        str2 = new String(str1);        // creates NEW str2 with NEW POINTER and same value
        
        System.out.println("String1: " + str1);
        System.out.println("String2: " + str2);
        System.out.println("Same object? " + (str1 == str2));   // pointers DIFFERENT
        System.out.println("Same value? " + str1.equals(str2)); // values SAME
        
//Determining Class of an Object
        System.out.println("Object str1: " + str1.getClass().getName()); // example of getClass method
        System.out.println("Object str2: " + str2.getClass().getName());
        
        /* note java will optimize string literals so if create two with same info
        then java will give you back the String object --> you must go out of your way
        to create TWO SEPARATE OBJECTS */
        
        boolean check1 = "Texas" instanceof String;
        System.out.println(check1);
        
        Object obiwan = new Object();
        boolean check2 = obiwan instanceof String;
        System.out.println(check2);  
    }
}
