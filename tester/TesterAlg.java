/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 3: Implementing Algorithms
* Assigned: 3/15/16
* Due: 4/7/16
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

public class TesterAlg extends TesterBase{
	
	String negfile = "negativeW.txt";
	String negfile2 = "negative.txt";

	public TesterAlg(){
		
	}

	public static void main(String args[]){
		TesterAlg tester = new TesterAlg();
		tester.run();
	}

	/*
	Testing
	kruskal weighted undirected List
	Topo unweighted list
	chain matrix

	/**/
	void run(){
		System.out.println("Running test program for Algorithms");
		System.out.println("\n--------\n");

		//For Topologic sorts
		System.out.println("Creating Weighted Directed List for positive testing");
		WeightedDirectedList wdl = new WeightedDirectedList(weightedFileName);

		System.out.println("\n--------\n");
		
		//POSITIVE SORTS

		//Topological sort by Kahn's
		System.out.println("Positive Topological sort by Kahn's");
		DirectedKahn kahn = new DirectedKahn(wdl);
		kahn.topSort();
		kahn.print();

		System.out.println("\n--------\n");

		//Topological sort by Tarjans's
		System.out.println("Positive Topological sort by Tarjan's");
		DirectedTarjan tarjan = new DirectedTarjan(wdl);
		tarjan.topSort();
		tarjan.print();

		System.out.println("\n--------\n");

		//NEGATIVE SORTS

		//For Topologic sorts
		System.out.println("Creating Weighted Directed List for negative testing");
		WeightedDirectedList loopGraph = new WeightedDirectedList(negfile);

		System.out.println("\n--------\n");

		//Topological sort by Kahn's
		System.out.println("Negative Topological sort by Kahn's");
		kahn = new DirectedKahn(loopGraph);
		kahn.topSort();
		kahn.print();

		System.out.println("\n--------\n");

		//Topological sort by Tarjans's
		System.out.println("Negative Topological sort by Tarjan's");
		tarjan = new DirectedTarjan(loopGraph);
		tarjan.topSort();
		tarjan.print();

		System.out.println("\n--------\n");

		// Kruskal MST
		System.out.println("Creating Weighted Undirected List for Kruskal");
		WeightedUndirectedList wudl = new WeightedUndirectedList(weightedFileName);

		System.out.println("\n--------\n");


		System.out.println("Finding a MST using Kruskal");
		KruskalMST kruskal = new KruskalMST(wudl);
		System.out.println();
		kruskal.printResults();

		System.out.println("\n--------\n");

		//Chain Matrix Multiplaction
		System.out.println("performing chain matrix multiplaction on values");
		int array[] = {5, 10, 6, 20, 1, 50, 5};
		for(int i = 0; i < array.length-1; i++){
			System.out.print("| " + array[i] + " ");
		}
		System.out.print("|\n\n");

		ChainMatrix cmm = new ChainMatrix(array);
		cmm.printOut();


	}
	

	//Not necessary for this set of testing, can rework later.
	void getDegrees(Graph g){}
}//end class
