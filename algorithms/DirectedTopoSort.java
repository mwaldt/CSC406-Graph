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
	PriorityQueue<Integer> tsortQueue;
	int sorted[];

	void initSortData(DirectedGraph g){
		graph = g;
		sorted = new int[g.numVertices()];
		tsortQueue = new PriorityQueue<Integer>();
	}


}//end class
