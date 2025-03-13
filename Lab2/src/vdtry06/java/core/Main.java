package vdtry06.java.core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VietnamesePhone vienamesePhone = new VietnamesePhone();

        while (true) {
            System.out.println("\n================ MENU QUẢN LÝ LIÊN LẠC ================");
            System.out.println("1️. Thêm thông tin liên lạc");
            System.out.println("2️. Xóa thông tin liên lạc");
            System.out.println("3️. Cập nhật số điện thoại");
            System.out.println("4️. Tìm kiếm liên lạc");
            System.out.println("5️. Hiển thị danh bạ");
            System.out.println("6️. Thoát chương trình");
            System.out.println("=====================================================");
            System.out.print("Chọn chức năng (1-6): ");
            
            String choose = sc.nextLine().trim();
            System.out.println("-----------------------------------------------------");

            switch (choose) {
                case "1":
                    System.out.println("Nhập thông tin liên lạc mới:");
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine().trim();
                    if(name.isEmpty()) {
                    	System.out.println("Tên không được bỏ trống!\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    System.out.print("Nhập số điện thoại: ");
                    String phone = sc.nextLine().trim();
                    if(phone.isEmpty()) {
                    	System.out.println("SĐT không được bỏ trống!\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    vienamesePhone.insertContact(name, phone);
                    break;

                case "2":
                    System.out.print("Nhập tên người dùng cần xóa: ");
                    String removeName = sc.nextLine().trim();
                    vienamesePhone.removeContact(removeName);
                    break;

                case "3":
                    System.out.print("Nhập tên cần cập nhật: ");
                    String updateName = sc.nextLine().trim();
                    System.out.print("Nhập số điện thoại mới: ");
                    String newPhone = sc.nextLine().trim();
                    if(newPhone.isEmpty()) {
                    	System.out.println("SĐT không được bỏ trống!\nVui lòng chọn lại thao tác");
                    	break;
                    }
                    vienamesePhone.updateContact(updateName, newPhone);
                    break;

                case "4":
                    System.out.print("Nhập tên cần tìm kiếm: ");
                    String searchName = sc.nextLine().trim();
                    vienamesePhone.searchContact(searchName);
                    break;

                case "5":
                    System.out.println("Danh bạ hiện tại:");
                    vienamesePhone.listAllContacts();
                    break;

                case "6":
                    System.out.println("Cảm ơn đã sử dụng chương trình.!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 1 đến 6.");
            }
        }
    }
}
