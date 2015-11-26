
public class SumOfNumbersInAString {
	
	public static void main(String[] args){
		String str = "d2SD$#23+-12#T1234;/.,10";
		int number;
		int negativeFlag = 0;
		int numberFlag = 0;
		int digit =0;
		int k = -1;
		int sum =0;
		char[] c = str.toCharArray();
		
		for(int i=0;i<c.length;i++){
			number = Character.getNumericValue(c[i]);
			if(c[i]=='-'){				
				negativeFlag = 1;
			}
			
			if(number >=0 && number <=9){				
				if(numberFlag == 0)
					numberFlag = 1;
				if(numberFlag==1){
					k++;
					if(k>0){						
						digit = (digit * (10)) + number;						
					}					
					else
						digit = number;					
				}				
			}
			else{
				if(numberFlag==1){
					if(negativeFlag == 1){						
						digit = digit - (digit * 2);
					}
					sum = sum + digit;
					System.out.print(digit+"+");
				}
				
				if(negativeFlag == 1 && numberFlag ==1)
					negativeFlag = 0;
				
				numberFlag = 0;
				k = -1;
				digit = 0 ;				
			}
			
		}
		
		if(numberFlag==1){
			if(negativeFlag == 1){				
				digit = digit - (digit * 2);
			}
			sum = sum + digit;
			System.out.print(digit+"+");
		}
		
		System.out.println("  = "+sum);
		
	}

}
