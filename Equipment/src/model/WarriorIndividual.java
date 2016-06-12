package model;

import java.util.List;

public class WarriorIndividual extends Individual {

	private double strength;
	private double agility;
	private double skill;
	private double life;
	private double resistance;

	public WarriorIndividual(List<Gene> chromosome) {
		super(chromosome);
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
		double strength = 0;
		for(int i = 0; i < chromosome.size(); i++) {
			
		}
		this.strength = strength;
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

	public double getAttack() {
		return 0;
	}

	public double getDeffense() {
		return 0;
	}

	@Override
	public double getFitness() {
		return 0.6 * getAttack() + 0.4 * getDeffense();
	}
}
