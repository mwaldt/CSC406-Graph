/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 2: Undirected Graphs
* Assigned: 2/15/16
* Due: 3/3/16
**/
package graph;

import graph.*;

import java.util.*;

public abstract class UndirectedList extends UndirectedGraph{

	LinkedList<Edge>[] adjacencyList;

	// Sets up the Matrix
	void setUpDataType(){
		adjacencyList = new LinkedList[vertexCount];
		for(int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}

	// Returns True if and edge exists, else false
	boolean existsEdge(Edge e){
		/*
		if(adjacencyList[e.getSource()].contains(e)){
			System.out.println("EDGE EXISTS AS E IN LIST[e.src]");
		}else if(adjacencyList[e.getDestination()].contains(e.flip())){
			System.out.println("EDGE EXISTS AS E IN LIST[e.dest]");
		}/**/
		return 
		adjacencyList[e.getSource()].contains(e);
		// ||adjacencyList[e.getDestination()].contains(e.flip());
	}

	// Create edge for List
	void createEdge(Edge e){
		adjacencyList[e.getSource()].add(e);
		adjacencyList[e.getDestination()].add(e.flip());
	}

	// Remove edge for List
	void clearEdge(Edge e){
		adjacencyList[e.getSource()].remove(e);
		adjacencyList[e.getDestination()].remove(e.flip());
	}

	// Produces an array of verticies adjacent to input vertex i
	ArrayList<Integer> adjacentVerticies(int i){
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		ListIterator<Edge> iterator = adjacencyList[i].listIterator();
		while(iterator.hasNext()){
			adjacentVerts.add(iterator.next().getDestination());
		}
		return adjacentVerts;
	}

	@Override
	public String toString(){
		String out = "String representation for Directed List\r\n";
		ListIterator<Edge> iterator;
		for(int i = 0; i < adjacencyList.length; i++){
			iterator = adjacencyList[i].listIterator();
			out += "Vertex " + (i) +": ";
			while(iterator.hasNext()){
				out +=	iterator.next().getDestination() +" ";
			}
			out += "\r\n";
		}
		return out;
	}
	
}
