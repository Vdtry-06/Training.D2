package vdtry06.java.core;

public class NhanVien extends CanBo {
	private String work;
	public NhanVien(String name, int age, String gender, String address, String work) {
		super(name, age, gender, address);
		this.work = work;
	}
	
	public String getWork() {
		return work;
	}
	
	public void setWork(String work) {
		this.work = work;
	}
}
