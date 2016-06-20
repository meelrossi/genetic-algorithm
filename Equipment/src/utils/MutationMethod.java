package utils;

import java.util.List;

import algorithm.EquipmentAlgorithm;
import model.Gene;
import model.Individual;

public enum MutationMethod {
	NonUniform, Classic;
	
	public void mutate(Individual individual) {
		List<Gene> chromosome = individual.getChromosome();
		int geneIndex;

		switch(this) {

		case NonUniform:
			for (geneIndex = 0; geneIndex < chromosome.size(); geneIndex++) {
				double rand = EquipmentAlgorithm.randNum.nextDouble();
				if (rand > 0.5) {
					chromosome.get(geneIndex).mutate();
				}
			}

			break;

		case Classic:
			geneIndex = (int) EquipmentAlgorithm.randNum.nextDouble() * chromosome.size();
			chromosome.get(geneIndex).mutate();

			break;

		}
	}
}
