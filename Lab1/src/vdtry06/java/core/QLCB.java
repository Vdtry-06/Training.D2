package vdtry06.java.core;

import java.util.ArrayList;

public class QLCB implements InterfaceQLCB {
    private static ArrayList<CanBo> danhSachCanBo = new ArrayList<>();
    
    public static void Add(String name, Integer age, String gender, String address) {
        CanBo canbo = new CanBo();
    	canbo.setName(name);
        canbo.setAge(age);
        canbo.setGender(gender);
        canbo.setAddress(address);
        danhSachCanBo.add(canbo);
        System.out.println("Thêm thành công cán bộ: " + name);
    }

    public static void Search(String name) {
        int count = 0;
        System.out.println("\nKết quả tìm kiếm:");
        System.out.println("---------------------------------");
        for (CanBo canBo : danhSachCanBo) {
            if (canBo.getName().equalsIgnoreCase(name)) {
                System.out.println(canBo.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy cán bộ có tên \"" + name + "\"");
        }
        System.out.println("---------------------------------");
    }

    public static void List() {
        if (danhSachCanBo.isEmpty()) {
            System.out.println("\nDanh sách cán bộ trống!");
            return;
        }
        System.out.println("\nDanh sách cán bộ:");
        System.out.println("---------------------------------");
        for (CanBo canbo : danhSachCanBo) {
            System.out.println(canbo.toString());
        }
        System.out.println("---------------------------------");
    }

    public static void Delete(String name) {
        boolean found = false;
        for (int i = 0; i < danhSachCanBo.size(); i++) {
            if (danhSachCanBo.get(i).getName().equalsIgnoreCase(name)) {
                danhSachCanBo.remove(i);
                System.out.println("Đã xóa cán bộ: " + name);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy cán bộ để xóa!");
        }
    }

    public static void End() {
        System.out.println("\nChương trình kết thúc. Hẹn gặp lại!");
        System.exit(0);
    }

}
