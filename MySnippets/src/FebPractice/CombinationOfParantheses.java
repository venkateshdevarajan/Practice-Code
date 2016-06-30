package FebPractice;

/**
 * Created by venkatesh.d on 27/06/16.
 */
public class CombinationOfParantheses {

    public static void main(String[] args){
        String str = new String();
        int n =2;
        printParantheses(n,0,0,str);

    }

    public static void printParantheses(int n,int open, int close,String str){


        if(close == n ){
            System.out.println(str);
        }

        else{
            if(open > close){
                printParantheses(n,open,close+1,str+")");
            }
            if(open < n){
                printParantheses(n,open+1,close,str+"(");
            }
        }

    }
}
