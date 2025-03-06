package vdtry06.java.core;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB implements InterfaceQLCB {
	private static ArrayList<CanBo> danhSachCanBo = new ArrayList();
	
	public static void Add(String name, int age, String gender, String address) {
		CanBo canbo = new CanBo();
		canbo.setName(name);
		canbo.setAge(age);
		canbo.setGender(gender);
		canbo.setAddress(address);
		danhSachCanBo.add(canbo);
	}
	
	public static void Search(String name) {
		int count = 0;
		for(CanBo canBo : danhSachCanBo) {
			if(name.contains(canBo.getName())) {
				System.out.println(canBo.toString());
				count += 1;
			} 
		}
		if (count == 0) System.out.println("Khong tim thay ten Can Bo");
	}
	
	public static void List() {
		for(CanBo canbo : danhSachCanBo) {
			System.out.println(canbo.toString());
		}
	}
	
	public static void Delete(String name) {
		boolean check = false;
		CanBo nameTmp = new CanBo();
		for(CanBo canBo : danhSachCanBo) {
			if(canBo.getName().equals(name)) {
				nameTmp = canBo;
				check = true;
			}
		}
		if(check) {
			danhSachCanBo.remove(nameTmp);
		} else System.out.println("Khong tim thay can bo de xoa"); 
	}
	
	public static void End() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Chon a, b, c, d, e de thuc hien thao tac voi can bo:");
			System.out.println("a. Them moi can bo");
			System.out.println("b. Tim kiem ho ten");
			System.out.println("c. Hien thi danh sach can bo");
			System.out.println("d. Nhap ten can bo va xoa ten can bo");
			System.out.println("e. Thoat khoi chuong trinh");
			String choose = scanner.nextLine();
			if(choose.equals("a")) {
				System.out.println("a. Them moi can bo");
				String name = scanner.nextLine();
				int age = Integer.parseInt(scanner.nextLine());
				String gender = scanner.nextLine();
				String address = scanner.nextLine();
				Add(name, age, gender, address);
			} else if (choose.equals("b")) {
				System.out.println("b. Tim kiem ho ten");
				String name = scanner.nextLine();
				Search(name);
			} else if (choose.equals("c")) {
				System.out.println("c. Hien thi danh sach can bo");
				List();
			} else if (choose.equals("d")) {
				System.out.println("d. Nhap ten can bo va xoa ten can bo");
				String name = scanner.nextLine();
				Delete(name);
			} else if (choose.equals("e")) {
				System.out.println("e. Thoat khoi chuong trinh");
				End();
			} else {
				System.out.println("Nhap khong dung ki tu");
			}
		}
	}
}
