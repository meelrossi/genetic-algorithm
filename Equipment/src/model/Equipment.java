package model;

public class Equipment {
	private double strength;
	private double agility;
	private double life;
	private double resistance;
	private double skill;

	public Equipment(double strength, double agility, double life, double resistance, double skill) {
		super();
		this.strength = strength;
		this.agility = agility;
		this.life = life;
		this.resistance = resistance;
		this.skill = skill;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getAgility() {
		return agility;
	}

	public void setAgility(double agility) {
		this.agility = agility;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
	}

	public double getSkill() {
		return skill;
	}

	public void setSkill(double skill) {
		this.skill = skill;
	}

}
