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


    public KruskalMST(UndirectedGraph g){
        mst = new PriorityQueue<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for(Edge e: g.getAllEdges()){
            pq.add(e);
        }

        UnionFind uf = new UnionFind(g.numVertices());

        //System.out.println("Created uf");

        while(!pq.isEmpty() && mst.size() < g.numVertices() -1){
            Edge e = pq.poll();
            //System.out.println("Polled edge " + e.toString());
            if(!uf.connected(e.getSource(), e.getDestination())){
                //System.out.println(e.toString() + " not connected");
                //System.out.println("Node " + e.getSource() +": " + uf.parent(e.getSource()));
                //System.out.println("Node " + e.getDestination() +": " + uf.parent(e.getDestination()));
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

    boolean check(UndirectedGraph g){
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

    void printResults(){
        System.out.println("Minimal spanning tree: ");
        for(Edge e : mst){
            System.out.print(e.toString() + " ");
        }
        System.out.println("Total weight: " + weight);
        
    }
}
