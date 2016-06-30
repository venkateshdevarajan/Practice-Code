package FebPractice;

/**
 * Created by venkatesh.d on 04/04/16.
 */
public class LongestSubStringLength {
    public static void main(String args[]){
        String s1 = "xab123abcde";
        String s2 = "abcd123abcde" +
                "";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int length=0;
        int maxLength = 0;

        for(int i=0;i<c1.length;i++){
            for(int j=0;j<c2.length;j++){
                length = 0;
                while(c1[i]==c2[j]){
                    if(i < c1.length-1)
                        i++;

                    if(j < c2.length-1)
                        j++;

                    length++;

                    if(i==c1.length-1 && j==c2.length-1) break;
                }
            }

            if(length > maxLength){
                maxLength = length;
            }
        }

        System.out.println(maxLength+1);
    }
}
