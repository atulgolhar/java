package com.java21days;

class ArrayCopier {
    public static void main(String[] arguments) {
        int[] array1 = { 7, 4, 8, 1, 4, 1, 4 };         // declaration
        float[] array2 = new float[array1.length];      // declaration of floating point numbers with same length as array1
        
        System.out.print("array1: [ ");             // iterate thru array1 using loop to print
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " " );
        }
        System.out.println("]");
        
        
        System.out.print("array2: [");              // while loop tests condition BEFORE looping
        int count = 0;                              // count keep track of array index elements
        while ( count < array1.length && array1[count] != 2) {      //track both conditions to exit while loop
            array2[count] = (float) array1[count];
            System.out.print(array2[count++] + " ");
        }
        
        
        int countx1 = 0;                         // Breaking out of loops
        while (countx1 < array1.length) {
            if (array1[countx1] == 1) {
                break;
            }
            array2[countx1] = (float) array2[countx1++];
        }
           
        
        int countx2a = 0;           // note we have two counters b/c we are skipping elements in the 1st array
        int countx2b = 0;           // so now we need to track two different counters
        while (countx2a++ < array1.length) {
            if (array1[countx2a] == 1) {
                continue;
            }
            array2[countx2b++] = (float) array1[countx2a];
        }
        
        
        // Labeled Loops - incicates where to resume execution
        // without a label, using break jumps outside loop
        // continue keyword restarts the loop it is enclosed within
        // to use a lable --> add the label BEFORE the initial part with a color
        
        out: for (int i = 0; i < 10; i++) {     // labeo out "labels" the outer loop
            for (int j = 0; j < 50; j++) {      // then when break is met, the break causes jumping OUT of both loops
                if (i * j > 400) {             // without the label out, break statement would exit inner loop BUT
                    break out;                  // would also RESUME execution with the outer loop
            }
            }
        }
        
        
    System.out.println("]");
    }
}

// output shows 1st four elements in array1 were copied to array2
// but 1 in the middle stopped the loop
// without the 1, then the array2 should have all same elements as array1

/*SUMMARY - we learned how to
- declare an array variable
- assing an object to it
- access and change elements
- with if and switch conditional statements, be can branch to different parts of the program
- learned the for, while and do loops


*/
