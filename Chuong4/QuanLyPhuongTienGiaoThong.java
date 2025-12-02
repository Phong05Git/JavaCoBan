package Chuong4;

import java.util.Scanner;

public class QuanLyPhuongTienGiaoThong {

    public static void main(String[] args) {
        try {
            PhuongTien[] danhSachXe = new PhuongTien[3];

            danhSachXe[0] = new Oto("VinFast VF8", "VinFast", 2023, 200, 5, "Điện");
            danhSachXe[1] = new Oto("Toyota Camry", "Toyota", 2022, 210, 5, "Xăng");
            danhSachXe[2] = new XeMay("Honda SH", "Honda", 2023, 120, 150.0);

            System.out.println("DANH SÁCH PHƯƠNG TIỆN");

            for (PhuongTien pt : danhSachXe) {
                pt.hienThiThongTin();
            }
        } catch (Exception e) {
            System.out.println("Lỗi dữ liệu phương tiện: " + e.getMessage());
        }
    }
}

abstract class PhuongTien {

    protected String ten;
    protected String hangSanXuat;
    protected int namSanXuat;
    protected double vanTocToiDa;

    public PhuongTien(String ten, String hangSanXuat, int namSanXuat, double vanTocToiDa) {
        if (vanTocToiDa < 0) {
            throw new IllegalArgumentException("Vận tốc tối đa không được âm");
        }
        this.ten = ten;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.vanTocToiDa = vanTocToiDa;
    }

    public void hienThiThongTin() {
        System.out.println("---------------------------------");
        System.out.println("Tên phương tiện: " + ten);
        System.out.println("Hãng sản xuất: " + hangSanXuat);
        System.out.println("Năm sản xuất: " + namSanXuat);
        System.out.println("Vận tốc tối đa: " + vanTocToiDa + " km/h");
    }
}

class Oto extends PhuongTien {

    private int soChoNgoi;
    private String loaiNhienLieu;

    public Oto(String ten, String hangSanXuat, int namSanXuat, double vanTocToiDa, int soChoNgoi, String loaiNhienLieu) {
        super(ten, hangSanXuat, namSanXuat, vanTocToiDa);
        if (soChoNgoi <= 0) {
            throw new IllegalArgumentException("Số chỗ ngồi phải lớn hơn 0");
        }
        this.soChoNgoi = soChoNgoi;
        this.loaiNhienLieu = loaiNhienLieu;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Số chỗ ngồi: " + soChoNgoi);
        System.out.println("Loại nhiên liệu: " + loaiNhienLieu);
    }
}

class XeMay extends PhuongTien {

    private double congSuatDongCo;

    public XeMay(String ten, String hangSanXuat, int namSanXuat, double vanTocToiDa, double congSuatDongCo) {
        super(ten, hangSanXuat, namSanXuat, vanTocToiDa);
        if (congSuatDongCo <= 0) {
            throw new IllegalArgumentException("Công suất động cơ phải lớn hơn 0");
        }
        this.congSuatDongCo = congSuatDongCo;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Công suất động cơ: " + congSuatDongCo + " CC");
    }
}
