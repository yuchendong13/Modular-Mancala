package kalah.commands;

import kalah.components.*;
import java.util.List;

// SowCommand handles the execution of the sowing action in a turn  
public class SowCommand implements IGameCommand {
    private Board board;
    private List<Player> players;
    public SowCommand(Board b, List<Player> p) {
        this.board = b;
        this.players = p;
    }

    public void execute(int house, int player) {
        Pit currentPit = this.board.getPits().get(house+1);
        int houseSeeds = this.board.getPits().get(house).getSeeds();
        ((House)this.board.getPits().get(house)).clearSeeds();
        for(int i = 0; i < houseSeeds; i++) {
            if(currentPit.isStore()) {
                
                if(((Store)currentPit).getPlayerStore() == 1) {
                    if(player == 1) {
                        this.players.get(0).addScore(1);
                    } else {
                        currentPit = currentPit.getNext();
                        currentPit.addSeed();
                    }
                    currentPit = currentPit.getNext();
                } else if(((Store)currentPit).getPlayerStore() == 2) {
                    if(player == 2) {
                        this.players.get(1).addScore(1);
                    } else {
                        currentPit = currentPit.getNext();
                        this.board.getPits().get(0).addSeed();
                    }
                    currentPit = currentPit.getNext();
                }
            } else {
                currentPit.addSeed();
                currentPit = currentPit.getNext();
            }
        }
    }
    
}