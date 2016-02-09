package Old;

public class FindIndexOfDuplicates {
	static int firstLocation = -1;
	public static void main(String[] args){
		//int arr[] = {1,2,3,4,5,6,7,8,9};
		//int arr[] = {0,0,1,2,2,3,3,3,4,5,6,7,7,7,8,9,9};
		int arr[] = {0, 0, 2, 3, 3, 3, 3, 4, 7, 7, 9};
		int s = 9 ;
		int start = 0;
		int end = arr.length - 1;
		int sindex = bs(arr,start,end,s);
		//System.out.println("Somewhere in middle index : "+sindex);
		int findex = sindex;
		int lindex = sindex;
		
		if(sindex < end  && sindex >= 1){
			while((findex-1) > -1 && arr[findex-1]==s ){
				findex = bs(arr,0,findex-1,s);
			}
			while((lindex+1)<= end && arr[lindex+1]==s ){
				lindex = bs(arr,lindex+1,end,s);
			}
		}
		System.out.println("first index : "+findex+"   Last Index:"+lindex);
	}
	
	public static int bs(int arr[],int start,int end,int s){
		int middle= -1;
		int numberFoundIndex = -1;
		while(start <= end) {
			middle = (start+end) / 2;
			if(arr[middle]==s){
				numberFoundIndex = middle;
				break;
			}
			else if(s < arr[middle]){
				end = middle - 1 ;
			}
			else if(s > arr[middle]){
				start = middle + 1;
			}
		}
		return numberFoundIndex;
	}
	
}
