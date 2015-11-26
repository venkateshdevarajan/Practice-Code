
public class GregorianCalendar {
	
	public static String str1 = new String("mug");
	public static String str2 = new String("gum");
	public static int flag = 0 , count = 0;
	public static char c[] = str1.toCharArray();
	
	public static void main(String args[]) throws Exception{
		
			check(c);	
	}
		
	public static void check(char[] cha){	
		
		
		
		for(int i=0; i<str1.length()-1; i++){
			
			char temp = cha[i];
			cha[i] = cha[i+1];
			cha[i+1] = temp;
			
			for(int j=0;j< str1.length();j++)
				System.out.print(cha[j]);			
			
			System.out.println();
			
			if(String.valueOf(cha).equals(str2)){
				flag = 1;
				break;
			}
			count ++;
	    }
		
		// && count < str1.length() * str1.length()
		
		if(flag != 1){
			check(c);
		}

	
	}
}
