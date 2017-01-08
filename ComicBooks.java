package com.java21days;         // uses maps for a shopping application

import java.util.*;

public class ComicBooks {       // application class

    public ComicBooks() {
    }
    
    public static void main(String[] arguments) {
        HashMap quality = new HashMap();        // set up hash map
      //HashMap<String, Float> quality = new HashMap<>();   // uses diamond operator infer with autoboxing 
                                                            // reduces bad code when compiling
        float price1 = 3.00F;                   // key = description, value = base price multiplier
        quality.put("mint", price1);            // worth 3 times their base price
        float price2 = 2.00F;
        quality.put("near mint", price2);       // worth 2 times their base price
        float price3 = 1.50F;           
        quality.put("very fine", price3);       // worth 1.5 times their base price
        float price4 = 1.00F;
        quality.put("fine", price4);            // worth 0.5 times their base price
        float price5 = 0.50F;
        quality.put("good", price5);            // worth 0.25 times their base price
        float price6 = 0.25F;
        quality.put("poor", price6);
        
        Comic[] comix = new Comic[3];
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition) );
                
        //comix[0].setPrice( (Float) quality.get(comix[0].condition) );
        //                      ^       ^     ^   ^          ^
        //                                   get(String)                        method
        //                                                book's condition      string        
        //                           object is returned
        //                    cast the object as a Float
        
        //using Generics --> ATUL just a phrase to describe what is happening
        //comix[0].setPrice(quality.get(comix[0].condition));

        
        comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        
        comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        
        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }        
    }
}

class Comic {       // helper class
    String title;               // instance variable
    String issueNumber;         // instance variable
    String condition;           // instance variable
    float basePrice;            // instance variable
    float price;                // instance variable
    
    Comic(String inTitle, String inIssueNumber, String inCondition,     // constructor method
            float inBasePrice) {                                        // of this class
        
        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }
    
    void setPrice(float factor) {               // float value is variable called factor
        price = basePrice * factor;
    }
}
