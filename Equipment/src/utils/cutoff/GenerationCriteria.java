package utils.cutoff;

import java.util.List;

import model.Individual;

public class GenerationCriteria implements CutOffCriteria {
	private double maxGenerationSize;
	private int generation = 0;

	public GenerationCriteria(double maxGenerationSize) {
		this.maxGenerationSize = maxGenerationSize;
	}

	@Override
	public boolean shouldEnd(List<Individual> population) {
		generation++;
		return generation > maxGenerationSize;
	}

}
