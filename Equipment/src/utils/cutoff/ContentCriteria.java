package utils.cutoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Individual;

public class ContentCriteria implements CutOffCriteria {
	public double numGen;
	public double maxFitness = 0;
	public int consecutiveGen = 0;

	public ContentCriteria(double numGen) {
		this.numGen = numGen;
	}

	@Override
	public boolean shouldEnd(List<Individual> population) {
		List<Individual> auxPopulation = new ArrayList<Individual>(population);
		Collections.sort(auxPopulation);
		int populationSize = auxPopulation.size();
		if (maxFitness < auxPopulation.get(populationSize - 1).getFitness()) {
			consecutiveGen = 0;
			maxFitness = auxPopulation.get(populationSize - 1).getFitness();
			return false;
		}
		consecutiveGen++;
		if (consecutiveGen == numGen) {
			return true;
		}
		return false;
	}

}
