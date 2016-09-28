/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roots;
import edu.cofc.Roots;
import static org.junit.Assert.*;

import org.junit.*;


/**
 *
 * @author lizhealy
 */
public class Testclass {
    @Test
    public void test1() {
            int a = 2;
            int b = 30;
            int c = 5;
            Roots r = new Roots(a,b,c);
            assertEquals(r.num_roots(), 2);
    }
    @Test
    public void test2() {
            int a = 1;
            int b = -4;
            int c = 4;
            Roots r = new Roots(a,b,c);
            assertEquals(r.num_roots(), 2);
    }
    
    @Test
    public void test3() {
            int a = 1;
            int b = -4;
            int c = -12;
            Roots r = new Roots(a,b,c);
            assertEquals(r.num_roots(), 2);
    }
    
    @Test
    public void test4() {
            int a = 0;
            int b = 0;
            int c = 25;
            Roots r = new Roots(a,b,c);
            assertEquals(r.num_roots(), 2);
    }
    
    @Test
    public void test5() {
            int a = 0;
            int b = 2;
            int c = 4;
            Roots r = new Roots(a,b,c);
            assertEquals(r.num_roots(), 2);
    }

    
    @Test
    public void test7() {
            int a = 1;
            int b = -3;
            int c = 5;
            Roots r = new Roots(a,b,c);
            assertEquals(r.num_roots(), 2);
    }
    
    @Test
	public void test8() {
		int a = 2;
		int b = 3;
		int c = 5;
                double q;
		
		Roots r = new Roots(a,b,c);
		assertEquals(r.num_roots(), 0);
		assertEquals(r.first_root(), -1, q);
		assertEquals(r.second_root(), -1, q);

	}
}
