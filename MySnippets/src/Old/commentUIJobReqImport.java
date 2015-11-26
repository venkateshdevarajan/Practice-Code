package Old;

import java.io.*;


public class commentUIJobReqImport {
	
	public static String toBeSearched = "CommonPermission.assignFormCreationPermission" ;
			//"CommonPermission.assignFormCreationPermission" ;
			//"ProvUploadRecruitingTemplate.importJobReq";
	
	public static void main(String[] args) throws IOException{
		commentUIJobReqImport obj = new commentUIJobReqImport();
		//obj.readFileAndComment();
		obj.listFiles("D:\\pure\\src\\java\\com\\successfactors\\saf\\tests\\recruiting2_0\\regression\\TeamHarmony");
	}
	
	public void readFileAndComment(String absoluteFilePath) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath));
		String line;
		StringBuffer contents = new StringBuffer();
		
		while ((line = br.readLine()) != null) {
			if(line.contains(toBeSearched)){
				if(line.endsWith(";")){
					line = "//" + line ;
					contents.append(line);
				}
				else{					
					line = "/*" + line ;					
					while(! line.endsWith(";")){		
						contents.append(line);
						line = br.readLine();						
					}
					line = line.replace(";", ";*/");					
					contents.append(line);
				}
			}
			else{
				contents.append(line);
			}
			contents.append("\n");	
		}
		System.out.println(contents);
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter(absoluteFilePath));
		bw.write(contents.toString());
		bw.close();
	}
	
	public void listFiles(String directoryName) throws IOException {
		    File directory = new File(directoryName);
		    File[] fList = directory.listFiles();
		    for (File file : fList) {
		        if (file.isFile()) {
		        	 readFileAndComment(file.getAbsolutePath());
		        } else if (file.isDirectory()) {
		            listFiles(file.getAbsolutePath());
		        }
		    }		    		    
	}
	
}
