/**
 * Created by venkatesh.d on 06/04/16.
 *
 * This123String213 -> Input
 *
 * 3his123String21T
 * 31is123String2hT
 *
 * 123213ThisString
 *
 *
 * null
 * empty
 * ThisisSting
 * 1234
 * 1234This
 * This1234
 * T
 * 1
 * special character check
 *
 *
 *
 */
public class Microsoft {
    public static void main(String[] args){
        int arr[] = {1,6,3,2,4,9,2,6};
        int i = -1 ,j = -1;
        int range = 2;


        while(j < arr.length-1){

            //setting i to the start of next set
            if(j + 1 < arr.length){
                i = j + 1;
            }

            //setting j to the end of the current set
            if(i+range < arr.length){
                j = i + range;
            }
            else
                j = arr.length-1;

            //findMax
            findMax(arr,i,j);
        }
    }

    public static void findMax(int[] arr, int i, int j){
        int max = Integer.MIN_VALUE;
        for (int k=i;k<=j;k++){
            if(arr[k]>max){
                max = arr[k];
            }
        }
        System.out.println(max);
    }
}
