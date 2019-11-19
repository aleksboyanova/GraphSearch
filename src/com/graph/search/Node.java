package com.graph.search;

import java.util.ArrayList;

public class Node {
	int weight;
	String name;
	int x;
	int y;
	boolean isTested;
	ArrayList<Link> links = new ArrayList<>();
	double distance = Double.MAX_VALUE;
	int depth = -1;
	
	public Node(String name) {
		this.name = name;
	}
	
	public Node(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public Node(String name, int x, int y) {
		this(name);
		this.x = x;
		this.y = y;
	}	
	
	public void addLink(Link link) {
		links.add(link);
	}

}
