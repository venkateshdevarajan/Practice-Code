
public class MedianOfTwoArrays {
	
	/*
	 * Problem:
Find median of A Append B. In other words: what is the median of the numbers if we put all the elements of A and B together? Note: Append keeps duplicate elements in both arrays.

If |A| + |B| is even, then the median is the lesser of  the two numbers that would be in the middle if (A Append B) were sorted. 

Your algorithm should be O(1) space (not including size of input arrays) and O(log(|A|+|B|)) time complexity.
	 */
	
	public static int a[] = {2,4,6};
	public static int b[] = {3,5,7,9};
	
	public static void main(String args[]) throws Exception {
		median(0, a.length, 0, b.length);
	}
	
	public static void median(int astart, int aend  , int bstart, int bend) throws Exception {
		
		int starta 	= astart;
		int startb 	= bstart;
		int enda 	= aend;
		int endb 	= bend;
		
		int medianA = (starta + enda) / 2 ;
		int medianB = (startb + endb) / 2;		
		
		
		if(a[medianA] == b[medianB])
			System.out.println("Median : " +a[medianA]);
		else if(a[medianA] < b[medianB]){
			starta = medianA + 1;
			endb = medianB - 1 ;
		}
		else if(a[medianA] > b[medianB]){
			enda = medianA - 1;
			startb = medianB + 1;
		}
		
		if(astart )
		median(starta,enda,startb,endb);
	}

}
