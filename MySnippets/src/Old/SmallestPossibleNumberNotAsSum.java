package Old;

public class SmallestPossibleNumberNotAsSum {
	public static void main(String[] args){
		int arr[] = {1,2,3,4};
		int res = 1;
		for(int i = 0; i<arr.length && arr[i]<= res ; i++){
			res = res + arr[i];
			System.out.println("Res : "+res+ "arr[i] :"+arr[i]);
		}
		System.out.println(res);
	}

}
