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
	//List<Integer> ordered;
	int sorted[];

	void initSortData(DirectedGraph g){
		graph = g;
		sorted = new int[g.numVertices()];
		//ordered = new ArrayList<Integer>();
	}

	void print(){
		for(int i = 0; i < graph.numVertices() - 1; i++ ){
			System.out.printf("%d ", sorted[i]);
		}
		System.out.printf("%d", sorted[graph.numVertices()-1]);
	}


}//end class
