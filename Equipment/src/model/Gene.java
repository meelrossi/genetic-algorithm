package model;

public class Gene {
	private double value;
	private double maxValue;

	public Gene(int value, int maxValue) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value2) {
		this.value = value2;
	}

	public void mutate() {
		value = (int) Math.random() * (maxValue + 1);
	}
	
	public double maxValue() {
		return maxValue;
	}
}
