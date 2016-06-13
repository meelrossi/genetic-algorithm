package utils.cutoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Individual;

public class ContentCriteria implements CutOffCriteria {
	public static int NUM_GEN = 5;
	public double maxFitness = 0;
	public int consecutiveGen = 0;

	@Override
	public boolean shouldEnd(List<Individual> population) {
		List<Individual> auxPopulation = new ArrayList<Individual>(population);
		Collections.sort(auxPopulation);
		if(maxFitness < auxPopulation.get(auxPopulation.size() - 1).getFitness()) {
			consecutiveGen = 0;
			maxFitness = auxPopulation.get(auxPopulation.size() - 1).getFitness();
			return false;
		}
		if(consecutiveGen == NUM_GEN) {
			return true;
		}
		consecutiveGen++;
		return false;
	}

}
