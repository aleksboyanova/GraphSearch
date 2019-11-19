package com.graph.search;

import java.util.ArrayList;

public class WeigthSearch extends BaseSearch {

	public WeigthSearch(Graph g) {
		super(g);
	}

	@Override
	public boolean checkForPath(String from, String to) {
		if(!graph.containsKey(from) ||
				!graph.containsKey(to)) {
			return false;
		}
		
		Node start = graph.get(from);
		ArrayList<Node> nodes = new ArrayList<>();
		
		nodes.add(start);
		
		while(!nodes.isEmpty()) {
			Node current = nodes.remove(0);
			
			current.isTested = true;
			System.out.println(current.name);
			
			if(current.name.equals(to)) {
				resetFlags();
				return true;
			}
			
			for(Link link : current.links) {
				if(!link.to.isTested &&
						!nodes.contains(link.to)) {
					addToNodes(link.to, nodes);
				}
			}
		}
		
		resetFlags();
		return false;
	}

	private void addToNodes(Node to, ArrayList<Node> nodes) {
			
		
		for(int i = 0; i < nodes.size(); i++) {
			if(to.weight < nodes.get(i).weight) {
				nodes.add(i, to);
				return;
			}
		}
		
		nodes.add(to);
	}

}
