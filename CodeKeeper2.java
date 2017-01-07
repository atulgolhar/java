package com.java21days;

import java.util.*;

public class CodeKeeper2 {
    //ArrayList list;           // prior version for CodeKeeper
    ArrayList<String> list;     // updated version for CodeKeeper2
    String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };
    
    public CodeKeeper2(String[] userCodes) {
        list = new ArrayList();
        
        for (int i = 0; i < codes.length; i++) {
            addCode(codes[i]);                          
        }
        
        for (int j = 0; j < userCodes.length; j++) {
            addCode(userCodes[j]);
        }
        
        for (String code : list) {
            System.out.println(code);
        }
        
    }
    
    private void addCode(String code) {
        if (!list.contains(code)) {
            list.add(code);
        }
    }
    
    public static void main(String[] arguments) {
        CodeKeeper2 keeperCallItAnything = new CodeKeeper2(arguments);
    }
}
