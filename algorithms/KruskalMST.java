/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 3: Implementing Algorithms
* Assigned: 3/15/16
* Due: 4/7/16
**/
package graph;

import graph.*;
import java.util.*;

public class KruskalMST{
    
    double weight;
    PriorityQueue<Edge> mst;


    public KruskalMST(DirectedGraph g){
        mst = new PriorityQueue<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for(int i = 0; i < g.numVertices(); i++ ){
            for(Edge e: g.getEdges(i)){
                pq.add(e);
            }
        }

        UnionFind uf = new UnionFind(g.numVertices());
        while(!pq.isEmpty() && mst.size() < g.numVertices() -1){
            Edge e = pq.poll();
            if(!uf.connected(e.getSource(), e.getDestination())){
                uf.union(e.getSource(), e.getDestination());
                mst.add(e);
                weight +=e.getWeight();
            }
        }

        //Check if optimal
        assert check(g);
    }

    double getWeight(){
        return weight;
    }

    Iterable<Edge> edges(){
        return mst;
    }

    boolean check(DirectedGraph g){
        double total = 0.0;
        for(Edge e : edges()){
            total += e.getWeight();
        }

        //Check if cyclic
        UnionFind uf = new UnionFind(g.numVertices());
        for(Edge e : edges()){
            if(uf.connected(e.getSource(), e.getDestination())){
                System.err.println("Cycle detected");
                return false;
            }
        }

        //Check if spanning
        for(Edge e : edges()){
            if(!uf.connected(e.getSource(), e.getDestination())){
                System.err.println("Not spanning");
                return false;
            }
        }

        //Check if minimal
        for(Edge e : edges()){
            
            // All edges in MST except e
            uf = new UnionFind(g.numVertices());
            for(Edge f : mst){
                if(f != e){
                    uf.union(e.getSource(), e.getDestination());
                }
            }

            // Check that e is the min weight edge
            for(Edge f : g.getAllEdges()){
                if(!uf.connected(e.getSource(), e.getDestination())){
                    System.err.println("Edge " + f + " violates optimal conditions");
                    return false;
                }
            }
        }
        return true;
    }
}
