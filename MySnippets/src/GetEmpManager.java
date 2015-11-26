package com.Recursivemanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class GetEmpManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeClass CEO=new EmployeeClass("Lars",null);
		EmployeeClass VP=new EmployeeClass("Sekar",CEO);
		EmployeeClass emp1=new EmployeeClass("rajesh",VP);
		EmployeeClass emp2=new EmployeeClass("Myla",emp1);
		EmployeeClass emp3=new EmployeeClass("Sandeep",emp2);
		EmployeeClass emp4=new EmployeeClass("Shashi",emp2);
		EmployeeClass emp5=new EmployeeClass("Din",emp3);
		EmployeeClass emp6=new EmployeeClass("Don",emp3);
		EmployeeClass emp7=new EmployeeClass("Dan",emp3);
		
		
		ArrayList<EmployeeClass> allEmpList = new ArrayList<EmployeeClass>();
		allEmpList.add(emp1);
		allEmpList.add(emp2);
		allEmpList.add(emp3);
		allEmpList.add(emp4);
		allEmpList.add(emp5);
		allEmpList.add(emp6);
		allEmpList.add(emp7);
		allEmpList.add(VP);
		allEmpList.add(CEO);
		
		ArrayList<EmployeeClass> managerList=EmployeeClass.returnManagerObject(emp7);

		for(EmployeeClass e:managerList)
		{
			System.out.println("Employee who is a manager: "+e.returnEmpName());
		}
		
//		ArrayList<String> sameManager=EmployeeClass.returnEmpWithSameManager(allEmpList);
//		for(String s:sameManager)
//		{
//			System.out.println(s);
//		}
		
		HashMap<String,EmployeeClass> managerEmp = EmployeeClass.returnEmpWithSameManager(allEmpList);
		Set<String> empNames=managerEmp.keySet();
		
		for(String st: empNames)
		{
			if(managerEmp.get(st)!=null)
			{
				System.out.println("Employee is: "+st+" and Manager is: "+managerEmp.get(st).returnEmpName());
			}
			else
			{
				System.out.println("Employee reporting to CEO: "+st);
			}
		}
	}

}
