package kalah.commands.IOCommands;

import kalah.game.GameIO;

public class PrintInvalidMoveCommand implements IioCommand {
    private GameIO io;
    public PrintInvalidMoveCommand(GameIO io) {
        this.io = io;
    }

    public void execute() {
        io.printInvalidMove();
    }
}