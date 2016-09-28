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
public class BinarySearchResearch {
    
    public int binarySearch(int[] a, int x) {
      int low = 0;
      int high = a.length - 1;
      while (low <= high) {
         int mid = (low + high)/2;
         if (a[mid] == x) return mid;
         else if (a[mid] < x) low = mid + 1;
         else high = mid - 1;
      }
      return -1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearch bin = new BinarySearch();

      int[] a =
        { 2, 8,12,14,16,19,24,28,31,33,// 0-9
         39,40,45,49,51,53,54,56,57,60,// 10-19
         63,69,77,82,88,89,94,96,97};  // 20-28
      for (int i = 0; i < a.length; i++)
      //   System.out.print(binarySearch(a,
        //    a[i]) + " ");   
      System.out.println(); 
        // TODO code application logic here
    }
    
}
