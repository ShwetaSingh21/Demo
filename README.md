# CSV Sorting

Sorting csv files in an way determined by another file. That is, sorting should not be on ascending nor descending way in the normal manner, but rather as determined by another csv file

##Getting Started

These instructions will get you a copy of the project up and running on your local machine. 

## Prerequisites
•	Environment - Java 1.8

•	Path and class for java should be set in environment variables

## Installing

For installing and building the project please follow below steps

•	Create a Demo folder in C drive

•	Copy the java files in Demo folder

•	For building the project please follow below steps.
  o Open command prompt
  o	Navigate to C/Demo folder
  o	Execute the below command
      javac *.java 
  o	Verify the class files in Demo folder

## Running the tests

For running the project please follow below steps

•	Open command prompt

•	Navigate to C folder

•	Execute the below command

    java Demo.CSVSorting <file_name_to_be_sorted> <file_column_to_be_sorted> <reference_file_name > <reference_file_column>

•	If any error for “Not able to load main class”, Please execute below command

    java -cp . Demo.CSVSorting <file_name_to_be_sorted> <file_column_to_be_sorted> <reference_file_name > <reference_file_column>

•	Sample example for running the program

    java -cp . Demo.CSVSorting "C:\\workspace\\Demo_Files\\F1.csv" "b" "C:\\workspace\\Demo_Files\\F2.csv" "f"
