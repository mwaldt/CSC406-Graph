/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 4: Huffman and Trees
* Assigned: 4/7/16
* Due: 4/28/16
**/
package graph;

public abstract class Node{

	String value;
	Node left, right, parent;


	void setParent(Node n){
		parent = n;
	}

	public String getValue(){
		return value;
	}

	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}

	public Node getParent(){
		return parent;
	}

	abstract String getKey();

	abstract void setKey(String s);
}
