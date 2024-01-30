import java.util.*;

/**
 * A ListGraph is an extension of the AbstractGraph abstract class
 * that uses an adjacency list to represent the edges.
 * 
 * From "Data Structures: Abstraction and Design Using Java, 2nd Edition"
 * by Elliot B. Koffman and Paul A.T. Wolfgang
 *
 */
public class ListGraph extends AbstractGraph {
	/**
	 * An array of List for the adjacency list
	 */
	private List<Edge>[] edges;

	/**
	 * Construct a graph with the specified number of 
	 * vertices and directionality
	 * @param numV The number of vertices
	 * @param directed The directionality flag
	 */
	public ListGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new List[numV];
		for(int i = 0; i < numV; i++) {
			edges[i] = new LinkedList<Edge>();
		}
	}
	
	/**
	 * Determine whether an edge exists.
	 * @param source The source vertex
	 * @param dest The destination vertex
	 * @return true if there is an edge from source to dest
	 */
	public boolean isEdge(int source, int dest) {
		return false;
//		return edges[source].contains(new Edge(source, dest));
		// Note: A dummy edge is created for the contains method to search for
		// We don't need weight in checking
	}
	
	/**
	 * Insert a new edge into the graph.
	 * @param edge The new edge
	 */
	public void insert(Edge edge) {
		edges[edge.getSource()].add(edge);
		if (!isDirected()) {
			edges[edge.getDest()].add(new Edge(edge.getDest(),
					edge.getSource(), edge.getWeight() ));
		}

	}
	
	/**
	 * Return an Iterator<Edge> object that can be used to iterate 
	 * through the edges adjacent to a given vertex.
	 * @return Iterator for the edges adjacent to source
	 */
	public Iterator<Edge> edgeIterator(int source) {
		return edges[source].iterator();
	}
	
	/**
	 * Get the edge between two vertices. If an 
	 * edge does not exist, an Edge with a weight 
	 * of Double.POSITVE_INFINITY is returned.
	 * @param source The source
	 * @param dest The destination
	 * @return the edge between these two vertices
	 */
	public Edge getEdge(int source, int dest) {
//		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
//		for(Edge edge : edges[source]) {
//			if (edge.equals(target)) {
//				return edge;	// Desired edge found, return it.
//			}
//		}
//
//		return target;			// Desired edge not found.
		return null;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(List<Edge> e : edges) {
			string.append(e + "\n");
		}

		return string.toString();
	}
}
