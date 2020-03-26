public class Graph {
    private String graphName;
    private String tgfPath;
    private String imgPath;

    Graph() {

    }

    Graph(String graphName, String tgfPath, String imgPath) {
        this.graphName = graphName;
        this.tgfPath = tgfPath;
        this.imgPath = imgPath;
    }

    public String getGraphName() {
        return graphName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getTgfPath() {
        return tgfPath;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setTgfPath(String tgfPath) {
        this.tgfPath = tgfPath;
    }

    @Override
    public String toString() {
        return "[ " + graphName + " , " + tgfPath + " , " +imgPath +" ]";
    }
}
