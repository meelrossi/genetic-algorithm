package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Equipment;
import model.EquipmentManager;
import model.Gene;
import model.Individual;
import model.ProblemIndividual;
import model.WarriorIndividual;
import utils.MethodPercentage;
import utils.PropertyManager;

public class EquipmentAlgorithm {
	private static double MIN_HEIGHT = 1.3;
	private static double MAX_HEIGHT = 2.0;

	private List<Individual> population;
	private PropertyManager properties;
	private MethodPercentage selectionOne;
	private MethodPercentage selectionTwo;
	
	public static Random randNum;

	public EquipmentAlgorithm() {
		this.properties = new PropertyManager();
		randNum = new Random();
		randNum.setSeed(this.properties.getSeed());
		this.selectionOne = this.properties.getSelectionMethodOne();
		this.selectionTwo = this.properties.getSelectionMethodTwo();

		this.population = getWarriorPopulation();
	}

	public Individual run() {
		List<Individual> selectedPopulation = new ArrayList<Individual>();
		List<Individual> crossedPopulation = new ArrayList<Individual>();
		int k = this.properties.getK();

		// mean and deviation
		int runCount = 0;
		printMeanAndDeviation(runCount);

		while (!this.properties.getCutOffCriteria().shouldEnd(this.population)) {
			selectedPopulation.clear();
			crossedPopulation.clear();

			int methodSize = (int) (k * this.selectionOne.getPercentage());
			// select parents to combine
			selectedPopulation.addAll(this.selectionOne.getMethod().getSelected(population, methodSize));
			selectedPopulation.addAll(this.selectionTwo.getMethod().getSelected(population, k - methodSize));
			Collections.shuffle(selectedPopulation, randNum);

			// create combinations
			List<List<Gene>> newChromosomes = this.properties.getCombineSelection().getCombined(selectedPopulation, this.properties.getCombinationMethod());
			newChromosomes.forEach(newChromosome -> crossedPopulation.add(new WarriorIndividual(newChromosome)));

			// mutate
			for (Individual crossedIndividual : crossedPopulation) {
				double rand = randNum.nextDouble();
				if (rand < this.properties.getMutationPercentage()) {
					this.properties.getMutationMethod().mutate(crossedIndividual);
					((ProblemIndividual) crossedIndividual).calculateValues();
				}
			}

			// replace for new generation creation
			this.population = this.properties.getReplacementMethod().replace(population, crossedPopulation,
					this.properties.getReplacementMethodOne(), this.properties.getReplacementMethodTwo());

			// mean and deviation
			runCount++;
			if (runCount % 20 == 0) {
				printMeanAndDeviation(runCount);
			}
		}

		Collections.sort(this.population, Collections.reverseOrder());
		return this.population.get(0);
	}

	public List<Individual> getWarriorPopulation() {
		List<Individual> warriors = new ArrayList<Individual>();
		List<List<Equipment>> equipments = EquipmentManager.instance().getEquipments();		
		for (int i = 0; i < properties.getPopulationSize(); i++) {
			List<Gene> chromosome = new ArrayList<Gene>();
			equipments.forEach(list -> chromosome.add(new Gene(randNum.nextDouble() * list.size(), 0, list.size())));
			chromosome.add(new Gene(randNum.nextDouble() * (MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT, MIN_HEIGHT, MAX_HEIGHT));
			//chromosome.add(new Gene(1.95, MIN_HEIGHT, MAX_HEIGHT));
			warriors.add(new WarriorIndividual(chromosome));
		}
		return warriors;
	}

	private void printMeanAndDeviation(int runCount) {
		double mean = 0.0;
		double deviation = 0.0;
		int n = this.population.size();
		for (Individual p : this.population) {
			mean += p.getFitness();
		}
		mean = mean / n;
		for (Individual p : this.population) {
			deviation += Math.pow(p.getFitness() - mean, 2);
		}
		deviation = deviation / n;
		System.out.println(runCount + "\t" + mean + "\t" + deviation);
	}
}
