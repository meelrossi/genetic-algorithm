package utils;

import java.util.ArrayList;
import java.util.List;

import model.Individual;
import model.Representation;

public enum CombinationMethod {
	OnePoint,
	TwoPoints,
	Anular,
	Uniform;
	
	public List<Individual> combine(Representation rep1, Representation rep2) {
		List<Individual> combinedIndividuals = null;
		switch(this) {
		case OnePoint:
			combinedIndividuals = rep1.getOnePointCombination(rep2);
			break;
		case TwoPoints:
			combinedIndividuals = rep1.getTwoPointCombination(rep2);
			break;
		case Anular:
			combinedIndividuals = rep1.getAnularCombination(rep2);
			break;
		case Uniform:
			combinedIndividuals = rep1.getUniformCombination(rep2);
			break;
		default:
			combinedIndividuals = new ArrayList<Individual>();
			break;
		}
		return combinedIndividuals;
	}
}
