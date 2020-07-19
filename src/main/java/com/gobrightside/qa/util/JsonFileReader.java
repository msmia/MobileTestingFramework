package com.gobrightside.qa.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class JsonFileReader<T> {

	
	/**
	 * Read Json file and return all the values
	 * @param pathToResources
	 * @param fileName
	 * @param cls
	 * @return
	 */
	public static <T> T loadDaTa(String pathToResources, String fileName, Class<T> cls) {

		File fs = new File(pathToResources + fileName);
		T jsonValues = null;

		BufferedReader br = null;
		Gson gson = new Gson();

		try {
			br = new BufferedReader(new FileReader(fs));
			jsonValues = gson.fromJson(br, cls);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + pathToResources + "/" + fileName);
		} finally {
			try { if (br != null) br.close();} catch (IOException e) {}
		}
		return jsonValues;
	}
	
	
	

}
