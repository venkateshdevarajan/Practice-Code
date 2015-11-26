package Old;

public class RotatedSortedArray {
	
	public static void main(String[] args){
		int[] arr = {3,4,5,6,7,8,1,2};
		int n = 7;
		System.out.println("Number found at index :"+binarySearch(arr, 0, arr.length, 31));
	}
	
	public static int binarySearch(int arr[],int start,int end,int n){
		int numberIndex = -1;
		int middle = -1;
		while(start<=end){
			middle = (start + end)/2;
			if(arr[middle]==n){
				numberIndex = middle;
				break;
			}
			else if(arr[middle]<n){
				if(arr[arr.length-1]>=n)
					start = middle + 1;
				else{
					start = 0;
					end = middle - 1 ;
				}
			}
			else if(arr[middle]>1){
				if(arr[0]<=n)
					end = middle - 1;
				else{
					start = middle + 1;
					end = arr.length;
				}
			}
		}
		return numberIndex;
	}
}
