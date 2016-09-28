/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lizhealy.algorithms;

import java.util.*;
import javax.sound.midi.*;

/**
 *
 * @author lizhealy
 */
public class Digraph {
    int V;
    private Sequence<Integer>[] adj;
    
    public Digraph(int V) {
        this.V = V;
        adj = (Sequence<Integer>[]) new Sequence[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Sequence<Integer>();
    }
    
    public void insert(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}