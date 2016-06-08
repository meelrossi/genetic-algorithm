package utils;

import java.util.ArrayList;
import java.util.List;

import model.Fitness;
import model.Gene;
import model.Individual;

public enum CombinationMethod {
	OnePoint, TwoPoints, Anular, Uniform;

	public List<Individual> combine(Individual ind1, Individual ind2) {
		List<Individual> combinedIndividuals = new ArrayList<Individual>();
		int end = ind1.getChromosome().size();

		List<Gene> chromosome1 = ind1.getChromosome();
		List<Gene> chromosome2 = ind2.getChromosome();

		List<Gene> newChromosome1 = new ArrayList<Gene>();
		List<Gene> newChromosome2 = new ArrayList<Gene>();

		Fitness fitness = ind1.getFitnessAlgorithm();

		switch (this) {
		case OnePoint:
			int locus = (int) Math.random() * end;

			newChromosome1.addAll(chromosome1.subList(0, locus));
			newChromosome1.addAll(chromosome2.subList(locus, end));

			newChromosome2.addAll(chromosome2.subList(0, locus));
			newChromosome2.addAll(chromosome1.subList(locus, end));

			break;

		case TwoPoints:
			int locus1 = (int) Math.random() * end;
			int locus2 = (int) Math.random() * (end - locus1) + locus1;

			newChromosome1.addAll(chromosome1.subList(0, locus1));
			newChromosome1.addAll(chromosome2.subList(locus1, locus2));
			newChromosome1.addAll(chromosome1.subList(locus2, end));

			newChromosome2.addAll(chromosome2.subList(0, locus1));
			newChromosome2.addAll(chromosome1.subList(locus1, locus2));
			newChromosome2.addAll(chromosome2.subList(locus2, end));

			break;
		case Anular:
			
			break;
		case Uniform:
			for (int i = 0; i < end; i++) {
				double rand = Math.random();
				if (rand > 0.5) {
					newChromosome2.add(chromosome1.get(i));
					newChromosome1.add(chromosome2.get(i));
				} else {
					newChromosome2.add(chromosome2.get(i));
					newChromosome1.add(chromosome1.get(i));
				}
			}
			break;
		default:
			break;
		}

		combinedIndividuals.add(new Individual(newChromosome1, fitness));
		combinedIndividuals.add(new Individual(newChromosome2, fitness));
		return combinedIndividuals;
	}
}
