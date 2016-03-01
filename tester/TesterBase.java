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

//Project Imports
import graph.*;

public abstract class TesterBase{

	final String weightedFileName = "input weighted.txt";
	final String unweightedFileName = "input unweighted.txt";
	Scanner scanner;

	abstract void run();


	void allTestsOnGraph(Graph g){
		System.out.println();
		printTheGraph(g);
		System.out.println();
		getDegrees(g);
		System.out.println();
		listAdjacentVerticies(g);
		System.out.println();
		removeEdgesTest(g, new Edge(5, 4, 5));
		System.out.println("Testing for edge that does exist.");
		testAdjacent(g, new Edge(4,5));
		System.out.println("Testing for edge that does not exist.");
		testAdjacent(g, new Edge(1,4));
	}

	void printTheGraph(Graph g){
		System.out.println("Printing the string representation of the graph.");
		System.out.println("Number of vertices: " + g.numVertices());
		System.out.println("Number of edges: " + g.numEdges());
		System.out.println(g.toString());
		System.out.println();
	}


	void removeEdgesTest(Graph g, Edge edge){
		System.out.println("Adding new edge " + edge.toString() + " to graph to be removed");
		g.putEdge(edge);

		System.out.println("Removing edge " + edge.toString() +" from graph . ");
		g.removeEdge(edge);

		System.out.println("Attemping to remove edge " + edge.toString() +" from graph again. ");
		g.removeEdge(edge);

		System.out.println();
	}

	void listAdjacentVerticies(Graph g){
		System.out.println("Printing the list of all adjacent verties to each vertice in the graph.");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i) + ": ");
			System.out.println(g.adjacentVerticies(i).toString() + "\n");
		}
		System.out.println();
	}

	void testAdjacent(Graph g, Edge e){
		System.out.println("Testing to see if vertices " + e.getSource() + " and " + e.getDestination() + " are adjacent.");
		if(g.existsEdge(e)){
			System.out.println("Edge " + e.toString() + " exists.");
		}else{
			System.out.println("Edge " + e.toString() + " does not exist.");
		}
		System.out.println();
	}

	abstract void getDegrees(Graph g);

}//end class
