package com.lizhealy.algorithms;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lizhealy
 */
public class RootsTest {
    public void solve() {
        double a = 1;
        double b = -3;
        double c = 5;
        double[] expectedResult = {-1,4}; 
        double[] result = Roots.Roots(a, b, c);
        
        System.out.println("The expected result is: " + expectedResult);
        System.out.println("Your result is" + result);

    }
    public void solve2() {
        double a = 1.0;
        double b = -4.0;
        double c = 4.0;
        double[] expectedResult = {2.0,2.0}; 
        double[] result = Roots.Roots(a, b, c);
        
        System.out.println("The expected result is: " + expectedResult);
        System.out.println("Your result is" + result);

    }
    public void solve3() {
        double a = 1.0;
        double b = -4.0;
        double c = -12.0;
        double[] expectedResult = {6.0,-2.0}; 
        double[] result = Roots.Roots(a, b, c);
        
        System.out.println("The expected result is: " + expectedResult);
        System.out.println("Your result is" + result);

    }
    public void solve4() {
        double a = 1;
        double b = -6;
        double c = 25;
        double[] result = Roots.Roots(a, b, c);
        
        System.out.println("The expected result is: No real solution");
        System.out.println("Your result is" + result);

    }
    public void solve5() {
        double a = 0;
        double b = 2;
        double c = 4;
        double[] result = Roots.Roots(a, b, c);
        
        System.out.println("The expected result is: No real solution");
        System.out.println("Your result is" + result);

    }
}