package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class AnalyticsCounter {

	private ISymptomReader symptomReader;
	private ISymptomWriter symptomWriter;

	private List<String> listSymptoms;
	private LinkedHashMap<String, Integer> hashMapCounterSymptom;

	/**
	 * constructs a instance with two attributes witch implements respectively
	 * interface ISymptomReader and ISymptomWriter to be able to read in and write
	 * into any file
	 * 
	 * @param symptomsReader
	 * @param symptomWriter
	 */
	public AnalyticsCounter(ISymptomReader symptomsReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomsReader;
		this.symptomWriter = symptomWriter;
	}

	/**
	 * generate a List of all symptoms presents in a file using symptomReader
	 */
	public void setListSymptoms() {
		this.listSymptoms = symptomReader.GetSymptoms();
	}

	public void setFileResult() {
		this.symptomWriter.setResultIntoFile(hashMapCounterSymptom);
	}

	public void setHashMapCounterSymptoms() {
		hashMapCounterSymptom = new LinkedHashMap<String, Integer>();

		if (!listSymptoms.isEmpty()) {

			Collections.sort(listSymptoms);

			System.out.println("**********************************************************");
			System.out.println("list of symptoms sorted !");
			System.out.println(listSymptoms);

			String symptom;

			for (int i = 0; i < listSymptoms.size(); i++) {

				symptom = listSymptoms.get(i);

				hashMapCounterSymptom.put(symptom, listSymptoms.lastIndexOf(symptom) - i + 1);

				i = listSymptoms.lastIndexOf(symptom);

			}

		}
		System.out.println("**********************************************************");
		System.out.println("HashMap sorted and terminated!");
		System.out.println(hashMapCounterSymptom);
	}
}
