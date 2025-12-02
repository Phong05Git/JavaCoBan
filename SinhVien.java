


import java.util.Scanner;


public class SinhVien {

    private String maSV;
    private String hoTen;
    private double diemM1, diemM2, diemM3;

    public SinhVien() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        if (maSV == null || maSV.isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên không được để trống!");
        } else {
            this.maSV = maSV;
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen == null || hoTen.isEmpty()) {
            throw new IllegalArgumentException("Họ tên không được để trống!");
        } else {
            this.hoTen = hoTen;
        }
    }

    public double getDiemM1() {
        return diemM1;
    }

    public void setDiemM1(double diemM1) {
        if (diemM1 < 0 || diemM1 > 10) {
            throw new IllegalArgumentException("Điểm môn 1 sai. Điểm phải có giá trị từ 0 đến 10!");
        } else {
            this.diemM1 = diemM1;
        }
    }

    public double getDiemM2() {
        return diemM2;
    }

    public void setDiemM2(double diemM2) {
        if (diemM2 < 0 || diemM2 > 10) {
            throw new IllegalArgumentException("Điểm môn 2 sai. Điểm phải có giá trị từ 0 đến 10!");
        } else {
            this.diemM2 = diemM2;
        }
    }

    public double getDiemM3() {
        return diemM3;
    }

    public void setDiemM3(double diemM3) {
        if (diemM3 < 0 || diemM3 > 10) {
            throw new IllegalArgumentException("Điểm môn 3 sai. Điểm phải có giá trị từ 0 đến 10!");
        } else {
            this.diemM3 = diemM3;
        }
    }

    public void nhap(Scanner scanner) {

        while (true) {
            try {
                System.out.print("Nhập mã sinh viên\t: ");
                String maSV = scanner.nextLine();
                setMaSV(maSV);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập họ tên\t\t: ");
                String hoTen = scanner.nextLine();
                setHoTen(hoTen);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập điểm môn 1\t\t: ");
                double diemM1 = scanner.nextDouble();
                setDiemM1(diemM1);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");

            } catch (java.util.InputMismatchException e) { 
                System.out.println("Lỗi: Bạn phải nhập một con số. Vui lòng nhập lại.");
                scanner.next();
            }
        }
        
        while (true) {
            try {
                System.out.print("Nhập điểm môn 2\t\t: ");
                double diemM2 = scanner.nextDouble();
                setDiemM2(diemM2);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");

            } catch (java.util.InputMismatchException e) { 
                System.out.println("Lỗi: Bạn phải nhập một con số. Vui lòng nhập lại.");
                scanner.next();
            }
        }
        
        while (true) {
            try {
                System.out.print("Nhập điểm môn 3\t\t: ");
                double diemM3 = scanner.nextDouble();
                setDiemM3(diemM3);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");

            } catch (java.util.InputMismatchException e) { 
                System.out.println("Lỗi: Bạn phải nhập một con số. Vui lòng nhập lại.");
                scanner.next();
            }
        }
        
        scanner.nextLine();
    }

    public void hienThi() {
        System.out.println("\n=========THÔNG TIN SINH VIÊN=========");
        System.out.println("Mã sinh viên\t: " + getMaSV());
        System.out.println("Họ tên\t\t: " + getHoTen());
        System.out.println("Điểm 1\t\t: " + getDiemM1());
        System.out.println("Điểm 2\t\t: " + getDiemM2());
        System.out.println("Điểm 3\t\t: " + getDiemM3());
        System.out.println("======================================");
    }

    public double tinhDiemTrungBinh() {
        return ((this.diemM1 + this.diemM2 + this.diemM3) / 3);
    }

    public void xepLoai() {
        double diem = this.tinhDiemTrungBinh();
        if (diem >= 8.0) {
            System.out.println("Học lực Giỏi!");
        } else if (diem >= 6.5) {
            System.out.println("Học lực Khá!");
        } else if (diem >= 5) {
            System.out.println("Học lực Trung bình!");
        } else {
            System.out.println("Học lực Yếu!");
        }
    }
}
