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

public class RedBlack extends Tree{

	public RedBlack(){
		createTree();
	}

	//
	void createTree(){
		readFromFile("redblack.txt");
	}

	//
	void insert(RBNode n){
		//System.out.println("inserting node: " + n.toString());
		if(root == null){
			root = n;
			root.setKey("black");
			depth = 1;
		}else{
			n.setParent(search(root, n, ""));
			if(found){
			}else{
				int a = n.compareTo(n.getParent());
				if(a > 0){
					System.out.println("inserting node to right of: "
						+ n.getParent().toString() +"at parent depth \n" + nodeDepth);
					n.getParent().setRight(n);
				}else if(a < 0){
					System.out.println("inserting node to left of: "
						+ n.getParent().toString() +"at parent depth \n" + nodeDepth);
					n.getParent().setLeft(n);
				}
				if(nodeDepth == depth){
					depth++;
				}
				if(!(n.getParent().equals(root))){
					checkNode(n);
				}
				root.setKey("black");
			}
		}
	}

	//
	void checkNode(RBNode n){
		//2 reds in a row
		if(n.getParent().equals(root)){
			//System.out.println("parent is root, we are done here");
		}else if(n.getParent().getKey().equals("red") && n.getKey().equals("red")){
			//System.out.println("redif");
			if(n.getUncle() == null || n.getUncle().getKey().equals("black")){
				System.out.println("\nblack uncle");
				recolorNodes(n);
				reOrder(n);
				depth--;
			}else if(n.getUncle().getKey().equals("red")){
				System.out.println("\nred uncle");
				recolorNodes(n);
			}
			if(n.getGrandParent() != null){
				//System.out.println("\ncheck up tree next node\n");
				checkNode((RBNode) n.getParent());
				nodeDepth--;
			}
		}
	}

	//
	void recolorNodes(RBNode n){
		//grandparent always changes
		((RBNode) n.getGrandParent()).switchColor();
		//red uncle case
		System.out.println("recolor triggered by node " + n.toString());
		if(n.getUncle() != null && n.getUncle().getKey().equals("red")){
			System.out.println("uncle not null, uncle red -rc");
			((RBNode) n.getUncle()).switchColor();
			((RBNode) n.getParent()).switchColor();
		}else{	//empty or black uncle nodes
			// r - x rotateions
			System.out.println("uncle null or black -rc");
			if(n.compareTo(n.getParent()) > 0){
				System.out.println("n.compareTo(n.getParent()): " + n.compareTo(n.getParent()));
				if(n.compareTo(n.getGrandParent()) > 0){
					//rr
					System.out.println("n.compareTo(n.getGrandParent()): " + n.compareTo(n.getGrandParent()));
					((RBNode) n.getParent()).switchColor();
				}else{
					//rl, no change to parent
					System.out.println("less than gp");
					((RBNode) n).switchColor();
				}
			}else{
				System.out.println("else to n.compareTo(n.getParent()) > 0");
				if(n.compareTo(n.getGrandParent()) < 0){
					//ll
					System.out.println("n.compareTo(n.getGrandParent()): " + n.compareTo(n.getGrandParent()));
					((RBNode) n.getParent()).switchColor();
				}else {
					//lr, no change to parent
					System.out.println("greater than gp");
					((RBNode) n).switchColor();
				}
			}
		}
			System.out.println("Colors:");
			System.out.println("gp:" + n.getGrandParent().toString());
			if(n.getUncle() != null){
				System.out.println("u:" + n.getUncle().toString());	
			}
			System.out.println("p:" + n.getParent().toString());
			System.out.println("n:" + n.toString());
	}

	//
	void reOrder(RBNode n){
		//System.out.println("Reordering nodes: " + n.toString());
		if(n.compareTo(n.getParent()) > 0){
			if(n.getParent().compareTo(n.getGrandParent()) > 0){
				//System.out.println("rr");
				rr(n);
			}else{
				//System.out.println("lr");
				lr(n);
			}
		}else{
			if(n.getParent().compareTo(n.getGrandParent()) > 0){
				//System.out.println("rl");
				rl(n);
			}else{
				//System.out.println("ll");
				ll(n);
			}
		}
	}



	//Reads input from a file, stores nodes in PriorityQueue
	void readFromFile(String filename){
		try{
			Scanner scan = new Scanner(new File(filename));
			String line;
			RBNode n;
			while(scan.hasNext()){
				//System.out.println("readloop");
				line = scan.nextLine();
				System.out.println("line: " + line);
				n = new RBNode(line);
				insert(n);
			}
		}catch(FileNotFoundException ex){
			System.out.println(ex.toString());
		}
		//System.out.println("end read in");
	}//End Method
}//end class
