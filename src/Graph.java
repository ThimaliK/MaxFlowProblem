//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

public class Graph {

    //represents a weighted graph as an adjacency matrix
    final int [][] adjacencyMatrix;

    //length of the array is the number of nodes in the graph
    public Graph(int noOfNodes) {
        this.adjacencyMatrix = new int[noOfNodes][noOfNodes];
    }

    //if there is an edge connecting node u with node v, its capacity is element [u][v] of the adjacency matrix
    public void addEdge(int u, int v, int capacity) {
        adjacencyMatrix[u][v] = capacity;
    }

    public int getNoOfNodes() {
        return adjacencyMatrix.length;
    }

}
