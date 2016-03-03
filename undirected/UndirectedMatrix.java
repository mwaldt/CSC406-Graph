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

/*
Potential improvement if time is available:
Implement the matrix so only the top half is used.
Adjacent Verts will get odd, needs to check all values before itself
for matches and then after itself.
/**/
public abstract class UndirectedMatrix extends UndirectedGraph{

	int[][] adjacencyMatrix;

	// Sets up the Matrix
	void setUpDataType(){
		adjacentVerts = new int[vertexCount];
		adjacencyMatrix = new int[vertexCount][vertexCount];
	}

	// Returns True if and edge exists, else false
	boolean existsEdge(Edge e){
		return (adjacencyMatrix[e.getSource()][e.getDestination()] != 0);
	}

	// Create edge for Matrix
	void createEdge(Edge e){
		adjacencyMatrix[e.getSource()][e.getDestination()] = e.getWeight();
		adjacencyMatrix[e.getDestination()][e.getSource()] = e.getWeight();
	}

	// Remove edge for Matrix
	void clearEdge(Edge e){
		adjacencyMatrix[e.getSource()][e.getDestination()] = 0;
		adjacencyMatrix[e.getDestination()][e.getSource()] = 0;
	}

	// Produces an ArrayList of verticies adjacent to input vertex i
	ArrayList<Integer> adjacentVerticies(int i){
		if(rangeCheck(i)){
			ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
			for(int j = 0; j < adjacencyMatrix[i].length; j++){
				if(adjacencyMatrix[i][j] != 0){
					adjacentVerts.add(j);
				}
			}
			return adjacentVerts;
		}else{
			System.out.println("Vertice value provided outside of the bounds of the graph, must be between 0 and " + vertexCount);
			return new ArrayList<Integer>();
		}
	}

	//Returns Directed Matrix as a String
	@Override
	public String toString(){
		String out = "String representation for Directed Materix\r\n";
		for(int i = 0; i < adjacencyMatrix.length; i++){
			for(int j = 0; j < adjacencyMatrix[i].length; j++){
				out += adjacencyMatrix[i][j] + "  ";
			}
			out += "\r\n";
		}
		return out;
	}
}