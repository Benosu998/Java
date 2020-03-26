import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player winPlayer;
    private Board board;

    Game() {

    }

    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void start(){
        for (Player player : players) {
            new Thread(player).start();
        }

    }
    public boolean haveWinner(){
         return this.winPlayer != null;
    }
    public void setWinner(Player player) {
        this.winPlayer=player;
    }

    public Player getWinner() {
        return winPlayer;
    }
    //Create getters and setters
    //Create the method that will start the game: start one thread for each player
}