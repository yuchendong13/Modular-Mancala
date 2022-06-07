package kalah.components;

abstract public class Pit {
	protected int seeds;
	protected Pit next;
	protected Pit prev;
	public abstract boolean isStore();
	public Pit() {
	}



	public void setNext(Pit next) {
		this.next = next;
	}

	public Pit getNext() {
		return this.next;
	}

	public void setPrev(Pit prev) {
		this.prev = prev;
	}

	public Pit getPrev() {
		return this.prev;
	}

	public int getSeeds() {
		return this.seeds;
	}

	public void addSeed() {
		this.seeds += 1;
	}
}
