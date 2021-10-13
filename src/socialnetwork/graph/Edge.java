package socialnetwork.graph;

public class Edge implements Comparable {

	private Node parent;
	private Node neighbor;
	
	public Edge(Node parent, Node neighbor) {
		this.parent = parent;
		this.neighbor = neighbor;
	}

	public Node getParent() {
		return parent;
	}

	public Node getNeighbor() {
		return neighbor;
	}

	@Override
	public int compareTo(Object o) {
//		 TODO Auto-generated method stub
		Edge m = (Edge) o;
		int score = 0;
		if ((this.getParent().getId() < m.getParent().getId())
				&& (this.getNeighbor().getId() < m.getNeighbor().getId())) {
			score = -1;
		} else if ((this.getParent().getId() > m.getParent().getId())
				&& (this.getNeighbor().getId() > m.getNeighbor().getId())) {
			score = 1;
		}
		return score;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((neighbor == null) ? 0 : neighbor.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (neighbor == null) {
			if (other.neighbor != null)
				return false;
		} else if (!neighbor.equals(other.neighbor))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [parent=" + parent + ", neighbor=" + neighbor + "]";
	}

}
