package com.java21days;
// single thread class finds a specific prime number in a sequence such as the 100th prime
public class PrimeThreads2 {
    public static void main(String[] arguments) {
        try {
            PrimeFinder2[] finder = new PrimeFinder2[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                long count = Long.parseLong(arguments[i]);
                finder[i] = new PrimeFinder2(count);
                System.out.println("Looking for prime " + count);
            }
            boolean complete = false;
            while (!complete) {
                complete = true;
                for (int j = 0; j < finder.length; j++) {
                    if (!finder[j].finished)
                        complete = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    // do nothing
                }
            }
            for (int j = 0; j < finder.length; j++) {
                System.out.println("Prime " + finder[j].target + " is " +
                        finder[j].prime);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error: " + nfe.getMessage());
        } catch (NegativeNumberException nne) {
            System.out.println("Error: " + nne.getMessage());
        }
    }
}

/*
Modify PrimeThreads application so that it can handle the new
NegativeNumberException error.
*/
