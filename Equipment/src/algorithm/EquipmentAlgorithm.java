package algorithm;

import java.util.List;

import model.EquipmentManager;
import model.Individual;
import utils.PropertyManager;
import utils.SelectionMethod;

public class EquipmentAlgorithm {
	private List<Individual> population;
	private PropertyManager properties;
	
	private SelectionMethod selMethodOne;
	private double selMethodOnePercentage;
	private SelectionMethod selMethodTwo;
	private double selMethodTwoPercentage;
	
	public EquipmentAlgorithm() {
		this.properties = new PropertyManager();
		initialize();
	}
	
	public void initialize() {
		this.selMethodOne = properties.getSelMethodOne();
		this.selMethodOnePercentage = properties.getMethodOnePercentage();
		this.selMethodTwo = properties.getSelMethodTwo();
		this.selMethodTwoPercentage = properties.getSelMethodTwoPercentage();
	}

	public void run() {
		EquipmentManager manager = EquipmentManager.instance();
	}
}
