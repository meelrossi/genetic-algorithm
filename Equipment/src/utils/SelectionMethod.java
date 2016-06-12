package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Individual;

public enum SelectionMethod {
	Elitte,
	Random,
	Roulette,
	Universal,
	Boltzman,
	ProbabilisticTournament,
	Ranking;
	
	public List<Individual> getSelected(List<Individual> population, int n) {
		List<Individual> selection = new ArrayList<Individual>();

		switch(this) {

		case Elitte:
			selection.addAll(population);
			Collections.sort(selection);
			selection = selection.subList(0, n);

			break;

		case Random:
			for (int i = 0; i < n; i++) {
				int index = (int) Math.random() * population.size();
				selection.add(population.get(index).clone());
			}

			break;

		case Roulette:
			GeneticAlgorithmUtils.setAccumulatedAptitude(population);

			for (int i = 0; i < n; i++) {
				double rand = Math.random();
				boolean found = false;

				for (int j = 0; j < population.size() && !found; j++) {
					Individual ind = population.get(j);
					if (ind.getAccumulatedAptitude() > rand) {
						selection.add(ind.clone());
						found = true;
					}
				}
			}

			break;

		case Universal:
			GeneticAlgorithmUtils.setAccumulatedAptitude(population);
			double rand = Math.random();

			for (int i = 1; i < n; i++) {
				boolean found = false;
				double randi = (rand + i - 1) / n;

				for (int j = 0; j < population.size() && !found; j++) {
					Individual ind = population.get(j);
					if (ind.getAccumulatedAptitude() > randi) {
						selection.add(ind.clone());
						found = true;
					}
				}
				
			}

			break;

		case Boltzman:

			break;

		case ProbabilisticTournament:

			for (int i = 0; i < n; i++) {
				double decisionRand = Math.random();
				Individual ind1 = population.get((int) Math.random() * population.size());
				Individual ind2 = population.get((int) Math.random() * population.size());

				if (decisionRand < 0.75) {
					if (ind1.compareTo(ind2) > 0) {
						selection.add(ind1.clone());
					} else {
						selection.add(ind2.clone());
					}
				} else {
					if (ind1.compareTo(ind2) > 0) {
						selection.add(ind2.clone());
					} else {
						selection.add(ind1.clone());
					}
				}				
			}

			break;

		case Ranking:
			GeneticAlgorithmUtils.setRankingAptitude(population);

			for (int i = 1; i < n; i++) {
				double rankingRand = Math.random();
				boolean found = false;

				for (int j = 0; j < population.size() && !found; j++) {
					Individual ind = population.get(j);
					if (ind.getAccumulatedAptitude() > rankingRand) {
						selection.add(ind.clone());
						found = true;
					}
				}
			}

			break;

		default:
			break;
		}
		return selection;
		
	}
}
