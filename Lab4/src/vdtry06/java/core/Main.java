package vdtry06.java.core;

import java.util.Scanner;

public class Main {
    
    public static void displayMenu() {
        System.out.println("=====================================");
        System.out.println("|          QUẢN LÝ NHÂN SỰ          |");
        System.out.println("=====================================");
        System.out.println("| 1. Đăng ký tài khoản Admin        |");
        System.out.println("| 2. Đăng nhập tài khoản Nhân viên  |");
        System.out.println("| 3. Đăng nhập tài khoản Admin      |");
        System.out.println("| 4. Thoát chương trình             |");
        System.out.println("=====================================");
        System.out.print("Lựa chọn của bạn: ");
    }
    
    public static void displayAdminMenu() {
        System.out.println("\n=====================================");
        System.out.println("|         QUẢN LÝ ADMIN             |");
        System.out.println("=====================================");
        System.out.println("| 1. Hiển thị tất cả người dùng      |");
        System.out.println("| 2. Hiển thị người dùng theo ID     |");
        System.out.println("| 3. Xóa người dùng theo ID          |");
        System.out.println("| 4. Tạo nhân viên mới               |");
        System.out.println("| 5. Thoát giao diện Admin           |");
        System.out.println("=====================================");
        System.out.print("Lựa chọn của bạn: ");
    }
    
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();
        
        while (true) {
            displayMenu();
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.print("Nhập họ và tên: ");
                    String fullName = sc.nextLine();
                    if(fullName.isEmpty()) {
                    	System.out.println("Tên không được để trống\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();
                    if(email.isEmpty()) {
                    	System.out.println("Email không được để trống\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    System.out.print("Nhập mật khẩu: ");
                    String password = sc.nextLine();
                    if(password.isEmpty()) {
                    	System.out.println("Password không được để trống\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    System.out.print("Nhập số năm kinh nghiệm: ");
                    String explnYearStr = sc.nextLine();
                    if(explnYearStr.trim().isEmpty()) {
                    	System.out.println("Năm kinh nghiệm không được để trống\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    int explnYear = Integer.parseInt(explnYearStr);
                    admin = new Admin(fullName, email, password, explnYear);
                    userManager.addUser(admin, "Admin");
                    break;
                
                case "2":
                    System.out.print("Nhập email: ");
                    String empEmail = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String empPassword = sc.nextLine();
                    if (userManager.login(empEmail, empPassword)) {
                        System.out.println("Đăng nhập nhân viên thành công!");
                    } else {
                        System.out.println("Đăng nhập thất bại!");
                    }
                    break;
                
                case "3":
                    System.out.print("Nhập email Admin: ");
                    String emailAdmin = sc.nextLine();
                    System.out.print("Nhập mật khẩu Admin: ");
                    String passwordAdmin = sc.nextLine();
                    if (userManager.login(emailAdmin, passwordAdmin)) {
                        System.out.println("Đăng nhập Admin thành công!");
                        boolean adminActive = true;
                        
                        while (adminActive) {
                            displayAdminMenu();
                            String adminChoice = sc.nextLine();
                            
                            switch (adminChoice) {
                                case "1":
                                    userManager.printAllUsers();
                                    break;
                                case "2":
                                    System.out.print("Nhập ID người dùng: ");
                                    int userId = Integer.parseInt(sc.nextLine());
                                    userManager.printUserById(userId);
                                    break;
                                case "3":
                                    System.out.print("Nhập ID người dùng cần xóa: ");
                                    int deleteId = Integer.parseInt(sc.nextLine());
                                    userManager.deleteUserById(deleteId);
                                    break;
                                case "4":
                                    System.out.print("Nhập họ và tên nhân viên mới: ");
                                    String newEmpFullName = sc.nextLine();
                                    System.out.print("Nhập email nhân viên mới: ");
                                    String newEmpEmail = sc.nextLine();
                                    userManager.createEmployee(newEmpFullName, newEmpEmail);
                                    System.out.println("Nhân viên mới đã được tạo!");
                                    break;
                                case "5":
                                    adminActive = false;
                                    System.out.println("Trở về menu chính...");
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ!");
                            }
                        }
                    } else {
                        System.out.println("Đăng nhập thất bại!");
                    }
                    break;
                
                case "4":
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
        }
    }
}
