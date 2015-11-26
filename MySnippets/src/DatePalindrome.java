
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DatePalindrome {
	
	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the start Date : ");
		String startDate = s.next();
		
		System.out.println("Enter the End Date : ");
		String endDate = s.next();
		
		String startMonth = startDate.substring(0, 2);
		String startDay = startDate.substring(2,4);
		String startYear = startDate.substring(4, 8);
		
		String endMonth = endDate.substring(0, 2);
		String endDay = endDate.substring(2,4);
		String endYear = endDate.substring(4,8);
		
		GregorianCalendar Startcalendar = new GregorianCalendar(Integer.parseInt(startYear),Integer.parseInt(startMonth)-1,Integer.parseInt(startDay));		
		GregorianCalendar Endcalendar = new GregorianCalendar(Integer.parseInt(endYear),Integer.parseInt(endMonth)-1,Integer.parseInt(endDay));
		
		String end = new SimpleDateFormat("MMddyyyy").format(Endcalendar.getTime());
		
		System.out.println("EndCalendar :"+end);
		
		String newDate;
		
		while(! end.equals(new SimpleDateFormat("MMddyyyy").format(Startcalendar.getTime()))){
			Startcalendar.add(Calendar.DAY_OF_MONTH, 1);
			newDate = (new SimpleDateFormat("MMddyyyy").format(Startcalendar.getTime()));			
			if(isPalindrome(newDate))
				System.out.println(newDate);
		}
		
		/*GregorianCalendar calendar = new GregorianCalendar(2012,11,25);
		calendar.add(Calendar.DAY_OF_MONTH, 1);		
		System.out.println(DateFormat.getDateInstance(3).format(calendar.getTime()));
		System.out.println(new SimpleDateFormat("MMddyyyy").format(calendar.getTime()));	
		new SimpleDateFormat("MM.dd.yyyy");		
		DateFormat.getDateInstance().format(calendar.getTime());*/
		
	}
	
	public static boolean isPalindrome(String newDate){
		char[] str = newDate.toCharArray();
		int n = str.length;
		int front = 0;
		int rear = n-1;
		int flag = 0;
		
		for(front =0 ; rear >= front ; front++,rear--){
			if(str[front] == str[rear]){
				flag = 1;
			}
			
			else{
				flag = 0;
				break;
			}
		}
		
		if(flag==1)
			return true;
		else
			return false;
	}

}
