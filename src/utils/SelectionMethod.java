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
	Tournament,
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
			for(int i = 0; i < n; i++) {
				int index = (int) Math.random() * population.size();
				selection.add(population.get(index));
			}
			break;
		case Roulette:
			GeneticAlgorithmUtils.setAccumulatedAptitude(population);
			for(int i = 0; i < n; i++) {
				double rand = Math.random();
				boolean found = false;
				for(int j = 0; j < population.size() && !found; j++) {
					Individual ind = population.get(j);
					if(ind.getAccumulatedAptitude() > rand) {
						selection.add(ind);
						found = true;
					}
				}
				
			}
			break;
		case Universal:
			GeneticAlgorithmUtils.setAccumulatedAptitude(population);
			double rand = Math.random();
			for(int i = 1; i <= n; i++) {
				boolean found = false;
				double randi = (rand + i - 1) / n;
				for(int j = 0; j < population.size() && !found; j++) {
					Individual ind = population.get(j);
					if(ind.getAccumulatedAptitude() > randi) {
						selection.add(ind);
						found = true;
					}
				}
				
			}
			break;
		case Boltzman:
			break;
		case Tournament:
			break;
		case Ranking:
			break;
		default: break;
		}
		return selection;
		
	}
}
