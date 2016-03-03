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

import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;

public abstract class UndirectedGraph extends Graph{
	
	int[] adjacentVerts;

	// Handles incrementing of edge count,
	// Specific implementation based on type of graph
	void insertEdge(Edge e){
		incrementDegrees(e);
		if(e.getSource() < e.getDestination()){
			createEdge(e);
		}else{
			createEdge(e.flip());
		}
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	abstract void createEdge(Edge e);

	// Handles decrementing of edge count,
	// Specific implementation based on type of graph
	void deleteEdge(Edge e){
		decrementDegrees(e);
		if(e.getSource() < e.getDestination()){
			clearEdge(e);
		}else{
			clearEdge(e.flip());
		}
	}

	// Create edge for Matrix/list
	// Specific implementation based on type of graph
	abstract void clearEdge(Edge e);
	
	// Increase adjaceny count based on input edge src and dest
	void incrementDegrees(Edge e){
		adjacentVerts[e.getDestination()]++;
		adjacentVerts[e.getSource()]++;
	}
	
	// Decrease adjaceny count  based on input edge src and dest
	void decrementDegrees(Edge e){
		adjacentVerts[e.getDestination()]--;
		adjacentVerts[e.getSource()]--;
	}

	//Returns the number of verticies that are adjacent to a verticy 
	int adjacentVertsCount(int i){
		return adjacentVerts[i];
	}
}
