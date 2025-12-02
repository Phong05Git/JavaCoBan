package Chuong4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HeThongQuanLyNhanSu {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Employee> danhSachNhanVien = new ArrayList<>();

            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Nhập Nhân viên");
                System.out.println("2. Nhập Quản lý");
                System.out.println("3. Xuất danh sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int chon;
                try {
                    chon = sc.nextInt();
                    sc.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println("Lỗi: Vui lòng nhập số nguyên!");
                    sc.nextLine(); 
                    continue; 
                }

                switch (chon) {
                    case 1 -> {
                        Employee nv = new Employee();
                        System.out.println("--- Nhập thông tin Nhân viên ---");
                        nv.nhapThongTin(sc);
                        danhSachNhanVien.add(nv);
                    }
                    case 2 -> {
                        Manager ql = new Manager();
                        System.out.println("--- Nhập thông tin Quản lý ---");
                        ql.nhapThongTin(sc);
                        danhSachNhanVien.add(ql);
                    }
                    case 3 -> {
                        System.out.println("\n=== DANH SÁCH NHÂN SỰ ===");
                        if (danhSachNhanVien.isEmpty()) {
                            System.out.println("Danh sách trống!");
                        } else {
                            for (Employee e : danhSachNhanVien) {
                                System.out.println(e);
                                System.out.println("--------------------");
                            }
                        }
                    }
                    case 0 -> {
                        System.out.println("Kết thúc chương trình.");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }
    }
}

abstract class Person {

    protected String ten;
    protected int tuoi;
    protected boolean gioiTinh;
    protected String diaChi;

    public Person() {
    }

    public Person(String ten, int tuoi, boolean gioiTinh, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public void nhapThongTin(Scanner sc) {
        while (true) {
            try {
                System.out.print("Nhập tên: ");
                this.ten = sc.nextLine();
                System.out.print("Nhập tuổi: ");
                this.tuoi = sc.nextInt();
                System.out.print("Nhập giới tính (true: Nam, false: Nữ): ");
                this.gioiTinh = sc.nextBoolean();
                sc.nextLine();
                System.out.print("Nhập địa chỉ: ");
                this.diaChi = sc.nextLine();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai định dạng, vui lòng nhập lại!");
                sc.nextLine(); 
            }
        }
    }
    
    public abstract double tinhLuong();

    @Override
    public String toString() {
        return "Tên: \t\t" + ten
                + "\nTuổi: \t\t" + tuoi
                + "\nGiới tính: \t" + (gioiTinh ? "Nam" : "Nữ")
                + "\nĐịa chỉ: \t" + diaChi;
    }
}

class Employee extends Person {

    protected String maNV;
    protected double heSoLuong;
    protected double luongCoBan;

    public Employee() {
    }

    public Employee(String ten, int tuoi, boolean gioiTinh, String diaChi,
            String maNV, double heSoLuong, double luongCoBan) {
        super(ten, tuoi, gioiTinh, diaChi);
        this.maNV = maNV;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        while (true) {
            try {
                System.out.print("Nhập mã NV: ");
                this.maNV = sc.nextLine();
                System.out.print("Nhập hệ số lương: ");
                this.heSoLuong = sc.nextDouble();
                System.out.print("Nhập lương cơ bản: ");
                this.luongCoBan = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Nhập sai định dạng số!");
                sc.nextLine();
            }
        }
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nMã NV: \t\t" + maNV
                + "\nHệ số lương: \t" + heSoLuong
                + "\nLương cơ bản: \t" + luongCoBan
                + "\nLương thực tế: \t" + tinhLuong();
    }
}

class Manager extends Employee {

    private double phuCap;

    public Manager() {
    }

    public Manager(String ten, int tuoi, boolean gioiTinh, String diaChi,
            String maNV, double heSoLuong, double luongCoBan, double phuCap) {
        super(ten, tuoi, gioiTinh, diaChi, maNV, heSoLuong, luongCoBan);
        this.phuCap = phuCap;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);
        while (true) {
            try {
                System.out.print("Nhập phụ cấp: ");
                this.phuCap = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Phụ cấp phải là số!");
                sc.nextLine();
            }
        }
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCap;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPhụ cấp: \t" + phuCap;
    }
}