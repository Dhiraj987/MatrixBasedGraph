public class MatrixBasedGraphTemplate 
{
public static void main(String[] args)
{   MatrixBasedGraph flyUS = new MatrixBasedGraph(5);
    Listing v1 = new Listing("Philadelphia");
    Listing v2 = new Listing("New York");
    Listing v3 = new Listing("Boston");
    Listing v4 = new Listing("Los Angeles");
    Listing v5 = new Listing("Huston");

    // add the hub cities to the graph as vertices
    flyUS.insertVertex(1, v1);
    flyUS.insertVertex(2, v2);
    flyUS.insertVertex(3, v3);
    flyUS.insertVertex(4, v4);
    flyUS.insertVertex(5, v5);

    // add the routes to the graph as edges
    flyUS.insertEdge(1,2,1);
    flyUS.insertEdge(1,4,1);
    flyUS.insertEdge(2,3,1);
    flyUS.insertEdge(2,4,1);
    flyUS.insertEdge(3,2,1);
    flyUS.insertEdge(4,5,1);
    flyUS.insertEdge(5,1,1);
    flyUS.insertEdge(5,4,1);

    // output the hubs and the routes stored in the graph
    for(int i=1; i<=5; i++)
    {   System.out.print("hub " + i + "\'s ");
        flyUS.showInfo(i);
        System.out.println("its routes are: ");
        flyUS.showEdges(i);
    } //end the output loop
    
    System.out.println("\nDFS Performed");
    flyUS.DFS();
    flyUS.printPath(1, 5);
//    flyUS.DFSWithIndex(3); 
//    flyUS.printPath(3, 1);
  } //end the method main
} // end the application

