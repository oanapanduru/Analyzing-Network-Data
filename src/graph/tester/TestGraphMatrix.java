package graph.tester;

import java.util.Map;

import org.junit.Test;

import socialnetwork.graph.Graph;
import socialnetwork.graph.GraphMatrix;
import util.DegreeOfSeparation;
import util.FloydWarshall;
import util.Utils;

public class TestGraphMatrix {

	@Test
	public void testConstructMatrix() {
		System.out.println("testing testConstructMatrix()");
		Graph graph = new GraphMatrix();
		graph.constructGraph("data/small_madeup.txt");
//		graph.constructGraph("data/small_test.txt");
//      graph.constructGraph( "data/facebook_1000.txt");
//      graph.constructGraph( "data/facebook_2000.txt");
//      graph.constructGraph( "data/twitter_combined.txt");
		((GraphMatrix) graph).printMatrix();
		System.out.println();
	}

	@Test
	public void testPrepareMatrix() {
		System.out.println("testing testPrepareMatrix()");
		Graph graph = new GraphMatrix();
		graph.constructGraph("data/small_madeup.txt");
//		graph.constructGraph("data/small_test.txt");
//      graph.constructGraph( "data/facebook_1000.txt");
//      graph.constructGraph( "data/facebook_2000.txt");
//      graph.constructGraph( "data/twitter_combined.txt");
		Utils.prepareMatrix(((GraphMatrix) graph));
		((GraphMatrix) graph).printMatrix();
		System.out.println();
	}

	@Test
	public void testFloydWarshall() {
		System.out.println("testing testFloydWarshall()");
		Graph graph = new GraphMatrix();
		graph.constructGraph("data/small_madeup.txt");
//		graph.constructGraph("data/small_test.txt");
//      graph.constructGraph( "data/facebook_1000.txt");
//      graph.constructGraph( "data/facebook_2000.txt");
//      graph.constructGraph( "data/twitter_combined.txt");
		Utils.prepareMatrix(((GraphMatrix) graph));
		int[][] distances = FloydWarshall.floydWarshall((GraphMatrix) graph);
		FloydWarshall.printAllDistancesMatrix(distances);
		System.out.println();
	}

	@Test
	public void testConstructFrequenciesMap() {
		System.out.println("testing testConstructFrequenciesMap()");
		Graph graph = new GraphMatrix();
//		graph.constructGraph("data/small_test.txt");
//		graph.constructGraph("data/small_madeup.txt");
      graph.constructGraph( "data/facebook_1000.txt");
//      graph.constructGraph( "data/facebook_2000.txt");
//      graph.constructGraph( "data/twitter_combined.txt");
		Utils.prepareMatrix(((GraphMatrix) graph));
		int[][] distances = FloydWarshall.floydWarshall((GraphMatrix) graph);
		System.out.println(Utils.distanceFrequencies(distances));
		System.out.println();
	}

	@Test
	public void testDegreeOfSeparation() {
		System.out.println("testing testDegreeOfSeparation()");
		Graph graph = new GraphMatrix();
//		graph.constructGraph("data/small_test.txt");
//		graph.constructGraph("data/small_madeup.txt");
		graph.constructGraph("data/facebook_1000.txt");
//      graph.constructGraph( "data/facebook_2000.txt");
//      graph.constructGraph( "data/twitter_combined.txt");
		Utils.prepareMatrix(((GraphMatrix) graph));
		int[][] distances = FloydWarshall.floydWarshall((GraphMatrix) graph);
		Map<Integer, Integer> distanceFrequencies = Utils.distanceFrequencies(distances);
		System.out.println(DegreeOfSeparation.degreeOfSeparation(distanceFrequencies));
		System.out.println();
	}

}
