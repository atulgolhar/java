package com.java21days;

// use a switch statement to count the days in a month.
// user inputs month year.

class DayCounter {
    public static void main(String[] arguments) {   // string is called arguments in class DayCounter
        int yearIn = 2016;
        int monthIn = 1;
        if (arguments.length > 0)
            monthIn = Integer.parseInt(arguments[0]);
        if (arguments.length > 1)                   // arguments from GUI 
            yearIn = Integer.parseInt(arguments[1]);
        System.out.println(monthIn + "/" + yearIn + " has " + countDays(monthIn, yearIn) + " days.");
    }
    
    static int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0)      // Leap year
                    count = 29;
                else
                    count = 28;
                if ((year % 100 == 0) & (year % 400 != 0))  // Leap year
                    count = 28;
        }
        return count;
    }
}

/*
NetBeans --> Run --> Set Project Configuation --> Customize
Main Class field enter name of class that contains main() method --> com.java21days.DayCounter
Arguments field --> 9 2016

To run the application choose Run --> Run Project (not Run, Run File)
*/

/* Ternary Operator

test ? trueResult : falseResult

int ouBestScore = myScore > yourScore ? myScore : yourScore;

this expression is equal to:

int ourBestScore;
if (myScore > yourScore) {
    ourBestScore = myScore;
} else {
    ourBesScore = yourScore;
}
*/



/* For Loops
for (initialization; test; increment) {
    statement;
}


Example

String[] salutation = new String[10];
int i;                                              // loop index variable
for (i = 0; i < salutation.length; i++) {           // here i vs number elements in salutation array.
    salutation[i] = "Mr.";                          //<--- this single line is the block INSIDE the loop
}


*/
