package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentManager {
	private static EquipmentManager instance;

	private List<List<Equipment>> equipments;

	private EquipmentManager() {
		this.equipments = new ArrayList<List<Equipment>>();
		this.equipments.add(new ArrayList<Equipment>());
		this.equipments.add(new ArrayList<Equipment>());
		this.equipments.add(new ArrayList<Equipment>());
		this.equipments.add(new ArrayList<Equipment>());
		this.equipments.add(new ArrayList<Equipment>());
		initialize();
	}

	public static EquipmentManager instance() {
		if(instance == null) {
			instance = new EquipmentManager();
		}
		return instance;
	}

	private void initialize() {
		readFile("files/armas.tsv", equipments.get(ChromosomeIndexes.WEAPONS.index()));
		readFile("files/guantes.tsv", equipments.get(ChromosomeIndexes.GLOVES.index()));
		readFile("files/pecheras.tsv", equipments.get(ChromosomeIndexes.SHIRT.index()));
		readFile("files/cascos.tsv", equipments.get(ChromosomeIndexes.HELMET.index()));
		readFile("files/botas.tsv", equipments.get(ChromosomeIndexes.BOOTS.index()));
	}

	private void readFile(String filename, List<Equipment> outputList) {		
		try {
			BufferedReader TSVFile = new BufferedReader(new FileReader(filename));
			TSVFile.readLine();
			String dataRow = TSVFile.readLine();
			while (dataRow != null) {
				String[] dataArray = dataRow.split("\t");
				int id = Integer.parseInt(dataArray[0]);
				double strength = Double.parseDouble(dataArray[1]);
				double agility = Double.parseDouble(dataArray[2]);
				double skill = Double.parseDouble(dataArray[3]);
				double resistance = Double.parseDouble(dataArray[4]);
				double life = Double.parseDouble(dataArray[5]);
				Equipment equipment = new Equipment(id, strength, agility, skill, resistance, life);
				outputList.add(equipment);
				dataRow = TSVFile.readLine();
			}
			TSVFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public double getStrength(List<Gene> chromosome) {
		double strength = 0;
		for (int i = ChromosomeIndexes.WEAPONS.index(); i <= ChromosomeIndexes.BOOTS.index(); i++) {
			strength += equipments.get(i).get((int)chromosome.get(i).getValue()).getStrength();
		}
		return strength;
	}
	
	public double getAgility(List<Gene> chromosome) {
		double agility = 0;
		for (int i = ChromosomeIndexes.WEAPONS.index(); i <= ChromosomeIndexes.BOOTS.index(); i++) {
			agility += equipments.get(i).get((int)chromosome.get(i).getValue()).getAgility();
		}
		return agility;
	}
	
	public double getLife(List<Gene> chromosome) {
		double life = 0;
		for (int i = ChromosomeIndexes.WEAPONS.index(); i <= ChromosomeIndexes.BOOTS.index(); i++) {
			life += equipments.get(i).get((int)chromosome.get(i).getValue()).getLife();
		}
		return life;
	}
	
	public double getResistance(List<Gene> chromosome) {
		double resistance = 0;
		for (int i = ChromosomeIndexes.WEAPONS.index(); i <= ChromosomeIndexes.BOOTS.index(); i++) {
			resistance += equipments.get(i).get((int)chromosome.get(i).getValue()).getResistance();
		}
		return resistance;
	}
	
	public double getSkill(List<Gene> chromosome) {
		double skill = 0;
		for (int i = ChromosomeIndexes.WEAPONS.index(); i <= ChromosomeIndexes.BOOTS.index(); i++) {
			skill += equipments.get(i).get((int)chromosome.get(i).getValue()).getSkill();
		}
		return skill;
	}
}
