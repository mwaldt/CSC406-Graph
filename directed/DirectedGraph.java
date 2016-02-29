/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/

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

	//Reads input from a file and constructs a Directed graph based on the input
	//Paramater filename is the desired file to read
	void readFromFile(String filename){
		try{
			Scanner scan = new Scanner(new File(filename));
			//scan.useDelimiter("\n");
			int[] ints = new int[3];
			vertexCount = Integer.parseInt(scan.nextLine());
			edgeCount = 0;
			inDegree = new int[vertexCount];
			outDegree = new int[vertexCount];
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

}
