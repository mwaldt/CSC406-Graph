/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 4: Huffman and Trees
* Assigned: 4/7/16
* Due: 4/28/16
**/
package graph;

public class Node implements Comparable{

	String value;
	int freq;
	Node left, right;

	//Constructor for bridging nodes
	public Node(int i, Node l, Node r){
		value = " ";
		freq = i;
		left = l;
		right = r;
	}

	//Constructor for nodes with value
	public Node(String s, int i){
		value = s;
		freq = i;
	}

	
	public String toString(){
		return "(" + value + ", " + freq + ")";
	}

	public int compareTo(Object o){
		return compareTo((Node) o);
	}

	public int compareTo(Node n){
		if(this.freq == n.getFreq())
			return 0;
		else
			return this.freq > n.getFreq() ? 1 : -1;
	}

	
	public boolean equals(Object e){
		if(this == e){
			return true;	
		}
		if(e == null) {
			return false;
		}
		if(getClass() != e.getClass()){
			return false;
		}
		final Node other = (Node) e;
		if(value == other.getValue() && freq == other.getFreq()){
			return true;
		}
		return false;
	}

	public String getValue(){
		return value;
	}

	public int getFreq(){
		return freq;
	}
	
	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}
}
