/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230;

import java.util.*;

/**
 *
 * @author lizhealy
 */
public class Balancer {
    private static final char leftParen    = '(';
    private static final char rightParen    = ')';

    public static boolean isItBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if      (s.charAt(i) == leftParen)   stack.push(leftParen);

            else if (s.charAt(i) == rightParen) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != leftParen) return false;
            }

        }
        return stack.isEmpty();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(isItBalanced("5"));
        System.out.println(isItBalanced("(4)"));
        System.out.println(isItBalanced("(4+2)"));
        System.out.println(isItBalanced("4+((3+5)"));
        System.out.println(isItBalanced("(2+3"));
        
        
    }
    
}
