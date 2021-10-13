package socialnetwork.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FileLoader;

public class GraphAdjList implements Graph {

	private int numberOfVertices;
	private int numberOfEdges;
	private Map<Node, List<Edge>> map;

	public GraphAdjList() {
		numberOfVertices = 0;
		numberOfEdges = 0;
		map = new HashMap<Node, List<Edge>>();
	}
	
	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	public Map<Node, List<Edge>> getMap() {
		return map;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public void setNumberOfEdges(int numberOfEdges) {
		this.numberOfEdges = numberOfEdges;
	}

	public void setMap(Map<Node, List<Edge>> map) {
		this.map = map;
	}


	public void addVertex(Node num) {
		// TODO Auto-generated method stub
		if(map.get(num) == null) {
			ArrayList<Edge> neighbors = new ArrayList<Edge>();
			map.put(num, neighbors);
			numberOfVertices++;
		}
	}
	
	public void addEdge(Node from, Edge to) {
		// TODO Auto-generated method stub
		(map.get(from)).add(to);
		numberOfEdges++;
	}
	

//	helper method to construct the graph based on the input data
	@Override
	public void constructGraph( String filename) {
		// TODO Auto-generated method stub
		FileLoader.loadFileGraphAdjList( this, filename);
	}


//	helper method for visualization purposes
	public void printGraphAdjList() {
		for(Node node:map.keySet()) {
			System.out.println(map.get(node));
		}
	}
	
}
