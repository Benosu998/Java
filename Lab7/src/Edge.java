public class Edge {
    private int first;
    private int last;
    Edge()
    {

    }
    Edge(int first,int last){
        this.first=first;
        this.last=last;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
