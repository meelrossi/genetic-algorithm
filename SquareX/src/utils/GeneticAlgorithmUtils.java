package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import model.Individual;
import model.SquareXIndividual;

public class GeneticAlgorithmUtils {

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
	
	public static void setRankingAptitude(List<Individual> population) {
		double n = population.size();
		int accumulated = 0; //sum of individual positions in ranking
		double accumulatedRankingValue = 0; //
		List<Individual> orderedIndividuals = new ArrayList<Individual>(population);
		orderedIndividuals.sort(null); //orders items upwardly
		for(int i = 1; i <= n; i++) {
			accumulated+=i; 
		}
		for(int i = 1; i <= n; i++) {
			double relativeAptitude = i / accumulated;
			accumulatedRankingValue += relativeAptitude;
			Individual individual = population.get(i);
			individual.setRelativeAptitude(relativeAptitude);
			individual.setAccumulatedAptitude(accumulatedRankingValue);
		}
	}
}
