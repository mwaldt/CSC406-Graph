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

public abstract class Tree{

	Node root;
	boolean found;
	int depth;
	int nodeDepth;

	void printTree(){
		//System.out.println("Root Node | Left Node | Right Node | frequency | Huffman Code");
		System.out.println("Print out of the Tree");
		System.out.println("Tree depth: " + depth);
		printNode(root);
	}

	void printNode(Node n){
		if(n.equals(root)){
			nodeDepth = 1;
		}else{
			nodeDepth++;
		}
		if(n.printMe()){
			System.out.println(n.toString() + "at d: " + nodeDepth);
			System.out.println("root is " + root.toString());
			n.debug();

		}
		if(n.getLeft() != null){
			printNode(n.getLeft());
			nodeDepth--;
		}
		if(n.getRight() != null){
			printNode(n.getRight());
			nodeDepth--;
		}
	}

	abstract void createTree();

	abstract void readFromFile(String filename);

	//Roattions
	//n is lowest node
	void rr(Node n){
		Node gp = n.getGrandParent();
		//mid to top + rehooking
		n.getParent().setParent(gp.getParent());
		fixSuperTree(n.getParent());
		//rehook parents left child to gp
		gp.setRight(n.getParent().getLeft());
		if(gp.getRight() != null)
			gp.getRight().setParent(gp);
		//attach gp
		n.getParent().setLeft(gp);
		gp.setParent(n.getParent());
	}

	void ll(Node n){

		Node gp = n.getGrandParent();
		Node p = n.getParent();;

		//mid to top + rehook
		p.setParent(gp.getParent());
		fixSuperTree(p);

		//rehook paretnts child to gp
		gp.setLeft(p.getRight());

		if(gp.getLeft() != null){
			gp.getLeft().setParent(gp);
		}
		//attach gp
		p.setRight(gp);
		gp.setParent(p);
	}

	//-mw debug
	void lr(Node n){
		Node gp = n.getGrandParent();
		Node p = n.getParent();

		System.out.println("-----");
		System.out.println("gp start");
		System.out.println("gp");
		gp.debug();
		System.out.println("p");
		p.debug();
		System.out.println("n");
		n.debug();
		System.out.println("-----");

		//move leaf to top
		n.setParent(gp.getParent());
		fixSuperTree(n);

		System.out.println("-----");
		System.out.println("postfixtreeart");
		System.out.println("gp");
		gp.debug();
		System.out.println("p");
		p.debug();
		System.out.println("n");
		n.debug();
		System.out.println("-----");

		//Free space on left side of n
		gp.getLeft().setRight(n.getLeft());
		if(n.getLeft() != null){
			n.getLeft().setParent(gp.getLeft());
		}

		System.out.println("-----");
		System.out.println("free space for left side of n");
		System.out.println("gp");
		gp.debug();
		System.out.println("p");
		p.debug();
		System.out.println("n");
		n.debug();
		System.out.println("-----");


		// Attach middle node to new root (n) node/vice versa
		n.setLeft(gp.getLeft());
		n.getLeft().setParent(n);

		System.out.println("-----");
		System.out.println("Attach middle node to new root (n) node/vice versa");
		System.out.println("gp");
		gp.debug();
		System.out.println("p");
		p.debug();
		System.out.println("n");
		n.debug();
		System.out.println("-----");

		//Free space on right side of n
		gp.setLeft(n.getRight());
		if(gp.getLeft() != null){
			gp.getLeft().setParent(gp);
		}
		//Hook temp to new root
		gp.setParent(n);
		n.setRight(gp);
		System.out.println("-----");
		System.out.println("Last section");
		System.out.println("gp");
		gp.debug();
		System.out.println("p");
		p.debug();
		System.out.println("n");
		n.debug();
		System.out.println("-----");
		printTree();
	}

	void rl(Node n){
		Node gp = n.getGrandParent();
		//move leaf to top
		n.setParent(gp.getParent());
		fixSuperTree(n);

		//Free space on new roots left side
		gp.getRight().setLeft(n.getRight());
		if(n.getRight() != null){
			n.getRight().setParent(gp.getRight());
		}

		// Free space on gp left, hook to new root
		n.setRight(gp.getRight());
		n.getRight().setParent(n);
		//Fill gp left side with new roots right side
		gp.setRight(n.getLeft());
		if(gp.getRight() != null){
			gp.getRight().setParent(gp);
		}
		//Hook gp to new root
		gp.setParent(n);
		n.setLeft(gp);	
	}

	//Method to attach a subtree back to the correct positon
	//in a larger tree after subtree root switches
	void fixSuperTree(Node n){
		if(n.getParent() != null){
			if(n.compareTo(n.getParent()) > 0){
				n.getParent().setRight(n);	
			}else{
				n.getParent().setLeft(n);
			}
		}else{
			root = n;
		}
	}


	//Search the tree or subtree from a root, subRoot
	//If the element is found the boolean found is now true
	//If the element is not found, boolean remains false, the parent node is returned
	Node search(Node subRoot, Node n, String s){
		System.out.println("comparing " + subRoot.toString() + " : " + n.toString());

		if(subRoot.equals(root)){
			nodeDepth = 1;
		}

		System.out.println("p depth: " + nodeDepth);
		System.out.println("p path: " + s);

		if(subRoot.compareTo(n) == 0){
			found = true;
		}else if(n.compareTo(subRoot) < 0){
			System.out.println("Node less than subnode");
			if(subRoot.getLeft() != null){
				nodeDepth++;
				s = s + "l";
				return search(subRoot.getLeft(), n, s);
			}else{
				found = false;
			}
		}else if(n.compareTo(subRoot) > 0){
			System.out.println("Node greater than subnode");
			if(subRoot.getRight() != null){
				nodeDepth++;
				s = s + "r";
				return search(subRoot.getRight(), n, s);
			}else{
				found = false;
			}
		}
		return subRoot;
	}
}//end class
