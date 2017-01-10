package com.java21days;

public class Weather {
    public static void main(String[] arguments) {
        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
        fah = fah - 32;     // convert F to C
        fah = fah / 9;      // divide by 9
        fah = fah * 5;      // multiply by 5
        System.out.println(fah + " degrees Celsius\n");
        
        float cel = 33;
        System.out.println(cel + " degrees Celsius is ...");
        cel = cel * 9;      // convert C to F
        cel = cel / 5;
        cel = cel + 32;
        System.out.println(cel + " degrees Fahrenheit");
    }
}
