package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0

	public static void main(String args[]) throws Exception {

		FileReader inputFile = null;
		BufferedReader BufferReader = null;
		String line;

		/**
		 * Read of each line of file symptoms.txt and count of number of occurrence for
		 * 3 symptoms
		 */

		try {
			inputFile = new FileReader("symptoms.txt");
			BufferReader = new BufferedReader(inputFile);

			while ((line = BufferReader.readLine()) != null) {

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
			BufferReader.close();
		}

		System.out.println("read of file \"symptoms.txt\" finished !");

		/**
		 * generate a file result.out with for each line, the description of symptom and
		 * the number of occurrence counted in file symptoms.txt
		 */

		FileWriter outFile = null;
		BufferedWriter bufferWriter = null;

		try {
			outFile = new FileWriter("result.out");
			bufferWriter = new BufferedWriter(outFile);

			bufferWriter.write("headache: " + headacheCount + "\n");
			bufferWriter.write("rash: " + rashCount + "\n");
			bufferWriter.write("dialated pupils: " + pupilCount + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bufferWriter.close();
			outFile.close();
		}

		System.out.println("creation of new file \"result.out\" with counts of symptoms is done !");
	}
}
