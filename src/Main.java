//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

public class Main {

    public static void main(String[] args) {

        Parser parser = new Parser();
        Graph graph = parser.readFile("ladder_1.txt");

        long startTime = System.nanoTime();
        MaximumFlow maximumFlow = new MaximumFlow();

        System.out.println("Therefore, Maximum Flow of the graph = " + maximumFlow.getMaxFlow(graph));

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Time taken = " + (duration/1000000000.000000000) + " seconds");

    }

}
