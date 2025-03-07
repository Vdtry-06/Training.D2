package vdtry06.java.core;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
	public static ArrayList<News> list = new ArrayList<News>();  
	public static News new1 = new News();
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Chon 1, 2, 3, 4 De thuc hien thao tac voi nguoi dung:");
			System.out.println("1. Tao doi tuong class News");
			System.out.println("2. Thuc thi phuong thuc Display()");
			System.out.println("3. Thuc hien phuong thuc Calculate de tinh gia tri trung binh");
			System.out.println("   Sau do thuc thi phuong thuc Display()");
			System.out.println("4. Thoat khoi chuong trinh.");
			
			String choose = sc.nextLine();
			if(choose.equals("1")) {
				System.out.println("Nhap Title:");
				String title = sc.nextLine();
				System.out.println("Nhap PublicDate:");
				String publicDate = sc.nextLine();
				System.out.println("Nhap Author:");
				String author = sc.nextLine();
				System.out.println("Nhap Content:");
				String content = sc.nextLine();
				System.out.println("Nhap 3 so nguyen de luu vao Rates");
				int num1 = Integer.parseInt(sc.nextLine());
				int num2 = Integer.parseInt(sc.nextLine());
				int num3 = Integer.parseInt(sc.nextLine());
				insertNews(title, publicDate, author, content, num1, num2, num3);
			}
			else if(choose.equals("2")) {
				viewListNews();
				for(News lst : list) {
					System.out.println(lst);
				}
			}
			else if(choose.equals("3")) {
				averageRate();
				for(News lst : list) {
					System.out.println(lst);
				}
			}
			else if(choose.equals("4")) {
				Exit();
			}
			else System.out.println("Nhap sai ki tu tu ban phim \n Vui long nhap dung ki tu de thuc hien cac thao tac");
			
			System.out.println();
		}
	}
	public static void insertNews(
			String title, 
			String publicDate, 
			String author, 
			String content, 
			int num1, 
			int num2, 
			int num3
			) {
		new1.setTitle(title);
		new1.setPublicDate(publicDate);
		new1.setAuthor(author);
		new1.setContent(content);
		new1.rates.add(num1);
		new1.rates.add(num2);
		new1.rates.add(num3);
		list.add(new1);
	}
	
	public static void viewListNews() {
		new1.Display();
		list.add(new1);
	}
	
	public static void averageRate() {
		new1.Calculate();
		new1.Display();
		list.add(new1);
	}
	
	public static void Exit() {
		System.out.println("Thoat khoi chuong trinh");
		System.exit(0);
	}
}
