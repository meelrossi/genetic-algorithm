package model;

public class Gene {
	private double value;
	private double maxValue;
	private double minValue;

	public Gene(double value, double minValue, double maxValue) {
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
		this.value = Math.random() * (this.maxValue - this.minValue) + this.minValue;
	}

	public Gene clone() {
		return new Gene(value, minValue, maxValue);
	}
}
