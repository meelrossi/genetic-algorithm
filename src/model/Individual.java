package model;

import java.util.List;

import utils.CombinationMethod;

public abstract class Individual implements Comparable<Individual> {
	private Representation representation;
	protected double fitness;
	protected double relativeAptitude;
	protected double accumulatedAptitude;

	public Individual() {
	}

	public double getFitness() {
		return this.fitness;
	}

	public int compareTo(Individual anIndividual) {
		return new Double(this.fitness).compareTo(anIndividual.fitness);
	}
	
	protected void setRepresentation(Representation representation) {
		this.representation = representation;
		this.fitness = representation.getFitness();
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
	
	public Representation getRepresentation() {
		return this.representation;
	}
	
	public List<Individual> combine(Individual ind, CombinationMethod method) {
		return method.combine(this.representation, ind.getRepresentation());
	}

}
