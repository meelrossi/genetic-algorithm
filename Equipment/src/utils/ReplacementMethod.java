package utils;

import java.util.ArrayList;
import java.util.List;

import model.Individual;

public enum ReplacementMethod {
	ReplaceAll, ChooseK, ChooseN;

	public List<Individual> replace(List<Individual> population, List<Individual> newGeneration,
			MethodPercentage replaceMethodOne, MethodPercentage replaceMethodTwo) {
		List<Individual> newPopulation = new ArrayList<Individual>();
		switch (this) {
		case ReplaceAll:
			break;
		case ChooseK:
			break;
		case ChooseN:
			break;
		}
		return newPopulation;
	}

}
