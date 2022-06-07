package kalah.commands.IOCommands;

import kalah.game.GameIO;
import kalah.components.Player;
import java.util.List;

public class PrintFinishedGameCommand implements IioCommand {
    private GameIO io;
    private List<Player> players;
    public PrintFinishedGameCommand(GameIO io, List<Player> players) {
        this.io = io;
        this.players = players;
    }

    public void execute() {
        io.printFinishedGame(this.players.get(0).getScore(), this.players.get(1).getScore());
    }
}