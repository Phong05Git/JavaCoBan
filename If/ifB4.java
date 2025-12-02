package If;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ifB4 {

    private static final String[] docSo = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};

    public static void doc(int n) {
        if (n <= 0 || n >= 1000) {
            throw new IllegalArgumentException("Số phải nguyên dương và nhỏ hơn 1000.");
        }

        int tram = n / 100;
        int chuc = (n % 100) / 10;
        int donVi = n % 10;

        if (tram > 0) {
            System.out.print(docSo[tram] + " trăm ");
        }

        switch (chuc) {
            case 0 -> {
                if (tram > 0 && donVi > 0) System.out.print("linh ");
            }
            case 1 -> System.out.print("mười ");
            default -> System.out.print(docSo[chuc] + " mươi ");
        }

        switch (donVi) {
            case 1 -> {
                if (chuc > 1) System.out.print("mốt");
                else System.out.print("một");
            }
            case 4 -> {
                if (chuc > 1) System.out.print("tư");
                else System.out.println("bốn");
            }
            case 5 -> {
                if (chuc > 0) System.out.print("lăm");
                else System.out.print("năm");
            }
            default -> System.out.print(docSo[donVi]);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập số (< 1000): ");
            int n = scanner.nextInt();

            doc(n);

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên.");
        }
    }
}