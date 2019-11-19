package com.graph.search;

import java.util.HashMap;

public abstract class BaseSearch {

	HashMap<String, Node> graph;
	
	
	public BaseSearch(Graph g) {
		graph = g.graph;
		
	}
	
	public abstract boolean 
		checkForPath(String from, String to);
	
	public void resetFlags() {
		for(Node node : graph.values()) {
			node.isTested = false;
		}
	}
	
	protected void printPath(Node current) {
		StringBuilder sb = new StringBuilder();
		
		while(current.depth != 0) {
			sb.append(current.name);
			sb.append(",");
			
			for(Link link : current.links) {
				if(link.to.depth == current.depth - 1) {
					current = link.to;
					break;
				}
			}
		}
		
		sb.append(current.name);
		
		System.out.println("The path is:" + sb.reverse());
		
	}
	
}
