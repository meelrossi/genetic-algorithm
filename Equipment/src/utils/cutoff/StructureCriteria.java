package utils.cutoff;

import java.util.List;

import model.Individual;

public class StructureCriteria implements CutOffCriteria {
	public static double DELTA = 10;

	@Override
	public boolean shouldEnd(List<Individual> population) {
		double fitness = population.get(0).getFitness();
		for (Individual ind : population) {
			if (ind.getFitness() > fitness + DELTA || ind.getFitness() < fitness - DELTA) {
				return false;
			}
		}
		return true;
	}

}
