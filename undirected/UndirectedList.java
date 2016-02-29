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
		return adjacencyList[e.getSource()].contains(e);
	}

	// Create edge for List
	void createEdge(Edge e){
		adjacencyList[e.getSource()].add(e);
	}

	// Remove edge for List
	void clearEdge(Edge e){
		adjacencyList[e.getSource()].remove(e);
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
		String out = "String representation for Directed List\n";
		ListIterator<Edge> iterator;
		for(int i = 0; i < adjacencyList.length; i++){
			iterator = adjacencyList[i].listIterator();
			out += "Vertex " + (i) +": ";
			while(iterator.hasNext()){
				out +=	iterator.next().getDestination() +" ";
			}
			out += "\n";
		}
		return out;
	}
	
}
