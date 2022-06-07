package kalah.components;

public class House extends Pit {
	private int id;
	public House(int id, int seeds) {
		this.id = id;
		this.seeds = seeds;
	}

	public boolean wasEmpty() {
		return (this.getSeeds() == 1);
	}

	public boolean isStore() {
		return false;
	}

	public int getId() {
		return this.id;
	}

	public int clearSeeds() {
		int seedHolder = this.seeds;
		this.seeds = 0;
		return seedHolder;
	}
}
