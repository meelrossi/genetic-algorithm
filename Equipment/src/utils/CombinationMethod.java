package utils;

import java.util.ArrayList;
import java.util.List;

import model.Gene;

public enum CombinationMethod {
	OnePoint, TwoPoints, Anular, Uniform;

	public List<List<Gene>> combine(List<Gene> ind1Chromosome, List<Gene> ind2Chromosome) {
		List<List<Gene>> combinedChromosomes = new ArrayList<List<Gene>>();
		int end = ind1Chromosome.size();
		int locus1;
		int locus2;
		int segment;

		List<Gene> chromosome1 = new ArrayList<Gene>();
		List<Gene> chromosome2 = new ArrayList<Gene>();
		ind1Chromosome.forEach(gene -> chromosome1.add(gene.clone()));
		ind2Chromosome.forEach(gene -> chromosome2.add(gene.clone()));

		List<Gene> newChromosome1 = new ArrayList<Gene>();
		List<Gene> newChromosome2 = new ArrayList<Gene>();

		switch (this) {
		case OnePoint:
			locus1 = (int) Math.random() * end;

			newChromosome1.addAll(chromosome1.subList(0, locus1));
			newChromosome1.addAll(chromosome2.subList(locus1, end));

			newChromosome2.addAll(chromosome2.subList(0, locus1));
			newChromosome2.addAll(chromosome1.subList(locus1, end));

			break;

		case TwoPoints:
			locus1 = (int) Math.random() * end;
			locus2 = (int) Math.random() * (end - locus1) + locus1;

			newChromosome1.addAll(chromosome1.subList(0, locus1));
			newChromosome1.addAll(chromosome2.subList(locus1, locus2));
			newChromosome1.addAll(chromosome1.subList(locus2, end));

			newChromosome2.addAll(chromosome2.subList(0, locus1));
			newChromosome2.addAll(chromosome1.subList(locus1, locus2));
			newChromosome2.addAll(chromosome2.subList(locus2, end));

			break;
		case Anular:
			locus1 = (int) Math.random() * end;
			segment = (int) Math.random() * end / 2;

			if (locus1 + segment > end) {
				int overflow = locus1 + segment - end;

				newChromosome1.addAll(chromosome2.subList(0, overflow));
				newChromosome1.addAll(chromosome1.subList(overflow, locus1));
				newChromosome1.addAll(chromosome2.subList(locus1, end));

				newChromosome2.addAll(chromosome1.subList(0, overflow));
				newChromosome2.addAll(chromosome2.subList(overflow, locus1));
				newChromosome2.addAll(chromosome1.subList(locus1, end));
			} else {
				newChromosome1.addAll(chromosome1.subList(0, locus1));
				newChromosome1.addAll(chromosome2.subList(locus1, locus1 + segment));
				newChromosome1.addAll(chromosome1.subList(locus1 + segment, end));

				newChromosome2.addAll(chromosome2.subList(0, locus1));
				newChromosome2.addAll(chromosome1.subList(locus1, locus1 + segment));
				newChromosome2.addAll(chromosome2.subList(locus1 + segment, end));
			}

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

		combinedChromosomes.add(newChromosome1);
		combinedChromosomes.add(newChromosome2);
		return combinedChromosomes;
	}
}
