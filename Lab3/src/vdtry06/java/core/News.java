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
	
	public News(String title, String publicDate, String author, String content, float averageRate) {
		this.id = cnt++;
		this.title = title;
		this.publicDate = publicDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
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
//		System.out.println("Id: "+ id);
//		System.out.println("Title: " + title);
//		System.out.println("PublicDate: " + publicDate);
//		System.out.println("Author: " + author);
//		System.out.println("Content: " + content);
//		System.out.println("AverageRate: " + averageRate);
		System.out.println(id + " " + title + " " + publicDate + " " + author + " " + content + " " + averageRate);
	}

	@Override
	public float Calculate() {
		int sum = 0;
		for(int num: rates) {
			sum += num;
		}
		averageRate = sum / rates.size();
		return averageRate;
	}

}
