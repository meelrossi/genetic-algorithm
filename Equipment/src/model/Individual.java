package model;

import java.util.List;

public abstract class Individual implements Comparable<Individual> {
	protected double relativeAptitude;
	protected double accumulatedAptitude;
	protected List<Gene> chromosome;

	public Individual(List<Gene> chromosome) {
		this.chromosome = chromosome;
	}

	public List<Gene> getChromosome() {
		return chromosome;
	}

	public abstract double getFitness();
	public abstract Individual clone();

	@Override
	public int compareTo(Individual anIndividual) {
		return new Double(this.getFitness()).compareTo(anIndividual.getFitness());
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
