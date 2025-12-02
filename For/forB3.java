package For;

import java.util.InputMismatchException;
import java.util.Scanner;

public class forB3 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Bậc của đa thức: ");
            int n = scanner.nextInt();
            
            if (n < 0) {
                throw new IllegalArgumentException("Bậc đa thức không thể âm.");
            }

            double[] heSo = new double[n + 1];

            for (int i = n; i >= 0; i--) {
                System.out.printf("Hệ số của x^%d: ", i);
                heSo[i] = scanner.nextDouble();
            }

            System.out.print("Nhập giá trị của x: ");
            double x = scanner.nextDouble();
            
            hienThi(n, heSo, x);

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Dữ liệu nhập vào phải là số.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    private static void hienThi(int n, double[] heSo, double x) {
        double res = 0.0;
        System.out.println("===============================");
        System.out.print("Đa thức P = ");
        boolean daInPhanTuDauTien = false;

        for (int i = n; i >= 0; i--) {
            if (heSo[i] == 0.0) continue;

            res += heSo[i] * Math.pow(x, i);

            if (daInPhanTuDauTien) {
                System.out.print(heSo[i] > 0 ? " + " : " - ");
            } else {
                if (heSo[i] < 0) System.out.print("-");
            }

            double heSoIn = Math.abs(heSo[i]);
            if (i == 0 || heSoIn != 1.0) {
                if (heSoIn == Math.floor(heSoIn)) System.out.printf("%.0f", heSoIn);
                else System.out.printf("%.2f", heSoIn);
            }

            if (i >= 1) {
                System.out.print("x");
                if (i > 1) System.out.print(i);
            }
            daInPhanTuDauTien = true;
        }

        if (!daInPhanTuDauTien) {
            System.out.print("0");
        }

        System.out.printf("\nVới x = %.2f, giá trị của đa thức là: %.2f%n", x, res);
        System.out.println("===============================");
    }
}