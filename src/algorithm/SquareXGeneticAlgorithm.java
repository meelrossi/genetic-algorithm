package algorithm;

import java.util.List;

import model.Individual;
import utils.GeneticAlgorithmUtils;

public class SquareXGeneticAlgorithm {
	private List<Individual> population;
	
	public SquareXGeneticAlgorithm(int initialPopulation) {
		this.population = GeneticAlgorithmUtils.getSquareXFirstGeneration(initialPopulation);
	}

	public void run() {
		
	}
}
