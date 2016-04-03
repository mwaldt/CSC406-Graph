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

import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;

public abstract class DirectedGraph extends Graph{
	
	int[] inDegree;
	int[] outDegree;

	
	// Handles incrementing of edge count,
	// Specific implementation based on type of graph
	void insertEdge(Edge e){
		incrementDegrees(e);
		createEdge(e);
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	abstract void createEdge(Edge e);

	// Produces an array of edge starting from input vertex i
	// Implemented in sub classes
	abstract ArrayList<Edge> getEdges(int i);

	// Produces an array of edge starting from input vertex i
	// Implemented in sub classes
	abstract ArrayList<Edge> getAllEdges();


	// Handles decrementing of edge count,
	// Specific implementation based on type of graph
	void deleteEdge(Edge e){
		decrementDegrees(e);
		clearEdge(e);
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	abstract void clearEdge(Edge e);


	// Increase inDegree and outDegree based on input edge src and dest
	void incrementDegrees(Edge e){
		inDegree[e.getDestination()]++;
		outDegree[e.getSource()]++;
	}
	
	// Decrease inDegree and outDegree based on input edge src and dest
	void decrementDegrees(Edge e){
		inDegree[e.getDestination()]--;
		outDegree[e.getSource()]--;
	}

	//Returns the number of edges that enter a verticy 
	int inDegree(int i){
		return inDegree[i];
	}
	
	int outDegree(int i){
		return outDegree[i];
	}

	int[] inDegrees(){
		return inDegree;
	}
	
	int[] outDegrees(){
		return outDegree;
	}

}
