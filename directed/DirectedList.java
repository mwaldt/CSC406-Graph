/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/
package graph;

import graph.*;
import java.util.*;

public abstract class DirectedList extends DirectedGraph{

	ArrayList<Edge>[] adjacencyList;

	// Sets up the Matrix
	void setUpDataType(){
		adjacencyList = new ArrayList[vertexCount];
		inDegree = new int[vertexCount];
		outDegree = new int[vertexCount];
		for(int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new ArrayList<Edge>();
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

	//Returns Edges associated with index i
	ArrayList<Edge> getEdges(int i){
		return adjacencyList[i];
	}

	//Returns Edges associated with index i
	ArrayList<Edge> getAllEdges(){
		ArrayList<Edge> adjEdges = new ArrayList<Edge>();
		for(int j = 0; j < adjacencyList.length; j++){
			adjEdges.addAll(getEdges(j));
		}
		return adjEdges;
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
