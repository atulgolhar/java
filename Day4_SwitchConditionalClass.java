package com.java21days;         // 3 instance variables but inefficient/redundant statements

class Day4_SwitchConditionalsClass {
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
 
// Record an integer value each day for 1 year then organize by week
        int[][] dayValue = new int[53][7];
        dayValue[9][0] = 14200;         // sets 10th week day 1
// 3 dimensional arrys of integers and displays the number of elements in each dimension
        int[][][] cen = new int[100][52][7];
        System.out.println("Elements in the 1st dimension: " + cen.length);
        System.out.println("Elements in the 2nd dimension: " + cen[0].length);
        System.out.println("Elements in the 3rd dimension: " + cen[0][0].length);
    }    
}
        
        
/*        
void testBlock() {
    int x = 10;
    {                           // start of block
        int y = 40;             // local scope inside the block only
        y = y + x;
    }                           // end of block
}
*/

        
        
/*        
//If conditionals
// example that displays "not enough arguments" only if value of an instance variable is less than 3
if (arguments.length <3) {
    System.out.println("Not enough arguments");
    System.exit(-1);
}
*/  
        
        


/*
// If Else conditional
String server;
int duration;
if (arguments.length < 1) {
    server = "localhost";
} else {
    server = arguments[0];
}
*/


/*
// Example using if with block
int speed;
String status;
float temperature = -60;

if (temperature < -80) {
    status = "returning home";
    speed = 5;
}
*/




/*
// Example if with boolean
if (outOfGas == true) {
    status = "inactive";
}
*/      

        
        

// Swith Conditionals --> Nested if statements  BAD
/*
if (operation == '+')
    add(object1, object2);
else if (operation == '-')
    subtract(object1, object2);
else if (operation == '*')
    multiply(object1, object2);
else if (operation == '/')
    divide(object1, object2);
*/


        
        
/*
// BETTER Nested using Switch Statement
char grade = 'D';
switch (grade) {
    case 'A':
        System.out.println("Great Job!");
        break;
    case 'B':
        System.out.println("Good Job");
        break;
    case 'C':
        System.out.println("You can do better!");
        break;
    default:
        System.out.println("Consider another attempt?");
}
*/  




/*
// Another switch example
String command = "close";
switch (command) {              // test variable is command
    case "open":                // command is compared with each case value
        openFile();
        break;
    case "close":
        closeFile();
        break;
    default:
        System.out.println("Invalid command");
    }
*/
  



/*
// Rewrite of prior Nested If example
switch (operation) {
    case '+':
        add(object1, object2);
        break;
    case '-':
        subtract(object1, object2);
        break;
    case '*':
        multiply(object1, object2);
        break;
    case '/':
        divide(object1, object2);
        break;
}       
*/




/*
// New example
// x is an even number and is printed if x has even value between 2 and 8.
// all other x values cause this statemet to be printed "x is an odd number"

int x = 5;
switch (x) {
    case 2:
    case 4:
    case 6:
    case 8:
        System.out.println("x is an even number");
        break;
    default:
        System.out.println("x is an odd number");
}
*/
