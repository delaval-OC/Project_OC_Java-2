package com.hemebiotech.analytics;

import com.hemebiotech.reader.ReadSymptomDataFromFile;
import com.hemebiotech.writer.WriteSymptomCounterDataIntoFile;

/**
 * The principal main class to run the application
 * 
 * @author delaval
 * @version v0.2
 */
public class Main {

	public static void main(String[] args) {

		AnalyticsCounter counterSymptoms = new AnalyticsCounter(new ReadSymptomDataFromFile("symptoms.txt"),
				new WriteSymptomCounterDataIntoFile("result3.out"));

		counterSymptoms.getListSymptoms();
		counterSymptoms.setHashMapCounterSymptoms();
		counterSymptoms.setFileResult();
	}

}
