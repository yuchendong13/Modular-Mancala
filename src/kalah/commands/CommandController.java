package kalah.commands;
import java.util.List;
import kalah.components.Player;

public class CommandController {
    private IGameCommand sowCommand, captureCommand;

    public CommandController(IGameCommand sow, IGameCommand capture) {
        this.sowCommand = sow;
        this.captureCommand = capture;
    }

    public void sowSeeds(int house, int player) {
        this.sowCommand.execute(house, player);
    }

    public void captureSeeds(int house, int player) {
        this.captureCommand.execute(house, player);
    }


}