package algorithm;

import model.Individual;

public class Test {

	public static void main(String[] args) {
		EquipmentAlgorithm ea = new EquipmentAlgorithm();
		Individual ind = ea.run();
		
		System.out.println(ind.toString());
	}
}
