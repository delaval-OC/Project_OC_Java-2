package com.hemebiotech.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class is use to read data in a file
 * </p>
 * This class allow to redefine methods of IsymptomReader and to specifies them
 * to read data symptoms from only a file This class will be also use to read
 * data from a specific file given in the constructor
 * 
 * @author delaval
 * @version v0.2
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * constructs a ReadSymptomDataFromFile with path of file to read in
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,one
	 *                 per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * recovery data from a specific file with path given by constructor
	 * {@link ReadSymptomDataFromFile(String)}
	 */
	@Override
	public List<String> getSymptoms() {

		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {

			BufferedReader reader = null;
			String line;

			try {
				reader = new BufferedReader(new FileReader(filepath));
				line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("File " + filepath + " correctly read !");
			System.out.println("***************************************************");
			System.out.println("list of symptoms read :");
			System.out.println(result);
		}

		return result;
	}

}
