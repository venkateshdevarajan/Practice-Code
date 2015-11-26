package Old.Algos;

// Kadane's Algorithm

public class MaximumSumSubArray {
	public static void main(String[] args){
		index max_index =new index(-1,-1);
		int max = 0;		
		int a[] = {-21,-1,-2,3,4,-3,6,4,3};
			//{-2, -3, 4, -1, -2, 1, 5, -3};
		
		for(int i=0;i<a.length;i++){
			max = max + a[i];
			
			if(max < 0){
				max = 0;
				max_index.i = i+1;
				max_index.j = i+1;
			}
			
			else if(max > 0){
				max_index.j = i;
			}
		}
		
		for(int i=max_index.i;i<=max_index.j;i++){
			System.out.print(a[i] + "+ ");
		}
		
		System.out.println("Max : "+max);
		
	}
}
