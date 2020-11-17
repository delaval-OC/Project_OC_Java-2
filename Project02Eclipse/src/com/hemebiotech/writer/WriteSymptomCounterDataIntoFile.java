package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * 
 * @author delaval
 *
 */
public class WriteSymptomCounterDataIntoFile implements ISymptomWriter {

	private String filePath;

	/**
	 * read the path to generate a new file of result
	 * 
	 * @param filePath a full path of the file to generate
	 */
	public WriteSymptomCounterDataIntoFile(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void setResultIntoFile(LinkedHashMap<String, Integer> hashMap) {

		if (filePath != null) {

			FileWriter outFile = null;
			BufferedWriter bufferWriter = null;

			try {
				outFile = new FileWriter(filePath);
				bufferWriter = new BufferedWriter(outFile);

				for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
					String symptom = entry.getKey();
					int count = entry.getValue();
					bufferWriter.write(symptom + ":\t" + count + "\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bufferWriter != null)
					try {
						bufferWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if (outFile != null)
					try {
						outFile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

			System.out.println("creation of new file " + filePath + " with counts of symptoms is done !");
		}
	}
}
