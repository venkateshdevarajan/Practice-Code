package Old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DefectiveCode {
	public static void main(String[] args) throws IOException{
		String fileLocation = "C:\\uitests.purewebdriver\\src\\java\\com\\successfactors\\saf\\tests\\recruiting2_0\\regression\\TeamPinnacle";
		//String fileLocation = "C:\\uitests.purewebdriver\\src\\java\\com\\successfactors\\saf\\tests\\recruiting2_0\\regression\\TeamSynergy\\jobApplicationInternalApplicant\\candidateapplication\\ENT16830VerifyTheVisibilityOfThePortletsOnThePrintPreviewWithWOWUIEnabled.java"; 
		//readFile(fileLocation);
		ArrayList<File> AList = new ArrayList<File>();
		listf(fileLocation,AList);
	}
	
	public static void listf(String directoryName, ArrayList<File> files) throws IOException {
	    File directory = new File(directoryName);

	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile()) {
	        	//System.out.println(file.getAbsolutePath());
	        	readFile(file.getAbsolutePath());
	            //files.add(file);
	        } else if (file.isDirectory()) {
	            listf(file.getAbsolutePath(), files);
	        }
	    }
	}

	public static void readFile(String fname){
		try {
			boolean result = false;
			boolean curlyFound = false;
			File file = new File(fname);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				//stringBuffer.append(line);
				//stringBuffer.append("\n");
				if(line.contains("{")){
					curlyFound = true;					
				}
				if(curlyFound == true){					
					
					while(curlyFound){
						line = bufferedReader.readLine();
						if(line!=null){
							line = line.trim();
							if(line.length() == 0){
								
							}
							else if(line.length() > 0){
								
								if(line.contains("super.stop();")){
									curlyFound = false;
									result = true;
									break;
								}
								else if(line.contains("{")){
									curlyFound = true;
									continue;
								}
								else{								
									break;
								}
							}
						}
					}
				}
			}
			fileReader.close();
			
			System.out.println(fname + " :: " +result);
			//System.out.println("Contents of file:");
			//System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

