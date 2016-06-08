package model;

import java.util.List;

public interface Fitness {
	public double getFitness(List<Gene> chromosome);
}
