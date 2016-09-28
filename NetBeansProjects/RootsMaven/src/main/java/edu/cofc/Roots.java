package edu.cofc;

public class Roots {
	double root_one, root_two;
	int num_roots;
	public Roots(double a, double b, double c) {
		double q;
		double r;
		q = b*b - 4*a*c;
		if(q>0 && a != 0) {
			num_roots = 2;
			r = (double) Math.sqrt(q);
			root_one = ((0-b) + r)/(2*a);
			root_two = ((0-b) - r)/(2*a);
		} else if(q==0) {
			num_roots = 1;
			root_one = (0-b)/(2*a);
			root_two = root_one;
		} else {
			num_roots = 0;
			root_one = -1;
			root_two = -1;
		}
	}
	public int num_roots() { return num_roots; }
	public double first_root() { return root_one; }
	public double second_root() { return root_two; }
} 