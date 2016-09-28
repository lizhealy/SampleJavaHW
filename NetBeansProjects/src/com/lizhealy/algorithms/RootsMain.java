/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lizhealy.algorithms;

/**
 *
 * @author lizhealy
 */
public class RootsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a = 1;
        double b = -3;
        double c = 5;
        double[] expectedResult = {-1,4}; 
        double[] result = Roots(a, b, c);
        
        System.out.println("The expected result is: " + expectedResult);
        System.out.println("Your result is" + result);
    }
    
}
