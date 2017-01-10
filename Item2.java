package com.java21days;

public class Item2 implements Comparable {       // Item class implements Comparable interface
    private String id;
    private String name;
    private double retail;
    private int quantity;
    private double price;
    private boolean noDiscount;
    
    Item2(String idIn, String nameIn, String retailIn, String quanIn, String discountIn) {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);  // convert from string to numeric value
        quantity = Integer.parseInt(quanIn);       // convert from string to numeric value
        noDiscount = discountIn.equals("TRUE");
        
        if (quantity > 400)
            price = retail * .5D;                           // $0.50 price per
        else if (quantity > 200)
            price = retail * .6D;                           // $0.60 price per
        else
            price = retail * .7D;                           // $0.70 price per
        price = Math.floor( price * 100 + .5 ) / 100;       // Math.floor method
        if (noDiscount) {
            price = retail;
        }
    }
    
    public int compareTo(Object obj) {      // interface has only one method compareTo(Object)
        Item2 temp = (Item2) obj;
        if (this.price < temp.price) {
            return 1;
        } else if (this.price > temp.price) {
            return -1;
        }
        return 0;
    }
    
    public String getId() {             // simple accessor methods provide avenue for
        return id;                      // other programs to retrieve these values
    }                                   // note no set methods are here -- see constructor methods
                                        // for this class 
    public String getName() {
        return name;
    }
    
    public double getRetail() {
        return retail;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
}
