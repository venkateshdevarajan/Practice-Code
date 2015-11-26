package Old;/*


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;




*/
/*class Racer {
	// max value is 10^9.
	public long id;

	// starttme/endtime max is 10^18
	public long start;
	public long end;

	public long score=0;
	
	public Racer(String[] data) {
		this.id = Integer.parseInt(data[0]);
		this.start = Integer.parseInt(data[1]);
		this.end = Integer.parseInt(data[2]);
	}	
}*//*



public class Solution2 {
	
	static TreeMap<Long,Racer> StartTime = new TreeMap<Long,Racer>();
	static TreeMap<Long,Racer> EndTime = new TreeMap<Long,Racer>();
	
public static void main(String[] args) throws Exception {
		
		*/
/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of racers : ");
		String line = br.readLine();
		int n = Integer.parseInt(line);
		
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\venkateshd\\Desktop\\racer_test\\racer_test\\input00.txt"));
		String line;
		while ((line = br.readLine()) != null) {
		   // process the line.
		}
		br.close();*//*

	
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\venkateshd\\Desktop\\racer_test\\racer_test\\input00.txt"));
		String line;		
		
		//TreeMap<Long,Racer> EndTime = new TreeMap<Long,Racer>();
		ArrayList<Racer> list = new ArrayList<Racer>();
		br.readLine();
		while ((line = br.readLine()) != null){			
			String[] data = line.split(" ");
			if(data.length != 3)	
				continue;
			try {
				Racer racer = new Racer(data);			
				long startkey = Long.parseLong(data[1]); //racer.starttime as key
				long endkey = Long.parseLong(data[2]);
				StartTime.put(startkey, racer);
				EndTime.put(endkey, racer);
				list.add(racer);
			}
			catch(NumberFormatException e ){
				continue;
			}			
		}
		br.close();
		//StartTime.lastEntry().getValue().end = 0;
		
		*/
/*Collection entryset = StartTime.entrySet();
		Iterator it = entryset.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*//*

		
		Iterator listIterator = list.iterator();
		while(listIterator.hasNext()){
			Racer r = (Racer)listIterator.next();
			r.score = calculateScore(r.start,r.end);
		}
		
		Iterator li = list.iterator();
		while(li.hasNext()){
			Racer r = (Racer)listIterator.next();
			System.out.println(r.id + "  " + r.score);
		}
		
		//Sort based on score.
		*/
/*Collections.sort(endList, new Comparator<Racer>() {
			@Override
			public int compare(Racer o1, Racer o2) {
				if(o1.score == o2.score) {
					return o1.id - o2.id;
				}
				return o1.score - o2.score;
			}
		});
		for(Racer racer: endList) {
			System.out.println(racer.id + " " + racer.score);
		}*//*

		
	}

	public static long calculateScore(long startTime, long endTime) throws Exception {
		
		TreeMap<Long,Racer> subStart =  StartTime.tailMap(StartTime.get(StartTime));
		TreeMap<Long,Racer> subEnd = (TreeMap<Long, Racer>) EndTime.subMap(EndTime.firstKey(), endTime);
		
		long subStartSize = subStart.size() -1;
		long subEndSize = subEnd.size();
		
		if(subStartSize < subEndSize)
			return subStartSize;
		else
			return subEndSize;
	}
}



*/
