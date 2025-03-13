package vdtry06.java.core;

public class KySu extends CanBo {
	private String major;
	public KySu(String name, Integer age, String gender, String address, String major) {
		super(name, age, gender, address);
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
}
