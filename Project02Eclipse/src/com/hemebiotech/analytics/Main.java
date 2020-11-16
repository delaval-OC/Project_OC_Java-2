package com.hemebiotech.analytics;

public class Main {

	public static void main(String[] args) {

		AnalyticsCounter counterSymptoms = new AnalyticsCounter(new ReadSymptomDataFromFile("symptoms.txt"),
				new WriteSymptomCounterDataIntoFile("result3.out"));
		counterSymptoms.setListSymptoms();
		counterSymptoms.setHashMapCounterSymptoms();
		counterSymptoms.setFileResult();
	}

}
