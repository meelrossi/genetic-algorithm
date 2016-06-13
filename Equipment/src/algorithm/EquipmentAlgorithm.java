package algorithm;

import java.util.ArrayList;
import java.util.List;

import model.Equipment;
import model.EquipmentManager;
import model.Gene;
import model.ProblemIndividual;
import model.WarriorIndividual;
import utils.PropertyManager;

public class EquipmentAlgorithm {
	private static double MIN_HEIGHT = 1.3;
	private static double MAX_HEIGHT = 2.0;
		
	private List<ProblemIndividual> population;
	private PropertyManager properties;

	public EquipmentAlgorithm() {
		this.properties = new PropertyManager();
		this.population = getWarriorPopulation();
	}

	public void run() {
	}
	
	public List<ProblemIndividual> getWarriorPopulation() {
		List<ProblemIndividual> warriors = new ArrayList<ProblemIndividual>();
		List<List<Equipment>> equipments = EquipmentManager.instance().getEquipments();
		for(int i = 0; i < properties.getPopulationSize(); i++) {
			List<Gene> chromosome = new ArrayList<Gene>();
			equipments.forEach(list -> chromosome.add(new Gene(Math.random() * list.size(), 0, list.size())));
			chromosome.add(new Gene(Math.random() * (MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT, MIN_HEIGHT, MAX_HEIGHT));
			warriors.add(new WarriorIndividual(chromosome));
		}
		return warriors;
	}
}
