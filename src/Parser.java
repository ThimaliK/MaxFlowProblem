//Name: Thimali Kannangara
//UoW ID: w1761084
//IIT ID: 2019303

import java.io.*;
import java.util.Scanner;

public class Parser {

    public Graph readFile(String fileName) {

        Graph graph = null;
        try {

            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            int edges = 0;
            while (myReader.hasNextLine() ) {
                String line = myReader.nextLine().trim();

                String[] split = line.split("\\s+");

                if(split.length == 1) {
                    int line0 = Integer.parseInt(line);
                    graph =  new Graph(line0);
                }

                else {
                    int u = Integer.parseInt(split[0]);
                    int v = Integer.parseInt(split[1]);
                    int capacity = Integer.parseInt(split[2]);
                    assert graph != null;
                    graph.addEdge(u, v, capacity);
                    edges++;
                }

            }

            assert graph != null;
//            network.displayAdjacencyMatrixData();
            System.out.println("");
            myReader.close();
            System.out.println("There are " + graph.getNoOfNodes() + " nodes in this graph");
            System.out.println("There are " + edges + " edges in this graph");
            return graph;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred...");
            e.printStackTrace();

        }

        return null;
    }
}
