package utils;

import java.util.Collections;
import java.util.List;

import model.Individual;

public class GeneticAlgorithmUtils {

	public static void setAccumulatedAptitude(List<Individual> population) {
		double totalFitness = getTotalFitness(population);
		double accumulatedAptitude = 0;
		for (Individual individual : population) {
			double aptitude = individual.getFitness();
			double relativeAptitude = aptitude / totalFitness;
			accumulatedAptitude += relativeAptitude;
			individual.setRelativeAptitude(relativeAptitude);
			individual.setAccumulatedAptitude(accumulatedAptitude);
		}
	}

	public static double getTotalFitness(List<Individual> population) {
		double totalFitness = 0;
		for (Individual individual : population) {
			totalFitness += individual.getFitness();
		}
		return totalFitness;
	}

	public static void setRankingAptitude(List<Individual> population) {
		int n = population.size();
		int accumulated = MathSIA.sumTo(n);
		double accumulatedRankingValue = 0;
		Collections.sort(population, Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			double aptitude = n - i;
			double relativeAptitude = aptitude / accumulated;
			accumulatedRankingValue += relativeAptitude;
			Individual individual = population.get(i);
			individual.setRelativeAptitude(relativeAptitude);
			individual.setAccumulatedAptitude(accumulatedRankingValue);
		}
	}
}
