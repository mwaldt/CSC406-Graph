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

public class RBNode extends Node{

	String color; 
	double freq;

	//Constructor for bridging nodes
	public RBNode(String v){
		value = v;
		color = "red";
		print = true;
	}

	public String getKey(){
		return color;
	}

	public void setKey(String s){
		color = s;
	}

	public void switchColor(){
		if(color.equals("black"))
			color = "red";
		else{
			color = "black";
		}
	}
	
	public String toString(){
		return "(" + value + ", " + color + ")";
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
		final RBNode other = (RBNode) e;
		if(value == other.getValue()){
			return true;
		}
		return false;
	}

}
