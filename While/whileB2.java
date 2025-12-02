package While;

import java.util.Scanner;
import java.util.InputMismatchException;

public class whileB2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập x = ");
            double x = scanner.nextDouble();

            System.out.print("Nhập sai số Eps = ");
            double Eps = scanner.nextDouble();

            if (Eps <= 0) {
                throw new IllegalArgumentException("Sai số Eps phải lớn hơn 0.");
            }

            double res = x;
            double k = x;
            int n = 1;

            while (true) {
                k *= (-1 * x * x) / ((2 * n) * (2 * n + 1));

                if (Math.abs(k) <= Eps) {
                    break;
                }
                res += k;
                n++;
            }

            System.out.printf("sin(%.2f) = %.10f\n", x, res);

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số thực hợp lệ.");
        }
    }
}