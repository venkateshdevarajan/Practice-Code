package FebPractice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by venkatesh.d on 06/02/16.
 */
public class DistanceBetweenTwoStrings {
    public static void main(String[] args){
        ArrayList<String> inputString = new ArrayList<String>();
        inputString.add("the");
        inputString.add("quick");
        inputString.add("brown");
        inputString.add("fox");
        inputString.add("one");
        inputString.add("the");
        //inputString.add("fox");
        inputString.add("quick");
        System.out.println(distanceBetweenWords(inputString,"the","fox"));

    }

    static int distanceBetweenWords(ArrayList<String> inputString,String a, String b) {
        int distance,minDistance= Integer.MAX_VALUE,counter=-1;
        int[] index = new int[2];
        if(inputString == null || a == null || b ==null ||inputString.size()<=0) return -1;

        for(int i=0;i<inputString.size();i++){
            String word = inputString.get(i);
            if(word.equals(a) || word.equals(b)){
                counter ++;
                index[counter] = i;
                if(counter==1){
                    counter = 0 ;
                    distance = index[1]-index[0];
                    index[0] = index[1];
                    if(distance < minDistance)
                        minDistance = distance;
                }
            }
        }

        return minDistance;
    }
}
