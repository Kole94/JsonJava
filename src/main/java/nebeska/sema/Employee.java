package nebeska.sema;

public class Employee {
	
	private String occupation;
	private String name;
	
	Employee(String occupation, String name){
		this.occupation = occupation;
		this.name = name;
	}
	
	Employee(){
		this.occupation = "";
		this.name = "";
		
	}
	
	@Override
	public String toString(){
		return occupation + " " + name;
	}
}
