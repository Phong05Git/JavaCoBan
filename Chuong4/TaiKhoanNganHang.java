package Chuong4;

public class TaiKhoanNganHang {

    public static void main(String[] args) {
        try {
            System.out.println("--- KIEM TRA TAI KHOAN THUONG ---");
            TaiKhoan tk1 = new TaiKhoan("TK001", "Nguyen Van A", 1000000);
            tk1.kiemTraSoDu();
            tk1.napTien(500000);

            tk1.rutTien(2000000); 
            tk1.rutTien(200000);
            tk1.kiemTraSoDu();

            System.out.println("\n--- KIEM TRA TAI KHOAN TIET KIEM ---");
            TaiKhoanTietKiem tk2 = new TaiKhoanTietKiem("TK002", "Tran Thi B", 5000000, 0.05);
            tk2.kiemTraSoDu();
            tk2.tinhLai();
            tk2.kiemTraSoDu();

            System.out.println("\n--- KIEM TRA TAI KHOAN VAY ---");
            TaiKhoanVay tk3 = new TaiKhoanVay("TK003", "Le Van C", 1000000, 2000000);
            tk3.kiemTraSoDu();
            tk3.rutTien(2500000);
            tk3.kiemTraSoDu();
            tk3.rutTien(1000000);

        } catch (Exception e) {
            System.out.println("Lỗi giao dịch: " + e.getMessage());
        }
    }
}

class TaiKhoan {

    protected String soTaiKhoan;
    protected String tenChuTaiKhoan;
    protected double soDu;

    public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
        if (soDu < 0) {
            throw new IllegalArgumentException("Số dư khởi tạo không được âm");
        }
        this.soTaiKhoan = soTaiKhoan;
        this.tenChuTaiKhoan = tenChuTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        if (soTien <= 0) {
            throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0");
        }
        soDu += soTien;
        System.out.printf("Nạp %.2f vào tài khoản. Số dư cuối: %.2f\n", soTien, soDu);
    }

    public void rutTien(double soTien) {
        if (soTien <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0");
        }
        if (soDu >= soTien) {
            soDu -= soTien;
            System.out.printf("Rút thành công %.2f. Số dư cuối: %.2f\n", soTien, soDu);
        } else {
            throw new IllegalArgumentException("Giao dịch thất bại, số dư không đủ (Có: " + soDu + ", Rút: " + soTien + ")");
        }
    }

    public void kiemTraSoDu() {
        System.out.println("Tài khoản: " + soTaiKhoan + " | Chủ TK: " + tenChuTaiKhoan + " | Số dư: " + soDu);
    }
}

class TaiKhoanTietKiem extends TaiKhoan {

    private double laiSuat;

    public TaiKhoanTietKiem(String soTaiKhoan, String tenChuTaiKhoan, double soDu, double laiSuat) {
        super(soTaiKhoan, tenChuTaiKhoan, soDu);
        if (laiSuat < 0) {
            throw new IllegalArgumentException("Lãi suất không được âm");
        }
        this.laiSuat = laiSuat;
    }

    public void tinhLai() {
        double tienLai = soDu * laiSuat;
        soDu += tienLai;
        System.out.println("Đã cộng tiền lãi: " + tienLai + ". Số dư cuối: " + soDu);
    }
}

class TaiKhoanVay extends TaiKhoan {

    private double hanMucVay;

    public TaiKhoanVay(String soTaiKhoan, String tenChuTaiKhoan, double soDu, double hanMucVay) {
        super(soTaiKhoan, tenChuTaiKhoan, soDu);
        if (hanMucVay < 0) {
            throw new IllegalArgumentException("Hạn mức vay không được âm");
        }
        this.hanMucVay = hanMucVay;
    }

    @Override
    public void rutTien(double soTien) {
        double khaDung = soDu + hanMucVay;
        if (khaDung >= soTien) {
            soDu -= soTien;
            System.out.println("Rút " + soTien + " từ tài khoản vay " + soTaiKhoan + " thành công.");
        } else {
            throw new IllegalArgumentException("Giao dịch thất bại. Vượt quá hạn mức vay (Khả dụng: " + khaDung + ")");
        }
    }
}
