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

public class TesterDirected extends TesterBase{
	
	public TesterDirected(){
		
	}

	public static void main(String args[]){
		TesterDirected tester = new TesterDirected();
		tester.run();
	}

	void run(){
		
		System.out.println("Running test program for Graph API");
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Directed Matrix");
		WeightedDirectedMatrix wdm = new WeightedDirectedMatrix(weightedFileName);
		allTestsOnGraph(wdm);
		System.out.println("\n--------\n");

		System.out.println("Creating Weighted Directed List");
		WeightedDirectedList wdl = new WeightedDirectedList(weightedFileName);
		allTestsOnGraph(wdl);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Directed Matrix");
		UnweightedDirectedMatrix uwdm = new UnweightedDirectedMatrix(unweightedFileName);
		allTestsOnGraph(uwdm);
		System.out.println("\n--------\n");

		System.out.println("Creating Unweighted Directed List");
		UnweightedDirectedList uwdl = new UnweightedDirectedList(unweightedFileName);
		allTestsOnGraph(uwdl);
		System.out.println("\n------------\n");
	}


	void getDegrees(Graph g){
		getInDegreesOfGraph((DirectedGraph)g);
		getOutDegreesOfGraph((DirectedGraph)g);
	}

	void getInDegreesOfGraph(DirectedGraph g){
		System.out.println("Printing the in degrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i) + ": ");
			System.out.println(g.inDegree(i) + "\n");
		}
		System.out.println();
	}

	void getOutDegreesOfGraph(DirectedGraph g){
		System.out.println("Printing the out degrees of each verticie in a graph");
		for(int i = 0; i < g.numVertices(); i++){
			System.out.print("Vertex  " + (i) + ": ");
			System.out.println(g.outDegree(i) + "\n");
		}
		System.out.println();
	}
	

}//end class
