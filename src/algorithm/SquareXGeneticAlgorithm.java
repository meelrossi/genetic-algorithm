package algorithm;

import java.util.List;

import model.Individual;
import utils.GeneticAlgorithmUtils;
import utils.SelectionMethod;

public class SquareXGeneticAlgorithm {
	private List<Individual> population;
	private int selectionNumber;
	
	public SquareXGeneticAlgorithm(int initialPopulation, int selectionNumber) {
		this.population = GeneticAlgorithmUtils.getSquareXFirstGeneration(initialPopulation);
	}

	public void run() {
		int counter = 0;
		while(counter < 1000) {
			List<Individual> selectedPopulation = SelectionMethod.Random.getSelected(population, selectionNumber);
			for(int i = 0; i < selectedPopulation.size(); i++) {
				for(int j = i + 1; j < selectedPopulation.size(); j++) {
					
				}
			}
		}
	}
}
