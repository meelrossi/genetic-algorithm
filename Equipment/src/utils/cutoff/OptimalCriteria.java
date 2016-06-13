package utils.cutoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Individual;

public class OptimalCriteria implements CutOffCriteria {

	public double minFitness;

	public OptimalCriteria(double minFitness) {
		this.minFitness = minFitness;
	}

	@Override
	public boolean shouldEnd(List<Individual> population) {
		List<Individual> auxPopulation = new ArrayList<Individual>(population);
		Collections.sort(auxPopulation);
		return auxPopulation.get(auxPopulation.size() - 1).getFitness() > minFitness;
	}

}
