package If;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ifB5 {

    public static boolean laNamNhuan(int y) {
        if (y <= 0) {
            throw new IllegalArgumentException("Năm phải lớn hơn 0");
        }
        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }

    public static String tinhNgay(int thang, int nam) {
        if (thang < 1 || thang > 12) {
            throw new IllegalArgumentException("Tháng không hợp lệ.");
        }
        if (nam <= 0) {
            throw new IllegalArgumentException("Năm không hợp lệ.");
        }

        int soNgay;
        switch (thang) {
            case 1, 3, 5, 7, 8, 10, 12:
                soNgay = 31;
                break;
            case 4, 6, 9, 11:
                soNgay = 30;
                break;
            case 2:
                soNgay = laNamNhuan(nam) ? 29 : 28;
                break;
            default:
                soNgay = 0;
        }

        return "Tháng " + thang + " năm " + nam + " có " + soNgay + " ngày.";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập tháng: ");
            int m = scanner.nextInt();
            System.out.print("Nhập năm: ");
            int y = scanner.nextInt();

            System.out.println(tinhNgay(m, y));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi nhập liệu: Vui lòng nhập số nguyên.");
        }
    }
}
