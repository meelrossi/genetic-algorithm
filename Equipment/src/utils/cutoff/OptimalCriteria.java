package utils.cutoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Individual;

public class OptimalCriteria implements CutOffCriteria {
	
	public static double MIN_FITNESS = 100;

	@Override
	public boolean shouldEnd(List<Individual> population) {
		List<Individual> auxPopulation = new ArrayList<Individual>(population);
		Collections.sort(auxPopulation);
		return auxPopulation.get(auxPopulation.size() - 1).getFitness() > MIN_FITNESS;
	}

}
