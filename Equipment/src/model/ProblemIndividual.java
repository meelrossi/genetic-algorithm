package model;

import java.util.List;

public abstract class ProblemIndividual extends Individual {

	protected double strength;
	protected double agility;
	protected double skill;
	protected double life;
	protected double resistance;

	public ProblemIndividual(List<Gene> chromosome) {
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

	protected abstract void setStrength();
	protected abstract void setAgility();
	protected abstract void setSkill();
	protected abstract void setLife();
	protected abstract void setResistance();

	public double getATM() {
		double h = chromosome.get(ChromosomeIndexes.HEIGHT.index()).getValue();
		return 0.5 - Math.pow(3 * h - 5, 4) + Math.pow(3 * h - 5, 2) + h / 2;
	}
	
	public double getDEM() {
		double h = chromosome.get(ChromosomeIndexes.HEIGHT.index()).getValue();
		return 2 + Math.pow(3 * h - 5, 4) - Math.pow(3 * h - 5, 2) - h / 2;
	}

	public double getAttack() {
		return (agility + skill) * strength * getATM();
	}

	public double getDeffense() {
		return (resistance + skill) * life * getDEM();
	}

	public double getStrength() {
		return strength;
	}

	public double getAgility() {
		return agility;
	}

	public double getSkill() {
		return skill;
	}

	public double getLife() {
		return life;
	}

	public double getResistance() {
		return resistance;
	}
}
