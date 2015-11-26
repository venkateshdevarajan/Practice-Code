

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeClass {
	public String employeeName=null;
	public String employeeID=null;
	public String employeeManager=null;
	
	public EmployeeClass empManager;
	
	public EmployeeClass(String employeeName)
	{
		this.employeeName=employeeName;
	}
	
	public void setEmpManager(EmployeeClass employeeManager)
	{
		this.empManager=employeeManager;
	}
	public EmployeeClass returnEmpManager()
	{
		return empManager;
	}
	public void setEmpName(String empName)
	{
		this.employeeName=empName;
	}
	public String returnEmpName()
	{
		return this.employeeName;
	}
	
	public EmployeeClass(String empName,EmployeeClass empManager)
	{
		this.employeeName=empName;
		this.empManager=empManager;
	}
	public EmployeeClass()
	{
		
	}
	
	public static ArrayList<EmployeeClass> returnManagerObject(EmployeeClass empClass)
	{
		ArrayList<EmployeeClass> managerHierarchy = new ArrayList<EmployeeClass>();
		EmployeeClass manager=empClass.returnEmpManager();
		while(manager.returnEmpManager()!=null)
		{
			managerHierarchy.add(manager);
			manager = manager.returnEmpManager();			
		}	
		if(manager.returnEmpManager()==null)
		{
			managerHierarchy.add(manager);
		}
		return managerHierarchy;
	}
	
	public static HashMap<String,EmployeeClass> returnEmpWithSameManager(ArrayList<EmployeeClass> allEmpList)
	{
		ArrayList<String> empWithSameManager = new ArrayList<String>();
		HashMap<String,EmployeeClass> managerEmployee = new HashMap<String,EmployeeClass>();
		
		for(int i=0; i<allEmpList.size();i++)
		{
			for(int j=0;j<allEmpList.size();j++)
			{
				if(i==j)
				{
					continue;
				}
				else
				{
					if(allEmpList.get(i).returnEmpManager()==allEmpList.get(j).returnEmpManager())
					{
						empWithSameManager.add(allEmpList.get(i).returnEmpName());
						managerEmployee.put(allEmpList.get(i).returnEmpName(), allEmpList.get(i).returnEmpManager());
						break;
					}
				}
			}
		}
		return managerEmployee;
	}
}
