/**
* Max Waldt
* CSC406
* Spring 2016
* Assignment 4: Huffman and Trees
* Assigned: 4/7/16
* Due: 4/28/16
**/
package graph;

public abstract class Node{

	String value;
	boolean print;	//False for spacer nodes, true for data nodes
	String path;
	Node left, right, parent;

	void setParent(Node n){
		parent = n;
	}

	public String getValue(){
		return value;
	}

	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}

	public void setLeft(Node n){
		left = n;
	}

	public void setRight(Node n){
		right = n;
	}

	public Node getParent(){
		return parent;
	}
	
	void setPath(String s){
		path = s;
	}

	String getPath(){
		return path;
	}

	abstract String getKey();

	abstract void setKey(String s);

	boolean printMe(){
	 	return print;
	}

	public Node getGrandParent(){
		return this.getParent().getParent();
	}

	public Node getUncle(){
		if(this.compareTo(getGrandParent()) > 0){
			return this.getGrandParent().getLeft();
		}else{
			return this.getGrandParent().getRight();
		}
	}

	public int compareTo(Node n){
		String s1, s2;
		if(this.value == n.getValue() || this.value.equals(n.getValue()))
			return 0;
		else{
			s1 = buffer(this.value, n.getValue());
			s2 = buffer(n.getValue(), this.value);
			return s1.compareTo(s2);
		}	
	}

	//pads a string for numeric comparisons.
	//Does not change original values
	private String buffer(String s1, String s2){
		if(s1.length() == s2.length()){
			//quick escape, trying to catch a bug
		}else if(s1.length() < s2.length()){
			for(int i = s1.length(); i < s2.length(); i ++){
				s1 = "0"+s1;
			}
			//System.out.println("Post buffer strings: " + s1 + " : " + s2);
		}
		return s1;
	}
	
	public boolean equals(Object e){
		if(this == e){
			return true;	
		}
		if(e == null) {
			return false;
		}
		if(getClass() != e.getClass()){
			return false;
		}
		final Node other = (Node) e;
		if(value == other.getValue()){
			return true;
		}
		return false;
	}

	public void debug(){
		System.out.println("debug for node " + this.toString());
		if(this.getParent() == null){
			System.out.println("I AM (G)ROOOT!");
		}else{
			System.out.println("parent " + this.getParent().toString());
		}
		
		if(this.getLeft() != null){
			System.out.println("left " + this.getLeft().toString());	
		}else{
			System.out.println("left is null");
		}
		if(this.getRight() != null){
			System.out.println("right " + this.getRight().toString());	
		}else{
			System.out.println("right is null");
		}
		
	}
}
