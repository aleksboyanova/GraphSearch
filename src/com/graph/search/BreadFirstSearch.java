package com.graph.search;

import java.util.ArrayList;

public class BreadFirstSearch extends BaseSearch{

	public BreadFirstSearch(Graph g) {
		super(g);
	}

	@Override
	public boolean checkForPath(String from, String to) {
		
		if(!graph.containsKey(from ) ||
				!graph.containsKey(to)) {
			return false;
		}
		
		Node start = graph.get(from);
		
		ArrayList<Node> queue = new ArrayList<>();
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node current = queue.remove(0);
			
			current.isTested = true;
			
			System.out.println(current.name);
			
			if(current.name.equals(to)) {
				return true;
			}
			
			for(Link link : current.links) {
				
				if(!link.to.isTested &&
						!queue.contains(link.to)) {
					queue.add(link.to);
				}
			}
		}
		
		return false;
	}

}
