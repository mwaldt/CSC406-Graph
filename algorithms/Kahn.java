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

	void topSort(){
		checkGraph();
		int front, position;
		while(!tsortQueue.empty()){
			front = tsortQueue.front();
			tsortQueue.pop();
			sorted[position] = front;
			list<int>::iterator it;
			for(it = graph)
		}
	}
	
	void checkGraph(){
		for(int i = 0; i < indegree.length; i++){
			if(graph.indegree[i] == 0){
				tsortQueue.push(i);
			}
		}
	}
}//end class
