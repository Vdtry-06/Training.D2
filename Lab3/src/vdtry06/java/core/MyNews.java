package vdtry06.java.core;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
    public static ArrayList<News> list = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
        	System.out.println("\n=====================================");
            System.out.println("=   CHƯƠNG TRÌNH QUẢN LÝ TIN TỨC    =");
            System.out.println("=====================================");
            System.out.println("1️. Tạo bài báo mới");
            System.out.println("2️. Hiển thị danh sách bài báo");
            System.out.println("3️. Tính và hiển thị trung bình đánh giá");
            System.out.println("4️. Thoát chương trình");
            System.out.println("-------------------------------------");
            System.out.print("Chọn thao tác: ");

            String choose = sc.nextLine();
            switch (choose) {
                case "1":
                    createNews();
                    break;
                case "2":
                    viewListNews();
                    break;
                case "3":
                	averageRate();
                    break;
                case "4":
                    exitProgram();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        }
    }

    public static void createNews() {
        System.out.println("\nNHẬP THÔNG TIN BÀI BÁO MỚI:");
        System.out.print("Tiêu đề: ");
        String title = sc.nextLine();
        System.out.print("Ngày xuất bản: ");
        String publicDate = sc.nextLine();
        System.out.print("Tác giả: ");
        String author = sc.nextLine();
        System.out.print("Nội dung: ");
        String content = sc.nextLine();

        News news = new News(title, publicDate, author, content);

        System.out.println("Nhập 3 đánh giá (1 - 10):");
        for (int i = 0; i < 3; i++) {
            int rate;
            while (true) {
                System.out.print("Đánh giá " + (i + 1) + ": ");
                try {
                    rate = Integer.parseInt(sc.nextLine());
                    if (rate < 1 || rate > 10) {
                        System.out.println("Điểm phải từ 1 đến 10! Hãy nhập lại.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hãy nhập một số nguyên hợp lệ!");
                }
            }
            news.rates.add(rate);
        }
        

        list.add(news);
        System.out.println("Bài báo đã được thêm thành công!\n");
    }

    public static void viewListNews() {
        if (list.isEmpty()) {
            System.out.println("Không có bài báo nào trong danh sách.");
            return;
        }
        System.out.println("\nDANH SÁCH BÀI BÁO:");
        System.out.println("=====================================");
        for (News news : list) {
            news.Display();
        }
    }

    public static void averageRate() {
        if (list.isEmpty()) {
            System.out.println("Không có bài báo nào trong danh sách.");
            return;
        }
        for (News news : list) {
            news.Calculate();
            news.Display();
        }
    }

    public static void exitProgram() {
        System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        System.exit(0);
    }
}
