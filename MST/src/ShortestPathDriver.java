import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortestPathDriver {

	public static void main(String[] args) {
		try {
			Scanner file = new Scanner(new File(args[0]));
			boolean isDirected = Integer.parseInt(args[1]) == 1 ? true : false;			
			Graph g = AbstractGraph.createGraph(file, isDirected, "List");
			
			int[] pred = new int[g.getNumV()];
			double[] cost = new double[g.getNumV()];
			
			int source = 0;
			int dest = 6;
			SingleSourceShortestPath.dijkstrasAlgorithm(g, source, pred, cost);			
			System.out.println("Cost of the shortest path from 0 to " + dest + ": " + cost[dest]);
			System.out.println("Shortest path from 0 to " + dest + ": ");
			SingleSourceShortestPath.printShortestPath(pred, source, dest);
			
			file.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("File " + args[0] + " not found!!!"); 
		}
	}

}
