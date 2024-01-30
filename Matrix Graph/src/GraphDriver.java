import java.io.*;
import java.util.*;

public class GraphDriver {

	/*
	 * Usage: java GraphDriver filename directed
	 * filename - filename containing the number of vertices followed the edges of the graph
	 * directed - 1 = directed graph, 0 = undirected graph
	 */
	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File(args[0]));
			boolean isDirected = Integer.parseInt(args[1]) == 1 ? true : false;
			System.out.println(isDirected);
//			Graph g1 = AbstractGraph.createGraph(file, isDirected, "List");
//			System.out.println(g1);
			Graph g2 = AbstractGraph.createGraph(file, isDirected, "Matrix");
			System.out.println(g2);
			file.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("File " + args[0] + " not found!!!"); 
		}
	}

}
