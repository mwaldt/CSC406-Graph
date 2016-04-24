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
			left.setParent(parent);
			right.setParent(parent);
			nodesRemaining.add(parent);
		}
		head = nodesRemaining.poll();
		System.out.println("Setting up huffman codes");
		setHuffman(head);
	}

	void setHuffman(Node n){
		System.out.println("Node " + n.getValue());
		if(n.getLeft() != null){
			if(n.equals(head)){
				n.getLeft().setHuffmanCode("L");
			}else{
				n.getLeft().appeadHuffman("L");
			}
			setHuffman(n.getLeft());
		}
		if(n.getRight() != null){
			if(n.equals(head)){
				n.getRight().setHuffmanCode("R");;
			}else{
				n.getRight().appeadHuffman("R");
			}
			n.getRight().appeadHuffman("R");
			setHuffman(n.getRight());
		}
	}

	//Prints out tree
	// 9 | 11 | 12 | 11 | 
	void printTree(){
		//System.out.println("Root Node | Left Node | Right Node | frequency | Huffman Code");
		System.out.println("Print out of the huffman code");
		printNode(head);
	}

	void printNode(Node n){
		System.out.println(n.toString());
		if(n.getLeft() != null){
			printNode(n.getLeft());
		}
		if(n.getRight() != null){
			printNode(n.getRight());
		}
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
				//System.out.println("Read in line \"" + line + "\"");
				n = new Node(line.substring(0, 2), Double.parseDouble(line.substring(1, line.length())));
				nodesRemaining.add(n);
			}
		}catch(FileNotFoundException ex){
			System.out.println(ex.toString());
		}
	}//End Method


}//end class
