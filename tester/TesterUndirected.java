/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 2: Undirected Graphs
* Assigned: 2/15/16
* Due: 3/3/16
**/
package graph;

import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;

//Project imports
import graph.*;

public class TesterUndirected{

	private final String weightedFileName = "input weighted.txt";
	private final String unweightedFileName = "input unweighted.txt";
	private Scanner scanner;

	public TesterUndirected(){
		
	}

	public static void main(String args[]){
		TesterUndirected tester = new TesterUndirected();
		tester.run();
	}

	private void run(){
		
		System.out.println("Running test program for Graph API");
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Directed Matrix");
		WeightedUndirectedMatrix wudm = new WeightedUndirectedMatrix(weightedFileName);
		allTestsOnUndirectedGraph(wudm);
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Directed List");
		WeightedUndirectedList wudl = new WeightedUndirectedList(weightedFileName);
		allTestsOnUndirectedGraph(wudl);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Directed Matrix");
		UnweightedUndirectedMatrix uwudm = new UnweightedUndirectedMatrix(unweightedFileName);
		allTestsOnUndirectedGraph(uwudm);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Directed List");
		UnweightedUndirectedList uwudl = new UnweightedUndirectedList(unweightedFileName);
		allTestsOnUndirectedGraph(uwudl);
		System.out.println("\n------------\n");
	}


	private void allTestsOnUndirectedGraph(UndirectedGraph g){
		System.out.println();
		printTheGraph(g);
		getVertAdjacenyDegreesOfGraph(g);
		listAdjacentVerticies(g);
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


	private void removeEdgesTest(Graph g, Edge edge){
		System.out.println("Adding new edge " + edge.toString() + " to graph to be removed");
		g.putEdge(edge);

		System.out.println("Removing edge " + edge.toString() +" from graph . ");
		g.removeEdge(edge);

		System.out.println("Attemping to remove edge " + edge.toString() +" from graph again. ");
		g.removeEdge(edge);

		System.out.println();
	}


	private void getVertAdjacenyDegreesOfGraph(UndirectedGraph g){
		System.out.println("Printing the in degrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i) + ": ");
			System.out.print(g.adjacentVertsCount(i) + "\n");
		}
		System.out.println();
	}

	
	

	private void listAdjacentVerticies(UndirectedGraph g){
		System.out.println("Printing the list of all adjacent verties to each vertice in the graph.");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i) + ": ");
			System.out.print(g.adjacentVerticies(i).toString() + "\n");
		}
		System.out.println();
	}

	private void testAdjacent(Graph g, Edge e){
		System.out.println("Testing to see if vertices " + e.getSource() + " and " + e.getDestination() + " are adjacent.");
		if(g.existsEdge(e)){
			System.out.println("Edge " + e.toString() + " exists.");
		}else{
			System.out.println("Edge " + e.toString() + " does not exist.");
		}
		System.out.println();
	}


}//end class
