package model;

import utils.GeneticAlgorithmUtils;

public class SquareXIndividual extends Individual{
	
	public SquareXIndividual(int decimalRepresentation) {
		super(decimalRepresentation);
	}
	
	public SquareXIndividual(String binaryRepresentation) {
		super(binaryRepresentation);
	}

	public void setFitness() {
		this.fitness = GeneticAlgorithmUtils.SquareXFitness(this.decimalRepresentation);
	}

}
