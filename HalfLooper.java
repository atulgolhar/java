package com.java21days;

class HalfLooper {
    public static void main(String[] arguments) {
        int[] denver = {1_700_000, 4_600_000, 2_100_000 };
        int[] philadelphia = new int[denver.length];
        int[] total = new int[denver.length];
        int sum = 0;
        
        for (int i = 0; i < denver.length; i++) {   //denver.length is total # elements in denver arrary
            total[i] = denver[i] + philadelphia[i];
            System.out.format((i + 2012) + " production: %,d%n", total[i]);
            sum += total[i];
        }
            
        System.out.format("Average production: %,d%n", (sum / denver.length));
    }
}
