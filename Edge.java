/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 1: Implementing Graphs
* Assigned: 1/26/16
* Due: 2/15/16
**/
public class Edge{

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

	public boolean equals(Edge e){
		return ((this.source == e.getSource()) && (this.destination == e.getDestination()));
	}
	
}
