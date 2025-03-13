package vdtry06.java.core;

import java.util.ArrayList;

public class News implements INews{
	public ArrayList<Integer> rates = new ArrayList<Integer>();
	private static int cnt = 1;
	private int id;
	private String title;
	private String publicDate;
	private String author;
	private String content;
	private float averageRate;
	
	public News() {
	}
	
	public News(String title, String publicDate, String author, String content) {
		this.id = cnt++;
		this.title = title;
		this.publicDate = publicDate;
		this.author = author;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}

	@Override
	public void Display() {
		System.out.println("Id: "+ id);
		System.out.println("Tiêu đề: " + title);
		System.out.println("Ngày xuất bản: " + publicDate);
		System.out.println("Tác giả: " + author);
		System.out.println("Nội dung: " + content);
		System.out.printf("Điểm trung bình: %.2f\n", averageRate);
		System.out.println("-------------------------------------");
	}

	@Override
	public float Calculate() {
		int sum = 0;
		for(int num: rates) {
			sum += num;
		}
		if (!rates.isEmpty()) {
            averageRate = sum / rates.size();
        }
		return averageRate;
	}

}
