package Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used for sorting csv file based on another csv file.
 * @author Shweta
 *
 */
public class CSVSorting {
	
	private static String separator=",";
	
	private ReadCSV readCSV=new ReadCSV();
	
	public static void main(String args[]){
		CSVSorting csvSorting=new CSVSorting();
		
		String	sortingFile= args[0];
		String	sortingColumn= args[1];
		String	sortedFile= args[2];
		String	sortedColumn= args[3];
		
		
		ArrayList<String[]> sortingFileLines= csvSorting.generateColumnArray(sortingFile);
		
		
		ArrayList<String[]> sortedFileLines= csvSorting.generateColumnArray(sortedFile);
		
		ArrayList<String[]> outputLine=new ArrayList<String[]>();
		try {
			outputLine = csvSorting.compareData(sortingFileLines, sortingColumn, sortedFileLines, sortedColumn);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		csvSorting.printOutput(outputLine);
		
		
	}
	
	/**
	 * Build output amnd print to console
	 * @param outputLine
	 */
	public ArrayList<String[]> generateColumnArray(String fileName) {
		
		ArrayList<String> lines=new ArrayList<String>();
		ArrayList<String[]> Column_array_list = new ArrayList<String[]>();
		
		try {
			lines = (ArrayList<String>) readCSV.readCSV(fileName);
			Column_array_list=readCSV.splitLines(lines,separator);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Column_array_list;
	}
	
	/**
	 * Build output amnd print to console
	 * @param outputLine
	 * @throws Exception 
	 */
	public ArrayList<String[]> compareData(ArrayList<String[]> sortingFileLines, String SortingColumnVal, ArrayList<String[]> sortedFileLines, 
			String sortedcolumnVal) throws Exception {
		
		int i=0;
		CSVSorting csvSorting=new CSVSorting();
		
		int  sortingColIndex=csvSorting.getColumnIndex(sortingFileLines.get(0), SortingColumnVal);
		
		if(sortingColIndex==-1) {
			throw new Exception("Sorting column value "+SortingColumnVal+" not found in CSV file.");
		}
		
		int sortedColIndex=csvSorting.getColumnIndex(sortedFileLines.get(0), sortedcolumnVal);
		
		if(sortedColIndex==-1) {
			throw new Exception("Sorted column value "+sortedcolumnVal+" not found in CSV file.");
		}
		
		
		ArrayList<String[]> outputLine=new ArrayList<String[]>();
		
		outputLine.add(sortingFileLines.get(0));
		
		for(String[] sortedLine:sortedFileLines){
			int j=0;
			if(i==0 ){
				i++;
			}else {
				for(String[] sortingLine:sortingFileLines){
					 if(j==0){
						 j++; 
					 }else{
							try {
								if(sortingLine[sortingColIndex].contentEquals(sortedLine[sortedColIndex])){
									outputLine.add(sortingLine);
								}
							}catch(ArrayIndexOutOfBoundsException e) {
								e.printStackTrace();
							}
						
						}
				}
			 j=0;
			
			}
			i++;
		}
		return outputLine;
	}
	
	
	/**
	 * Method is used for getting column index 
	 * @param columns
	 * @param columnValue
	 * @return
	 */

	public int getColumnIndex(String[] columns,String columnValue) {
		int Columnindex=-1;
		for (int col = 0; col < columns.length; col++){
			 if(columns[col].equals(columnValue)){
				 Columnindex=col;
			 }
		 }
		return Columnindex;
	}
	
	
	/**
	 * Build output and print to console
	 * @param outputLine
	 */
	public void printOutput(ArrayList<String[]> outputLine) {
		
		for(String[] lines:outputLine){
			
			for (int column = 0; column < lines.length; column++){
				if(column==lines.length-1) {
					System.out.print(lines[column]);
				}else if(column<lines.length-1) {
					System.out.print(lines[column]+",");
				}
		}
		System.out.println("");
		}
	}
	

}
