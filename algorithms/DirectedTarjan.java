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
	List<Integer> ordered;
	int count;


	void topSort(){
		count = graph.numVertices();
		used = new boolean[count];
		ordered = new ArrayList<Integer>();
		for(int i = 0; i< graph.numVertices(); i++){
			if(!used[i]){
				dfs(i);
			}
		}
		Collections.reverse(ordered);
	}

	void dfs(int x){
		used[x] = true;
		for(int y : graph.adjacentVerticies(x)){
			if(!used[y]){
				dfs(y);
			}
		}
		count--;
		sorted[count] = x;
	}
	
	
}//end class
