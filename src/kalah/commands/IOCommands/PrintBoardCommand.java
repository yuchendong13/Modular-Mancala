package kalah.commands.IOCommands;

import kalah.game.GameIO;
import kalah.components.Board;
import kalah.components.Player;
import kalah.game.GameIO;
import java.util.List;


public class PrintBoardCommand implements IioCommand {
    private Board board;
    private List<Player> players;
    private GameIO io;

    public PrintBoardCommand(Board b, List<Player> p, GameIO io) {
        this.board = b;
        this.players = p;
        this.io = io;
    }

    public void execute() {
        this.io.printBoard(this.board, this.players.get(0).getScore(), this.players.get(1).getScore());
    }
}