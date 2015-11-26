package Old;

public class RetrySecondLargestAfterShuffle {

	/**
	 * Given a number like 17986, we will have to shuffle the digits and
	 * find out the next highest number possible. In this case it is
	 * 18679
	 * We first traverse from the last but one digit and check if it is greater
	 * than the last digit. If yes, we continue...else, the digit to the left is the pivot.
	 * Then to the right of that pivot digit we try to find the smallest number bigger than 
	 * this pivot.
	 * Once identified, we swap the digits <pivot and the smallest largest number>.
	 * After swap, we have to sort the numbers on the right of the pivot index.
	 * This is the algo to get the second highest number.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sNumber="17986";
		char[] cNumber = sNumber.toCharArray();
//		int length=cNumber.length;
//		
//		int whichHigh=(length-1)*findFactorialToFindHighest(length-1);
//		
		String nextHighestNumber=null;
		String secondNextHighestNumber=null;
//		for(int i=1;i<whichHigh;i++)
//		{
			nextHighestNumber=returnNextHighestNumberString(cNumber);
			secondNextHighestNumber=returnNextHighestNumberString(nextHighestNumber.toCharArray());
//		}
		
		System.out.println("First next highest number: "+nextHighestNumber);
		System.out.println("Second next highest number: "+secondNextHighestNumber);
	}
	
	public static int findFactorialToFindHighest(int len)
	{
		int fact=1;
		for(int i=1;i<len;i++)
		{
			fact*=i;
		}
		return fact;
	}
	
	public static String returnNextHighestNumberString(char[] cNumber)
	{
		int iPivot=0;
		int iLastBut = cNumber.length-2;
		for(int i=iLastBut;i>0;i--)
		{
			if(i>0)
			{
				if(cNumber[i]<cNumber[i+1])
				{
					iPivot=i;
					break;
				}
				else
				{
					continue;
				}
			}
			
		}
		
		int iDiff1=0;
		int iDiff2=0;
		int secondL=0;
		for(int i=iPivot+1;i<cNumber.length;i++)
		{
			if(cNumber[i]>cNumber[iPivot])
			{
				iDiff1=(int)cNumber[i]-(int)cNumber[iPivot];
				if(iDiff2==0)
				{
					iDiff2=iDiff1;
				}
				if(iDiff2>iDiff1)
				{
					iDiff2=iDiff1;
				}
			}
		}
		for(int i=0;i<cNumber.length;i++)
		{
			if(cNumber[i]>cNumber[iPivot])
			{
				if((int)cNumber[i]-(int)cNumber[iPivot]==iDiff2)
				{
					secondL=i;
				}
			}
		}
		
		char temp;
		temp=cNumber[iPivot];
		cNumber[iPivot]=cNumber[secondL];
		cNumber[secondL]=temp;
		
//		char temp2;
//		for(int i=iPivot+1;i<cNumber.length;i++)
//		{
//			for(int j=i+1;j<cNumber.length;j++)
//			{
//				if(cNumber[i]>cNumber[j])
//				{
//					temp2=cNumber[i];
//					cNumber[i]=cNumber[j];
//					cNumber[j]=temp2;
//				}
//			}
//		}
		int le = cNumber.length-1;
		char temp2;
		for(int i=iPivot+1;i<le;i++)
		{
			if(cNumber[i]==cNumber[le])
			{
				break;
			}
			else
			{
				temp2=cNumber[i];
				cNumber[i]=cNumber[le];
				cNumber[le]=temp2;
				le--;
			}			
		}
		return new String(cNumber);
	}
//	{
//		int iLastBut=cNumber.length-2;
//		int iPivot=0;
//		//Finding the Pivot
//		for(int i=iLastBut;i>0;i--)
//		{
//			if(i>0)
//			{
//				if(cNumber[i]<cNumber[i+1])
//				{
//					iPivot=i;
//					break;
//				}
//				else
//				{
//					continue;
//				}
//			}
//			
//		}
//		//System.out.println("Pivot: "+cNumber[iPivot]);
//		//Finding the smallest largest number to the right of pivot
//		int iDiff=0;
//		int iDiff2=0;
//		int iSecondL=0;
//		for(int i=iPivot+1;i<cNumber.length;i++)
//		{
//			if(cNumber[i]>cNumber[iPivot])
//			{
//				iDiff=0;
//				iDiff=(int)cNumber[i]-(int)cNumber[iPivot];
//				if(iDiff2==0)
//				{
//					iDiff2=iDiff;
//				}
//				
//				if(iDiff2>iDiff)
//				{
//					iDiff2=iDiff;
//				}
//			}
//		}
//		for(int i=iPivot+1;i<cNumber.length;i++)
//		{
//			if(cNumber[i]>cNumber[iPivot])
//			{
//				if((int)cNumber[i]-(int)cNumber[iPivot]==iDiff2)
//				{
//					iSecondL=i;
//				}
//			}
//		}
////		System.out.println("Smallest Diff: "+iDiff2);
////		System.out.println("Smallest large: "+cNumber[iSecondL]);
//		
//		//Swapping pivot and smallest largest number
//		char temp;
//		temp=cNumber[iPivot];
//		cNumber[iPivot]=cNumber[iSecondL];
//		cNumber[iSecondL]=temp;
//		
//		//System.out.println("Array swapped");
//		
//		//Sorting the digits to the right of pivot
//		char temp2;
//		for(int i=iPivot+1;i<cNumber.length;i++)
//		{
//			for(int j=i+1;j<cNumber.length;j++)
//			{
//				if(cNumber[i]>cNumber[j])
//				{
//					temp2=cNumber[i];
//					cNumber[i]=cNumber[j];
//					cNumber[j]=temp2;
//				}
//			}
//		}
////		System.out.println("Next largest number: "+new String(cNumber));
//		return new String(cNumber);
//	}

}
