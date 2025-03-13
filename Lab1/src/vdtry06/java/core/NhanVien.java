package vdtry06.java.core;

public class NhanVien extends CanBo {
	private String job;
	public NhanVien(String name, Integer age, String gender, String address, String job) {
		super(name, age, gender, address);
		this.job = job;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
}
