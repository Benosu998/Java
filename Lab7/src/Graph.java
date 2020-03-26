import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private List<Edge> edgeList = new ArrayList<>();

    Graph() {

    }

    void add(Edge edge) {
        this.edgeList.add(edge);
    }

    void removeEdge(Edge edge) {
        this.edgeList.remove(edge);
    }

    void shuffle() {
        Collections.shuffle(edgeList);
    }

    Edge pollFirst() {
        Edge poolEdge = edgeList.get(1);
        edgeList.remove(1);
        return poolEdge;
    }

    boolean isEmpty() {
        return edgeList.isEmpty();
    }

    boolean isSpanningTree(int size) {
        int[] v = new int[size];
        for (int i = 0; i < edgeList.size(); i++) {
            v[edgeList.get(i).getFirst()-1] = 1;
            v[edgeList.get(i).getLast()-1] = 1;
        }
        for (int i = 0; i < size; i++)
            if (v[i] != 1)
                return false;
        return true;
    }

    @Override
    public String toString() {
        String aux="["+edgeList.get(0).getFirst()+" "+edgeList.get(0).getLast()+"]";
        for(int i=1;i<edgeList.size();i++){
            aux+="["+edgeList.get(i).getFirst()+" "+edgeList.get(i).getLast()+"]";
        }
        return aux;

    }
}
