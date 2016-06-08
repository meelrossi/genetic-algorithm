package model;

import java.util.List;

public class Individual implements Comparable<Individual> {
	private Fitness fitness;
	private double relativeAptitude;
	private double accumulatedAptitude;
	private List<Gene> chromosome;

	public Individual(List<Gene> chromosome, Fitness fitness) {
		this.chromosome = chromosome;
		this.fitness = fitness;
	}
	
	public List<Gene> getChromosome() {
		return chromosome;
	}
	
	public double getFitness() {
		return this.fitness.getFitness(chromosome);
	}
	
	public Fitness getFitnessAlgorithm() {
		return fitness;
	}
	
	@Override
	public int compareTo(Individual anIndividual) {
		return new Double(this.fitness.getFitness(chromosome)).compareTo(anIndividual.getFitness());
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
