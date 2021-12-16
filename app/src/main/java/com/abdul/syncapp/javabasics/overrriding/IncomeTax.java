package com.abdul.syncapp.javabasics.overrriding;

import com.abdul.syncapp.javabasics.designpatterns.GFG;

public class IncomeTax {

    public int calculateTax(int income){
        GFG myGfg =  GFG.getInstance();
        return income/10;
    }
}
