package com.java21days;
                            // example of using more than one filter on a stream
import java.io.*;

public class PrimeWriter {
    public static void main(String[] arguments) {
        int[] primes = new int[400];
        int numPrimes = 0;

        int candidate = 2;              // candidate number might be prime
        while (numPrimes < 400) {
            if (isPrime(candidate)) {
                primes[numPrimes] = candidate;
                numPrimes++;
            }
            candidate++;
        }

        try (
            FileOutputStream file = new         // write output to disk
                FileOutputStream("400primes.dat");  // create file output
            BufferedOutputStream buff = new         
                BufferedOutputStream(file);     // associate buffered output stream to the file stream
            DataOutputStream data = new 
                DataOutputStream(buff);         // associate data output stream to the buffered stream    
            ) {

            for (int i = 0; i < 400; i++)
               data.writeInt(primes[i]);        // write the primes to the file
            data.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }

    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0)
                return false;
        }
        return true;
    }
}
