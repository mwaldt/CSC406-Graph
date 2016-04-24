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

public class Huffman{

	PriorityQueue<Node> nodesRemaining;
	Node head;

	public Huffman(){
		readFromFile("huffman.txt");
		createTree();
	}

	//Creates the Huffman tree from nodes in the priorityqueue
	//Always pulls the 2 smallest nodes and hooks them to a new spacer node
	//On last node (100%) sets that node to the head of the tree
	void createTree(){
		Node left, right, parent;
		while(nodesRemaining.size() > 1){
			left = nodesRemaining.poll();
			right = nodesRemaining.poll();
			parent = new Node((left.getFreq() + right.getFreq()), left, right);
			nodesRemaining.add(parent);
		}
		head = nodesRemaining.poll();
	}

	//Reads input from a file, stores nodes in PriorityQueue
	void readFromFile(String filename){
		try{
			Scanner scan = new Scanner(new File(filename));
			String line;
			Node n;
			nodesRemaining = new PriorityQueue<Node>();
			while(scan.hasNext()){
				line = scan.nextLine();
				n = new Node(line.substring(0, 2), Integer.parseInt(line.substring(1, line.length())));
				nodesRemaining.add(n);
			}
		}catch(FileNotFoundException ex){
			System.out.println(ex.toString());
		}
	}//End Method


}//end class
