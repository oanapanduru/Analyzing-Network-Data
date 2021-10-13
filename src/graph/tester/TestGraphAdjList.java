package graph.tester;

import org.junit.Test;

import socialnetwork.graph.Graph;
import socialnetwork.graph.GraphAdjList;
import util.MinimumDominatingSet;

public class TestGraphAdjList {
	@Test
	public void testConstructGraphAdjList() {
		System.out.println("testing testConstructGraphAdjList()");
		Graph graphAdj = new GraphAdjList();
//		graphAdj.constructGraph("data/small_madeup.txt");
		graphAdj.constructGraph("data/small_test.txt");
//      graphAdj.constructGraph( "data/facebook_1000.txt");
//      graphAdj.constructGraph( "data/facebook_2000.txt");
//      graphAdj.constructGraph( "data/twitter_combined.txt");
		((GraphAdjList) graphAdj).printGraphAdjList();
		System.out.println();

	}
	
	@Test
	public void testMinimumDominatingSet() {
		System.out.println("testing testMinimumDominatingSet()");
		Graph graphAdj = new GraphAdjList();
//		graphAdj.constructGraph("data/small_madeup.txt");
//		graphAdj.constructGraph("data/small_test.txt");
//      graphAdj.constructGraph( "data/facebook_1000.txt");
//      graphAdj.constructGraph( "data/facebook_2000.txt");
      graphAdj.constructGraph( "data/twitter_combined.txt");
//		((GraphAdjList) graphAdj).printGraphAdjList();
		System.out.println(MinimumDominatingSet.minimumDominatingSet((GraphAdjList) graphAdj));
		System.out.println();
	}
}
