package utils;

import java.util.ArrayList;
import java.util.List;

import model.Individual;
import model.SquareXIndividual;

public class GeneticAlgorithmUtils {

	public static int SquareXFitness(int x) {
		return x * x;
	}

	public static List<Individual> getSquareXFirstGeneration(int n) {
		List<Individual> generation = new ArrayList<Individual>();
		for(int i = 0; i < n; i++) {
			int decimal = (int)Math.random() * 40;
			generation.add(new SquareXIndividual(decimal));
		}
		return generation;
	}
	
	public static void setAccumulatedAptitude(List<Individual> population) {
		double totalFitness = getTotalFitness(population);
		double accumulatedAptitude = 0;
		for(Individual individual: population) {
			double aptitude = individual.getFitness();
			double relativeAptitude = aptitude / totalFitness;
			accumulatedAptitude += relativeAptitude;
			individual.setRelativeAptitude(relativeAptitude);
			individual.setAccumulatedAptitude(accumulatedAptitude);
		}
	}
	
	public static double getTotalFitness(List<Individual> population) {
		double totalFitness = 0;
		for(Individual individual : population) {
			totalFitness += individual.getFitness();
		}
		return totalFitness;
	}
}
