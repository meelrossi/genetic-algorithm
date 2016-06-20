package model;

import java.util.List;

public abstract class Individual implements Comparable<Individual> {
	private static int next_id = 0;
	
	protected int id;
	protected double relativeAptitude;
	protected double accumulatedAptitude;
	protected List<Gene> chromosome;

	public Individual(List<Gene> chromosome) {
		this.id = ++Individual.next_id;
		this.chromosome = chromosome;
	}
	
	public Individual(int id, List<Gene> chromosome) {
		this.id = id;
		this.chromosome = chromosome;
	}

	public List<Gene> getChromosome() {
		return chromosome;
	}
	
	public int getId() {
		return this.id;
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
	
	@Override
	public String toString() {
		return "Individuo: " + this.id + "\n" + "Arma: " + (int) chromosome.get(0).getValue() + " Guantes: " + (int) chromosome.get(1).getValue() + " Pechera: " + (int) chromosome.get(2).getValue() + " Casco: " + (int) chromosome.get(3).getValue() + " Botas: " + (int) chromosome.get(4).getValue() + " Altura: " + chromosome.get(5).getValue() + "\nFitness: " + getFitness();
	}

}
