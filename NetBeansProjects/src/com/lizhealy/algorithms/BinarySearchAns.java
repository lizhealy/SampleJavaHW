/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lizhealy.algorithms;
import java.util.*;
/**
 *
 * @author lizhealy
 */
public class BinarySearchAns {

    /*
       Constants and instance variables.
       To simplify this code, used simply for testing, some data are 
          static, so they can be used from static methods.
    */
    private static final int SIZE = 1000000; 
    private static int KEY_NOT_FOUND = -1;

    /* 
    The safe way to compute the midpoint - see Bloch, Joshua (June 2, 2006) 
    [Updated 17 Feb 2008]. "Extra, Extra – Read All About It: Nearly 
    All Binary Searches and Mergesorts are Broken". Google Research Blog.
    */
    private static int midpoint(int first, int last)
    {
        return first + ((last - first) / 2);

    }

    /* 
        A straightforward implementation of binary search is recursive. 
        The initial call uses the indices of the entire array to be 
        searched. The procedure then calculates an index midway between 
        the two indices, determines which of the two subarrays to search, 
        and then does a recursive call to search that subarray. Each of the 
        calls is tail recursive, so a compiler need not make a new stack 
        frame for each call. The variables imin and imax are the lowest 
        and highest inclusive indices that are searched.
    */
    // Precondition: 0 <= imin  
    public static int binary_search_rec(int A[], int key, int imin, int imax)
    {
      // test if array is empty
      if (imax < imin)
        // set is empty, so return value showing not found
        return KEY_NOT_FOUND;
      else
        {
          // calculate midpoint to cut set in half
          int imid = midpoint(imin, imax);

          // three-way comparison
          if (A[imid] > key)
            // key is in lower subset
            return binary_search_rec(A, key, imin, imid - 1);
          else if (A[imid] < key)
            // key is in upper subset
            return binary_search_rec(A, key, imid + 1, imax);
          else
            // key has been found
            return imid;
        }
    }

    /* 
       The binary search algorithm can also be expressed iteratively with two 
       index limits that progressively narrow the search range.
    */
    // Precondition: 0 <= imin 
    public static int binary_search_itr1(int A[], int key, int imin, int imax)
    {
      // continue searching while [imin,imax] is not empty
      while (imax >= imin)
        {
          // calculate the midpoint for roughly equal partition
          int imid = midpoint(imin, imax);
          if(A[imid] == key)
            // key found at index imid
            return imid; 
          // determine which subarray to search
          else if (A[imid] < key)
            // change min index to search upper subarray
            imin = imid + 1;
          else         
            // change max index to search lower subarray
            imax = imid - 1;
        }
      // key was not found
      return KEY_NOT_FOUND;
    }


    /*
       Deferred detection of equality
       The above iterative and recursive versions take three paths 
       based on the key comparison: one path for less than, one path 
       for greater than, and one path for equality. (There are two 
       conditional branches.) 
       The path for equality is taken only when the record is finally 
       matched, so it is rarely taken. That branch path can be moved 
       outside the search loop in the deferred test for equality version 
       of the algorithm. The following algorithm uses only one conditional 
       branch per iteration.
    */
    // Precondition: 0 <= imin 
    public static int binary_search_itr2(int A[], int key, int imin, int imax)
    {
      // continually narrow search until just one element remains
      while (imin < imax)
        {
          int imid = midpoint(imin, imax);

          // code must guarantee the interval is reduced at each iteration
          assert(imid < imax);
          // note: 0 <= imin < imax implies imid will always be less than imax

          // reduce the search
          if (A[imid] < key)
            imin = imid + 1;
          else
            imax = imid;
        }
      // At exit of while:
      //   if A[] is empty, then imax < imin
      //   otherwise imax == imin

      // deferred test for equality
      if ((imax == imin) && (A[imin] == key))
        return imin;
      else
        return KEY_NOT_FOUND;
    }


   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      /* 
        Create and initialize array of values that will be used
        to verify search algorithms
        */
      int[] arrayToTest = new int[SIZE];
      for (int i = 0; i < SIZE; i++){  // it doesn't matter what the contents are
          arrayToTest[i] = i*2;         // as long as the values are ordered / sorted
      //    System.out.println("a["+i+"]="+arrayToTest[i]);
      }

     /**
      * To compute the average, we search for every value, accumulating counts
      * and take the average of those counts.
      */
     /* Test recursive version */
      System.out.println("Testing recursive binary search:");
      for (int i = -5000; i < SIZE+100000; i=i+25000){
          System.out.println("\tFound "+i+" at " + binary_search_rec(arrayToTest, i, 0, SIZE-1));
      }
      System.out.println("\tFound "+ 2 +" at " + binary_search_rec(arrayToTest, 2, 0, SIZE-1));
      System.out.println("\tFound "+ 23 +" at " + binary_search_rec(arrayToTest, 23, 0, SIZE-1));

   /* Test first iterative version */
      System.out.println("Testing recursive binary search:");
      for (int i = -5000; i < SIZE+100000; i=i+25000){
          System.out.println("\tFound "+i+" at " + binary_search_itr1(arrayToTest, i, 0, SIZE-1));
      }
      System.out.println("\tFound "+ 2 +" at " + binary_search_rec(arrayToTest, 2, 0, SIZE-1));
      System.out.println("\tFound "+ 23 +" at " + binary_search_rec(arrayToTest, 23, 0, SIZE-1));

   /* Test second iterative version */
      System.out.println("Testing recursive binary search:");
      for (int i = -5000; i < SIZE+100000; i=i+25000){
          System.out.println("\tFound "+i+" at " + binary_search_itr2(arrayToTest, i, 0, SIZE-1));
      } 
      System.out.println("\tFound "+ 2 +" at " + binary_search_rec(arrayToTest, 2, 0, SIZE-1));
      System.out.println("\tFound "+ 23 +" at " + binary_search_rec(arrayToTest, 23, 0, SIZE-1));
      
    } // end main method

} // end class BinarySearch
