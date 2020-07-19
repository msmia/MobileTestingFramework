package com.gobrightside.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
		
	public static  Properties readPropertyFiles(String file) {
		
		Properties prop = null;

		try {

			// Properties file
			Properties propConfig = new Properties();
			propConfig.load(new FileInputStream(file));

			// All objects merged property instance
			prop = new Properties();

			// file
			prop.putAll(propConfig);

		} catch (IOException e) {
			e.getMessage();
		}
		return prop;
	}
}
