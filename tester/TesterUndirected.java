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

public class TesterUndirected extends TesterBase{

	TesterUndirected(){
		
	}

	public static void main(String args[]){
		TesterUndirected tester = new TesterUndirected();
		tester.run();
	}

	void run(){
		
		System.out.println("Running test program for Graph API");
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Undirected Matrix");
		WeightedUndirectedMatrix wudm = new WeightedUndirectedMatrix(weightedFileName);
		allTestsOnGraph(wudm);
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Undirected List");
		WeightedUndirectedList wudl = new WeightedUndirectedList(weightedFileName);
		allTestsOnGraph(wudl);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Undirected Matrix");
		UnweightedUndirectedMatrix uwudm = new UnweightedUndirectedMatrix(unweightedFileName);
		allTestsOnGraph(uwudm);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Undirected List");
		UnweightedUndirectedList uwudl = new UnweightedUndirectedList(unweightedFileName);
		allTestsOnGraph(uwudl);
		System.out.println("\n------------\n");
	}

	void getDegrees(Graph g){
		getVertAdjacenyDegreesOfGraph((UndirectedGraph) g);
	}

	void getVertAdjacenyDegreesOfGraph(UndirectedGraph g){
		System.out.println("Printing the in degrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i) + ": ");
			System.out.println(g.adjacentVertsCount(i) + "\n");
		}
		System.out.println();
	}

}//end class
