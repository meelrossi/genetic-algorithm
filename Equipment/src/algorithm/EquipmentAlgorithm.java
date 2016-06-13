package algorithm;

import java.util.List;

import model.EquipmentManager;
import model.Individual;
import utils.PropertyManager;

public class EquipmentAlgorithm {
	private List<Individual> population;
	private PropertyManager properties;

	public EquipmentAlgorithm() {
		this.properties = new PropertyManager();
	}

	public void run() {
		EquipmentManager manager = EquipmentManager.instance();
	}
}
