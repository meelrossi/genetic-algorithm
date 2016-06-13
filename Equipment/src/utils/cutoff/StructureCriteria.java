package utils.cutoff;

import java.util.List;

import model.Individual;

public class StructureCriteria implements CutOffCriteria {
	public double delta;

	public StructureCriteria(double delta) {
		this.delta = delta;
	}

	@Override
	public boolean shouldEnd(List<Individual> population) {
		double fitness = 0;
		for (Individual ind : population) {
			fitness += ind.getFitness();
		}
		fitness = fitness / population.size();

		for (Individual ind : population) {
			if (ind.getFitness() > fitness + delta || ind.getFitness() < fitness - delta) {
				return false;
			}
		}
		return true;
	}

}
