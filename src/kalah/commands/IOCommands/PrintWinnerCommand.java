package kalah.commands.IOCommands;

import kalah.game.GameIO;
import kalah.components.Player;
import java.util.List;

public class PrintWinnerCommand implements IioCommand {
    private GameIO io;
    private List<Player> players;
    public PrintWinnerCommand(GameIO io, List<Player> players) {
        this.io = io;
        this.players = players;
    }

    public void execute() {
        if(this.players.get(0).getScore() == this.players.get(1).getScore()) {
            io.printTie();
        } else if(this.players.get(0).getScore() > this.players.get(1).getScore()) {
            io.printWinner(this.players.get(0).getPlayer());
        } else {
            io.printWinner(this.players.get(1).getPlayer());
        }
    }
}