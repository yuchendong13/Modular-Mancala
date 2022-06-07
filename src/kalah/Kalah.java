package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;
import kalah.components.Player;
import kalah.game.GameController;
import kalah.game.GameIO;
import kalah.commands.*;
import kalah.commands.IOCommands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure. Remove this comment (or rather, replace it
 * with something more appropriate)
 */
public class Kalah {
	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}
	public void play(IO io) {
		
		List<Player> players = new ArrayList<>();
		players.add(new Player(1));
		players.add(new Player(2));


		GameController game = new GameController(players);
		GameIO ioControl = new GameIO(io);

		PrintBoardCommand printBoardCommand = new PrintBoardCommand(game.getBoard(), players, ioControl); 
		PrintInvalidMoveCommand printInvalidMoveCommand = new PrintInvalidMoveCommand(ioControl);
		PrintEmptyPitCommand printEmptyPitCommand = new PrintEmptyPitCommand(ioControl); 
		PrintFinishedCommand printFinishedCommand = new PrintFinishedCommand(ioControl);
		PrintFinishedGameCommand printFinishedGameCommand = new PrintFinishedGameCommand(ioControl, players); 
		PrintWinnerCommand printWinnerCommand = new PrintWinnerCommand(ioControl, players);

		IOCommandController ioCommandController = new IOCommandController(printBoardCommand, printInvalidMoveCommand, printEmptyPitCommand, printFinishedCommand, printFinishedGameCommand, printWinnerCommand);

		ioCommandController.printBoard();

		while(!game.getBoard().playerPitsEmpty(game.getPlayerTurn())) {
			String input = ioControl.userInput(game.getPlayerTurn());

			if(ioControl.validMove(input) == true) {
				if(input.equals("q")) {
					break;
				} else {
					int house = Integer.parseInt(input) - 1;
					if(game.getPlayerTurn() == 2) {
						house += 7;
					}
					if(game.getBoard().getPits().get(house).getSeeds() == 0) {
						ioCommandController.printEmptyPit();
					} else {
						game.play(game.getPlayerTurn(), house);
					}
				}
			} else {
				ioCommandController.printInvalidMove();
			}
			ioCommandController.printBoard();
		}

		if(game.getBoard().playerPitsEmpty(game.getPlayerTurn())) {
			ioCommandController.printFinished();
			ioCommandController.printBoard();
			game.tallyRemainingSeeds();
			ioCommandController.printFinishedGame();

			ioCommandController.printWinner();

		} else {
			ioCommandController.printFinished();
			ioCommandController.printBoard();
		}

	}
}
