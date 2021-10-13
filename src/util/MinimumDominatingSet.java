package util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import socialnetwork.graph.Edge;
import socialnetwork.graph.GraphAdjList;
import socialnetwork.graph.Node;

public class MinimumDominatingSet {

	public static int minimumDominatingSet(GraphAdjList graph) {
//		constructing set with all of the nodes in the graph
		Set<Node> allNodesOfTheGraph = new HashSet<Node>();
		for (Node node : graph.getMap().keySet()) {
			allNodesOfTheGraph.add(node);
		}
//		initializing empty set that I will use for the nodes that are found as dominant
		Set<Node> dominantSet = new HashSet<>();
		while (!allNodesOfTheGraph.isEmpty()) {
			Node nodeFound = null;
			int max = 0;
			for (Node node : allNodesOfTheGraph) {
//				searching for the node with the most connections
				if (graph.getMap().get(node).size() > max) {
					max = graph.getMap().get(node).size();
					nodeFound = node;
				}
			}

			if (nodeFound == null) {
//				System.out.println("unconnected nodes " + vertices.size());
				
//				nodes without connections will be added individually to the dominating set 
//				as they cannot be reached from any other nodes
				for (Iterator<Node> iterator = allNodesOfTheGraph.iterator(); iterator.hasNext();) {
					Node element = iterator.next();
					dominantSet.add(element);
					iterator.remove();
				}
			} else {
//				the node that was found to have the most connections will be added to the dominating set
				dominantSet.add(nodeFound);
				allNodesOfTheGraph.remove(nodeFound);
				List<Edge> neighbors = graph.getMap().get(nodeFound);
				if (neighbors.size() > 0) {
					for (Edge edge : neighbors) {
						if (allNodesOfTheGraph.contains(edge.getNeighbor())) {
//							the connections/neighbors of the node found to have the most connections will be
//							removed from the initial set of nodes as they no longer need to be inspected because
//							the already can be reached
							allNodesOfTheGraph.remove(edge.getNeighbor());
						}
					}
				}
			}

		}
		System.out.print("Considering the given dataset the minimum number of nodes in a dominating set is ");
		return dominantSet.size();
	}

}
