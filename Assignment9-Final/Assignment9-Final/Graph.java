import java.util.*;
import javax.swing.JOptionPane;

class Graph
{
    private final Listing[] vertex;
    private final int[][] edge;
    private final int max;
    private int numberOfVertices;
    private int nodeCheck = 0;
    private int selectNum = 0;

    Graph(final int g)
    {
        vertex = new Listing[g];
        edge = new int[g][g];
        max = g;
        numberOfVertices = 0;
    }
    private void depthFirstSearch(final int firstVertex)
    {
        int v;
        final Stack<Integer> nodeStack = new Stack<>();

        for(int i = 0; i<numberOfVertices; i++)
        {
            if (vertex[i] != null) {
                vertex[i].setPushed(false);
            }
        }
        nodeStack.push(firstVertex);
        vertex[firstVertex].setPushed(true);

        while (!nodeStack.empty())
        {
            v = nodeStack.pop();
            vertex[v].visit();
            nodeCheck++;
            for (int column = 0; column < numberOfVertices; column++)
            {

                if(edge[v][column] == 1 && vertex[column].getPushed())
                {
                    nodeStack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }
    private void breathFirstSearch(final int firstVertex)
    {
        int V;
        final Queue<Integer> nodeQueue = new LinkedList<>();

        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
                vertex[i].setPushed(false);
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPushed(true);

        while(!nodeQueue.isEmpty())
        {
            V = nodeQueue.remove();
            vertex[V].visit();
            nodeCheck++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if(edge[V][column] == 1 && vertex[column].getPushed())
                {
                    nodeQueue.add(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }

    private void dijkstra(final int firstVertex)
    {
        int v;
        final LinkedList<Integer> nodeQueue = new LinkedList<>();

        int i = 0;
        while (i < numberOfVertices)
        {
            if(vertex[i] != null)
                vertex[i].setPushed(false);
            i++;
        }
        nodeQueue.add(firstVertex);
        vertex[firstVertex].setPushed(true);

        while(!nodeQueue.isEmpty())
        {
            v = nodeQueue.remove();
            vertex[v].visit();
            nodeCheck++;
            for(int column = 0; column < numberOfVertices; column++)
            {
                if(edge[v][column] == 1 && vertex[column].getPushed())
                {
                    nodeQueue.add(column);
                    vertex[column].setPushed(true);
                }
            }
        }
    }

    private void insertVertex(final int vertexNumber, final Listing newListing)
    {
        if(vertexNumber >= max)
        {
            return;
        }
        vertex[vertexNumber] = newListing.deepCopy();
        numberOfVertices++;
    }

    private void insertEdge(final int fromVertex, final int toVertex)
    {
        if(vertex[fromVertex] == null || vertex[toVertex] == null)
            return;
        edge[fromVertex][toVertex] = 1;
    }

    void showVertex(final int vertexNumber)
    {
        System.out.print(vertex[vertexNumber]);
    }

    void showEdges(final int vertexNumber)
    {
        for(int column = 0; column < numberOfVertices; column++)
        {
            if(edge[vertexNumber][column] == 1)
            {
                System.out.println(vertexNumber + "," + column);
            }
        }
        System.out.println();
    }

    void initializeNodes(final Graph G, final int nodesNum)
    {
        final Random random = new Random();
        for (int i = 0; i < nodesNum; i++ )
        {
            final Listing v = new Listing(random.nextInt(300000) + 1);
            G.insertVertex(i, v);
        }

        final int vertexListNumber = G.vertex.length;
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nodesNum; i++ )
        {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < vertexListNumber; i++ )
        {
            final int randnum = random.nextInt(5);
            for (int j = 0; j < randnum; j++ )
            {
                final int rand = random.nextInt(5);
                G.insertEdge(i, list.get(rand));
            }
        }

    }

    int search()
    {
        final String search = JOptionPane.showInputDialog("Enter a Node to search:");
        try
        {
            if(search != null)
            {
                selectNum = Integer.parseInt(search);
            }
        }
        catch (final NumberFormatException e)
        {
            selectNum = 0;
        }
        return selectNum;
    }

    private int selectPane()
    {
        final String paneSelect = JOptionPane.showInputDialog("Choose one of the search method:" +
                "\n\t1: Use Depth-First Search" +
                "\n\t2: Use Breadth-First Search" +
                "\n\t3: Use Dijkstra's Search" +
                "\n\t4: Close the Program");
        int selectNum = 0;

        try{
            if(paneSelect != null)
            {
                selectNum = Integer.parseInt(paneSelect);
            }
        }
        catch (final NumberFormatException ignored)
        {
        }
        return selectNum;
    }

    void algorithmChoice(final Graph graph, final int vertexStart)
    {
        int paneNum = 0;
        while (paneNum != 4)
        {
            paneNum = selectPane();
            switch (paneNum)
            {
                case 1:
                    graph.depthFirstSearch(vertexStart);
                    System.out.println("Nodes that are counted were: " + nodeCheck);
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    graph.breathFirstSearch(vertexStart);
                    System.out.println("Nodes that are counted were: " + nodeCheck);
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    graph.dijkstra(vertexStart);
                    System.out.println("Nodes that are counted were: " + nodeCheck);
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Enter 4 to quit the program.");
                    break;
            }
        }
    }


}