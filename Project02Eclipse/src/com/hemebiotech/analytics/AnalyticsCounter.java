package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import com.hemebiotech.reader.ISymptomReader;
import com.hemebiotech.writer.ISymptomWriter;

/**
 * <p>
 * AnalyticsCounter is a class, due to its methods, that allow to:
 * </p>
 * <ul>
 * <li>Read data from a file into a List</li>
 * <li>Count the number of occurrences of each value in this list and put the
 * result (value, count) in a linkedHashMap</li>
 * <li>Write the data (value,count) into a file, each per line</li>
 * </ul>
 * <p>
 * AnalyticsCounter contains private fields:
 * </p>
 * <ul>
 * <li><b>symptomReader</b> : a instance of class (DI)
 * {@link com.hemebiotech.reader.ReadSymptomDataFromFile} of type
 * {@link com.hemebiotech.reader.ISymptomReader}</li>
 * <li><b>symptomWriter</b>: a instance of class (DI)
 * {@link com.hemebiotech.writer.WriteSymptomDataIntoFile} of type
 * {@link com.hemebiotech.writer.ISymptomWriter}</li>
 * <li><b>listSymptoms</b>: a list to get the data (symptoms) of a file
 * into</li>
 * <li><b>hashMapCounterSymptom</b>: a LinkedHashMap to get the count of
 * occurrence of each value in the listSymptoms</li>
 * </ul>
 * 
 * @author delaval
 * @version v0.2
 *
 */
public class AnalyticsCounter {

	// Instance of type IsymptomReader to enable AnalysticsCounter to read from file
	// (DI with the constructor)
	private ISymptomReader symptomReader;

	// Instance of type IsymptomWriter to enable AnalysticsCounter to write into
	// file (DI with the constructor)
	private ISymptomWriter symptomWriter;

	// the list of all values from the file read with symptomReader
	private List<String> listSymptoms;

	// the LinkedHasMAp with all value sorted as key and their number of occurrence
	// in the list
	private LinkedHashMap<String, Integer> hashMapCounterSymptom;

	/**
	 * constructor with attributes witch implements respectively ISymptomReader and
	 * ISymptomWriter to enable to read in and write into any file
	 * 
	 * @param symptomsReader this instance is able to read data from any type of
	 *                       file (implements interface
	 *                       {@link com.hemebiotech.reader.ISymptomReader})
	 * 
	 * @param symptomWriter  this instance is able to write data into a file
	 *                       (implements interface
	 *                       {@link com.hemebiotech.writer.ISymptomWriter})
	 */
	public AnalyticsCounter(ISymptomReader symptomsReader, ISymptomWriter symptomWriter) {
		this.symptomReader = symptomsReader;
		this.symptomWriter = symptomWriter;
	}

	/**
	 * generate private ListSymptoms with all value presents into file read by
	 * symptomReader. <b>Note:</b> This List is not sorted
	 */
	public void getListSymptoms() {
		this.listSymptoms = symptomReader.getSymptoms();
	}

	/**
	 * create a file with the contain (Value,NumberOfOcccurrence) of the private
	 * LinkedHashMap hashMapCounterSymptom, each per line and sorted
	 */
	public void setFileResult() {
		this.symptomWriter.setResultIntoSource(hashMapCounterSymptom);
	}

	/**
	 * Allow to create a private {@link LinkedHashMap} with as Key Value of Symptom
	 * and as Value the number of its occurrence) From the private list listSymptoms
	 * 
	 */
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
