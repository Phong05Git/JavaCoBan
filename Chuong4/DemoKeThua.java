package Chuong4;

class NVien {

    protected String ten;
    protected int maNV;
    protected float luongCoBan;

    public NVien(String ten, int maNV, float luongCoBan) {
        if (luongCoBan < 0) {
            throw new IllegalArgumentException("Lương cơ bản không được âm");
        }
        this.ten = ten;
        this.maNV = maNV;
        this.luongCoBan = luongCoBan;
    }

    public void hienThiThongTin() {
        System.out.println("Tên: " + ten);
        System.out.println("Mã NV: " + maNV);
        System.out.println("Lương CB: " + luongCoBan);
    }
}

class NVienKDoanh extends NVien {

    private float hoaHong;

    public NVienKDoanh(String ten, int maNV, float luongCoBan, float hoaHong) {
        super(ten, maNV, luongCoBan);
        if (hoaHong < 0) {
            throw new IllegalArgumentException("Hoa hồng không được âm");
        }
        this.hoaHong = hoaHong;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Hoa hồng: " + hoaHong);
    }

    public void tinhLuongThucTe() {
        float luongThucTe = luongCoBan + hoaHong;
        System.out.println("Lương thực tế của " + ten + ": " + luongThucTe);
    }
}

public class DemoKeThua {

    public static void main(String[] args) {
        try {
            NVienKDoanh nv1 = new NVienKDoanh("Nguyễn Thanh Bình", 101, 600, 100);
            System.out.println("--- Thông tin Nhân viên Kinh doanh ---");
            nv1.hienThiThongTin();
            nv1.tinhLuongThucTe();

            System.out.println("\n--- Thông tin Nhân viên (dùng đối tượng NVien) ---");
            NVien nv2 = new NVien("Trần Minh Hiếu", 102, 850);
            nv2.hienThiThongTin();

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
