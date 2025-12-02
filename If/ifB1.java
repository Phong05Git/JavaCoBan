package If;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ifB1 {

    public static String giaiHePhuongTrinh(double a, double b, double c, double d, double e, double f) {
        double D = a * e - b * d;
        double Dx = c * e - b * f;
        double Dy = a * f - c * d;

        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                return "Hệ phương trình có vô số nghiệm";
            } else {
                return "Hệ phương trình vô nghiệm";
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            return "Hệ phương trình có nghiệm duy nhất:\nx = " + x + "\ny = " + y;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Nhập hệ phương trình:");
            System.out.print("a = "); double a = scanner.nextDouble();
            System.out.print("b = "); double b = scanner.nextDouble();
            System.out.print("c = "); double c = scanner.nextDouble();
            System.out.print("d = "); double d = scanner.nextDouble();
            System.out.print("e = "); double e = scanner.nextDouble();
            System.out.print("f = "); double f = scanner.nextDouble();

            System.out.println(giaiHePhuongTrinh(a, b, c, d, e, f));

        } catch (InputMismatchException ex) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số thực.");
        }
    }
}