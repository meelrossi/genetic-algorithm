package model;

import java.util.List;

public class Individual implements Comparable<Individual> {
	private Fitness fitness;
	private double relativeAptitude;
	private double accumulatedAptitude;
	private List<Gene> chromosome;
	
	private double strength;
	private double agility;
	private double skill;
	private double life;
	private double resistance;

	public Individual(List<Gene> chromosome, Fitness fitness) {
		this.chromosome = chromosome;
		this.fitness = fitness;
	}

	public List<Gene> getChromosome() {
		return chromosome;
	}

	public double getFitness() {
		return this.fitness.getFitness(this);
	}

	public Fitness getFitnessAlgorithm() {
		return fitness;
	}

	@Override
	public int compareTo(Individual anIndividual) {
		return new Double(this.fitness.getFitness(this)).compareTo(anIndividual.getFitness());
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

	public double getAttack() {
		return 0;
	}

	public double getDeffense() {
		return 0;
	}

	public double getStrength() {
		return strength;
	}

	public double getAgility() {
		return agility;
	}

	public double getSkill() {
		return skill;
	}

	public double getLife() {
		return life;
	}

	public double getResistance() {
		return resistance;
	}

}
