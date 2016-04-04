/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 3: Implementing Algorithms
* Assigned: 3/15/16
* Due: 4/7/16
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

public class DirectedKahn extends DirectedTopoSort{

	int indegree[];
	PriorityQueue<Integer> tsortQueue;

	public DirectedKahn(DirectedGraph g){
		initSortData(g);
		tsortQueue = new PriorityQueue<Integer>();
	}

	void topSort(){
		indegree = graph.inDegrees();
		checkGraph();
		int front, position = 0;
		while(!tsortQueue.isEmpty()){
			front = tsortQueue.peek();
			tsortQueue.poll();
			sorted[position] = front;
			position++;
			for(int i : graph.adjacentVerticies(front)){
				indegree[i]--;
			}
		}
	}
	
	void checkGraph(){
		for(int i = 0; i < indegree.length; i++){
			if(indegree[i] == 0){
				tsortQueue.offer(i);
			}
		}
	}
}//end class
