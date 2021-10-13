/**
 * @author UCSD MOOC development team
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import socialnetwork.graph.Edge;
import socialnetwork.graph.GraphAdjList;
import socialnetwork.graph.Node;

public class FileLoader {

//	loading file and constructing adjacency list graph - used for the minimum dominating set algorithm
	public static void loadFileGraphAdjList(GraphAdjList graphAdjList, String filename) {
		Set<Node> visitedNodes = new HashSet<Node>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		while (scanner.hasNextInt()) {
			Node nodeOne = new Node(scanner.nextInt());
			Node nodeTwo = new Node(scanner.nextInt());
			if (!visitedNodes.contains(nodeOne)) {
				graphAdjList.addVertex(nodeOne);
				visitedNodes.add(nodeOne);
			}
			if (!visitedNodes.contains(nodeTwo)) {
				graphAdjList.addVertex(nodeTwo);
				visitedNodes.add(nodeTwo);
			}
			graphAdjList.addEdge(nodeOne, new Edge(nodeOne, nodeTwo));
		}

		scanner.close();
	}

//	loading file and constructing matrix graph - used for the degree of separation algorithm  
	public static void loadFileGraphMatrix(socialnetwork.graph.GraphMatrix graphMatrix, String filename) {
		BufferedReader reader = null;
		try {
			String nextLine;
			int currentRow = 0;
			int currentColumn = 0;
			int size = 0;
			// transforming input data into zero indexed data
			SortedSet<Integer> nodeIndexes = new TreeSet<>();
			Map<Integer, Integer> nodeLinks = new HashMap<>();
			reader = new BufferedReader(new FileReader(filename));
			while ((nextLine = reader.readLine()) != null) {
				String[] inputData = nextLine.split(" ");
				currentRow = Integer.parseInt(inputData[0]);
				currentColumn = Integer.parseInt(inputData[1]);
				nodeIndexes.add(currentRow);
				nodeIndexes.add(currentColumn);
			}
			size = nodeIndexes.size();
			int i = 0;
			for (Integer n : nodeIndexes) {
				nodeLinks.put(n, i);
				i++;
			}
			// construct the graph considering the zero indexed data as I only need the
			// matrix showing connections between nodes
			graphMatrix.initialize(size);
			reader.close();
			reader = new BufferedReader(new FileReader(filename));
			while ((nextLine = reader.readLine()) != null) {
				String[] inputData = nextLine.split(" ");
				currentRow = Integer.parseInt(inputData[0]);
				currentColumn = Integer.parseInt(inputData[1]);
				graphMatrix.addNode(nodeLinks.get(currentRow), nodeLinks.get(currentColumn));
			}
			reader.close();
		} catch (IOException e) {
			System.err.println("problem with " + filename);
			e.printStackTrace();
		}
	}

}
