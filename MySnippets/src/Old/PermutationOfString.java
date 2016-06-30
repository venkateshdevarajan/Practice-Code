package Old;

public class PermutationOfString {
	public static void main(String[] args){
		String str = "ABC";
		permute(str);
	}
	
	protected static void permute(String str){
		permutation("",str);
	}
	
	protected static void permutation(String prefix,String str){
		int length = str.length();
        if(length==0) System.out.println(prefix);
		if(length>0) {
            for (int i = 0; i < length; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, length));
                //System.out.println(prefix+str.charAt(i)+"**"+((str.substring(0, i) + str.substring(i+1, length))));
            }
        }
       // if(length==0) System.out.println(prefix);
	}

}
