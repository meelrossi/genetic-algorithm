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
			break;
		case Universal:
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
