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

public class UnionFind{

	int parent[];
	int count;

	public UnionFind(int n){
		count = n;
		parent = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = -1;
		}
	}

	//Returns parent of x using path compression
	int find(int x){
		validate(x);
		if(parent[x] >= 0){
			parent[x] = find(parent[x]);
		}
		return x;
	}

	//the number of nodes
	int count(){
		return count;
	}

	//Returns if x and y are connected
	boolean connected(int x, int y){
		return find(x) == find(y);
	}

	//Adds a connection between x and y
	void union(int x, int y){
		int rootx = find(x);
		int rooty = find(y);
		if(rootx == rooty) return;
		hook(rootx, rooty);
	}

	//Attaches nodes x and y
	//The one with more subnodes will become the root.
	void hook(int x, int y){
		if(x > y){
			y += x;
			parent[x] = y;
		}else if(x <= y){
			x += y;
			parent[y] = x;
		}
		count--;
	}

	//Make sure the node is in the bounds of the set
	void validate(int x){
		int n = parent.length;
		if (x >= n){
			throw new IndexOutOfBoundsException ("index " + x + " is not between 0 and " + (n-1));
		}
	}



}//end class
