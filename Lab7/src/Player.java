public class Player implements Runnable {
    private final int THINKING_TIME=1000;
    private String name;
    private Game game;
    private Graph graph;
    Player(){
        this.name="John Doe";
        graph=new Graph();
    }
    Player(String name){
        this.name=name;
        graph=new Graph();
    }
    public void setGame(Game game){
        this.game=game;
    }
    private boolean play() throws InterruptedException {
        if(this.game.haveWinner())
        {
            System.out.println("["+this.name+"]: Jucatorul casstigator este "+this.game.getWinner());
            return false;
        }
        Board board = game.getBoard();
        if (board.isEmpty()) { return false; }
        graph.add( board.extract() );
        Thread.sleep(THINKING_TIME); //declare this constant
        if (graph.isSpanningTree(game.getBoard().getSize())) {
            game.setWinner(this);
        }
        return true;
    }
    public void run(){
        try {
            while(this.play())
            {
                System.out.println("["+this.name+"]: Extrage muchie");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name+" avand urmatoarele muchii " +this.graph;
    }
    // implement the run() method, that will repeatedly extract edges
    // implement the toString() method
}