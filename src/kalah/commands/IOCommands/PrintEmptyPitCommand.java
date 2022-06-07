package kalah.commands.IOCommands;

import kalah.game.GameIO;

public class PrintEmptyPitCommand implements IioCommand {
    private GameIO io;
    public PrintEmptyPitCommand(GameIO io) {
        this.io = io;
    }

    public void execute() {
        io.printEmptyPit();
    }
}