package For;

import java.util.InputMismatchException;
import java.util.Scanner;

public class forB1 {

    public static double tinhTongChuoi(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Giá trị n không được âm (n = " + n + ")");
        }

        double res = 0, temp = 1;
        for (int i = 1; i <= n; i++) {
            temp *= i;
            res += 1.0 / temp;
        }
        return res;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập vào 1 số n: ");
            int n = scanner.nextInt();
            double ketQua = tinhTongChuoi(n);
            System.out.println("Kết quả: " + ketQua);

        } catch (IllegalArgumentException e) {
            System.err.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Lỗi nhập liệu: Bạn phải nhập vào một số nguyên.");
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi không mong muốn: " + e.getMessage());
        }
    }
}