//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

public class Graph {

    private final int noOfNodes;
    private final int [][] adjacencyMatrix;

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public Graph(int noOfNodes) {
        this.noOfNodes = noOfNodes;
        this.adjacencyMatrix = new int[noOfNodes][noOfNodes];
    }

    public void addEdge(int u, int v, int capacity) {
        adjacencyMatrix[u][v] = capacity;
    }

    public void search(int u, int v) {

    }

    public void delete(int u, int v) {
        adjacencyMatrix[u][v] = 0;
    }

    public void displayAdjacencyMatrixData() {

        System.out.print("*  ");

        for (int i=0; i<noOfNodes; i++) {
            System.out.print(i+"  ");
        }

        System.out.println("");

        for (int i = 0; i< noOfNodes; i++) {
            System.out.print(i +"  ");
            for (int j = 0; j< noOfNodes; j++) {
                System.out.print(adjacencyMatrix[i][j]+ "  ");
            }
            System.out.println("");
        }

    }

}
