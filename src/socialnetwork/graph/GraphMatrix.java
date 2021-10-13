package socialnetwork.graph;

import util.FileLoader;

public class GraphMatrix implements Graph {

	private int[][] cells;
	private int size;

	public void initialize(int size) {
		cells = new int[size][size];
		this.size = size;

	}

	public int[][] getCells() {
		return cells;
	}

	public void addNode(int row, int col) {
		cells[row][col] = 1;

	}


//	helper method to construct the graph based on the input data
	@Override
	public void constructGraph(String filename) {
		// TODO Auto-generated method stub
		FileLoader.loadFileGraphMatrix(this, filename);
	}


//	helper method for visualization purposes
	public void printMatrix() {
		for (int i = 0; i < this.cells.length; i++) {
			for (int j = 0; j < this.cells.length; j++) {
				System.out.print(cells[i][j] + " ");
			}
			System.out.println();
		}
	}

}
