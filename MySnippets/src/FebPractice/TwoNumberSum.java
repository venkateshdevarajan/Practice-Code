package FebPractice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by venkatesh.d on 06/02/16.
 */
public class TwoNumberSum {

    // sum of 2 numbers = given x
    public static void main(String[] args){
        int[] arr = {1, -2, 3,6};
        int sum = 4,diff;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<arr.length;i++){
            diff = sum - arr[i];
            if(map.containsKey(arr[i])){
                //return true;
            }
            else{
                map.put(diff,arr[i]);
            }
        }
        //return false;
        System.out.println(returnSmallestCharacter());
        contiguousSubMaxSum();
    }

    static char returnSmallestCharacter(){
        char[] arr = {'c','f','j','p','v'};
        char c = 'a';
        int start=0, end = arr.length -1,mid;

        if(c > arr[end]) return arr[start];
        if(c < arr[start]) return arr[start];

        while(start<end){
            mid = (start+end)/2;

            if(arr[mid]=='c'){
                return arr[mid+1];
            }
            else if(c < arr[mid]){
                if(c > arr[mid-1]){
                    return arr[mid];
                }
                end = mid - 1;
            }
            else if(c > arr[mid]){
                if(c < arr[mid+1]){
                    return arr[mid+1];
                }
                start = mid + 1;
            }
        }

        return '@';
    }

    static void contiguousSubMaxSum(){
        int[] arr = {1, 2, -4, 1, 3, -2, 3, -1};
        int max = 0,sum=0;

        for(int i=0;i<arr.length;i++){
            sum = sum + arr[i];
            if(sum < 0){
                sum = 0;
            }
            if(max < sum)
                max = sum;
        }

        System.out.println("Max:"+max);
    }

    static int distanceBetweenWords(ArrayList<String> inputString,String a, String b) {
        int distance,minDistance= Integer.MAX_VALUE,counter=-1;
        int[] index = new int[2];
        if(inputString == null || a == null || b ==null ||inputString.size()<=0) return -1;

        for(int i=0;i<inputString.size();i++){
            String word = inputString.get(i);
            if(word.equals(a) || word.equals(b)){
                counter ++;
                index[counter] = i;
                if(counter==1){
                    counter = 0 ;
                    distance = index[1]-index[0];
                    index[0] = index[1];
                    if(distance < minDistance)
                        minDistance = distance;
                }
            }
        }

        return minDistance;
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
