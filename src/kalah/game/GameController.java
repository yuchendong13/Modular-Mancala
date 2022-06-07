package kalah.game;

import kalah.components.*;
import kalah.commands.*;
import java.util.List;

public class GameController extends TurnController {
    private Board board;
    private List<Player> players;
    private CommandController commandController;
    private SowCommand sowCommand;
    private CaptureCommand captureCommand;

    public GameController(List<Player> players){
        super(players);
        this.players = players;
        this.board = new Board();
        this.sowCommand = new SowCommand(this.board, this.players);
        this.captureCommand = new CaptureCommand(this.board, this.players);
        this.commandController = new CommandController(this.sowCommand, this.captureCommand);

    }

    public Board getBoard() {
        return this.board;
    }


    public void tallyRemainingSeeds() {
        for(int i = 0; i < 6; i++) {
            this.players.get(0).addScore(this.board.getPits().get(i).getSeeds());
        }
        for(int i = 7; i < 13; i++) {
            this.players.get(1).addScore(this.board.getPits().get(i).getSeeds());
        }
    }

    public boolean play(int player, int house) {
        Pit currentPit = this.board.getPits().get(house+1);
        int houseSeeds = this.board.getPits().get(house).getSeeds();
        this.commandController.sowSeeds(house, player);

        // Calculate ending pit
        for(int i = 0; i < houseSeeds; i++) {
            if(currentPit.isStore()) {
                
                if(((Store)currentPit).getPlayerStore() == 1) {
                    if(player != 1) {
                        currentPit = currentPit.getNext();
                    }
                } else if(((Store)currentPit).getPlayerStore() == 2) {
                    if(player != 2) {
                        currentPit = currentPit.getNext();
                    }
                }
            } 
            currentPit = currentPit.getNext();
        }
        currentPit = currentPit.getPrev();

        if(!currentPit.isStore()) {
            this.commandController.captureSeeds((((House)currentPit).getId()),player);
        }
        if(!currentPit.isStore()) {
            this.nextTurn();
        }

        return true;
    }

}
