package model;

public class Gene {
	private int value;
	private int maxValue;

	public Gene(int value, int maxValue) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void mutate() {
		value = (int) Math.random() * (maxValue + 1);
	}
	
	public int maxValue() {
		return maxValue;
	}
}
