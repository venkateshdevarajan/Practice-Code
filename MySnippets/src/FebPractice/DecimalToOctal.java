package FebPractice;

/**
 * Created by venkatesh.d on 01/04/16.
 */
public class DecimalToOctal {
    public static void main(String[] args){
        int decimal = 59;
        int octal=0 ;
        int remainder;
        int count = 0;

        while(decimal > 0){

        remainder = decimal % 8;
            decimal = decimal / 8;
        if(count > 0) {
            octal = octal + (remainder * 10^count);
        }
        else{
            octal =remainder;
        }
        count ++;
        }

        System.out.println("Decimal : "+ decimal+ "Octal Number :"+octal);

    }
}
