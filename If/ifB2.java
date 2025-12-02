package If;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ifB2 {

    public static String timUocSo(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Vui lòng nhập số nguyên dương > 0.");
        }

        String ketQua = "";
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                ketQua += i + " ";
            }
        }
        return ketQua;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập 1 số nguyên: ");
            int n = scanner.nextInt();

            System.out.println("Các ước của " + n + " là: " + timUocSo(n));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
        }
    }
}