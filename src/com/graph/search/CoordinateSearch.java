package com.graph.search;

import java.util.ArrayList;

public class CoordinateSearch extends BaseSearch {

	public CoordinateSearch(Graph g) {
		super(g);
	}

	@Override
	public boolean checkForPath(String from, String to) {

		if(!graph.containsKey(from) || 
				!graph.containsKey(to)) {
			return false;
		}
		
		Node start = graph.get(from);
		
		ArrayList<Node> list = new ArrayList<>();
		
		list.add(start);
		
		while(!list.isEmpty()) {
			Node current = list.remove(0);
			
			System.out.println(current.name);
			
			if(current.name.equals(to)) {
				printPath(current);
				return true;
			}
			
			current.isTested = true;
			
			for(Link link : current.links) {
				
				if(link.to.depth == -1) {
					link.to.depth = current.depth + 1;
				}
				
				if(!link.to.isTested &&
						!list.contains(link.to)){
					
					calculateDistance(link.to, graph.get(to));
					addElement(link.to, list);
				}				
			}			
		}
		
		return false;
	}



	private void calculateDistance(Node current, Node end) {
		double a = current.x - end.x;
		double b = current.y - end.y;
		
		current.distance = Math.sqrt(a*a + b*b);
		
		System.err.println(current.name + "->" + current.distance);
	}
	
	private void addElement(Node to, ArrayList<Node> list) {
		
		for(int i = 0; i < list.size(); i++) {
			if(to.distance < list.get(i).distance) {
				list.add(i, to);
				return;
			}
		}
		
		list.add(to);
		
	}

}
