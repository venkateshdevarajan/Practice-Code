
public class ThreeBigNumbers {
	
	public static void main(String args[]){
		int arr[] = { 1000,2000,3000,2,8,9,6,271,109 };
		int first = 0, second =0, third =0 ;
		
		for(int i =0; i<arr.length; i++){
			
			if(arr[i] > first){
				third = second ;
				second = first;
				first = arr[i];				
			}
			
			else if(arr[i] > second){
				third = second;
				second = arr[i];
			}
			
			else if (arr[i] > third)
				third = arr[i];
		}
		
		System.out.println("First : "+ first+"    Second : "+second+"    third : "+third);
	}

}
