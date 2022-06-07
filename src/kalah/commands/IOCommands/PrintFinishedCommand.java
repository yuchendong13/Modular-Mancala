package kalah.commands.IOCommands;

import kalah.game.GameIO;

public class PrintFinishedCommand implements IioCommand {
    private GameIO io;
    public PrintFinishedCommand(GameIO io) {
        this.io = io;
    }

    public void execute() {
        io.printFinished();
    }
}