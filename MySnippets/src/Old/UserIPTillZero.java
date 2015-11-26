package Old;

import java.util.Scanner;


public class UserIPTillZero {
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int i=1,j=0;
		int arr[] = new int[100];
		
		while(i!=0){
			System.out.println("");
			i = scanner.nextInt();
			if(i!=0){
				arr[j] = i;
				j++;
			}			
		}
		
		for(int k =0 ;k<j;k++){
			System.out.println(arr[k]);
		}		
	}

}
