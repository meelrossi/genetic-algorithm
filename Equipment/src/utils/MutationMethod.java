package utils;

import java.util.List;

import model.Gene;
import model.Individual;

public enum MutationMethod {
	NonUniform, Classic;
	
	public void mutate(Individual individual) {
		List<Gene> chromosome = individual.getChromosome();
		switch(this) {
		case NonUniform:
			for (int i = 0; i < chromosome.size(); i++) {
				double rand = Math.random();
				if (rand > 0.5) {
					Gene gene = chromosome.get(i);
					int maxValue = gene.maxValue();
					int value = (int)Math.random() * maxValue;
					gene.setValue(value);
					chromosome.set(i, gene);
				}
			}
			break;
		case Classic:
			int rand = (int) Math.random() * chromosome.size();
			Gene gene = chromosome.get(rand);
			int maxValue = gene.maxValue();
			int value = (int)Math.random() * maxValue;
			gene.setValue(value);
			chromosome.set(rand, gene);
			break;
		}
	}
}
