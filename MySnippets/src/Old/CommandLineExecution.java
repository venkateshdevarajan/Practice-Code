package Old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommandLineExecution {
	public static void main(String args[]) throws IOException, InterruptedException{
		try {
            // Run "netsh" Windows command
            Process process = Runtime.getRuntime().exec("C:\\Users\\venkateshd\\Desktop\\vineet\\Test.bat");

            // Get input streams
            
            //BufferedReader(FileReader(File("C:\\dev\\v4\\RCM-WebServices\\RCM_SOATest\\Data\\ENT20735InsertJobApplication_InsertCandidate.xml")))
            //B = BufferedReader(InputStreamReader(p.getInputStream()))
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Read command standard output
            String s;
            System.out.println("Standard output: ");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Read command errors
            System.out.println("Standard error: ");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
	}
}
