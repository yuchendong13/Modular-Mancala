package kalah.commands.IOCommands;
import java.util.List;
import kalah.components.Player;

public class IOCommandController {
    private IioCommand printBoardCommand, printInvalidMoveCommand, printEmptyPitCommand, printFinishedCommand, printFinishedGameCommand, printWinnerCommand;

    public IOCommandController(IioCommand printBoardCommand, IioCommand printInvalidMoveCommand, IioCommand printEmptyPitCommand, IioCommand printFinishedCommand, IioCommand printFinishedGameCommand, IioCommand printWinnerCommand) {
        this.printBoardCommand = printBoardCommand;
        this.printInvalidMoveCommand = printInvalidMoveCommand;
        this.printEmptyPitCommand = printEmptyPitCommand;
        this.printFinishedCommand = printFinishedCommand;
        this.printFinishedGameCommand = printFinishedGameCommand;
        this.printWinnerCommand = printWinnerCommand;
    }

    public void printBoard(){
        this.printBoardCommand.execute();
    }

    public void printInvalidMove() {
        this.printInvalidMoveCommand.execute();
    }

    public void printEmptyPit() {
        this.printEmptyPitCommand.execute();
    }

    public void printFinished() {
        this.printFinishedCommand.execute();
    }

    public void printFinishedGame() {
        this.printFinishedGameCommand.execute();
    }

    public void printWinner() {
        this.printWinnerCommand.execute();
    }

}