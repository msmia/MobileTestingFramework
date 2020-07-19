package com.gobrightside.qa.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

	/**
	 * Read string user input
	 * @return
	 */
	public static String[] getUserInput() {
		
		System.out.println("Enter the confirmation code: ");
		
		String s = null;
		String[] strChar = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			s = br.readLine();
			strChar = s.split("(?!^)");
		} catch (NumberFormatException | IOException e) {
			e.getMessage();
		}
	  return strChar;
	}
}
