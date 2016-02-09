package Old;

public class RotatedSortedArray {
	
	public static void main(String[] args){
		int[] arr = {3,4,5,6,7,8,1,2};
		int[] arr1= {7,8,1,2,3,4,5,6};
        int[] arr2 = {3,4,5,6,7,1,2};
        int[] arr3 = {2,3,4,5,1};
        int n =1;
        for(int i=0;i<arr.length;i++) {
            System.out.println("Number "+arr[i]+" found at index :" + binarySearch(arr, 0, arr.length - 1, arr[i]));
        }
        System.out.println("--------------------------------------------------");
        for(int i=0;i<arr1.length;i++) {
            System.out.println("Number "+arr1[i]+" found at index :" + binarySearch(arr1, 0, arr1.length - 1, arr1[i]));
        }
        System.out.println("--------------------------------------------------");
        for(int i=0;i<arr2.length;i++) {
            System.out.println("Number "+arr2[i]+" found at index :" + binarySearch(arr2, 0, arr2.length - 1, arr2[i]));
        }
        System.out.println("--------------------------------------------------");
        for(int i=0;i<arr3.length;i++) {
            System.out.println("Number "+arr3[i]+" found at index :" + binarySearch(arr3, 0, arr3.length - 1, arr3[i]));
        }
	}
	
	public static int binarySearch(int arr[],int start,int end,int n){
		int numberIndex = -1;
		int middle = -1;
		while(start<=end){
			middle = (start+end)/2;
			if(arr[middle]==n){
				numberIndex = middle;
				break;
			}

            else if(arr[middle]<n){
                if(arr[start] >= arr[middle] && arr[middle]< n && arr[end] < n){
                    end = middle -1;
                }
                else
                    start = middle + 1;
            }
            else if(arr[middle] > n){
                if(arr[end] <= arr[middle] && arr[middle]>n && arr[start] > n){
                    start = middle + 1;
                }
                else
                    end = middle-1;
            }
		}
		return numberIndex;
	}
}