package utils;

import java.util.List;

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
				double rand = Math.random();
				if (rand > 0.5) {
					chromosome.get(geneIndex).mutate();
				}
			}

			break;

		case Classic:
			geneIndex = (int) Math.random() * chromosome.size();
			chromosome.get(geneIndex).mutate();

			break;

		}
	}
}
