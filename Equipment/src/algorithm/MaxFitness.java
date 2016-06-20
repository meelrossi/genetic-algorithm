package algorithm;

import java.util.ArrayList;
import java.util.List;

import model.ChromosomeIndexes;
import model.Equipment;
import model.EquipmentManager;

public class MaxFitness {
	private static double STRENGTH_COEF = 1.1;
	private static double AGILITY_COEF = 0.6;
	private static double SKILL_COEF = 0.5;
	private static double RESISTANCE_COEF = 1.2;
	private static double LIFE_COEF = 1.1;
	
	public static void main(String[] args) {
		EquipmentManager manager = EquipmentManager.instance();
		List<List<Equipment>> equipments = manager.getEquipments();
		List<Equipment> maxFitnessChromosome = null;
		double maxFitness = 0;
		double agility, strength, skill, life, resistance;
		for(Equipment weapon: equipments.get(ChromosomeIndexes.WEAPONS.index())) {
			for(Equipment glove: equipments.get(ChromosomeIndexes.GLOVES.index())) {
				for(Equipment shirt: equipments.get(ChromosomeIndexes.SHIRT.index())) {
					for(Equipment helmet: equipments.get(ChromosomeIndexes.HELMET.index())) {
						for(Equipment boot: equipments.get(ChromosomeIndexes.BOOTS.index())) {
							List<Equipment> chromosome = new ArrayList<Equipment>();
							chromosome.add(weapon);
							chromosome.add(glove);
							chromosome.add(shirt);
							chromosome.add(helmet);
							chromosome.add(boot);
							agility = 0;
							strength = 0;
							skill = 0;
							life = 0;
							resistance = 0;
							for(Equipment e : chromosome) {
								agility += e.getAgility();
								strength += e.getStrength();
								skill += e.getSkill();
								life += e.getLife();
								resistance += e.getResistance();
							}
							strength = 100 * Math.tanh(0.01 * STRENGTH_COEF * strength);
							agility = Math.tanh(0.01 * AGILITY_COEF * agility);
							skill = 0.6 * Math.tanh(0.01 * SKILL_COEF * skill);
							life = 100 * Math.tanh(0.01 * LIFE_COEF * life);
							resistance = Math.tanh(0.01 * RESISTANCE_COEF * resistance);
							double h = 1.95;
							double atack = (agility + skill) * strength * 0.5 - Math.pow(3 * h - 5, 4) + Math.pow(3 * h - 5, 2) + h / 2;
							double defense = (resistance + skill) * life * 2 + Math.pow(3 * h - 5, 4) - Math.pow(3 * h - 5, 2) - h / 2;;
							double fitness = 0.6 * atack + 0.4 * defense;
							if(fitness > maxFitness) {
								System.out.println(fitness);
								maxFitness = fitness;
								maxFitnessChromosome = chromosome;
							}
						}
					}
				}
			}	
		}
		System.out.println(maxFitness);
		System.out.println("armas " + maxFitnessChromosome.get(0).getId());
		System.out.println("guante " + maxFitnessChromosome.get(1).getId());
		System.out.println("remera " + maxFitnessChromosome.get(2).getId());
		System.out.println("gorro " + maxFitnessChromosome.get(3).getId());
		System.out.println("botas " + maxFitnessChromosome.get(4).getId());
	}
}
