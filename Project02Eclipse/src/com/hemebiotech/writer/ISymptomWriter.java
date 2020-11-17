package com.hemebiotech.writer;

import java.util.LinkedHashMap;

/**
 * Anything that will write data into any type of source (file, stream...)
 * 
 * @author delaval
 * @version v0.2
 */
public interface ISymptomWriter {

	/**
	 * generate into any type of source a list of description of symptom and the
	 * number of occurrence counted in a input source.
	 * 
	 * The list of description must be a LinkedHashMap If the map is empty or null ,
	 * no write in the source
	 * 
	 * @param hashMap a sorted map with for key symptom and for value number of
	 *                occurrence in the input file given to the application
	 * 
	 */
	void setResultIntoSource(LinkedHashMap<String, Integer> hashMap);
}
