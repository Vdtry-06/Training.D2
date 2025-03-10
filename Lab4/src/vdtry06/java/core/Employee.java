package vdtry06.java.core;

public class Employee extends User{
	
	private String proSkill;
	
	public Employee() {};
	
	public Employee(String fullName, String email, String password, String proSkill) {
		super(fullName, email, password);
		this.proSkill = proSkill;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
}
