package Old.Collection_Examples;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample  {
	
	public static void main(String[] args){
		HashSet<Character> hs = new HashSet<Character>();
		boolean result = false;
		String str = "abcdefghijkldefgh";
		char[] c = str.toCharArray();
		for(int i=0;i<c.length;i++){
			result = hs.add(c[i]);
			if(result != true){
				System.out.println("first repeated character :" + c[i]);
				break;
			}
		}
		
		//Collections.sort(hs);
		Iterator i = hs.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		
	}


}
