package vdtry06.java.core;

public class CongNhan extends CanBo{
	private int degree;
	public CongNhan(String name, int age, String gender, String address, int degree) {
		super(name, age, gender, address);
		this.degree = degree;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
}
