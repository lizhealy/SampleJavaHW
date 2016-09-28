package com.lizhealy.algorithms;


import java.util.Stack;
import sun.security.provider.certpath.Vertex;

public class TopologicalStack {
	
	Stack stk;
	Vertex [] stkArray;
	int c;
		
	public TopologicalStack() {
		stk =new Stack();
		c=1;
	}
	
	
	void dfs(Vertex v) {
		System.out.println("Visiting "+v.getIndex());
		//mark v visited
		v.setVisted();
		//get the number of OUT(V)
		int numouts=v.getOutsNum();

		//copies v.getOuts(i), the out vertices of v, to a temporary array outs[i]
		Vertex [] outs= new Vertex[numouts+1];
		for (int i=1;i<=numouts;i++) outs[i]=v.getOuts(i);

		//for each w in OUT(v) do
		for (int i=1;i<=numouts;i++) {
			Vertex w=outs[i];
			System.out.println(v.getName()+" now looks at "+w.getName());

			//if w is unvisited then dfs(w)
			if(!w.isVisited()) {
				dfs(w);
			}
		}
		//push(v) into STACK
		stk.push(v); System.out.println("STACK: "+v.getName()+" pushed");
	
	}
	
	