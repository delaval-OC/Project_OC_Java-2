package com.hemebiotech.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * This class is use to write date into a File.
 * </p>
 * It redefines the methods of ISymptomWriter. This class will be also use to write data into a
 * specific file given in the constructor
 * 
 * @author delaval
 * @version V0.2
 */
public class WriteSymptomDataIntoFile implements ISymptomWriter {

  private String filePath;

  /**
   * constructs a instance with path of the file to write into
   * 
   * @param filePath a full path of the file to generate
   */
  public WriteSymptomDataIntoFile(String filePath) {
    this.filePath = filePath;
  }

  /**
   * write the data in a LinkedHasMap into a file with path given in constructor
   * 
   * @param linkedHashMap a list sorted without duplicates of data to write into the file
   */
  @Override
  public void setResultIntoSource(LinkedHashMap<String, Integer> linkedHashMap) {

    if (filePath != null) {

      FileWriter outFile = null;
      BufferedWriter bufferWriter = null;

      try {
        outFile = new FileWriter(filePath);
        bufferWriter = new BufferedWriter(outFile);

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
          String symptom = entry.getKey();
          int count = entry.getValue();
          bufferWriter.write(symptom + ": " + count + "\n");
        }

      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (bufferWriter != null) {
          try {
            bufferWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (outFile != null) {
          try {
            outFile.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
      System.out.println("***********************************************");
      System.out.println("Creation of new file " + filePath + " with counts of symptoms is done !");
    }
  }
}
