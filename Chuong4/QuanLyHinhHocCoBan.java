package Chuong4;

public class QuanLyHinhHocCoBan {

    public static void main(String[] args) {
        try {
            HinhHoc hinhTron = new HinhTron(5.0);
            System.out.println(hinhTron);

            HinhHoc hinhCN = new HinhChuNhat(4, 10);
            System.out.println(hinhCN);

            HinhHoc hinhTG = new HinhTamGiac(3, 4, 5);
            System.out.println(hinhTG);

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi hình học: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

abstract class HinhHoc {

    protected String tenHinh;
    protected double chuVi;
    protected double dienTich;

    public HinhHoc(String tenHinh) {
        this.tenHinh = tenHinh;
    }

    public abstract double tinhChuVi();

    public abstract double tinhDienTich();

    @Override
    public String toString() {
        return String.format("%-13s | Chu vi: %.2f | Diện tích: %.2f",
                tenHinh, chuVi, dienTich);
    }
}

class HinhTron extends HinhHoc {

    private double radius;

    public HinhTron(double radius) {
        super("Hình Tròn");
        if (radius <= 0) {
            throw new IllegalArgumentException("Bán kính phải > 0");
        }
        this.radius = radius;
        this.chuVi = tinhChuVi();
        this.dienTich = tinhDienTich();
    }

    @Override
    public double tinhChuVi() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * radius * radius;
    }
}

class HinhChuNhat extends HinhHoc {

    private double chieuDai, chieuRong;

    public HinhChuNhat(double canh1, double canh2) {
        super("Hình Chữ Nhật");
        if (canh1 <= 0 || canh2 <= 0) {
            throw new IllegalArgumentException("Cạnh phải > 0");
        }
        this.chieuDai = Math.max(canh1, canh2);
        this.chieuRong = Math.min(canh1, canh2);
        this.chuVi = tinhChuVi();
        this.dienTich = tinhDienTich();
    }

    @Override
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    @Override
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
}

class HinhTamGiac extends HinhHoc {

    private double a, b, c;

    public HinhTamGiac(double a, double b, double c) {
        super("Hình Tam Giác");
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Cạnh phải > 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Không thỏa mãn bất đẳng thức tam giác");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.chuVi = tinhChuVi();
        this.dienTich = tinhDienTich();
    }

    @Override
    public double tinhChuVi() {
        return a + b + c;
    }

    @Override
    public double tinhDienTich() {
        double p = this.chuVi / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
