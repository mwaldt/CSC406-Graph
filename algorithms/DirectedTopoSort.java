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

public abstract class DirectedTopoSort{

	DirectedGraph graph;
	int sorted[];
	boolean looping;
	int indegree[];

	void initSortData(DirectedGraph g){
		graph = g;
		sorted = new int[g.numVertices()];
		looping = false;
		indegree = graph.inDegrees();
		/*
		for(int i = 0; i < g.numVertices(); i++){
			sorted[i] = -1;		//sentinal values for detecting loops
		}/**/
	}

	void print(){
		for(int i = 0; i < graph.numVertices()-1; i ++){
			if(sorted[i] == sorted[i+1]){
				looping = true;
				i = graph.numVertices();
			}
		}
		if(looping == true){
			System.out.printf("Loop detected in graph, can not have a topological sort");
		}else{
			for(int i = 0; i < graph.numVertices() - 1; i++ ){
				System.out.printf("%d ", sorted[i]);
			}
			System.out.printf("%d", sorted[graph.numVertices()-1]);
		}
	}

}//end class
