package com.hemebiotech.treatment;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Interface to be able to treat data describe signatures of different methods
 * to treat data as we want
 * 
 * @author delaval
 * @version v0.3
 */
public interface ISymptomTreatment {
	/**
	 * Method that treat a list of String and put the result in a LinkedHashMap
	 * 
	 * If the list is empty, return a empty linkedHashMAp
	 * 
	 * @param list a list of String containing the data to use
	 * @return {@link LinkedHashMap} LinkedHAshMap with as Key a String and as Value
	 *         a Integer
	 */
	LinkedHashMap<String, Integer> treatmentSymptoms(List<String> list);
}
