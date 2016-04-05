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

public class ChainMatrix{
	int m[][];
	//int s[][];

	public ChainMatrix(int p[]){
		int n = p.length -1;
		m = new int[n][n];
		//s = new int[n][n];

		for(int ii = 1; ii < n; ii++){
			for(int i = 0; i < n-ii; i++){
				int j = i + ii;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++){
					int q = m[i][k] + m[k+1][j] + p[i]*p[k+1]*p[j+1];
					if(q < m[i][j]){
						m[i][j] = q;
						m[j][i] = k;
						//int s[i][j] = k;
					}
				}
			}
		}
	}

	void printOut(){
		for(int i = 0; i< m.length; i++){
			for(int j = 0; j < m.length; j++){
				System.out.print("|" + buffer(m[i][j]) + "|");
			}
			System.out.println();
		}
	}

	String buffer(int x){
		String s = "" + x;
		for(int i = s.length(); i < 7; i++){
			s = s + " ";
		}
		return s;
	}
}//end class
