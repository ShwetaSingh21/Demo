package Demo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is designed for reading csv files and converting the data into list of arrays.
 * @author Shweta
 *
 */
public class ReadCSV {
	
	
	/**
	 * Read CSV from specified location and convert into list of arrays.
	 * @Param - String filename
	 * @return - ArrayList<String[]>  
	 */
	public List<String> readCSV(String fileName) throws IOException{
		List<String> lines=new ArrayList<String>();
		try {
			if(!fileName.endsWith(".csv")) {
				throw new IOException("Not a valid file - "+fileName);
			}
			
			File file = new File(fileName);
			
			// read all lines of csv and add to list
			lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		
		} catch (IOException e) {
			throw e;
		}
	   return  lines;
	}
	
	/**
	 * Read CSV from specified location and convert into list of arrays.
	 * @param - String filename
	 * @param - String separator
	 * @return - ArrayList<String[]>  
	 */
	public ArrayList<String[]> splitLines(ArrayList<String> lines, String separator){
		ArrayList<String[]> lineList=new ArrayList<String[]>();
			//split comma separated values and save to array.
		    for (String line : lines) {
		        String[] array = line.split(separator, -1);
		        lineList.add(array);
		    }
	   return  lineList;
	}

}
