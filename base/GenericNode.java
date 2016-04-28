/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 4: Huffman and Trees
* Assigned: 4/7/16
* Due: 4/28/16
* Experimental class that I might not get to use in my program due to time.
* I would like to implement it at some time after the assignment is due
**/
package graph;

public abstract class GenericNode<S>{

	private S value;
	GenericNode left, right, parent;


	void setParent(GenericNode n){
		parent = n;
	}

	public S getValue(){
		return value;
	}

	public GenericNode getLeft(){
		return left;
	}

	public GenericNode getRight(){
		return right;
	}

	public GenericNode getParent(){
		return parent;
	}

	abstract S getKey();

	abstract void setKey(S s);
}
