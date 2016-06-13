package model;

public class Gene {
	private double value;
	private double maxValue;

	public Gene(double value, double maxValue) {
		this.value = value;
		this.maxValue = maxValue;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public double maxValue() {
		return this.maxValue;
	}

	public void mutate() {
		this.value = Math.random() * this.maxValue;
	}

	public Gene clone() {
		return new Gene(value, maxValue);
	}
}
