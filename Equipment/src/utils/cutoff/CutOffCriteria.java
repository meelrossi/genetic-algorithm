package utils.cutoff;

import java.util.List;

import model.Individual;

public interface CutOffCriteria {

	public boolean shouldEnd(List<Individual> population);
}
