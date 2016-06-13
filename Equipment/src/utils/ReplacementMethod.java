package utils;

import java.util.ArrayList;
import java.util.List;

import model.Individual;

public enum ReplacementMethod {
	ReplaceAll, ChooseK, ChooseN;

	public List<Individual> replace(List<Individual> population,
			List<Individual> newGeneration, MethodPercentage replaceMethodOne,
			MethodPercentage replaceMethodTwo) {

		List<Individual> newPopulation = new ArrayList<Individual>();

		switch (this) {
		case ReplaceAll:
			newPopulation.addAll(newGeneration);

			break;

		case ChooseK:
			int oldGenerationSize = population.size() - newGeneration.size();

			newPopulation.addAll(replaceMethodOne.getMethod().getSelected(
					population, (int) Math.floor(oldGenerationSize * replaceMethodOne.getPercentage())));
			newPopulation.addAll(replaceMethodTwo.getMethod().getSelected(
					population, (int) Math.ceil(oldGenerationSize * replaceMethodTwo.getPercentage())));

			newPopulation.addAll(newGeneration);

			break;

		case ChooseN:
			population.addAll(newGeneration);

			newPopulation.addAll(replaceMethodOne.getMethod().getSelected(
					population, (int) Math.floor(population.size() * replaceMethodOne.getPercentage())));
			newPopulation.addAll(replaceMethodTwo.getMethod().getSelected(
					population, (int) Math.ceil(population.size() * replaceMethodTwo.getPercentage())));

			break;

		}

		return newPopulation.subList(0, population.size());
	}

}
