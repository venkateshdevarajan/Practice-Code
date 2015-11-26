package SuccessfactorsPractice.CodeReview;

import java.io.*;


public class Solution {	

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("Enter array size: ");
        	int length = Integer.parseInt(br.readLine().trim());
        	
        	System.out.println("Enter sequence: ");
        	String[] arrayStr = br.readLine().trim().split(" ");
        	
        	if(arrayStr.length != length) {
        		throw new Exception(String.format("Size of N - <%d> and size of Array - <%d> differ.", length, arrayStr.length));
        	}
        	
        	findSubArray(arrayStr);
        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int[] flip(String[] array, int L, int R) throws Exception {
		
		int length = array.length;
		
    	int[] arrayInt = new int[array.length];
    	for(int i = 0; i < array.length; i++) {
    		arrayInt[i] = Integer.parseInt(array[i].trim());
    	}
		
		if(L > length || L < 0 || R > length || R < 0 || L > R) {
			throw new Exception("Constraint: 0 <= L <= R < n");
		}
		
		for(int i = L; i <= R; i++) {
			arrayInt[i] ^= 1; 			
		}
		
		return arrayInt;
	}
	
	public static void findSubArray(String[] array) throws Exception{
		int a[] = new int[array.length];
		int sum = 0;

		// count the 1s in the original array and
		// do the 0 -> 1 and 1 -> -1 conversion
		for(int i = 0; i < array.length; i++) {
		    sum += Integer.parseInt(array[i]);
		    a[i] = array[i].equals("0") ? 1 : -1;        
		}
		
		int xvalue = 0,xleft = 0,xright = 0;
		int yvalue =0, yleft = 0;
		for (int n = 0; n < a.length; n++) {
		    // update y
		    if (yvalue + a[n] >= 0) {
		        yvalue += a[n];
		    } else {
		        yleft = n+1;
		        yvalue = 0;
		    }
		    // update x
		    if (xvalue < yvalue) {
		        xleft = yleft;
		        xright = n;
		        xvalue = yvalue;
		    }
		}
		
		System.out.println(xleft +","+xright);
		
		int[] tmpArray = flip(array, xleft, xright);
		
		int aces = 0;
		for(int k = 0; k < array.length; k++) {
			if(tmpArray[k] == 1) aces++;
		}
    	System.out.println(aces);
		
	}
}
