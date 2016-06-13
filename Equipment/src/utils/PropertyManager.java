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
				SelectionMethod.valueOf(properties.getProperty("selectionOne", "Elitte")),
				Double.parseDouble(properties.getProperty("selectionOnePercentage", "1")));
		this.selectionMethodTwo = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("selectionTwo", "Roulette")),
				Double.parseDouble(properties.getProperty("selectionTwoPercentage", "0")));
		this.replacementMethodOne = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("replacementOne", "Elitte")),
				Double.parseDouble(properties.getProperty("replacementOnePercentage", "1")));
		this.replacementMethodTwo = new MethodPercentage(
				SelectionMethod.valueOf(properties.getProperty("replacementTwo", "Roulette")),
				Double.parseDouble(properties.getProperty("replacementTwoPercentage", "0")));
		this.populationSize = Integer.parseInt(properties.getProperty("populationSize", "20"));
		this.mutationMethod = MutationMethod.valueOf(properties.getProperty("mutation", "Classic"));
		this.cutoffCriteria = CutOffCriteriaEnum.valueOf(properties.getProperty("cutoffCriteria", "Generation"))
				.getCriteriaClass(Double.parseDouble(properties.getProperty("cutoffParameter", "0")));
		this.combinationMethod = CombinationMethod.valueOf(properties.getProperty("combination", "OnePoint"));

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

}
