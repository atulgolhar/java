package com.java21days; // Day4
/* create an array -->                                      USE THIS                NOT THIS
    1 declare a variable to hold the array              information type variable name
    2 create new array object and assign it DIRECTLY    --> String[] requests;  or String requests[];
                                                        Point[] targets;    or Point targets[];
                                                        float[] donations;  or float donations[];
    3 store info in that array
*/

class PeanutButterJelly {
    public static void main(String[] arguments) { 
        
// Creating Array Objects
        String[] players = new String[10];
        System.out.println(players);
        
        int[] temps1 = new int[99];
        System.out.println(temps1);
        int[] temps2 = new int[99];
        System.out.println(temps2);
        int[] temps3 = new int[99];
        System.out.println(temps3);
        
        Integer[] series = new Integer[3];
        series[0] = new Integer(10);
        series[1] = new Integer(3);
        series[2] = new Integer(5);
        System.out.println(series[0] + series[1] - series[2]);
        
        //int[] markup = new int;
        //Point[] markup = { new Point(1,5), new Point(3,3), new Point(2,3) };
        //System.out.println(markup);
        
        String[] titles = { "Mr.", "Mrs.", "Ms.", "Miss", "Dr." };
        System.out.println(titles);
        System.out.println(titles.length);
        
        //testScore[40] = 920;
        //float[] rating = new float[20]; error b/c slots 0-19 exist, not 20th
        //rating[20] = 3.22F;
        //System.out.println("Elements: " + rating.length);   //to avoid overrunning end of array
        
        //temperature[4] = 85; an array of objects is actually an array of references to those objects
        //day[0] = "Sunday";        also when you move arond values inside an array, you are reassigning references
        //manager[2] = manager[0];  rather than copying a value from one slot to another
        
        
        
        
        String str1, str2 ;
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
