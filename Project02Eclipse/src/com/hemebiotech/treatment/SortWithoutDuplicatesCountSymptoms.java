package com.hemebiotech.treatment;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * This class is use to sort and to eliminate duplicatesand count in a list of
 * String The result is store in
 * 
 * @author delaval
 *
 */
public class SortWithoutDuplicatesCountSymptoms implements ISymptomTreatment {

	private LinkedHashMap<String, Integer> hashMapCounterSymptom;

	/**
	 * constructor without parameters initialize the private LinkedHashMap
	 */
	public SortWithoutDuplicatesCountSymptoms() {

		this.hashMapCounterSymptom = new LinkedHashMap<String, Integer>();
	}

	/**
	 * Method that sort a list of String, count the number of occurrences for each
	 * one and eliminates duplicates and put the result in a linkedHashMap to
	 * preserve the sort
	 * 
	 * The list is not modified. If the list is empty, return a empty linkedHashMAp
	 * 
	 * @param listSymptoms a list of String containing data to use
	 * @return a LinkedHAshMap with as Key a String for each value in the list and
	 *         as Value a Integer the number of occurrences of this string in list
	 */
	@Override
	public LinkedHashMap<String, Integer> TreatmentSymptoms(List<String> listSymptoms) {

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

		return hashMapCounterSymptom;
	}
}
