package com.java21days;

class RangeLister {
    int[] makeRange(int lower, int upper) {
        int[] range = new int[(upper-lower) + 1];
        
        for (int i = 0; i < range.length; i++) {
            range[i] = lower++;
        }
        return range;
    }
    
    public static void main(String[] arguments) {
        int[] range;
        RangeLister lister = new RangeLister();
        
        range = lister.makeRange(4, 13);
        // t = this.x;              // the x instance variable for this object
        // or
        // t = x;                   // same as above
        // z.resetData(this);       //call the resetData method, defined in z class and pass it the current object this
        // return this              // only instance methods can use this, while class methods can NOT use this
        
        System.out.print("The array: [ ");
        for (int i = 0; i < range.length; i++) {
            System.out.print(range[i] + " ");
        }
        System.out.println("]");
    }
    
}
