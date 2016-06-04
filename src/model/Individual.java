package model;

public abstract class Individual implements Comparable<Individual> {
	protected int decimalRepresentation;
	protected String binaryRepresentation;
	protected double fitness;
	protected double relativeAptitude;
	protected double accumulatedAptitude;

	public Individual(int decimalRepresentation) {
		this.decimalRepresentation = decimalRepresentation;
		this.binaryRepresentation = Integer.toBinaryString(this.decimalRepresentation);
		setFitness();
	}

	public Individual(String binaryRepresentation) {
		this.binaryRepresentation = binaryRepresentation;
		this.decimalRepresentation = Integer.parseInt(this.binaryRepresentation);
		setFitness();
	}

	public double getFitness() {
		return this.fitness;
	}

	public int getDecimalRepresentation() {
		return this.decimalRepresentation;
	}

	public String getBinaryRepresentation() {
		return this.binaryRepresentation;
	}

	public abstract void setFitness();

	public int compareTo(Individual anIndividual) {
		return new Double(this.fitness).compareTo(anIndividual.fitness);
	}

	public void setRelativeAptitude(double relativeAptitude) {
		this.relativeAptitude = relativeAptitude;
	}

	public double getRelativeAptitude() {
		return this.relativeAptitude;
	}

	public void setAccumulatedAptitude(double accumulatedAptitude) {
		this.accumulatedAptitude = accumulatedAptitude;
	}
	
	public double getAccumulatedAptitude() {
		return accumulatedAptitude;
	}

}
