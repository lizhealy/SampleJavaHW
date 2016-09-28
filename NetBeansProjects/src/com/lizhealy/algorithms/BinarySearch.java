/*
 * This algorithm searches through an array using recursion, iteration,
 * and deferred detection of equality. The array size is set to 1,000,000
 * but multiple array sizes were tested including 1, 100,000, 500,000, 
 * 1,000,000, 2,000,000, and 3,000,000. The main method is setup with the 
 * iterative method. Each method was tested separately to determine the
 * correct CPU Time.
 */
package com.lizhealy.algorithms;
import java.util.*;

/**
 * Version 1.0
 * @author shell by Wikipedia updated by Liz Healy
 */
public class BinarySearch {
    private static int KEY_NOT_FOUND = -1;
    private static final int SIZE = 1000000; 
    
    public static int recursive(int A[], int key, int imin, int imax) {
        
            
    // test if array is empty
        if (imax < imin)
    // set is empty, so return value showing not found
            return KEY_NOT_FOUND;
        else {
        // calculate midpoint to cut set in half
            int imid = (imax+imin)/2;
      
        // three-way comparison
            if (A[imid] > key)
        // key is in lower subset
                return recursive(A, key, imin, imid - 1);
            else if (A[imid] < key)
        // key is in upper subset
                return recursive(A, key, imid + 1, imax);
            else
        // key has been found
                return imid;
        }
    }
    
    public static int iterative(int A[], int key, int imin, int imax){
    // continue searching while [imin,imax] is not empty
        while (imax >= imin) {
      // calculate the midpoint for roughly equal partition
            int imid = (imax+imin)/2;
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
    
    // inclusive indices
//   0 <= imin when using truncate toward zero divide
//     imid = (imin+imax)/2;
//   imin unrestricted when using truncate toward minus infinity divide
//     imid = (imin+imax)>>1; or
//     imid = (int)floor((imin+imax)/2.0);
public static int deferred(int A[], int key, int imin, int imax) {
  // continually narrow search until just one element remains
    while (imin < imax) {
        int imid = (imax+imin)/2;

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
        
        int[] arrayToTest = new int[SIZE];
      for (int i = 0; i < SIZE; i++){  // it doesn't matter what the contents are
          arrayToTest[i] = i;         // as long as the values are ordered / sorted
          System.out.println("a["+i+"]="+iterative(arrayToTest, i, 0, SIZE-1)); //changed to deferred ,recursive and iterative
      }
      
    
    }
}
