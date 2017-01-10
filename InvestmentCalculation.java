package com.java21days;

class InvestmentCalculation {
    public static void main(String[] arguments) {
        float total = 140000;
        System.out.println("Original investment: $" + total);
        
        total = total + (total * .4F);
        System.out.println("After one year: $" + total);
        
        total = total - 1500F;
        System.out.println("After two years: $" + total);
        
        total = total + (total * .12F);
        System.out.println("After three years: $" + total);
    }
}
