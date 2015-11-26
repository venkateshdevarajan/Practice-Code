package Old.Collection_Examples;

class Employee {
	String id;
	String name;
	Employee(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public boolean equals(Object O){
		Employee e = (Employee)O;
		if(O instanceof Employee && this.id == e.id){
			return true;
		}
		else
			return false;		
	}
}
