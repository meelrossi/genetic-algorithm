package model;

public class Equipment {
	private int id;
	private double strength;
	private double agility;
	private double life;
	private double resistance;
	private double skill;

	public Equipment(int id, double strength, double agility, double skill, double resistance, double life) {
		super();
		this.id = id;
		this.strength = strength;
		this.agility = agility;
		this.life = life;
		this.resistance = resistance;
		this.skill = skill;
	}
	
	public int getId() {
		return id;
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
