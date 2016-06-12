package model;

import java.util.List;

public class WarriorIndividual extends Individual {

	private static double STRENGTH_COEF = 1.1;
	private static double AGILITY_COEF = 0.6;
	private static double SKILL_COEF = 0.5;
	private static double RESISTANCE_COEF = 1.2;
	private static double LIFE_COEF = 1.1;

	private double strength;
	private double agility;
	private double skill;
	private double life;
	private double resistance;

	public WarriorIndividual(List<Gene> chromosome) {
		super(chromosome);
		calculateValues();
	}

	public void calculateValues() {
		setStrength();
		setAgility();
		setSkill();
		setLife();
		setResistance();
	}

	public double getStrength() {
		return strength;
	}

	private void setStrength() {
		this.strength = 100 * Math.tanh(0.01 * STRENGTH_COEF * EquipmentManager.instance().getStrength(chromosome));
	}

	public double getAgility() {
		return agility;
	}

	private void setAgility() {
		this.agility = Math.tanh(0.01 * AGILITY_COEF * EquipmentManager.instance().getAgility(chromosome));
	}

	public double getSkill() {
		return skill;
	}

	private void setSkill() {
		this.skill = 0.6 * Math.tanh(0.01 * SKILL_COEF * EquipmentManager.instance().getSkill(chromosome));
	}

	public double getLife() {
		return life;
	}

	private void setLife() {
		this.life = 100 * Math.tanh(0.01 * LIFE_COEF * EquipmentManager.instance().getLife(chromosome));
	}

	public double getResistance() {
		return resistance;
	}

	private void setResistance() {
		this.resistance = Math.tanh(0.01 * RESISTANCE_COEF * EquipmentManager.instance().getResistance(chromosome));
	}

	public double getAttack() {
		return (agility + skill) * strength * getATM();
	}

	public double getDeffense() {
		return (resistance + skill) * life * getDEM();
	}

	public double getATM() {
		double h = chromosome.get(ChromosomeIndexes.HEIGHT.index()).getValue();
		return 0.5 - Math.pow(3 * h - 5, 4) + Math.pow(3 * h - 5, 2) + h / 2;
	}
	
	public double getDEM() {
		double h = chromosome.get(ChromosomeIndexes.HEIGHT.index()).getValue();
		return 2 + Math.pow(3 * h - 5, 4) - Math.pow(3 * h - 5, 2) - h / 2;
	}

	@Override
	public double getFitness() {
		return 0.6 * getAttack() + 0.4 * getDeffense();
	}
}
