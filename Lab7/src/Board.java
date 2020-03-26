public class Board {
    private final Graph complete;
    private int size;
    public Board() {
        Graph graph = new Graph();
        for(int i=1;i<9;i++){
            for(int j=i+1;j<=10;j++){
                graph.add(new Edge(i,j));
            }
        }
        graph.shuffle();
        this.complete=graph;
    }
    public Board(int size){
        this.size=size;
        Graph graph = new Graph();
        for(int i=1;i<size-1;i++){
            for(int j=i+1;j<=size;j++){
                graph.add(new Edge(i,j));
            }
        }
        graph.shuffle();
        this.complete=graph;
    }

    public int getSize() {
        return size;
    }

    public synchronized Edge extract() {
        // replace the dots so that the board is thread-safe
        Edge edge = complete.pollFirst();
        return edge;
    }
    public boolean isEmpty() {
        return complete.isEmpty();
    }
}