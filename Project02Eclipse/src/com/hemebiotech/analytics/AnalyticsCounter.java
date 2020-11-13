package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {

		FileReader file = null;
		BufferedReader reader = null;
		String line;

		/**
		 * Read of each line of file symptoms.txt and count of number of occurrence for
		 * 3 symptoms
		 */

		try {
			file = new FileReader("symptoms.txt");
			reader = new BufferedReader(file);

			while ((line = reader.readLine()) != null) {

				if (line.equals("headache")) {
					headacheCount++;
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}

		System.out.println("read of file \"symptoms.txt\" finished !");

		/**
		 * generate a file result.out with for each line, the description of symptom and
		 * the number of occurrence counted in file symptoms.txt
		 */

		FileWriter writer = null;

		try {
			writer = new FileWriter("result.out");

			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

		System.out.println("creation of new file \"result.out\" with counts of symptoms is done !");
	}
}
