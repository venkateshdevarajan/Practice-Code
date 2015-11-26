import java.util.*;


public class WordReverse {

	public static void main(String args[]){
		
		/*Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		Stack<String> stack = new Stack<String>();
		
		String[] input = str.split(" ");
		
		for(int i=0;i<input.length;i++)
			stack.add(input[i]);
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}*/
		
		String jifi = "abcdef";
		String c[] = jifi.split("abc");
		System.out.println(c.length);
		for(int i =0; i<c.length; i++)
			System.out.println(c[i]);
		
		
	}
}
