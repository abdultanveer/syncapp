package com.abdul.syncapp.javabasics.overrriding;
public class Gst extends IncomeTax{

    @Override
    public int calculateTax(int income) {
        int oldTax = super.calculateTax(income);
        int gst = 0;
        if(income > 20){
            gst = 3;
        }
        return  oldTax + gst;
    }
}
