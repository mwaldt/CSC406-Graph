/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 4: Huffman and Trees
* Assigned: 4/7/16
* Due: 4/28/16
**/
package graph;

import java.text.*;

public class HuffNode extends Node implements Comparable{

	String huffmanCode;
	double freq;

	//Constructor for bridging nodes
	public HuffNode(double i, HuffNode l, HuffNode r){
		huffmanCode = "";
		value = "#";
		print = false;
		freq = i;
		left = l;
		right = r;
	}

	//Constructor for nodes with value
	public HuffNode(String s, double i){
		value = s;
		print = true;
		huffmanCode = "";
		freq = i;
	}

	public String getKey(){
		return huffmanCode;
	}

	public void setKey(String s){
		huffmanCode = s;
	}

	public double getFreq(){
		return freq;
	}
	
	public String toString(){
		NumberFormat formatter = new DecimalFormat("#0.00");
		return "(" + value + ", " + formatter.format(freq) + ", " + huffmanCode + ")";
	}

	public int compareTo(Object o){
		return compareTo((HuffNode) o);
	}

	public int compareTo(HuffNode n){
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
		final HuffNode other = (HuffNode) e;
		if(value == other.getValue() && freq == other.getFreq()){
			return true;
		}
		return false;
	}
}
