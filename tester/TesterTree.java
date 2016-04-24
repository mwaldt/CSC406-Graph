/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 4: Huffman and Trees
* Assigned: 4/7/16
* Due: 4/28/16
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

public class TesterTree extends TesterBase{
	
	String treeFile = "huffman.txt";

	public TesterTree(){
		
	}

	public static void main(String args[]){
		TesterTree tester = new TesterTree();
		tester.run();
	}

	/*
	Testing
	kruskal weighted undirected List
	Topo unweighted list
	chain matrix

	/**/
	void run(){
		System.out.println("Running test program for Trees");
		System.out.println("\n--------\n");

		//For Huffman Code
		System.out.println("Creating Huffman Code");
		Huffman huffmanCode = new Huffman();
		huffmanCode.printTree();

		System.out.println("\n--------\n");
	}
	

	//Not necessary for this set of testing, can rework later.
	void getDegrees(Graph g){}
}//end class
