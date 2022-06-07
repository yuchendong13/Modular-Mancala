package kalah.commands;
import java.util.List;

import kalah.components.Board;
import kalah.components.Player;
import kalah.components.House;

// CaptureCommand handles the capturing of seeds if a player's turn ends in a House
public class CaptureCommand implements IGameCommand {
    private Board board;
    private List<Player> players;
    public CaptureCommand(Board b, List<Player> p) {
        this.board = b;
        this.players = p;
    }

    public void execute(int house, int player) {
        int oppositeHouse = board.captureHelper(house);
        if(this.board.getPits().get(oppositeHouse).getSeeds() != 0) {
            if(player == 1) {
                if(house >= 0 && house < 6) {
                    if(((House)this.board.getPits().get(house)).wasEmpty()) {
                        this.players.get(0).addScore(this.board.getPits().get(oppositeHouse).getSeeds()+1);
                        ((House)this.board.getPits().get(house)).clearSeeds();
                        ((House)this.board.getPits().get(oppositeHouse)).clearSeeds();
                    }
                }
            } else {
                if(house > 6 && house < 13) {
                    if(((House)this.board.getPits().get(house)).wasEmpty()) {
                        this.players.get(1).addScore(this.board.getPits().get(oppositeHouse).getSeeds()+1);
                        ((House)this.board.getPits().get(house)).clearSeeds();
                        ((House)this.board.getPits().get(oppositeHouse)).clearSeeds();
                    }
                }
            }
        }
    }
}