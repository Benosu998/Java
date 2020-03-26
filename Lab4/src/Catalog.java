import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Catalog extends  CatalogIO{
    private ArrayList<Graph> graphs = new ArrayList<>();

    public Catalog(String pathString) {
        super(pathString);
    }

    public void add(Graph graph) {
        this.graphs.add(graph);
    }

    public void list() {
        for (int i = 0; i < graphs.size(); i++) {
            System.out.println(graphs.get(i));
        }
    }

    public void open(String fileName) {
        super.open(graphs,fileName);
    }

    public void save(String fileName) {
        super.save(this,fileName);
    }

    public void load(String fileName) {
        super.load(this,fileName);
    }
}
