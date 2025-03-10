package vdtry06.java.core;

public class Admin extends User{
	
	private int explnYear;
	
	public Admin() {};
	
	public Admin(String fullName, String email, String password, int explnYear) {
		super(fullName, email, password);
		this.explnYear = explnYear;
	}

	public int getExplnYear() {
		return explnYear;
	}

	public void setExplnYear(int explnYear) {
		this.explnYear = explnYear;
	}
	
}
