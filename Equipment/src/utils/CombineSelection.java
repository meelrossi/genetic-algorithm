package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithm.EquipmentAlgorithm;
import model.Gene;
import model.Individual;

public enum CombineSelection {
	Combine2, CombineAll, CombineRandom, CombineBest;

	public List<List<Gene>> getCombined(List<Individual> parents, CombinationMethod cm) {
		List<List<Gene>> newChromosomes = new ArrayList<List<Gene>>();
		switch (this) {
		case Combine2:
			while (newChromosomes.size() < parents.size()) {
				int newChromosomesSize = newChromosomes.size();

				newChromosomes.addAll(cm.combine(parents.get(newChromosomesSize).getChromosome(),
						parents.get(newChromosomesSize + 1).getChromosome()));
			}
			break;
		case CombineAll:
			while (newChromosomes.size() < parents.size()) {
				int rand1 = (int) EquipmentAlgorithm.randNum.nextDouble() * parents.size();
				newChromosomes.addAll(cm.combine(parents.get(newChromosomes.size()).getChromosome(),
						parents.get(rand1).getChromosome()));
			}
			break;
		case CombineRandom:
			while (newChromosomes.size() < parents.size()) {
				int rand1 = (int) EquipmentAlgorithm.randNum.nextDouble() * parents.size();
				int rand2 = (int) EquipmentAlgorithm.randNum.nextDouble() * parents.size();

				newChromosomes
						.addAll(cm.combine(parents.get(rand1).getChromosome(), parents.get(rand2).getChromosome()));
			}
			break;
		case CombineBest:
			Collections.sort(parents, Collections.reverseOrder());
			Individual bestInd = parents.get(0);
			for (Individual ind : parents) {
				int rand = (int) EquipmentAlgorithm.randNum.nextDouble() * 2;
				newChromosomes.add(cm.combine(bestInd.getChromosome(), ind.getChromosome()).get(rand));
			}
			break;
		}
		return newChromosomes.subList(0, parents.size());
	}
}
