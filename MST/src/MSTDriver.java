import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MSTDriver {
    public static void main(String[] args){
        try {
            Scanner file = new Scanner(new File(args[0]));
            boolean isDirected = Integer.parseInt(args[1]) == 1 ? true : false;
            Graph g = AbstractGraph.createGraph(file, isDirected, "List");

            ArrayList<Edge> tree = MinimumSpanningTree.getMST(g);
            MinimumSpanningTree.printMST(tree);

            file.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("File " + args[0] + " not found!!!");
        }
    }
}

