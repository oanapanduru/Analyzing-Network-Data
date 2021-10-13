package util;

import socialnetwork.graph.GraphMatrix;

public class FloydWarshall {

	public static int[][] floydWarshall(GraphMatrix graph) {
//		constructing a new matrix with the shortest distances between every pair of nodes
		int allDistancesMatrix[][] = graph.getCells();
		int i;
		int j;
		int k;
		for (k = 0; k < graph.getCells().length; k++) {
			for (i = 0; i < graph.getCells().length; i++) {
				for (j = 0; j < graph.getCells().length; j++) {
					if (allDistancesMatrix[i][k] != Integer.MAX_VALUE && allDistancesMatrix[k][j] != Integer.MAX_VALUE
							&& allDistancesMatrix[i][k] + allDistancesMatrix[k][j] < allDistancesMatrix[i][j])
						allDistancesMatrix[i][j] = allDistancesMatrix[i][k] + allDistancesMatrix[k][j];
				}
			}
		}
		return allDistancesMatrix;
	}

//	helper method for visualization purposes
	public static void printAllDistancesMatrix(int[][] allDistancesMatrix) {
		for (int i = 0; i < allDistancesMatrix.length; i++) {
			for (int j = 0; j < allDistancesMatrix.length; j++) {
				System.out.print(allDistancesMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
