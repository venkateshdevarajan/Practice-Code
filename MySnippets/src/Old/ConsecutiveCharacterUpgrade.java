package Old;

public class ConsecutiveCharacterUpgrade {
	public static void main(String args[]){
		String str = "aabcddefghiij";
		char c[] = str.toCharArray();
		char s;		
		for(int i=0;i<c.length-1;i++){
			if(c[i] == c[i+1]){
				s = (char) ((char) c[i+1] + 1);
				c[i+1] = s;
			}
		}		
		str = String.copyValueOf(c);
		System.out.println(str);
	}
}
