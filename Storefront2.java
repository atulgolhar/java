package com.java21days;

import java.util.*;

public class Storefront2 {
    private LinkedList catalog = new LinkedList();
    
    public void addItem(String id, String name, String price, 
        String quant, String discount) {
        
        Item2 it = new Item2(id, name, price, quant, discount);
        catalog.add(it);
    }
    
    public Item2 getItem(int i) {            // this provides an interface to the catalog variable
        return (Item2) catalog.get(i);       // returns object from LinkedList at that index i location
    }
    
    public int getSize() {                  // this provides an interface to the catalog variable
        return catalog.size();
    }
     
    public void sort() {                    // benefit from using interface to access class is here
        Collections.sort(catalog);          // sorts a linked list and other data structures
    } 
}
