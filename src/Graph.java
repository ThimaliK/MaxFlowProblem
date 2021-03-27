//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

public class Graph {

    final int [][] adjacencyMatrix;

    public Graph(int noOfNodes) {
        this.adjacencyMatrix = new int[noOfNodes][noOfNodes];
    }

    public void insert(int u, int v, int capacity) {
        adjacencyMatrix[u][v] = capacity;
    }

    public int getNoOfNodes() {
        return adjacencyMatrix.length;
    }

    public void displayAdjacencyMatrixData() {

        System.out.print("* ");

        for (int i=0; i<adjacencyMatrix.length; i++) {
            System.out.print(i+" ");
        }

        System.out.println("");

        for (int i = 0; i< adjacencyMatrix.length; i++) {
            System.out.print(i +" ");
            for (int j = 0; j< adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j]+ " ");
            }
            System.out.println("");
        }

    }

}
