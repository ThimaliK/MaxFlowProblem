//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

import java.util.LinkedList;

public class MaximumFlow {

    public boolean breadthFirstSearch(int [][] adjacencyMatrix, int [] parentNodes, int source, int sink) {

        //to keep track of all visited nodes
        boolean [] visitedNodes = new boolean[adjacencyMatrix.length];
        for (int i=0; i<adjacencyMatrix.length; i++) {
            visitedNodes[i] = false;
        }

        //to keep track of the next child nodes to be visited
        LinkedList<Integer> queue = new LinkedList<>();

        //initially the source node is added
        queue.add(source);

        //visited state of source node (0th element) is set to true
        visitedNodes[source] = true;

        //since the source node has no parent, parentNodes[source] is set to -1
        parentNodes[source] = -1;

        //while there are nodes (meaning while queue is not empty)
        while (!queue.isEmpty()) {

            //the first added element is removed (FIFO)
            int previousNode = queue.poll();

            //checking for all edges in the graph
            for (int currentNode = 0; currentNode < adjacencyMatrix.length; currentNode++) {

                if (!visitedNodes[currentNode] && adjacencyMatrix[previousNode][currentNode] > 0) {

                    //if an edge is outgoing towards the sink node
                    if (currentNode == sink) {
                        //parent of the sink node is the node connected to the other end of that edge
                        parentNodes[currentNode] = previousNode;
                        //breadth first search is possible since the sink node has been reached
                        return true;
                    }

                    //if there is an edge, the node that the edge is out going towards is added to queue
                    queue.add(currentNode);

                    //parent of this node is the node connected to the other end of that edge
                    parentNodes[currentNode] = previousNode;

                    //visited state of this node is set to true
                    visitedNodes[currentNode] = true;
                }
            }
        }

        //if sink node is not reached, there is no path from source to sink, therefore false is returned
        return false;
    }

    public int getMaxFlow(Graph graph) {

        int source = 0;    //source node is always zero
        int sink = graph.getNoOfNodes() - 1;  //sink node is the last node numerically

        int previousNode;
        int currentNode;

        //to keep track of the augmenting path
        int[] parentNodes = new int[graph.getNoOfNodes()];

        //Initially, maximum flow is set be zero
        int maxFlow = 0;

        //while breadth first search is possible, an augmenting path is found
        while (breadthFirstSearch(graph.adjacencyMatrix, parentNodes, source, sink)) {

            System.out.print("\nAugmenting path = ");

            //Initially flow through the path is set to be the maximum integer value
            int pathFlow = Integer.MAX_VALUE;

            //starting from the sink, path is tracked through parent nodes and the biggest possible flow is found
            for (currentNode = sink; currentNode != source; currentNode = parentNodes[currentNode]) {
                previousNode = parentNodes[currentNode];
                pathFlow = Math.min(pathFlow, graph.adjacencyMatrix[previousNode][currentNode]);
            }

            //the path flow going through the edges used in augmenting path is deducted from residual graph
            //path flow is added to backward edges
            for (currentNode = sink; currentNode != source; currentNode = parentNodes[currentNode]) {
                System.out.print(currentNode + " <-- ");
                previousNode = parentNodes[currentNode];
                graph.adjacencyMatrix[previousNode][currentNode] -= pathFlow;
                graph.adjacencyMatrix[currentNode][previousNode] += pathFlow;
            }

            System.out.print(source);
            System.out.println("\nFlow units that can be transported through this path = " + pathFlow);
            System.out.println("Therefore, max flow is now " + maxFlow + " + " + pathFlow + " = " + (maxFlow+pathFlow));

            //flow going through each path is added to calculate maximum flow of the graph
            maxFlow += pathFlow;

        }

        //maximum flow is returned once there are no more paths from source node to sink node
        System.out.println("\nThere are no more paths that go from source node to sink node...\n");
        return maxFlow;

    }

}
