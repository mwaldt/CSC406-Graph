/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/
package graph;

public class Edge implements Comparable{

	int source;
	int destination;
	int weight;

	//Default Constructor
	public Edge(){
		source = 0;
		destination = 0;
		weight = 0;
	}

	//Constructor for weighted graph 
	public Edge(int src, int dest, int wght){
		source = src;
		destination = dest;
		weight = wght;
	}

	//Constructor for unweighted graph 
	public Edge(int src, int dest){
		source = src;
		destination = dest;
		weight = 1;
	}

	// Accessor Methods
	public int getSource(){ return source; }
	public int getDestination(){ return destination; }
	public int getWeight(){ return weight; }
	
	public String toString(){
		return "(" + source + ", " + destination + ")";
	}

	public int compareTo(Object o){
		return compareTo((Edge) o);
	}

	public int compareTo(Edge e){
		if(this.source == e.getSource())
			return 0;
		else
			return this.weight > e.getWeight() ? 1 : -1;
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
		final Edge other = (Edge) e;
		if(source == other.getSource() && destination == other.getDestination()){
			return true;
		}
		return false;

	}

	public Edge flip(){
		return new Edge(destination, source, weight);
	}
	
}
