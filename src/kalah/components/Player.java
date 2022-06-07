package kalah.components;

public class Player {
    private int player;
    private int score;

    public Player(int player) {
        this.player = player;
        this.score = 0;
    }

    public int getPlayer() {
        return this.player;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int seeds) {
        this.score += seeds;
    }

}
