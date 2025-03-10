package vdtry06.java.core;

import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.println("Nhap phim 1: Dang ki tai khoan cho admin");
		System.out.println("Nhap phim 2: Dang nhap tai khoan nhan vien");
		System.out.println("Nhap phim 3: Dang nhap tai khoan voi quyen admin");
		System.out.println("Nhap phim 4: De ket thuc chuong trinh");
	}
	
	public static void menuAdmin() {
		System.out.println("Nhap phim 1: Hien thi tat ca nguoi dung\n"
				+ "Nhap phim 2: Hien thi nguoi dung theo id\n"
				+ "Nhap phim 3: Xoa nguoi dung theo id\n"
				+ "Nhap phim 4: Tao nhan vien\n"
				+ "Nhap phim 5: De thoat khoi giao dien Admin");
	}
	
	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin();
		Employee employee = new Employee();
		
		while(true) {
			menu();
			String choise = sc.nextLine();
			if(choise.equals("1")) {
				System.out.println("Nhap ho va ten: ");
				String fullName = sc.nextLine();
				System.out.println("Nhap email: ");
				String email = sc.nextLine();
				System.out.println("Nhap password");
				String password = sc.nextLine();
				System.out.println("Nhap explnYear");
				int explnYear = Integer.parseInt(sc.nextLine());
				admin = new Admin(fullName, email, password, explnYear);
				userManager.addUser(admin, "Admin");
			} else if(choise.equals("2")) {
				System.out.println("Nhap email:");
				String email = sc.nextLine();
				System.out.println("Nhap password: ");
				String password = sc.nextLine();
				if(userManager.login(email, password)) {
					System.out.println("Day la giao dien nhan vien");
				} else {
					System.out.println("Loi dang nhap!");
				}
			} else if(choise.equals("3")) {
				System.out.println("Nhap email: ");
				String emailAdmin = sc.nextLine();
				System.out.println("Nhap password: ");
				String passwordAdmin = sc.nextLine();
				if(userManager.login(emailAdmin, passwordAdmin)) {
					System.out.println("Dang nhap thanh cong!");
					boolean check = true;
					while(check) {
						menuAdmin();
						
						String choice = sc.nextLine();
						switch (choice) {
						case "1":
							userManager.printAllUsers();
							break;
						case "2":
							System.out.println("Nhap id nguoi dung:");
							int userId = sc.nextInt();
							userManager.printUserById(userId);
							break;
						case "3":
							System.out.println("Nhap id nguoi dung:");
							int deleteId = sc.nextInt();
							userManager.deleteUserById(deleteId);
							break;
						case "4":
							System.out.println("Tao ho ten nhan vien moi:");
							String empFullName = sc.nextLine();
							System.out.println("Tao email nhan vien moi");
							String empEmail = sc.nextLine();
							userManager.createEmployee(empFullName, empEmail);
							break;
						case "5":
							check = false;
							
						default:
							if(check == true) {
								System.out.println("Lua chon khong dung dinh dang");
							} else {
								System.out.println("Tro ve Menu");
							}
						} 
					}
					
				} else {
					System.out.println("Loi dang nhap!");
				}
			} else if(choise.equals("4")) {
				System.out.println("Ket thuc chuong trinh!");
				System.exit(0);
			} else {
				System.out.println("Loi nhap sai ki tu dau vao!");
			}
		} 
	}
}
