import java.util.ArrayList;
import java.util.Comparator;

public class TravelMap {
    private ArrayList<Node> nodes= new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    public void addNode(Node node)
    {
        this.nodes.add(node);
    }
    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
    }
    public void addEdge(Node node1,Node node2,int cost)
    {
        Edge edge= new Edge(node1,node2,cost,true);
        this.edges.add(edge);
    }
    public void addEdge(Node node1,Node node2,int cost,boolean twoWayStreet)
    {
        Edge edge= new Edge(node1,node2,cost,twoWayStreet);
        this.edges.add(edge);
    }
    TravelMap()
    {
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        ArrayList<Node> nodesSorted=this.nodes;
        nodesSorted.sort(Comparator.comparing(Node::toString));
        return nodesSorted;

    }
    @Override
    public String toString() {
        return this.getNodes().toString() + this.getEdges().toString();
    }
}
