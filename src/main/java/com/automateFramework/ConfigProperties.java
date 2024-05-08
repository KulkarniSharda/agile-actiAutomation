package com.automateFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

	FileInputStream inputFile;
	Properties prop;

	public ConfigProperties() {

		File file = new File("config.properties");

		try {
			// this class will read the file
			inputFile = new FileInputStream(file);

			// created the instance of Properties class to access the properties file
			prop = new Properties();

			// this will load the properties file
			prop.load(inputFile);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public long getProperty(String key) {

		return prop.getProperty(key);

	}

}
