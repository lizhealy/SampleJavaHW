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
public class ArrayProcessing {
    
    public static int maxElement(int[] a, int first, int last) {
        if (first == last)
            return a[first];
        else
            return Math.max(a[last], maxElement(a, first, last - 1));
            
    }
    
    public static int minElement(int[] a, int first, int last) {
        if (first == last)
            return a[first];
        else
            return Math.min(a[first], maxElement(a, first, last - 1));
            
    }
    
    public static int sumOfArray(int[] a, int index) {
        if (index == a.length)
            return 0;
        else
            return a[index] + sumOfArray(a, index + 1);
    }
    
    public static int productOfArray(int[] a, int index) {
        if (index == a.length)
            return 1;
        else
            return a[index] * productOfArray(a, index + 1);
            
    }
    
    public static int averageOfArray(int[] a, int index) {
        int arraySum;
        if (index == 1) {
            arraySum = a[0];
            return arraySum;
        }
        else {
            return (a[index] + sumOfArray(a, index + 1))/a.length;
        }
    }
    
    

   
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        
        System.out.println("The max element in a is: " + maxElement(a, 0, a.length-1) );
        System.out.println("The min element in a is: " + minElement(a, 0, a.length-1) );
        System.out.println("The sum of the elements in a is: " + sumOfArray(a, 0) );
        System.out.println("The product of the elements in a is: " + productOfArray(a, 0) );
        System.out.println("The average of the elements in a is: " + averageOfArray(a, 0) );
    }
    
}
