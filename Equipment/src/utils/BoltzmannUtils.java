package utils;

import java.util.List;

import model.Individual;

public class BoltzmannUtils {

	private static BoltzmannUtils instance;
	private static double initialT = 10;
	private static double decreacingPercentage = 0.9;
	private double T;
	
	public static BoltzmannUtils instance() {
		if (instance == null) {
			instance = new BoltzmannUtils();
		}
		return instance;
	}

	public void calculateForRoulette(List<Individual> population) {
		double sumBoltzmann = sumBoltzmann(population);
		double accumulatedAptitude = 0;

		for(Individual individual: population) {
			double aptitude = individualBoltzmann(individual.getFitness());
			double relativeAptitude = aptitude / sumBoltzmann;
			accumulatedAptitude += relativeAptitude;
			individual.setRelativeAptitude(relativeAptitude);
			individual.setAccumulatedAptitude(accumulatedAptitude);
		}

		T = T * decreacingPercentage;
	}

	private BoltzmannUtils() {
		this.T = initialT;
	}

	private double individualBoltzmann(double fitness) {
		return Math.exp(fitness / T);
	}

	private double sumBoltzmann(List<Individual> population) {
		double ans = 0;
		for (Individual ind : population) {
			ans += individualBoltzmann(ind.getFitness());
		}
		return ans;
	}
}
