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
		String path = "";
		printNode(root, path);
	}

	void printNode(Node n, String s){
		String str = s;
		if(n.equals(root)){
			nodeDepth = 1;
		}else{
			nodeDepth++;
		}
		if(n.printMe()){
			System.out.println(n.toString());
			System.out.println("d: " + nodeDepth);
			System.out.println("p: "+ str);
			System.out.println();
		}
		if(n.getLeft() != null){
			str = str + "l";
			printNode(n.getLeft(), str);
			nodeDepth--;
		}
		if(n.getRight() != null){
			if(n.equals(root)){
				str = "";
			}
			str = str + "r";
			printNode(n.getRight(), str);
			nodeDepth--;
		}
	}

	abstract void createTree();

	abstract void readFromFile(String filename);

	//Roattions
	//n is lowest node
	void rr(Node n){
		Node gp = n.getGrandParent();
		Node p = n.getParent();

		//mid to top + rehooking
		p.setParent(gp.getParent());
		fixSuperTree(p);

		//rehook parents left child to gp
		gp.setRight(p.getLeft());

		if(gp.getRight() != null)
			gp.getRight().setParent(gp);

		//attach gp
		p.setLeft(gp);
		gp.setParent(p);
	}

	void ll(Node n){

		Node gp = n.getGrandParent();
		Node p = n.getParent();

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

		//n to root
		n.setParent(gp.getParent());
		fixSuperTree(n);

		// move n's left to p's right
		p.setRight(n.getLeft());
		if(p.getRight() != null){
			p.getRight().setParent(p);
		}

		//move p to n' left
		n.setLeft(p);
		p.setParent(n);

		//move n's right node to gp's left
		gp.setLeft(n.getRight());
		if(gp.getLeft() != null){
			gp.getLeft().setParent(gp);	
		}

		//move gp to right of n
		n.setRight(gp);
		gp.setParent(n);
	}

	void rl(Node n){
		Node gp = n.getGrandParent();
		Node p = n.getParent();

		//n to root
		n.setParent(gp.getParent());
		fixSuperTree(n);

		// move n's right to p's left
		p.setLeft(n.getRight());
		if(p.getLeft() != null){
			p.getLeft().setParent(p);
		}
		//move p to n' right
		n.setRight(p);
		p.setParent(n);

		//--
		//move n's left node to gp's right
		gp.setRight(n.getLeft());
		if(gp.getRight() != null){
			gp.getRight().setParent(gp);	
		}

		//move gp to left of n
		n.setLeft(gp);
		gp.setParent(n);
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
		//System.out.println("comparing " + subRoot.toString() + " : " + n.toString());

		if(subRoot.equals(root)){
			nodeDepth = 1;
		}

		//System.out.println("p depth: " + nodeDepth);
		//System.out.println("p path: " + s);

		if(subRoot.compareTo(n) == 0){
			found = true;
		}else if(n.compareTo(subRoot) < 0){
			//System.out.println("Node less than subnode");
			if(subRoot.getLeft() != null){
				nodeDepth++;
				s = s + "l";
				return search(subRoot.getLeft(), n, s);
			}else{
				found = false;
			}
		}else if(n.compareTo(subRoot) > 0){
			//System.out.println("Node greater than subnode");
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
