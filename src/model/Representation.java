package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Representation {
	public abstract double getFitness();

	public List<Individual> getOnePointCombination(Representation rep) {
		return new ArrayList<Individual>();
	}

	public List<Individual> getTwoPointCombination(Representation rep) {
		return new ArrayList<Individual>();
	}

	public List<Individual> getAnularCombination(Representation rep) {
		return new ArrayList<Individual>();
	}

	public List<Individual> getUniformCombination(Representation rep) {
		return new ArrayList<Individual>();
	}
}
