package kalah.components;

import java.util.List;
import java.util.ArrayList;

public class TurnController {
    private List<Player> players;
    private int playerTurn;

    public TurnController(List<Player> players) {
        this.players = players;
        this.playerTurn = this.players.get(0).getPlayer();
    }

    public Player getPlayer(int player) {
        return this.players.get(player-1);
    }

    public int getPlayerTurn() {
        return this.playerTurn;
    }

    public void nextTurn() {
        if(this.playerTurn == 1) {
            this.playerTurn = this.players.get(1).getPlayer();
        } else {
            this.playerTurn = this.players.get(0).getPlayer();
        }
    }

}
