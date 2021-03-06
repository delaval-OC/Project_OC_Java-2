package com.hemebiotech.reader;

import java.util.List;

/**
 * Anything that will read symptom data from a source The important part is, the
 * return value from the operation, which is a list of strings, that may contain
 * many duplications
 * 
 * The implementation does not need to order the list
 * 
 * @author delaval
 * @version v0.2
 */
public interface ISymptomReader {
	/**
	 * Recovery of Data from Source into a List. If no data is available, return an
	 * empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> getSymptoms();
}
