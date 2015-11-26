

public class DottedStringReverse {
	public static void main(String[] args){
		String str = "priya..kakaka.a....ipog";
		char[] c = str.toCharArray();
		int len = c.length;
		int m = 0, n = 0, i = 0, cflag = 0, pflag =0;
		if (len == 0 ){
			return;
		}
		else {
			for(i = m ; i < len; i++){
				if(c[i] == '.' ){
					if(i>0 && cflag ==1){
						n = i-1;
						pflag = 1;
					}
				}
				else{
					if(cflag == 0){
						m = i;
						cflag = 1;
					}
				}
				
				if((cflag == 1 && pflag == 1) || (cflag==1 && i == (len-1))){
					if(i==len-1){
						rev(c,m,i);
						//System.out.println(" m : " + m + "  n : "+i);
					}
					else{
						rev(c,m,n);
						//System.out.println(" m : " + m + "  n : "+n);
					}
					cflag = 0;
					pflag = 0;
				}
			}
		}
		str = String.copyValueOf(c);
		System.out.println(str);
		
		for(int k =0;k<len;k++)
			System.out.print(c[k]);
	}
	
	public static void rev(char[] c,int m, int n){
		char temp;		
		int i = m;
		int j = n;
		
		while(j>=i){
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++;
			j--;
		}
	}

}
