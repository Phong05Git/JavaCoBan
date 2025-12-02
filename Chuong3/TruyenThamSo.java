package Chuong3;

class NhanVien {

    String hoTen;
    int tuoi;

    public NhanVien(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }
}

class Main {

    public static void capNhatNhanVien(NhanVien nv, int tangTuoi) {
        if (nv == null) {
            throw new IllegalArgumentException("Đối tượng nhân viên null");
        }

        nv.tuoi += tangTuoi; // kiểu tham chiếu: thay đổi thuộc tính đối tượng
        System.out.println("Tuổi mới: " + nv.tuoi);
        tangTuoi += 5; // kiểu nguyên thủy: chỉ thay đổi trong phương thức
        System.out.println("tangTuoi trong phương thức: " + tangTuoi);
    }

    public static void main(String[] args) {
        try {
            NhanVien nv1 = new NhanVien("Phúc", 25);
            int soTuoiTang = 2;
            capNhatNhanVien(nv1, soTuoiTang);
            System.out.println("Tuổi NV1 sau phương thức: " + nv1.tuoi);
            System.out.println("soTuoiTang bên ngoài phương thức: " + soTuoiTang);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
