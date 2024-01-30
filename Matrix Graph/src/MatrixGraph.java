public class MatrixGraph extends AbstractGraph{

    private int numV = getNumV();

    @Override
    public int getNumV() {
        return super.getNumV();
    }

    private int matrix [][] = new int [numV][numV];

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        double matrix[][] = new double[numV][numV];
        for (int i = 0; i < numV; i++){
            for (int j = 0; j < numV; j++){
                matrix[i][j] = '0';
            }
        }
    }

    @Override
    public void insert(Edge edge) {
        int weight = (int) edge.getWeight();

        matrix[edge.getSource()][edge.getDest()] = weight;
        if (!isDirected()){
            matrix[edge.getDest()][edge.getSource()] = weight;
        }
    }

    @Override
    public boolean isEdge(int source, int dest) {
        return matrix[source][dest] != 0;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        if (isEdge(source, dest)) {
            return new Edge(source, dest, matrix[source][dest]);
        }

        else{
            return new Edge(source, dest, Double.POSITIVE_INFINITY);
        }
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("\t\t");

        for (int row = 0; row < numV; row++){
            string.append(row + "\t\t");
        }

        string.append("\n");
        string.append("\t\t");

        for (int row = 0; row < numV; row++){
            string.append("-\t\t");
        }

        string.append("\n");

        for (int i = 0; i < numV; i++){
            string.append(i + " |" + "\t\t");
            for (int j = 0; j < numV; j++){
                string.append(matrix[i][j] + "\t\t");
            }
            string.append("\n");
        }
        return string.toString();
    }
}

