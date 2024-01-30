import java.util.*;

/**
 * Implementation of Dijkstra's single-source shortest-path algorithm
 * 
 * From "Data Structures: Abstraction and Design Using Java, 2nd Edition"
 * by Elliot B. Koffman and Paul A.T. Wolfgang 
 *
 */
public class SingleSourceShortestPath {
	private static int NIL = -1;
	
	/**
	 * Dijktra's Single-Source Shortest-Path Algorithm
	 * 
	 * @param graph The weighted graph to be searched
	 * @param start The start vertex
	 * @param pred Output array to contain the predecessors 
	 * 			   in the shortest path
	 * @param dist Output array to contain the distance 
	 *             in the shortest path
	 */
	public static void dijkstrasAlgorithm(Graph graph, int start, int[] pred, double[] dist) {
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		// Initialize the hash table which acts as the priority queue 
		// in the lecture's pseudocode
		for(int i = 0; i < numV; i++) {
			if (i != start) {
				vMinusS.add(i);
			}
		}
		
		// Initializing the predecessor and shortest distance arrays
		for(int v : vMinusS) {
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();
		}
		
		// Main loop
		while(vMinusS.size() != 0) {
			// Find the value u in V - S with smallest dist[u].
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for(int v : vMinusS) {
				if (dist[v] < minDist) {
					minDist = dist[v];
					u = v;
				}
			}
			// Remove u from vMinusS
			vMinusS.remove(u);
			// Relax the distances
			for(int v : vMinusS) {
				if (graph.isEdge(u, v)) {
					double weight = graph.getEdge(u, v).getWeight();
					if (dist[u] + weight < dist[v]) {
						dist[v] = dist[u] + weight;
						pred[v] = u;
					}
				}
			}
		}
	}
	
	public static void printShortestPath(int[] pred, int source, int dest) {
		if (source == dest) {
			System.out.print(source);
		}
		else if (pred[dest] == NIL) {
			System.out.print("There is no shortest path from " + source
					+ " to " + dest);
		}
		else {
			printShortestPath(pred, source, pred[dest]);
			System.out.print(" " + dest);
		}
	}
}
