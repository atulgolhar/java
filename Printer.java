package com.java21days;

class Printer {
    int x = 0;
    int y = 0;
    
    void printMe() {
        System.out.println("x is " + x + ", y is " + y);
        System.out.println("I am an instance of the class " + this.getClass().getName());
    }
}

class SubPrinter extends Printer {      // adds a z instance variable to the Printer class
    int z = 3;

/*
    void printMe() {
        System.out.println("x is " + x + ", y is " + y " , z is " + z);
        System.out.println("I am an instance of the class " + this.getClass().getName());
    }
        
*/        
    public static void main(String[] arguments) {
        SubPrinter obj = new SubPrinter();
        obj.printMe();      
    }
    
}

// when this file is compiled, there are now two class files (rather than one class file)
// b/c the source file the classes separately, the compiler produces both
// NetBeans: must run Printer class as a File (not as an Application)

// z instance variable is NOT printed b/c superclass does NOT define it
/*
run:
x is 0, y is 0
I am an instance of the class com.java21days.SubPrinter
BUILD SUCCESSFUL (total time: 0 seconds)
*/
