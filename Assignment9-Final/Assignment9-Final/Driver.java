public class Driver
{
    public static void main(String[] args)
    {
        int nodesNum = 7000; //In the assignemnt you told us to generate a graph with 100,000 nodes when i tried that i got an error 
                             //and that was java.lang.outofmemoryerror so i had to use a smaller number to work.
        Graph graph = new Graph(nodesNum);
        graph.initializeNodes(graph, nodesNum);

        for(int i = 0; i<5; i++)
        {
            System.out.print("Node " + i + "\'s ");
            graph.showVertex(i);
            System.out.print("The routes were:\n");
            graph.showEdges(i);
        }

        int select = graph.search();
        graph.algorithmChoice(graph, select);
    }
}