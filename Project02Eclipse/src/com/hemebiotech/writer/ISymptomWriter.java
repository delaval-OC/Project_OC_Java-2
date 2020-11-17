package com.hemebiotech.analytics;

import java.util.LinkedHashMap;

/**
 * Anything that will write a list of symptoms and their number of occurence
 * each per line into a file. For that we need to use a hashmap sorted without
 * duplicates with as key name of symptom (String) and as value its number of
 * occurrence (Integer)
 * 
 * * @author delaval
 * 
 */
public interface ISymptomWriter {

	/**
	 * generate a file with for each line, description of symptom and the number of
	 * occurrence counted in file symptoms.txt
	 * 
	 * @param hashMap a sorted map with for key symptom and for value number of
	 *                occurrence in the file given to the application
	 */
	void setResultIntoFile(LinkedHashMap<String, Integer> hashMap);
}
