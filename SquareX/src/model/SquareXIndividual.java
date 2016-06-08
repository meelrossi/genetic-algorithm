package model;

public class SquareXIndividual extends Individual{
	
	public SquareXIndividual(int decimalRepresentation) {
		super();
		setRepresentation(new SquareXRepresentation(decimalRepresentation));
	}
	
	public SquareXIndividual(String binaryRepresentation) {
		super();
		setRepresentation(new SquareXRepresentation(binaryRepresentation));
	}

}
