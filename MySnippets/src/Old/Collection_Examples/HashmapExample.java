package Old.Collection_Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashmapExample {
	private static boolean exitCode = false ; 
	public static void main(String args[]) throws IOException{
		HashMap<String,Employee> employeeMap = new HashMap<String,Employee>();
		Employee e1 = new Employee("1","Venkatesh");
		Employee e2 = new Employee("2","Priyadarsini");
		Employee e3 = new Employee("3","Ramya");
		Employee e4 = new Employee("4","Nithya");
		
		employeeMap.put(e1.id, e1);
		employeeMap.put(e2.id, e2);
		employeeMap.put(e3.id, e3);
		employeeMap.put(e4.id, e4);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(! exitCode){
			displayMenu();
			String ip = br.readLine();
			int i = Integer.parseInt(ip);
			if(i > 0 && i < 6){
				switch(ip){
					case "1" : addEmployee(employeeMap);
							   break;
					case "2" : removeEmployee(employeeMap);
							   break;
					case "3" : displayEmployee(employeeMap);
							   break;
					case "4" : displayAll(employeeMap);
							   break;
					case "5" : exitCode = true;
							   break;
				}
					
			}
			else{
				System.out.println("Enter a valid input");
				continue;
			}
				
		}		
	}
	
	public static void displayAll(HashMap<String,Employee> e){
		Iterator i = e.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry items = (Map.Entry) i.next();
			Employee e2 = (Employee) items.getValue();
			System.out.println(items.getKey() +": "+e2.name);
		}
	}
	
	public static void removeEmployee(HashMap<String,Employee> e) throws IOException{
		String id;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the id : ");
		id = br.readLine();
		
		if(e.containsKey(id)){
			e.remove(id);
		}
		else{
			System.out.println("No Such Employee to delete");
		}
		
	}
	
	
	public static void addEmployee(HashMap<String,Employee> e) throws IOException{
		String id,name;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the id : ");
		id = br.readLine();
		System.out.println("Enter the name : ");
		name = br.readLine();
		
		if(e.containsKey(id)){
			System.out.println("Employee id already present");
		}
		else{
			e.put(id, new Employee(id,name));
		}
		
	}
	
	public static void displayEmployee(HashMap<String,Employee> e) throws IOException{
		String id;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		id = br.readLine();
		if(e.containsKey(id)){
			System.out.println(e.get(id).name);
		}
		else{
			System.out.println("No Such Employee");
		}		
	}
	
	public static void displayMenu(){
		System.out.println("Press 1 - Add an employee");
		System.out.println("Press 2 - Remove an employee");
		System.out.println("Press 3 - Display an employee");
		System.out.println("Press 4 - Display all");
		System.out.println("Press 5 - Exit");
		System.out.print("Enter your choice : ");
	}	
}

