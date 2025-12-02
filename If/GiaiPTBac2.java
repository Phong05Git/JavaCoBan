package If;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GiaiPTBac2 {

    public static String giaiPhuongTrinh(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Hệ số a phải khác 0 (đây là phương trình bậc 2).");
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return "Phương trình vô nghiệm!";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép: x1 = x2 = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập a = ");
            double a = scanner.nextDouble();
            System.out.print("Nhập b = ");
            double b = scanner.nextDouble();
            System.out.print("Nhập c = ");
            double c = scanner.nextDouble();

            System.out.println(giaiPhuongTrinh(a, b, c));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi nhập liệu: Vui lòng nhập số thực.");
        }
    }
}