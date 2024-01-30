import java.util.*;

public class MinimumSpanningTree {
    public static ArrayList<Edge> getMST(Graph graph){
        ArrayList<Edge> tree = new ArrayList<Edge>();
        int numV = graph.getNumV();
        int source = 0;

        //Hashset - A set where elements are not sorted.
        HashSet<Integer> vMinusU = new HashSet<Integer>(numV);

        //Priority Queue - A queue, every element has some priority value associated with it.
        PriorityQueue<Edge> pq = new PriorityQueue<>(numV,(edge1, edge2) -> Double.compare(edge1.getWeight(), edge2.getWeight())); //Don't get the order yet

        for(int i = 0; i < numV; i++) { //Initialize unvisited vertices (V-U)
            if (i != source) {
                vMinusU.add(i);
            }
        }
        //This iterates to all vertices
        int current = source;
        while (vMinusU.size() != 0){ //V-U (Unvisited vertices) needs to be empty! //This allows us to iterate to all vertices
            Iterator<Edge> it = graph.edgeIterator(current); //(e.g. from 0 to 2, 2 to 1) The dest of previous vertex will be the source of the next vertex

            while (it.hasNext()){ //This only iterates from one vertex to vertices attached to it (e.g. from 0 to 2,4,7)
               Edge edge = it.next();
               int dest = edge.getDest();
               if (vMinusU.contains(dest)){ //If unvisited
                   pq.add(edge); //Add to priority queue, not yet to tree because still not the least cost edge //In our previous example, this adds 0 2, 0 4, 0 7 in order (what order)
               }
            }

            //Turn edge & dest to null (There is 0 value for dest, that's why we will use -1)
            Edge edge = null;
            int dest = -1;

            //This will pick the lowest weight
            do{
                edge = pq.remove(); //0 2 (?)
                dest = edge.getDest(); // 2
            } while (!vMinusU.contains(dest)); //While visited??? //This removes everything(?) I DONT GET IT pq = [0 2 0 4 0 7] (V-U)' = [0]
            vMinusU.remove(dest); //
            tree.add(edge);
            current = dest;
        }

        return tree;
    }

    public static void printMST(ArrayList<Edge> tree) {
        int totalCost = 0;
        System.out.println("MST: ");

        for (int i = 0; i < tree.size(); i++){
            System.out.println(tree.get(i));
            totalCost += tree.get(i).getWeight();
        }

        System.out.print("Total Cost: ");
        System.out.print(totalCost);

    }
}
