package utils.cutoff;

import java.util.List;

import model.Individual;

public class GenerationCriteria implements CutOffCriteria {
	private static int MAX_GENERATION_SIZE = 40;
	private int generation = 0;

	@Override
	public boolean shouldEnd(List<Individual> population) {
		generation++;
		return generation > MAX_GENERATION_SIZE;
	}

}
