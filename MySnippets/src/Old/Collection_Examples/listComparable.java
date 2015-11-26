package Old.Collection_Examples;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class listComparable implements Comparable {
	
	
	public static void main(String[] args){
		List<String> names = new ArrayList<String>();
		names.add("Sun");
		names.add("MicroSystems");
		names.add("Factors");
		Iterator<String> i = names.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		names.add("MySystem");
		names.add("YourSystems");
		
		Collections.sort(names);
		Iterator<String> i1 = names.iterator();
		while(i1.hasNext()){
			System.out.println(i1.next());
		}
		

		
	}

	@Override
	public int compareTo(Object arg0) {		
		return this.compareTo(arg0);
	}

}
