package com.graph.search;

public class Link {
	double distance;
	Node to;
	
	public Link(Node to) {
		this.to = to;
	}
	
	public Link(Node to, double distance) {
		this.to = to;
		this.distance = distance;
	}
}
