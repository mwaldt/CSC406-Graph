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
		adjacentVerts = new int[vertexCount];
		for(int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new LinkedList<Edge>();
		}
	}

	// Returns True if and edge exists, else false
	boolean existsEdge(Edge e){
		if(rangeCheck(e.getSource()) && rangeCheck(e.getDestination())){
			return 
			adjacencyList[e.getSource()].contains(e) || adjacencyList[e.getDestination()].contains(e.flip());
		}else{
			System.out.println("Edge contains a value that is out of bounds of the graph, must be between 0 and " + vertexCount);
			return false;
		}
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
		if(rangeCheck(i)){
			ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
			for(int j = 0; j < i; j++){
				if(adjacencyList[j].contains(new Edge(j, i))){
					adjacentVerts.add(j);
				}
			}
			ListIterator<Edge> iterator = adjacencyList[i].listIterator();
			while(iterator.hasNext()){
				adjacentVerts.add(iterator.next().getDestination());
			}
			return adjacentVerts;
		}else{
			System.out.println("The number provided is outside of the range of vertices in the graph");
			return new ArrayList<Integer>();
		}

	}

	@Override
	public String toString(){
		String out = "String representation for Directed List\r\n";
		ListIterator<Edge> iterator;
		for(int i = 0; i < adjacencyList.length; i++){
			iterator = adjacencyList[i].listIterator();
			out += "Vertex " + (i) +": ";
			for(int j = 0; j < i; j++){
				if(adjacencyList[j].contains(new Edge(j, i))){
					out += "" + j + " "; 
				}
			}
			while(iterator.hasNext()){
				out +=	iterator.next().getDestination() +" ";
			}
			out += "\r\n";
		}
		return out;
	}
	
}
