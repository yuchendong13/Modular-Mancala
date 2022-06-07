package kalah.components;

public class Store extends Pit {
	private int seeds;
	private int playerStore;
	public Store(int player) {
		this.seeds = 0;
		this.playerStore = player;
	}

	public boolean isStore() {
		return true;
	}

	public int getPlayerStore() {
		return this.playerStore;
	}

}
