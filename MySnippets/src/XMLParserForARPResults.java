import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;


public class XMLParserForARPResults {
	
	public static void main(String[] args) throws IOException{
		String filePath = "C:\\MyDrive\\CodeBase\\uitests.purewebdriver\\src\\java\\com\\successfactors\\saf\\tests\\recruiting2_0\\regression\\templates\\WebServices\\Report.xml"; 

				//"C:\\Users\\i073338\\Desktop\\Gravity\\Zenith_All_Testlink_Results-08-14.xml";	
		String[] resultTests = RCMParser(filePath,"p");
		/*for(int i=0;resultTests[i]!=null;i++){
			System.out.println(resultTests[i]);
		}*/
	}
	
	private static String[] RCMParser(String filePath,String condition) throws IOException{
		HashMap<String,String> reportResult = new HashMap<String,String>();
		String[] testCaseList = new String[2000];
		int counter = 0;
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String line = null;
		while((line = br.readLine())!= null){
			if(line.contains("<testcase external_id=")){
				String[] testcaseId = line.split("'");
				line = br.readLine();
				String substr = line.replace("<", ">");
				String[] testResult = substr.split(">");
				reportResult.put(testcaseId[1], testResult[2]);
				if(testResult[2].equals(condition)){
					testCaseList[counter]=testcaseId[1];
					counter++;
				}				
			}
		}
		
		java.util.Iterator<Entry<String, String>> i = reportResult.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry items = (Map.Entry) i.next();
			String testId = (String) items.getKey();
			String result = (String) items.getValue();
			System.out.println(testId +" : "+result);
			
		}
		return testCaseList;
	}
	

}
