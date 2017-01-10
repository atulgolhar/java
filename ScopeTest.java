package com.java21days;

class ScopeTest {
    int test = 10;                      // instance variable (ie class instance variable)
    
    void PrintTest() {                  // PrintTest method
        int test = 20;                  // local variable (ie method instance variable)
                System.out.println("Test: " + test);
    }
    public static void main(String[] arguments) {
        ScopeTest st = new ScopeTest();
        st.PrintTest();
    }
}

// default is local TRUMPS instance (ie method trumps class)
// except when using 
//                      this.test       (refers to the instance variable)
