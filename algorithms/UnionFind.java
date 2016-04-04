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

	int parent(int i){
		return parent[i];
	}

	//Returns if x and y are connected
	boolean connected(int x, int y){
		return find(x) == find(y);
	}

	//Adds a connection between x and y
	void union(int x, int y){
		int rootx = find(x);
		int rooty = find(y);
		//System.out.println("root x: " + rootx);
		//System.out.println("root y: " + rooty);
		if(rootx == rooty && rootx >= 0 ){
			//System.out.println("Already connected");
		}else{
			hook(rootx, rooty);
		}
	}

	//Attaches nodes x and y
	//The one with more subnodes will become the root.
	void hook(int x, int y){
		//System.out.println("Hooking " + x + " " + y);
		if(x > y){
			//System.out.println("x > y");
			parent[y] += parent[x];
			parent[x] = y;
		}else if(x <= y){
			//System.out.println("x <= y");
			parent[x] += parent[y];
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
