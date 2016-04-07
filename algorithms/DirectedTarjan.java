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

public class DirectedTarjan extends DirectedTopoSort{

	boolean used[];
	int count;

	public DirectedTarjan(DirectedGraph g){
		initSortData(g);
		count = graph.numVertices();
		used = new boolean[count];
	}

	void topSort(){
		for(int i = 0; i < graph.numVertices(); i++){
			if(!used[i]){
				dfs(i);
			}
		}
		for(int i = 0; i < graph.numVertices(); i++){
			if(indegree[i] > 0){
				looping = true;
				i = graph.numVertices();
			}
		}
	}

	void dfs(int x){
		used[x] = true;
		if(indegree[x] > 0){
			indegree[x]--;	
		}
		for(int y : graph.adjacentVerticies(x)){
			if(!used[y]){
				dfs(y);
			}
		}
		count--;
		sorted[count] = x;
	}
	
	
}//end class
