Sample project for OpenClassroom's fundamentals of Java:

Version of the project : v0.2
=============================

Aim of the application:
-----------------------

Is to collect a list of all symptoms non sorted from a file and to sort data,to eliminate duplicates, and to put the result (one symptoms with its number of occurrences per ligne) into a another file 

Behavior is as follows:
-----------------------

In this version we use interfaces to produce genericity ie:

We structured the application with 3 packages
-com.hemebiotch.analytics in which we treat data ans start the application with a main.java
-com.hemebiotch.reader in which we treat the read of data from a source 
-com.hemebiotch.writer in which we treat the write of data into a source

In each package reader and writer,we have 2 interfaces that allow us to define respectivly how to read and write data into a any type of source
- ISymtomReader
- IsymptomWriter

and two classes which implements this interfaces to override methods and to define more specifically with which type a source we want to read and write data

As their name can suggest, today WriteSymptomDataIntoFile and ReadSymptomDataFromFile were created to use a file as source.
but if we want tomorrow, to read and write from the consol we will be able to implement two other class for doing that...

After we have AnalyticsCounter that is used to treat the data using the two classes by DI with its constructor.
AnalyticsCounter allows us essentially:
- to collect data from file 
- to sort data
- to count their number of occurences
- to put data sorted with counters into a file 

Future progression
==================

We are going to use another Interface ISymptomTreatment to treat data collected in a general way for after create a class which can defines exactly how to treat data.
- Interface : general use of data (in this version we sorted and eliminate duplicates)
- Class that implements this interface to specifie how to use and treat data (For exemple: just collect the list of symptoms begining with a specific letter...)



