public class Edge {
    private Node node1;
    private Node node2;
    private int cost;
    private boolean twoWayStreet;
    Edge()
    {}
    Edge(Node node1,Node node2,int cost,boolean twoWayStreet)
    {
        this.node1=node1;
        this.node2=node2;
        this.cost=cost;
        this.twoWayStreet=twoWayStreet;
    }

    public int getCost() {
        return cost;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }
    public boolean getTwoWayStreet() {
        return this.twoWayStreet;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public void setTwoWayStreet(boolean twoWayStreet) {
        this.twoWayStreet = twoWayStreet;
    }

    @Override
    public String toString() {
        return "(" + this.node1.toString() + "," + this.node2.toString() + "," + this.cost + "," + this.twoWayStreet +")";
    }
}
