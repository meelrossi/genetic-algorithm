package model;

import java.util.ArrayList;
import java.util.List;

public class WarriorIndividual extends ProblemIndividual {

	private static double STRENGTH_COEF = 1.1;
	private static double AGILITY_COEF = 0.6;
	private static double SKILL_COEF = 0.5;
	private static double RESISTANCE_COEF = 1.2;
	private static double LIFE_COEF = 1.1;

	public WarriorIndividual(List<Gene> chromosome) {
		super(chromosome);
	}
	
	public WarriorIndividual(int id, List<Gene> chromosome) {
		super(chromosome);
	}

	@Override
	protected void setStrength() {
		this.strength = 100 * Math.tanh(0.01 * STRENGTH_COEF * EquipmentManager.instance().getStrength(chromosome));
	}

	@Override
	protected void setAgility() {
		this.agility = Math.tanh(0.01 * AGILITY_COEF * EquipmentManager.instance().getAgility(chromosome));
	}

	@Override
	protected void setSkill() {
		this.skill = 0.6 * Math.tanh(0.01 * SKILL_COEF * EquipmentManager.instance().getSkill(chromosome));
	}

	@Override
	protected void setLife() {
		this.life = 100 * Math.tanh(0.01 * LIFE_COEF * EquipmentManager.instance().getLife(chromosome));
	}

	@Override
	protected void setResistance() {
		this.resistance = Math.tanh(0.01 * RESISTANCE_COEF * EquipmentManager.instance().getResistance(chromosome));
	}

	@Override
	public double getFitness() {
		return 0.6 * getAttack() + 0.4 * getDeffense();
	}

	@Override
	public Individual clone() {
		List<Gene> cloneChromosome = new ArrayList<Gene>();

		this.chromosome.forEach(gene -> cloneChromosome.add(gene.clone()));

		return new WarriorIndividual(id, cloneChromosome);
	}
}
