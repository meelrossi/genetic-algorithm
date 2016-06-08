package model;

public class WarriorFitness implements Fitness{

	@Override
	public double getFitness(Individual ind) {
		return 0.6 * ind.getAttack() + 0.4 * ind.getDeffense();
	}
	
}
