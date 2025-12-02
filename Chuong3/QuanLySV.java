package Chuong3;

class SinhVien1 {

    private String maSo;
    private String ten;
    private double diem;
    private static int soLuongSV = 0;

    public SinhVien1(String maSo, String ten, double diem) {
        if (maSo == null || maSo.isEmpty()) {
            throw new IllegalArgumentException("Mã số không hợp lệ");
        }
        if (diem < 0 || diem > 10) {
            throw new IllegalArgumentException("Điểm phải từ 0-10");
        }

        this.maSo = maSo;
        this.ten = ten;
        this.diem = diem;
        soLuongSV++;
    }

    public String getMaSo() {
        return maSo;
    }

    public String getTen() {
        return ten;
    }

    public double getDiem() {
        return diem;
    }

    public static int getSoLuongSV() {
        return soLuongSV;
    }
}

class QLSinhVien {

    static final int MAX_SINH_VIEN = 100;
    static SinhVien1[] dsSV = new SinhVien1[MAX_SINH_VIEN];

    static int soLuongHienCo = 0;

    public static void themSV(SinhVien1 sv) {
        if (soLuongHienCo >= MAX_SINH_VIEN) {
            throw new IllegalStateException("Lỗi: Danh sách đã đầy!");
        }

        dsSV[soLuongHienCo++] = sv;
    }

    static double tinhDiemTB() {
        if (soLuongHienCo == 0) {
            return 0.0;
        }

        double tongDiem = 0;
        for (int i = 0; i < soLuongHienCo; i++) {
            tongDiem += dsSV[i].getDiem();
        }
        return tongDiem / soLuongHienCo;
    }

    public static void tim_SVMax() {
        if (soLuongHienCo == 0) {
            throw new IllegalStateException("Danh sách rỗng, không tìm thấy sinh viên.");
        }

        SinhVien1 svMax = dsSV[0];

        for (int i = 1; i < soLuongHienCo; i++) {
            if (dsSV[i].getDiem() > svMax.getDiem()) {
                svMax = dsSV[i];
            }
        }

        System.out.println("Sinh viên có điểm cao nhất: " + svMax.getMaSo());
    }

    public static void main(String[] args) {
        try {
            SinhVien1 sv1 = new SinhVien1("SV001", "Nguyễn Văn A", 8.5);
            SinhVien1 sv2 = new SinhVien1("SV002", "Nguyễn Văn B", 9.3);
            SinhVien1 sv3 = new SinhVien1("SV003", "Nguyễn Văn C", 7.8);

            QLSinhVien.themSV(sv1);
            QLSinhVien.themSV(sv2);
            QLSinhVien.themSV(sv3);

            double dtb = QLSinhVien.tinhDiemTB();
            System.out.println("--- Điểm trung bình ---");
            System.out.printf("Tổng số sinh viên: %d\n", SinhVien1.getSoLuongSV());
            System.out.printf("Số sinh viên trong danh sách: %d\n", soLuongHienCo);
            System.out.printf("Điểm trung bình của lớp: %.2f\n", dtb);

            QLSinhVien.tim_SVMax();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
