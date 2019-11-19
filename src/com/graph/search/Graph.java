package com.graph.search;

import java.util.HashMap;

public class Graph {

	HashMap<String, Node> graph = new HashMap<>();
	
	
	public void addNodeToGraph(Node node) {
		
		if(graph.containsKey(node.name)) {
			System.err.println("Node is duplicated!");
			return;
		}
		
		graph.put(node.name, node);
	}
	
	
	public void createLink(String from, String to, boolean bidirectional) {
				
		Node start = graph.get(from);
		Node end = graph.get(to);
		
		if(start != null  && end != null) {
			start.addLink(new Link(end));
			
			if(bidirectional) {
				end.addLink(new Link(start));
			}
			
		}		
	}
	
	

}
