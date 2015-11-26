package Old.Algos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AmazonCodingRound {
	public static void main(String[] args){
		int[] arr = {1,1,3,4,5,4,5,6};
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		for(int i =0;i<arr.length;i++){
			if(! hm.containsKey(arr[i])){
				hm.put(arr[i], 1);
			}
			else{
				int value = hm.get(arr[i]);
				value++;
				hm.put(arr[i], value);				
			}
		}
		
		
		
		Iterator i = hm.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry items = (Map.Entry) i.next();
			System.out.println(items.getKey()+":"+items.getValue());		
			
		}
		
		
		for(int k=0;k<arr.length;k++){
			if(hm.get(arr[k])==1){
				System.out.println(k);
			}
		}
		
	}

}
