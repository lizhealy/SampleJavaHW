

package com.lizhealy.algorithms;
import csci230.hw8.MinMax.*;
/**
 * @author Liz Healy
 * 
 * Implementation of Weiss 7.40, shell provided to students
 * 

 */
public class HW8 {

   
    /**
     * findMinAndMax returns an object containing both values
     * This is the public method - it calls a private recursive method
     * @param a an array of Comparable values
     * @return findMinAndMax returns an object containing both values
     */   
    public static <AnyType extends Comparable<? super AnyType>>
        MinMax findMinAndMax(AnyType [] a)
        {
            return findMinAndMax(a, 0, a.length-1);
        }
    
    /**
     * findMinAndMax algorithm to find both the minimum and maximum of an 
     *   array, using "divide-and-conquer" algorithm described in Weiss problem 7.40. 
     * This is a private recursive algorithm
     * @param <AnyType> works on any Comparable type
     * @param a array of values from which minimum and maximum are to be found
     * @param left  index of left-most value in current "array" being processed
     * @param right index of right-most value in current "array" being processed
     * @return mmvalue (MinMaxValue) a MinMax object containing the minimum and maximum values in a
     */
    private static <AnyType extends Comparable<? super AnyType>>
        MinMax findMinAndMax(AnyType [] a, int left, int right)   {
            MinMax mmvalue = new MinMax();
            MinMax left2 = new MinMax();
            MinMax right2 = new MinMax();
            if(a.length == 0)
                return null;
            if(left == right) {
                mmvalue.maximum = a[left];
                mmvalue.minimum = a[left];
                return mmvalue;
            }
            if(right == left + 1){
                if(a[left].compareTo(a[right]) > 0) {
                    mmvalue.maximum = a[left];
                    mmvalue.minimum = a[right];
                }
                else{
                    mmvalue.maximum = a[right];
                    mmvalue.minimum = a[left];
                }
                return mmvalue;
                
            }
            int center = (left+right)/2;
            left2 = findMinAndMax(a, left, center);
            right2 = findMinAndMax(a, center + 1, right);
            
            if (left2.minimum.compareTo(right2.minimum) < 0)
                mmvalue.minimum = left2.minimum;
            else
                mmvalue.minimum = right2.minimum;
            if (left2.maximum.compareTo(right2.maximum) > 0)
                mmvalue.maximum = left2.maximum;
            else
                mmvalue.maximum = right2.maximum;
            return mmvalue;

                
    }
    
    
    /**
     * Test program provided for you 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] sizesToTry = {0, 1, 2, 3, 7, 16, 32, 40};
        for (int i = 0; i < sizesToTry.length; i++){
            Integer[] arrayToTest = new Integer[sizesToTry[i]];
            System.out.println("Testing array of size: "+ sizesToTry[i]);
            for (int index = 0; index < arrayToTest.length; index++){
                // put some random numbers in the array and print out
                arrayToTest[index] = (int)(Math.random()*100+1);
                System.out.println("element ["+index+"]="+arrayToTest[index]);
            }
            System.out.println("Results: "+ findMinAndMax(arrayToTest));   
            System.out.println("-------\n");
        }

    }

}
