package com.lizhealy.algorithms;
import java.util.*;
/*
 * This program uses topological sort on a Directed Acyclic Graph.
 * The topological sorts: 1 - Regular, 2 - Queue, 3 - Stack
 */

/**
 *
 * @author mccauleyr modified and updated by lizhealy
 */
public class DirectedGraph {
    private static class Node
    {
        // Constructor
        Node(int theIndegree, int [] list)
        {
            indegree = theIndegree;  
            adjNodes = list;
        }
        int       indegree;     // how many nodes point to this node
        int []    adjNodes;     // array of nodes this node adjacent/points to    
    }
    
    public static int SIZE;     // Maximum number of nodes that can be in a graph
    /** The graph is an adjacency list of nodes*/
    private ArrayList<Node> adjList;  // adjacency list representation used
    private int currentNumberOfNodes; // Actual number of nodes stored so far
    
    
    public DirectedGraph(int size){
        SIZE = size;
        adjList = new ArrayList<>(SIZE);  
        currentNumberOfNodes = 0;      
    }
    
    /**
     * Will always add new node in next available position
     * @param inDegree
     * @param adjacentNodes 
     */
    public void addNodetoGraph(int inDegree, int[] adjacentNodes){
        adjList.add(new Node(inDegree, adjacentNodes));
        currentNumberOfNodes++;
        
    }
    
    /**
     * Display graph in table form
     */
    public void display(){
        System.out.println("The graph contains "+ currentNumberOfNodes + " nodes:");
        System.out.println("Node\tIndegree\tAdjacent to these");
        for (int i = 0; i < currentNumberOfNodes; i++){    
            System.out.print(i+1 +"\t" + adjList.get(i).indegree +"\t\t");
            for (int j = 0; j < adjList.get(i).adjNodes.length; j++)
                System.out.print(adjList.get(i).adjNodes[j] + ((adjList.get(i).adjNodes.length-1==j)?" ":", "));
            System.out.println();
        }  
    }
    
    /**
     *Original Topological Sort
     */
    public void topologicalSort1(){

        ArrayList<Node> L = new ArrayList<Node>(); //Empty list that will contain sorted elements
        HashSet<Node> S = new HashSet<Node>(); //Set of all nodes with indegree = 0
        for(Node n: adjList){
            if(n.indegree == 0)
                S.add(n);
        }
        
        while(!S.isEmpty()){
            Node n = S.iterator().next();
            S.remove(n);
            L.add(n);
            
        }
        System.out.println("Topological Sort: ");
        System.out.println(S);
        System.out.println(Arrays.toString(L.toArray()));
         
    }
    
    /**
     *Topological Sort with a Queue
     */
    public void topologicalSort2(){
        Queue q = new Queue(); //Create new Queue
        int count = 0;
        
        for(Node n:adjList){ //For each node in the adjacency list
            if(n.indegree == 0) //if the indegree = 0
                q.enqueue(n); //add it to the queue
        }
        while(!q.isEmpty()){ //while the queue is not empty
            Node n = (Node) q.dequeue(); 
            q.peek(); //return first node
            
            for(n.adjNodes:adjList){ //for each of the adjacent nodes in the adjlist
                if(--n.idegree == 0) 
                    q.enqueue(n); //add the node to the queue
            }
        }
        if(count != currentNumberOfNodes){
            System.out.print("Not acyclic.");
        }
        System.out.println("Topological Sort 2: " + q);
    
    }
    
    /**
     * Topological Sort with a Stack
     */
    public void topologicalSort3(){
        Stack s = new Stack(); //create new stack
        Node v; 
        boolean visited[] = null; //set visited to null
        s.push(v); //push node onto the stack
        while (!s.isEmpty()){ // while stack is not empty
            Node n = s.pop(); //get rid of the node on the top of the stack
            if(!visited[n]){ //if the node is already visited
                visited[n]=true; //set visited to true
                s.push(n); //and push the node onto the top of the stack
                for (Node v : adjList.get(n)) { 
                    if(!visited[v]){
                        s.push(v);
                    }
                }
            }
        }
        System.out.println("Topological Sort 3: " + s);
    }

    /**
    /**
     * Main Method
     */
    public static void main(String[] args) {
        
        DirectedGraph dg = new DirectedGraph(7);
        // Populate a graph, like that in figure 9.1
        int [] nodes1 = {2,3,4};
        dg.addNodetoGraph(0, nodes1 );
        int [] nodes2 = {4, 5};
        dg.addNodetoGraph(1, nodes2 );
        int [] nodes3 = {6};
        dg.addNodetoGraph(2, nodes3 );
        int [] nodes4 = {6, 7, 3};
        dg.addNodetoGraph(4, nodes4 );
        int [] nodes5 = {4, 7};
        dg.addNodetoGraph(1, nodes5 );
        int [] nodes6 = {};
        dg.addNodetoGraph(3, nodes6 );
        int [] nodes7 = {6};
        dg.addNodetoGraph(2, nodes7 );
        
        
        dg.display();
        
        
        dg.topologicalSort1();
        dg.topologicalSort2();
        dg.topologicalSort3();
    }
}
