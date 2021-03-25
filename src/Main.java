//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        Graph graph = parser.readFile("bridge_3.txt");

        MaximumFlow maximumFlow = new MaximumFlow();

        System.out.println("There are " + graph.getNoOfNodes() + " nodes in this graph");

        double startTime = System.nanoTime();
        System.out.println("Therefore, Maximum Flow of the graph = " + maximumFlow.getMaxFlow(graph));
        double endTime = System.nanoTime();
        double duration = (endTime - startTime);

        System.out.println("Time taken = " + (duration/1000000000.000000000) + " seconds");

    }

}
