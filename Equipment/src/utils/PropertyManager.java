package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private Properties properties;
	private FileInputStream fileIn;
	
	public PropertyManager() {
		properties = new Properties();
		FileInputStream fileIn;
		try {
			
			fileIn = new FileInputStream("files/algorithm.properties");
			properties.load(fileIn);
			
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
	
	public String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
	
	public String getProperty(String propertyName, String defaultValue) {
		return properties.getProperty(propertyName, defaultValue);
	}

	public SelectionMethod getSelMethodOne() {
		return SelectionMethod.valueOf(properties.getProperty("selMethodOne", "Elitte"));
	}

	public double getMethodOnePercentage() {
		return Double.parseDouble(properties.getProperty("selMethodOnePerc", "1"));
	}

	public SelectionMethod getSelMethodTwo() {
		return SelectionMethod.valueOf(properties.getProperty("selMethodTwo", "Roulette"));
	}

	public double getSelMethodTwoPercentage() {
		return Double.parseDouble(properties.getProperty("selMethodTwoPerc", "0"));
	}
}
