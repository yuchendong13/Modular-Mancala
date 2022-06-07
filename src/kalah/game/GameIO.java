package kalah.game;

import kalah.components.Board;
import com.qualitascorpus.testsupport.IO;

import java.util.Arrays;

public class GameIO {
    private IO io;
    private String[] validInput;
    public GameIO(IO ioIn){
        io = ioIn;
        this.validInput = new String[]{"1","2","3","4","5","6","q"};
    }

    public String userInput(int playersTurn) {
        return io.readFromKeyboard("Player P" + playersTurn + "'s turn - Specify house number or 'q' to quit: ");
    }

    public boolean validMove(String input) {
        boolean moveValid = false;
        if(Arrays.asList(this.validInput).contains(input.toLowerCase())){
            moveValid = true;
        }
        return moveValid;
    }

    public void printBoard(Board board, int p1Score, int p2Score){
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");
        io.println(String.format("| P2 | 6[%2d] | 5[%2d] | 4[%2d] | 3[%2d] | 2[%2d] | 1[%2d] | %2d |",board.getPits().get(12).getSeeds(),board.getPits().get(11).getSeeds(),board.getPits().get(10).getSeeds(),board.getPits().get(9).getSeeds(),board.getPits().get(8).getSeeds(),board.getPits().get(7).getSeeds(),p1Score));
        io.println("|    |-------+-------+-------+-------+-------+-------|    |");
        io.println(String.format("| %2d | 1[%2d] | 2[%2d] | 3[%2d] | 4[%2d] | 5[%2d] | 6[%2d] | P1 |",p2Score,board.getPits().get(0).getSeeds(),board.getPits().get(1).getSeeds(),board.getPits().get(2).getSeeds(),board.getPits().get(3).getSeeds(),board.getPits().get(4).getSeeds(),board.getPits().get(5).getSeeds()));
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");
    }

    public void printInvalidMove() {
        io.println("Invalid move, please try again.");
    }

    public void printEmptyPit() {
        io.println("House is empty. Move again.");
    }

    public void printFinished() {
        io.println("Game over");
    }

    public void printFinishedGame(int p1Score, int p2Score) {
        io.println(String.format("\tplayer 1:%d",p1Score));
        io.println(String.format("\tplayer 2:%d",p2Score));
    }

    public void printTie() {
        io.println("A tie!");
    }

    public void printWinner(int player) {
        io.println(String.format("Player %d wins!", player));
    }
}
