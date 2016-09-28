package com.lizhealy.algorithms;

import java.util.*;
import csci230.DoublyLinkedQueue.*;





public class TopologicalQueue {
    private Queue<Integer> order;     // vertices in topological order
    private int[] rank;               // rank[v] = order where vertex v appers in order
    private int V;                    // number of vertices

    public TopologicalQueue(Digraph G) {
        V = G.V;
        // compute indegrees
        int[] indegree = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                indegree[w]++;
            }
        }

        // initialize 
        rank = new int[G.V()]; 
        order = new Queue<Integer>() {};
        int count = 0;

        // initialize queue to contain all vertices with indegree = 0
        Queue<Integer> queue = new Queue<Integer>();
        for (int v = 0; v < G.V; v++)
            if (indegree[v] == 0) queue.enqueue(v);

        for (int j = 0; !queue.isEmpty(); j++) {
            int v = queue.dequeue();
            order.enqueue(v);
            rank[v] = count++;
            for (int w : G.adj(v)) {
                indegree[w]--;
                if (indegree[w] == 0) queue.enqueue(w);
            }
        }

        if (count != G.V) {
            order = null;
        }

        assert check(G);
    }

    // the vertices in topological order; null if G is not a DAG
    public Iterable<Integer> order() {
        return order;
    }

    // does G have a topological order? (is G a DAG?)
    public boolean hasOrder() {
        return order != null;
    }

    // the rank of vertex v in topological order; -1 if G is not a DAG
    public int rank(int v) {
        validateVertex(v);
        if (hasOrder()) return rank[v];
        else            return -1;
    }

    // certify that digraph is acyclic
    private boolean check(Digraph G) {

        // digraph is acyclic
        if (hasOrder()) {
            // check that ranks are a permutation of 0 to V-1
            boolean[] found = new boolean[G.V()];
            for (int i = 0; i < G.V; i++) {
                found[rank(i)] = true;
            }
            for (int i = 0; i < G.V; i++) {
                if (!found[i]) {
                    System.err.println("No vertex with rank " + i);
                    return false;
                }
            }

            // check that ranks provide a valid topological order
            for (int v = 0; v < G.V; v++) {
                for (int w : G.adj(v)) {
                    if (rank(v) > rank(w)) {
                        System.err.printf("%d-%d: rank(%d) = %d, rank(%d) = %d\n",
                                          v, w, v, rank(v), w, rank(w));
                        return false;
                    }
                }
            }

            // check that order() is consistent with rank()
            int r = 0;
            for (int v : order()) {
                if (rank(v) != r) {
                    System.err.println("order() and rank() inconsistent");
                    return false;
                }
                r++;
            }
        }


        return true;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public static void main(String[] args) {

        // create random DAG with V vertices and E edges; then add F random edges
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        int F = Integer.parseInt(args[2]);
        Digraph G = new Digraph(V);
        int[] vertices = new int[V];
        for (int i = 0; i < V; i++)
            vertices[i] = i;
        StdRandom.shuffle(vertices);
        for (int i = 0; i < E; i++) {
            int v, w;
            do {
                v = StdRandom.uniform(V);
                w = StdRandom.uniform(V);
            } while (v >= w);
            G.addEdge(vertices[v], vertices[w]);
        }

        // add F extra edges
        for (int i = 0; i < F; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            G.addEdge(v, w);
        }

        StdOut.println(G);

        // find a directed cycle
        TopologicalQueue topological = new TopologicalQueue(G);
        if (!topological.hasOrder()) {
            StdOut.println("Not a DAG");
        }

        // or give topologial sort
        else {
            StdOut.print("Topological order: ");
            for (int v : topological.order()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }

}

