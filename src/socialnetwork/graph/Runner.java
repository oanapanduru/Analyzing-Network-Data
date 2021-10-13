package socialnetwork.graph;

import java.util.Map;

import util.DegreeOfSeparation;
import util.FloydWarshall;
import util.MinimumDominatingSet;
import util.Utils;

public class Runner {

	public static void main(String[] args) {
//		RUNNING DEGREE OF SEPARATION
		DegreeOfSeparationRunner();
		System.out.println();
//		RUNNING MINIMUM DOMINATING SET
		MinimumDominatingSetRunner();
	}

	public static void DegreeOfSeparationRunner() {
//		alternative data files for degree of separation 
//		graph.constructGraph("data/small_test.txt");
//		graph.constructGraph("data/small_madeup.txt");
//		graph.constructGraph("data/facebook_1000.txt");
//      graph.constructGraph( "data/twitter_combined.txt");
		System.out.println("Degree of separation ");
		Graph graph = new GraphMatrix();
		graph.constructGraph("data/facebook_2000.txt");
		Utils.prepareMatrix(((GraphMatrix) graph));
		int[][] distances = FloydWarshall.floydWarshall((GraphMatrix) graph);
		Map<Integer, Integer> distanceFrequencies = Utils.distanceFrequencies(distances);
		System.out.println(DegreeOfSeparation.degreeOfSeparation(distanceFrequencies) + " other nodes.");
	}

	public static void MinimumDominatingSetRunner() {
//		alternative data files for minimum dominating set 
//		graphAdj.constructGraph("data/small_madeup.txt");
//		graphAdj.constructGraph("data/small_test.txt");
//      graphAdj.constructGraph( "data/facebook_1000.txt");
//      graphAdj.constructGraph( "data/twitter_combined.txt");
		System.out.println("Minimum dominating set ");
		Graph graphAdj = new GraphAdjList();
		graphAdj.constructGraph("data/facebook_2000.txt");
		System.out.print(MinimumDominatingSet.minimumDominatingSet((GraphAdjList) graphAdj) + " nodes.");
	}
}
