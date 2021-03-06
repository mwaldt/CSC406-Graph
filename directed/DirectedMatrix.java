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

public abstract class DirectedMatrix extends DirectedGraph{

	int[][] adjacencyMatrix;

	// Sets up the Matrix
	void setUpDataType(){
		adjacencyMatrix = new int[vertexCount][vertexCount];
		inDegree = new int[vertexCount];
		outDegree = new int[vertexCount];
	}

	// Returns True if and edge exists, else false
	boolean existsEdge(Edge e){
		return !(adjacencyMatrix[e.getSource()][e.getDestination()] == 0);
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
		ArrayList<Integer> adjacentVerts = new ArrayList<Integer>();
		for(int j = 0; j < adjacencyMatrix[i].length; j++){
			if(adjacencyMatrix[i][j] != 0){
				adjacentVerts.add(j);
			}
		}
		return adjacentVerts;
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
			for(int j = 0; j < adjacencyMatrix[i].length; j++){
				out += adjacencyMatrix[i][j] + "  ";
			}
			out += "\r\n";
		}
		return out;
	}
}
