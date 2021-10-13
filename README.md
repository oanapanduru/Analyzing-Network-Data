# Analyzing-Network-Data
University of California San Diego Capstone project (on Coursera).

The scope of the project is to analyze social network data in order to determine:

(a) the propagation of information in a social network. How many people need to make an announcement/post 
in order for that announcement/post to reach everyone? (Based on the dominating set problem).
The proposed algorithm is a Greedy algorithm that will compute the minimum dominating sets. It will search
for the subset of vertices that will satisfy the condition that every vertex, not in the subset, is adjacent
to at least one vertex in the set. Finding such a subset will in fact represent the subset of the vertices
that have the most connections(edges) and therefore can reach most other vertices. The graph is constructed
having an adjacency list, representing a directed unweighted graph.

(b) the degree of separation between people in a social network.  What is the number of connections by which
each individual is connected with any other individual.
The proposed algorithm is the Floyd–Warshall algorithm. It will find the weights (length of the paths) of the
shortest paths between all pairs of vertices. The algorithm will use a matrix and will return a matrix of size
V*V. Having computed the shortest paths between each pair of vertices will then allow to search for the most
common value of such weights. The found most common value will represent the approximated minimal number of nodes
between any vertices, namely the most common degree of separation. The graph is constructed as a matrix, 
representing a directed weighted graph.

