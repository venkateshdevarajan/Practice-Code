package SuccessfactorsPractice;/* Enter your code here. Read input from STDIN. Print output to STDOUT */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter the number of racers : ");
		String line = br.readLine();
		int n = Integer.parseInt(line);
		
		HashMap<Integer, ArrayList<Racer>> bucket = new HashMap<Integer, ArrayList<Racer>>();
		List<Racer> endList = new ArrayList<Racer>();
		
		// Sample input 
		// String[] temp = {"2 100 200", "3 110 190", "4 105 145", "1 90 150", "5 102 198"};		
		
		while (n-- > 0) {
			line = br.readLine();
			String[] data = line.split(" ");
			
			//Validate:Skip if the length is different.
			if(data.length != 3) continue;
			try {
				Racer racer = new Racer(data);			
				int key = 1; //racer.score
				ArrayList<Racer> list = (bucket.get(key) == null) ? new ArrayList<Racer>()
						: bucket.get(key);
				list.add(racer);
				bucket.put(key, list);
				endList.add(racer);
			}
			catch(NumberFormatException e ){
				continue;
			}			
		}
		
		//Sort based on end time.
		Collections.sort(endList, new Comparator<Racer>() {
			@Override
			public int compare(Racer o1, Racer o2) {
				return o2.end - o1.end;
			}
		});
		
		//Iterate based on end time.
		for(Racer current: endList) {
			int key = 1;
			List<Racer> list = bucket.get(key);
			for(Racer opponent : list) {
				if(current.start < opponent.start && current.end > opponent.end) {
					current.score++;
				}
			}
		}
		
		
		//Sort based on score.
		Collections.sort(endList, new Comparator<Racer>() {
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
		}
		
	}
}

/*class Racer {
	// max value is 10^9.
	public int id;

	// starttme/endtime max is 10^18
	public int start;
	public int end;

	public int score=0;
	
	public Racer(String[] data) {
		this.id = Integer.parseInt(data[0]);
		this.start = Integer.parseInt(data[1]);
		this.end = Integer.parseInt(data[2]);
	}	*/
}