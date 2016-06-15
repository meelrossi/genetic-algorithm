package utils;

import java.util.ArrayList;
import java.util.List;

import model.Individual;

public enum ReplacementMethod {
	ReplaceAll, ChooseK, ChooseN;

	public List<Individual> replace(List<Individual> population, List<Individual> newGeneration,
			MethodPercentage replaceMethodOne, MethodPercentage replaceMethodTwo) {

		List<Individual> newPopulation = new ArrayList<Individual>();
		int originalPopulationSize = population.size();

		switch (this) {
		case ReplaceAll:
			newPopulation.addAll(newGeneration);

			break;

		case ChooseK:
			int oldGenerationSize = originalPopulationSize - newGeneration.size();

			int methodSize = (int) (oldGenerationSize * replaceMethodOne.getPercentage());

			newPopulation.addAll(replaceMethodOne.getMethod().getSelected(population, methodSize));
			newPopulation.addAll(replaceMethodTwo.getMethod().getSelected(population, oldGenerationSize - methodSize));

			newPopulation.addAll(newGeneration);

			break;

		case ChooseN:
			population.addAll(newGeneration);
			int methodOneSize = (int) (originalPopulationSize * replaceMethodOne.getPercentage());
			
			newPopulation.addAll(replaceMethodOne.getMethod().getSelected(population, methodOneSize));
			newPopulation.addAll(
					replaceMethodTwo.getMethod().getSelected(population, originalPopulationSize - methodOneSize));
			
			break;

		}

		return newPopulation.subList(0, originalPopulationSize);
	}

}
