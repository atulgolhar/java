package com.java21days;         // 3 instance variables but inefficient/redundant statements

class HalfDollars {
    public static void main(String[] arguments) {
        int[] denver = {1_700_000, 4_600_000, 2_100_000 };      // declared and initialized
        int[] philadelphia = new int[denver.length];            // declared only
        int[] total = new int[denver.length];                   // declared only
        int average;
        
        philadelphia[0] = 1_800_000;        // initialized array index 0
        philadelphia[1] = 5_000_000;        // etc
        philadelphia[2] = 2_500_000;        // etc
        
        total[0] = denver[0] + philadelphia[0];     // initialized
        total[1] = denver[1] + philadelphia[1];     // etc...
        total[2] = denver[2] + philadelphia[2];
        average = (total[0] + total[1] + total[2]) / 3;
        
        System.out.print("2012 production: ");
        System.out.format("%,d%n", total[0]);
        System.out.print("2013 production: ");
        System.out.format("%,d%n", total[1]);
        System.out.print("2014 prodution: ");
        System.out.format("%,d%n", total[2]);
        System.out.print("Average production: ");
        System.out.format("%,d%n", average);
    }
}
