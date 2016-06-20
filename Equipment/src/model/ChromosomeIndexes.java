package model;

public enum ChromosomeIndexes {
	WEAPONS (0),
	GLOVES (1),
	SHIRT (2),
	HELMET (3),
	BOOTS (4),
	HEIGHT (5);

	private final int index;
	ChromosomeIndexes(int index) {
		this.index = index;
	}
	
	public int index() {
		return this.index;
	}
}
