import java.util.Scanner;


public class Puzzle {
	
	 public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.println("Enter the value of n : ");
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        
	        for(int i =0;i <n; i++){	            
	            arr[i] = sc.nextInt();
	        }
	        
	        for(int i=0;i<n;i++){
	            if(arr[i] == 4)
	                System.out.println("YES");
	            else if(arr[i] % 4 ==0)
	                System.out.println("YES");
	            else if((arr[i]-1) % 4 ==0)
	                System.out.println("YES");
	            else
	                System.out.println("NO");
	        }
	    }

}
