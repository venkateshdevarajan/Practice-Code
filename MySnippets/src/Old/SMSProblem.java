package Old;

import java.util.Scanner;


public class SMSProblem {

	public static void main(String args[]){
		
		int index = 0;
		String Pattern[] = { "", "", "ABC2","DEF3","GHI4","JKL5","MNO6","PQRS7","TUV8","WXYZ9" } ;
		
		Scanner input = new Scanner(System.in);		
		System.out.println("Enter the number : ");
		String str = input.next();
		
		
		
		char[] ip = str.toCharArray();
		
		
		for(int i =0 ; i < ip.length; i++) {
			 ip[i] = (char) Integer.parseInt(Character.toString(ip[i]));
		}
		
		while(index == 0){
			System.out.println(Pattern[ip[0]]);
			index ++;
		}
		
		
	}
}
