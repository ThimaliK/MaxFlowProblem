//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input file name:");
        String fileName = scanner.nextLine();

        //graph is created after reading the text file using the parser
        Parser parser = new Parser();
        Graph graph = parser.readFile("input_files/"+fileName+".txt");

        MaximumFlow maximumFlow = new MaximumFlow();

        //timer starts with the start of the method which begins the algorithm
        long startTime = System.nanoTime();
        System.out.println("Therefore, Maximum Flow of the graph = " + maximumFlow.getMaxFlow(graph));

        //timer ends as soon as the maximum flow is returned
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Time taken = " + (duration/1000000000.00) + " seconds");

    }

}
