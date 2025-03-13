package vdtry06.java.core;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("QUẢN LÝ CÁN BỘ");
            System.out.println("==============================");
            System.out.println("1️. Thêm mới cán bộ");
            System.out.println("2️. Tìm kiếm cán bộ");
            System.out.println("3️. Hiển thị danh sách cán bộ");
            System.out.println("4️. Xóa cán bộ");
            System.out.println("5️. Thoát chương trình");
            System.out.println("==============================");
            System.out.print("Chọn chức năng (1-5): ");
            
            String choose = scanner.nextLine().trim();
            
            switch (choose) {
            case "1":
                System.out.println("\nNhập thông tin cán bộ:");

                System.out.print("Tên: ");
                String name = scanner.nextLine().trim();
                if(name.isEmpty()) {
                	System.out.println("Tên không được để trống!\nVui lòng chọn lại để thực hiện lại các thao tác");
                	break;
                }

                System.out.print("Tuổi: ");
                Integer age = null;
                String ageInput = scanner.nextLine().trim();
                if (!ageInput.isEmpty()) {
                    try {
                        age = Integer.parseInt(ageInput);
                        if (age <= 0) {
                            System.out.println("Lỗi: Tuổi phải là số nguyên dương!");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Tuổi phải là số hợp lệ!");
                        break;
                    }
                } else {
                    System.out.println("Lỗi: Tuổi không được để trống!");
                    break;
                }

                System.out.print("Giới tính: ");
                String gender = scanner.nextLine().trim();
                if(gender.isEmpty()) {
                	System.out.println("Giới tính không được để trống!\nVui lòng chọn lại để thực hiện lại các thao tác");
                }
                System.out.print("Địa chỉ: ");
                String address = scanner.nextLine().trim();

                if(address.isEmpty()) {
                	System.out.println("Địa chỉ không được để trống!\nVui lòng chọn lại để thực hiện lại các thao tác");
                }

                QLCB.Add(name, age, gender, address);
                break;

                    
                case "2":
                    System.out.print("\nNhập tên cán bộ cần tìm: ");
                    String searchName = scanner.nextLine();
                    QLCB.Search(searchName);
                    break;

                case "3":
                    QLCB.List();
                    break;

                case "4":
                    System.out.print("\nNhập tên cán bộ cần xóa: ");
                    String deleteName = scanner.nextLine();
                    QLCB.Delete(deleteName);
                    break;

                case "5":
                    QLCB.End();
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    break;
            }
        }
    }
}
