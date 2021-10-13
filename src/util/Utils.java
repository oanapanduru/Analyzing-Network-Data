package util;

import java.util.HashMap;
import java.util.Map;

import socialnetwork.graph.GraphMatrix;

public class Utils {

//  helper method used in the Floyd Warshall algorithm 
//	as a prerequisite the matrix should be computed as
//	a all distances matrix having distances between nodes
//	calculated and infinity values for nodes without connection
	public static void prepareMatrix(GraphMatrix graph) {
		for (int i = 0; i < graph.getCells().length; i++) {
			for (int j = 0; j < graph.getCells().length; j++) {
				if (graph.getCells()[i][j] != 1 && i != j) {
					graph.getCells()[i][j] = Integer.MAX_VALUE;

				}
			}
		}
	}

//  helper method that will map the distances in the matrix with their frequency
	public static Map<Integer, Integer> distanceFrequencies(int[][] allDistancesMatrix) {
		Map<Integer, Integer> frequenciesMap = new HashMap<>();
		for (int i = 0; i < allDistancesMatrix.length; i++) {
			for (int j = 0; j < allDistancesMatrix.length; j++) {
				if (allDistancesMatrix[i][j] != 0) {
					if (!frequenciesMap.containsKey(allDistancesMatrix[i][j])) {
						frequenciesMap.put(allDistancesMatrix[i][j], 1);
					} else {
						frequenciesMap.put(allDistancesMatrix[i][j], frequenciesMap.get(allDistancesMatrix[i][j]) + 1);
					}
				}
			}
		}
		return frequenciesMap;
	}

}
