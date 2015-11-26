package Old;

import java.io.*;


public class FileComparison {
	public static void main(String[] args) throws IOException{
		File f1=new File("D:\\NewWorkSpace\\purewebdriver\\src\\java\\com\\successfactors\\saf\\tests\\recruiting2_0\\regression\\templates\\Ent8844JobReq.xml");
	    File f2=new File("D:\\NewWorkSpace\\purewebdriver\\src\\java\\com\\successfactors\\saf\\tests\\recruiting2_0\\regression\\templates\\Ent8845JobReq.xml");
	    FileInputStream fi1=new FileInputStream(f1);
	    FileInputStream fi2=new FileInputStream(f2); 
	    DataInputStream di1=new DataInputStream(fi1);
	    BufferedReader br1=new BufferedReader(new InputStreamReader(di1));
	    DataInputStream di2=new DataInputStream(fi2);
	    BufferedReader br2=new BufferedReader(new InputStreamReader(di2));
	    String s1, s2;  
	    while ((s1=br1.readLine())!=null && (s2=br2.toString())!=null) 
	     {
	    	if(!s1.equals(s2)){
	    		System.out.println(s1);
	    		System.out.println(s2);
	      }
	    } 
	}
}
