package vdtry06.java.core;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		VietnamesePhone vienamesePhone = new VietnamesePhone();
		while(true) {
			System.out.println("Chon 1, 2, 3, 4, 5, 6 De thuc hien thao tac voi nguoi dung:");
			System.out.println("1. Them thong tin lien lac cho nguoi dung");
			System.out.println("2. Xoa thong tin lien lac cua nguoi dung");
			System.out.println("3. Cap nhat thong tin lien lac cua nguoi dung");
			System.out.println("4. Tim kiem thong tin lien lac cua nguoi dung");
			System.out.println("5. Hien thi thong tin lien lac cua tat ca nguoi dung");
			System.out.println("6. Thoat khoi chuong trinh.");
			String choose = sc.nextLine().trim();
			
			if(choose.equals("1")) {
				System.out.println("Them thong tin lien lac cho nguoi dung: ");
				String name = sc.nextLine();
				String phone = sc.nextLine();
				vienamesePhone.insertContact(name, phone);
				
			} else if (choose.equals("2")) {
				System.out.println("Xoa thong tin lien lac cua nguoi dung");
				String name = sc.nextLine();
				vienamesePhone.removeContact(name);
				
			} else if (choose.equals("3")) {
				System.out.println("Cap nhat thong tin lien lac cua nguoi dung");
				String name = sc.nextLine();
				String newPhone = sc.nextLine();
				vienamesePhone.updateContact(name, newPhone);
				
			} else if (choose.equals("4")) {
				System.out.println("Tim kiem thong tin lien lac cua nguoi dung");
				String name = sc.nextLine();
				vienamesePhone.searchContact(name);
				
			} else if (choose.equals("5")){
				System.out.println("Hien thi thong tin lien lac cua tat ca nguoi dung: ");
				vienamesePhone.listContacts();
			} else if(choose.equals("6")) {
				System.out.println("Thoat khoi chuong trinh.");
				System.exit(0);
				
			} else {
				System.out.println("Ki tu nhap vao khong hop le, vui long thu lai!");
			}
			
			System.out.println();
		}
	}
}
