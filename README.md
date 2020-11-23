Sample project for OpenClassroom's fundamentals of Java:

Version of the project : v0.3
=============================

Aim of the application:
-----------------------

Is to collect a list of all symptoms non sorted from a file and to sort data,to eliminate duplicates, and to put the result (one symptoms with its number of occurrences per ligne) into a another file 

Behavior is as follows:
-----------------------

Use of interfaces to produce genericity ie:

We structured the application with 4 packages and not 3:

- com.hemebiotch.analytics in which we treat data ans start the application with a main.java
- com.hemebiotch.reader in which we treat the read of data from a source 
- com.hemebiotch.writer in which we treat the write of data into a source
- ** a new one com.hemebiotch.treatment in which we treat data collected from a source**

In each package reader and writer,we have 2 interfaces that allow us to define respectivly how to read and write data into a any type of source
- ISymtomReader
- IsymptomWriter
and two classes which implements this interfaces to override methods and to define more specifically with which type a source we want to read and write data


 ** In the package treatment**, we have a interface that allows us to define how we want to treat data collected from the source
and a class more specific which implements the interface to allow us to only sort data, to count the occurrences and to store the result in a linkedHashmap
 
As their name can suggest, today WriteSymptomDataIntoFile and ReadSymptomDataFromFile were created to use a file as source.
but if we want tomorrow, to read and write from the consol we will be able to implement two other class for doing that...

It is the same with SortWithoutDuplicatesCountSymptoms, we can implement a another class which implements ISymptomTreatment to treat differently data.

AnalyticsCounter was modified to use the new interface with a injection of dependences and to be able to:
- to collect data from file 
- to treat the data as we want
- to put data treated into a file 


