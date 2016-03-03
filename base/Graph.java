/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/
package graph;

import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;

public abstract class Graph{


	int vertexCount;
	int edgeCount;

	// Returns number of vertices in graph
	int numVertices(){
		return vertexCount;
	}
	
	// Returns number of edges in graph
	int numEdges(){
		return edgeCount;
	}

	// Returns True if and edge exists, else false
	// Input edge class object
	abstract boolean existsEdge(Edge e);

	// Returns True if and edge exists, else false
	// Input ints source and destination
	boolean existsEdge(int src, int dest){
		return existsEdge(new Edge(src, dest));
	}

	// Adds an edge e to the graph if it doesn't already exist.
	// Input edge class object
	void putEdge(Edge e){
		if(rangeCheck(e.getSource()) && rangeCheck(e.getDestination())){
			if(existsEdge(e)){
				System.out.println("Edge " + e.toString() +" already exists, no duplicates.");
			}else{
				insertEdge(e);
				edgeCount++;
				System.out.println("Edge " + e.toString() + " inserted successfully.");
			}
		}else{
			System.out.println("Edge contains a value that is out of bounds of the graph, can not be added");
		}

	}

	// Adds an edge e to the graph if it doesn't already exist.
	// Input ints source, destination and weight
	void putEdge(int src, int dest, int wght){
		putEdge(new Edge(src, dest, wght));
	}

	// Adds an edge e to the graph if it doesn't already exist.
	// Input ints source and destination, weight is implied at 1
	void putEdge(int src, int dest){
		putEdge(new Edge(src, dest, 1));
	}

	// Handles actual insertion of an edge,
	// Specific implementation based on type of graph
	abstract void insertEdge(Edge e);

	// Removes an edge e from the graph if it exists.
	// Input edge class object
	void removeEdge(Edge e){
		if(rangeCheck(e.getSource()) && rangeCheck(e.getDestination())){
			if(existsEdge(e)){
				deleteEdge(e);
				edgeCount--;
				System.out.println("Edge " + e.toString() + " removed successfully.");
			}else {
				System.out.println("Edge does not exist.");
			}
		}else{
			System.out.println("Edge contains a value that is out of bounds of the graph, can not be removed");
		}
	}

	// Removes an edge e from the graph if it exists.
	// Input ints source and destination
	void removeEdge(int src, int dest){
		removeEdge(new Edge(src, dest));
	}

	// Handles actual removal of an edge,
	// Specific implementation based on type of graph
	abstract void deleteEdge(Edge e);

	// Produces an array of verticies adjacent to input vertex i
	// Implemented in sub classes
	abstract ArrayList<Integer> adjacentVerticies(int i);

	// Checks to see if an edge exists from vertex i to vertex j
	boolean areAdjacent(int i, int j){
		return existsEdge(i, j);
	}

	// Checks to see if edge e exists from
	boolean areAdjacent(Edge e){
		return existsEdge(e);
	}

	boolean rangeCheck(int i){
		return (i >= 0 && i < vertexCount);
	}
	
	//Method used in reading of a file
	//Splits an input string into the src, dest, and wght of an edge.
	int[] splitInputString(String s){
		String[] str = s.split(" ");
		int[] ints = new int[3];
		if(str.length == 2){
			ints[2] = 1;
		}
		for(int i = 0; i < str.length; i++){
			ints[i] = Integer.parseInt(str[i]);
		}
		return ints;
	}

	//Reads input from a file and constructs a Undirected graph based on the input
	//Paramater filename is the desired file to read
	void readFromFile(String filename){
		try{
			Scanner scan = new Scanner(new File(filename));
			//scan.useDelimiter("\n");
			int[] ints = new int[3];
			vertexCount = Integer.parseInt(scan.nextLine());
			edgeCount = 0;
			setUpDataType();
			while(scan.hasNext()){
				ints = splitInputString(scan.nextLine());
				putEdge(ints[0], ints[1], ints[2]);
			}
		}catch(FileNotFoundException ex){
			System.out.println(ex.toString());
		}
	}//End Method

	// Creates and instantiates the Matrix/List
	// Implemented in sub classes
	abstract void setUpDataType();


}//End Class
