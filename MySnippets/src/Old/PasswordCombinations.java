package Old;

public class PasswordCombinations {
	
	
	
	public static void main(String args[]){	
		
		sequence(5);
	}
	
	public static void sequence (int n){
		
		int min  = (int) Math.pow(10, n-1);
		int max  = (int) Math.pow(10, n) - 1 ;
		int arr[] = new int[n];
		int flag = 0 ;
		
		System.out.println("Min : " + min);
		System.out.println("Max : " + max);
						
		while(min!=max){
			
			int number = min;
			for(int i=0;i<n;i++){
				arr[i] = number % 10;
				number = number / 10 ;
			}
			
			for(int i=0; i < n-1; i++){
				
					if(arr[i] > arr[i+1]){
						flag = 1;
					}
					else{
						flag = 0;
						break;
					}				
			}
			
			if(flag ==1){
				for(int i=n-1;i>=0;i--){
					System.out.print(arr[i]);
				}
				System.out.println();
			}		
			
			
			min++;
			
		}
		
	}
}
