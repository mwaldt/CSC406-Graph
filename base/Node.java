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

	String value, huffmanCode;
	double freq;
	Node left, right, parent;

	//Constructor for bridging nodes
	public Node(double i, Node l, Node r){
		value = " ";
		huffmanCode = "";
		freq = i;
		left = l;
		right = r;
	}

	//Constructor for nodes with value
	public Node(String s, double i){
		value = s;
		huffmanCode = "";
		freq = i;
	}

	void setParent(Node n){
		parent = n;
	}

	void setHuffmanCode(String s){
		huffmanCode = s;
	}

	public String getValue(){
		return value;
	}

	public String getHuffmanCode(){
		return huffmanCode;
	}

	public void appeadHuffman(String s){
		huffmanCode = parent.getHuffmanCode() + s;
	}

	public double getFreq(){
		return freq;
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
	
	public String toString(){
		return "(" + value + ", " + freq + ", " + huffmanCode + ")";
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
}
