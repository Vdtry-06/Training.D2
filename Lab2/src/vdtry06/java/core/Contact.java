package vdtry06.java.core;

public class Contact {
	private String number;
	private String name;
	
	public Contact() {
	};
	
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return name + " " + number;
	}
}
