package Old.CodeReview;

public class priyacode {

	 

    

    public static void main(String args[]){

         

          String a = "haaii";

          String[] b= a.split("");

          for(int i=0;i<b.length;i++){

                for(int j=0;j<i;j++){

                      if(b[i].equalsIgnoreCase(b[j])){

                            System.out.println(b[i]);

                            return;

                      }    

                }

          }

    }

}