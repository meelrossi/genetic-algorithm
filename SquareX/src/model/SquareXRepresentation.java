package model;

import java.util.ArrayList;
import java.util.List;

public class SquareXRepresentation extends Representation {
	private int decimalRepresentation;
	private String binaryRepresentation;
	
	public SquareXRepresentation(int decimalRepresentation) {
		this.decimalRepresentation = decimalRepresentation;
		this.binaryRepresentation = String.format("%16s", Integer.toBinaryString(this.decimalRepresentation)).replace(' ', '0');
	}
	
	public SquareXRepresentation(String binaryRepresentation) {
		this.binaryRepresentation = binaryRepresentation;
		this.decimalRepresentation = Integer.parseInt(this.binaryRepresentation);
	}
	
	public String getBinaryRepresentation() {
		return this.binaryRepresentation;
	}
	
	public int getDecimalRepresentation() {
		return this.decimalRepresentation;
	}
	
	public double getFitness() {
		return this.decimalRepresentation * this.decimalRepresentation;
	}
	
	public List<Individual> getOnePointCombination(Representation rep1) {
		SquareXRepresentation rep = (SquareXRepresentation)rep1;

		List<Individual> individuals =  new ArrayList<Individual>();

		int locus = (int)Math.random() * 16;
		String lastRep1 = this.binaryRepresentation.substring(locus);
		String lastRep2 = ((SquareXRepresentation)rep).getBinaryRepresentation().substring(locus);

		individuals.add(new SquareXIndividual(this.binaryRepresentation.substring(0, locus) + lastRep2));
		individuals.add(new SquareXIndividual(rep.getBinaryRepresentation().substring(0, locus) + lastRep1));
		return individuals;
	}

	public List<Individual> getTwoPointCombination(Representation rep1) {
		SquareXRepresentation rep = (SquareXRepresentation)rep1;

		List<Individual> individuals =  new ArrayList<Individual>();

		int locus = (int)Math.random() * 16;
		int locus2 = (int)Math.random() * (16 - locus) + locus;

		String lastRep1 = this.binaryRepresentation.substring(locus, locus2);
		String lastRep2 = ((SquareXRepresentation)rep).getBinaryRepresentation().substring(locus, locus2);
		
		String newBinary1 = this.binaryRepresentation.substring(0, locus) + lastRep2 + this.binaryRepresentation.substring(locus2);
		String newBinary2 = rep.getBinaryRepresentation().substring(0, locus) + lastRep1 + rep.getBinaryRepresentation().substring(locus2);

		individuals.add(new SquareXIndividual(newBinary1));
		individuals.add(new SquareXIndividual(newBinary2));
		return individuals;
	}

	public List<Individual> getAnularCombination(Representation rep) {
		return new ArrayList<Individual>();
	}

	public List<Individual> getUniformCombination(Representation rep1) {
		SquareXRepresentation rep = ((SquareXRepresentation)rep1);
		List<Individual> individuals =  new ArrayList<Individual>();

		char[] binary1 = this.binaryRepresentation.toCharArray();
		char[] binary2 = rep.getBinaryRepresentation().toCharArray();
		for(int i = 0; i < binary1.length; i++) {
			double rand = Math.random();
			if(rand > 0.5) {
				char aux = binary1[i];
				binary1[i] = binary2[i];
				binary2[i] = aux;
			}
		}
		
		individuals.add(new SquareXIndividual(binary1.toString()));
		individuals.add(new SquareXIndividual(binary2.toString()));
		return individuals;
		
	}
}
