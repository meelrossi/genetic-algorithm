package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import utils.cutoff.CutOffCriteria;
import utils.cutoff.CutOffCriteriaEnum;

public class PropertyManager {
	private Properties properties;
	private FileInputStream fileIn;

	// Algorithm Properties
	private MethodPercentage selectionMethodOne;
	private MethodPercentage selectionMethodTwo;
	private MethodPercentage replacementMethodOne;
	private MethodPercentage replacementMethodTwo;
	private int populationSize;
	private MutationMethod mutationMethod;
	private CutOffCriteria cutoffCriteria;
	private CombinationMethod combinationMethod;
	private ReplacementMethod replacementMethod;
	private int k;
	private double mutationPercentage;

	public PropertyManager() {
		properties = new Properties();
		FileInputStream fileIn;
		try {

			fileIn = new FileInputStream("files/algorithm.properties");
			properties.load(fileIn);
			loadProperties();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			fileIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadProperties() {
		this.selectionMethodOne = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("selection.one.type", "Elite")),
				Double.parseDouble(properties.getProperty("selection.one.percentage", "1")));

		if (selectionMethodOne.getPercentage() > 1) {
			throw new RuntimeException("Invalid selectionOnePercentage argument. Must be between 0 and 1.");
		}

		this.selectionMethodTwo = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("selection.two.type", "Roulette")),
				1 - selectionMethodOne.getPercentage());

		this.replacementMethodOne = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("replacement.one.type", "Elite")),
				Double.parseDouble(properties.getProperty("replacement.one.percentage", "1")));

		if (replacementMethodOne.getPercentage() > 1) {
			throw new RuntimeException("Invalid replacementOnePercentage argument. Must be between 0 and 1.");
		}

		this.replacementMethodTwo = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("replacement.two", "Roulette")),
				1 - replacementMethodOne.getPercentage());

		this.populationSize = Integer.parseInt(properties.getProperty("population.size", "20"));

		this.mutationMethod = MutationMethod.valueOf(properties.getProperty("mutation.type", "Classic"));

		this.cutoffCriteria = CutOffCriteriaEnum.valueOf(properties.getProperty("cutoff.type", "Generation"))
				.getCriteriaClass(Double.parseDouble(properties.getProperty("cutoff.parameter", "0")));

		this.combinationMethod = CombinationMethod.valueOf(properties.getProperty("combination.type", "OnePoint"));

		this.replacementMethod = ReplacementMethod.valueOf(properties.getProperty("replacement.type", "ReplaceAll"));
		this.k = Integer.parseInt(properties.getProperty("population.k", Integer.toString(this.populationSize)));

		if (this.k > this.populationSize) {
			throw new RuntimeException("Invalid k argument. Must be between 1 and populationSize.");
		}
		if (replacementMethod.equals(ReplacementMethod.ReplaceAll)) {
			this.k = this.populationSize;
		}
		
		this.mutationPercentage = Double.parseDouble(properties.getProperty("mutation.parameter", "0.1"));
		
		
	}

	public MethodPercentage getSelectionMethodOne() {
		return this.selectionMethodOne;
	}

	public MethodPercentage getSelectionMethodTwo() {
		return this.selectionMethodTwo;
	}

	public MethodPercentage getReplacementMethodOne() {
		return this.replacementMethodOne;
	}

	public MethodPercentage getReplacementMethodTwo() {
		return this.replacementMethodTwo;
	}

	public int getPopulationSize() {
		return this.populationSize;
	}

	public MutationMethod getMutationMethod() {
		return this.mutationMethod;
	}

	public CutOffCriteria getCutOffCriteria() {
		return this.cutoffCriteria;
	}

	public CombinationMethod getCombinationMethod() {
		return this.combinationMethod;
	}

	public ReplacementMethod getReplacementMethod() {
		return this.replacementMethod;
	}

	public int getK() {
		return this.k;
	}
	
	public double getMutationPercentage() {
		return this.mutationPercentage;
	}
}
