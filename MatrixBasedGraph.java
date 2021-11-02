
import java.util.ArrayDeque;

public class MatrixBasedGraph {

    Node vertex[];  //the reference to the vertex array
    int edge[][];  // references to the adjacency matrix array
    int max, numberOfVertices;
    int time; // for the DFS and DFSVisit methods

    public MatrixBasedGraph(int n) {
        vertex = new Node[n + 1]; // allocation of the vertex array
        edge = new int[n + 1][n + 1];   // adjacency matrix with all elements set to 0
        max = n;
        numberOfVertices = 0;
    }

    public boolean insertVertex(int vertexNumber, Listing newListing) {
        if (vertexNumber > max) //the graph is full
        {
            return false;
        }
        vertex[vertexNumber] = new Node(newListing);
        numberOfVertices++;
        return true;
    }

    public boolean insertEdge(int fromVertex, int toVertex, int weight) {
        if (vertex[fromVertex] == null || vertex[toVertex] == null) // non-existent vertex
        {
            return false;
        }
        edge[fromVertex][toVertex] = weight;
        return true;
    }

    public void showVertex(int vertexNumber) {
        System.out.println(vertex[vertexNumber]);
    }

    public void showEdges(int vertexNumber) //edges emanating from vertexNumber
    {
        for (int column = 1; column <= numberOfVertices; column++) {
            if (edge[vertexNumber][column] != 0) // there is an edge
            {
                System.out.println(vertexNumber + "," + column);
            }
        }
    }

    public void showInfo(int vertexNumber) {
        System.out.println(vertex[vertexNumber].info.toString());
    }

    public void DFS() {
        //add book's code here
        
        for (int i = 1; i <= max; i++){
            vertex[i].color = 'W' ;
            vertex[i].d = 0;
            vertex[i].pi = Integer.MIN_VALUE;
        }
        int time = 0;
        
       for (int u = 1; u<= max; u++){
           if (vertex[u].color == 'W') {
               DFSVisit(u);
           }
       }
    }

    private void DFSVisit(int u) {
        // add book's code here
        
        time += 1;
        vertex[u].d = time;
        vertex[u].color = 'G';
        for (int v = 1; v <= max; v++){
            if (edge[u][v]!= 0) {
                vertex[v].pi = u;
                if (vertex[v].color=='W')
                 DFSVisit(v);
            }
        }
        vertex[u].color = 'B';
        time += 1;
        vertex[u].f = time;

        System.out.println("vertex " + u + " its d/f is: " + vertex[u].d
                + "/" + vertex[u].f);
    }
    
    
    public void DFSWithIndex(int u){
        for (int i = 1; i <= max; i++){
            vertex[i].color = 'W' ;
            vertex[i].d = 0;
            vertex[i].pi = Integer.MIN_VALUE;
        }
        int time = 0;
        
        for (int j = 1; j<= max; j++){
            if (vertex[u].color == 'W') {
            u ++;
            if (u == max) {
                u = 1;
               DFSVisit(u);
           }
       }
        }
    }

    private class Node {

        private char color;
        private int d; // dicovered time
        private int f; //finish time
        private int pi;
        private Listing info;

        public Node(Listing info) {
            this.info = info.deepCopy();
        }
    }

    public void printPath(int s, int v)//verticies on path from s to v
    {
        if (v == s) {
            System.out.println(s);
            System.out.println("From " + s + " " + vertex[s].info);
        } else if (vertex[v].pi == Integer.MIN_VALUE) {
//            System.out.println("no path from " + s + " to " + v + " exists");
        } else {
            printPath(s, vertex[v].pi);
            System.out.println("to " + v + " " + vertex[v].info);
        }
    }
}// end of SimpleGraph class

