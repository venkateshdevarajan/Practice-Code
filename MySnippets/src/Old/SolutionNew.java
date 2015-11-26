package Old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SolutionNew {
	
	static int noOfRows ;
	static int noOfColumns;
	static int laserBeginRow;
	static int laserBeginColumn;
	
	static Map<Character, Coordinates> prisms = new HashMap<Character, Coordinates>();
	static Set<Coordinates> visitedPrisms = new HashSet<Coordinates>();
	
	public static void main(String[] args) throws IOException{		
		char inputString[][] = readInputFromConsole();
		initialize();
		distanceTravelled(inputString);		
	}
	
	private static char[][] readInputFromConsole() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] ip = new char[50][50];		
		int i = 0;
		String currentLine = br.readLine();
		noOfColumns = currentLine.length();
		do {
			currentLine = currentLine.trim();
			if (currentLine.length() == 0)
				break;			
			ip[i] = currentLine.toCharArray();
			for(int k=0;k<ip[i].length;k++){
				if(ip[i][k]=='@'){
					laserBeginRow = i;
					laserBeginColumn = k;
				}
			}
			i++;
		} while ((currentLine = br.readLine()) != null);
		noOfRows = i;
		return ip;
	}
	
	private static void initialize(){
		prisms.put('>', new Coordinates(0,1));
		prisms.put('v', new Coordinates(1,0));
		prisms.put('^', new Coordinates(-1,0));
		prisms.put('<', new Coordinates(0,-1));		
	}
	
	private static void distanceTravelled(char[][] inputString){
		int laserRowIndex = laserBeginRow;
		int laserColumnIndex = laserBeginColumn;
		int numberOfRowsToBeMoved = prisms.get('>').getRow();
		int numberOfColumnsToBeMoved = prisms.get('>').getColumn();
		int i=laserBeginRow;
		int j=laserBeginColumn;
		int distance = 0;		
		
		while((i<noOfRows && i >= 0) && (j>=0 && j<noOfColumns)){			
			if(prisms.get(inputString[i][j]) != null){				
				numberOfRowsToBeMoved = prisms.get(inputString[i][j]).getRow();
				numberOfColumnsToBeMoved = prisms.get(inputString[i][j]).getColumn();
				laserRowIndex += numberOfRowsToBeMoved;
				laserColumnIndex += numberOfColumnsToBeMoved;
				
				// If the prism is already visited, there will be a loop.
				if(! visitedPrisms.add(new Coordinates(i,j))){
					distance = -1;
					break;
				}
				else{
					distance += 1;
				}					
				i = laserRowIndex;
				j = laserColumnIndex;
												
			}
			else{
				laserRowIndex += numberOfRowsToBeMoved;
				laserColumnIndex += numberOfColumnsToBeMoved;				
				i = laserRowIndex;
				j = laserColumnIndex;
				distance = distance + 1;							
			}			
		}
		
		System.out.println(distance);
	}	
}

