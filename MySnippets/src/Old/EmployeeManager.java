package Old;

import java.util.ArrayList;
import java.util.List;


public class EmployeeManager {
	String name;
	EmployeeManager manager;	
	
	public EmployeeManager(String name, EmployeeManager manager){
		this.name = name;
		this.manager = manager;
	}
	
	public static EmployeeManager getManager(EmployeeManager employee){
		return employee.manager;
	}
	
	public static void main(String[] args){
		EmployeeManager e1 = new EmployeeManager("Sekar",null);
		EmployeeManager e2 = new EmployeeManager("Srini", e1);
		EmployeeManager e3 = new EmployeeManager("Pratush",e2);
		EmployeeManager e4 = new EmployeeManager("Mohan", e3);
		EmployeeManager e6 = new EmployeeManager("YouALL", e4);
		EmployeeManager e5 = new EmployeeManager("WEALL", e4);
		
		List<EmployeeManager> empList = new ArrayList<EmployeeManager>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);
		
		//showAllManagers(e6);
		showAllMyReportees(e4,empList);

        //empList.remove(e4);
	}
	
	private static void showAllManagers(EmployeeManager employee){		
		if(employee.manager != null){
			System.out.println(getManager(employee).name);
			showAllManagers(getManager(employee));
		}
	}
	
	private static void showAllMyReportees(EmployeeManager manager,List<EmployeeManager> empList){
		java.util.Iterator<EmployeeManager> i = empList.iterator();
		while(i.hasNext()){
			EmployeeManager e = i.next();			 
			if(getManager(e)!= null){
				if(getManager(e).name.equalsIgnoreCase(manager.name))
					System.out.println(e.name);
			}
		}
	}
}
