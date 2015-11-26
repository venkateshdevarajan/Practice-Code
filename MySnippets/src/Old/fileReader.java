package Old;

import java.io.BufferedReader;
import java.io.FileReader;


public class fileReader {
	
	public static void main(String args[]) throws Exception {
		String str = "<name>";
		String tag = "<sortable>";
		String name = new String();
		String fieldname =new String() , value = new String() ;
		
		char[] tagname = new char[50] ;
		char[] bname = new char[50] ;
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\venkateshd\\Desktop\\UIComment.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			line=line.trim();
			
			if(line.contains(str)){
				
				int i = str.length();
				int j = -1;
				char[] c =line.toCharArray();
				
				
			
				
				while(i != c.length){
					
					if(c[i]!='<'){
						j++;
						tagname[j] = c[i];												
					}
					
					else{						
						break;
					}
					i++;
				}
				
				fieldname = String.copyValueOf(tagname, 0, j+1);
			}
			
			if(line.contains(tag)){
				
				int i = tag.length();
				int j = -1;
				char[] c =line.toCharArray();
				
				while(i != c.length){
					
					if(c[i]!='<'){
						j++;
						bname[j] = c[i];												
					}
					
					else{
						break;
					}
					i++;
				}
				
				value =  String.copyValueOf(bname,0,j+1);
				
				if(value.equalsIgnoreCase("true"))
					System.out.print(fieldname +",");
				
			}	
			
			
		}
		br.close();
	}

}
