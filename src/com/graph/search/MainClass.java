package com.graph.search;

public class MainClass {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.addNodeToGraph(new Node("A", 6, 10));
		graph.addNodeToGraph(new Node("B", 0, 5));
		graph.addNodeToGraph(new Node("C", 7, 5));
		graph.addNodeToGraph(new Node("D", 13, 5));
		graph.addNodeToGraph(new Node("E", 5, 0));
		graph.addNodeToGraph(new Node("F", 8, 0));
		
		graph.createLink("A", "B", true);
		graph.createLink("A", "C", true);
		graph.createLink("A", "D", true);
		
		graph.createLink("B", "E", true);
		
		graph.createLink("C", "E", true);		
		graph.createLink("C", "F", true);		
			
		graph.createLink("D", "F", true);
		
		graph.createLink("E", "F", true);		
		
		BaseSearch search = 
				new CoordinateSearch(graph);
		
		if(search.checkForPath("B", "D")) {
			System.out.println("Path Found!");
		}else {
			System.out.println("No path found!");
		}
		
	}

}
