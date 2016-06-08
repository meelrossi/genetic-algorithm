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
			
			fileIn = new FileInputStream("algorithm");
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
}
