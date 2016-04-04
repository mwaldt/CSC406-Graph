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
		if(e.getSource() < e.getDestination()){
			return (adjacencyMatrix[e.getSource()][e.getDestination()] != 0);
		}else{
			return (adjacencyMatrix[e.getDestination()][e.getSource()] != 0);
		}
		
	}

	// Create edge for Matrix
	void createEdge(Edge e){
		adjacencyMatrix[e.getSource()][e.getDestination()] = e.getWeight();
	}

	// Remove edge for Matrix
	void clearEdge(Edge e){
		adjacencyMatrix[e.getSource()][e.getDestination()] = 0;
	}

	// Produces an ArrayList of verticies adjacent to input vertex i
	ArrayList<Integer> adjacentVerticies(int i){
		if(rangeCheck(i)){
			ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
			for(int j = 0; j < i; j++){
				if(adjacencyMatrix[j][i] != 0){
					adjacentVerts.add(j);
				}
			}
			for(int j = i; j < adjacencyMatrix[i].length; j++){
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

	// Produces an ArrayList of edges starting from input vertex i
	ArrayList<Edge> getEdges(int i){
		ArrayList<Edge> adjEdges = new ArrayList<Edge>();
		for(int j = 0; j < adjacencyMatrix.length; j++){
			if(adjacencyMatrix[i][j] > 0){
				adjEdges.add(new Edge(i, j, adjacencyMatrix[i][j]));
			}
		}
		return adjEdges;
	}

	// Produces an ArrayList of edges starting from input vertex i
	ArrayList<Edge> getAllEdges(){
		ArrayList<Edge> adjEdges = new ArrayList<Edge>();
		for(int j = 0; j < adjacencyMatrix.length; j++){
			adjEdges.addAll(getEdges(j));
		}
		return adjEdges;
	}

	//Returns Directed Matrix as a String
	@Override
	public String toString(){
		String out = "String representation for Directed Materix\r\n";
		for(int i = 0; i < adjacencyMatrix.length; i++){	
			for(int j = 0; j < i; j++){
				out += adjacencyMatrix[j][i] + "  ";
			}
			for(int j = i; j < adjacencyMatrix[i].length; j++){
				out += adjacencyMatrix[i][j] + "  ";
			}
			out += "\r\n";
		}
		return out;
	}
}