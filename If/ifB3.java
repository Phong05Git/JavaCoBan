package If;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ifB3 {

    private static final double SAI_SO = 1e-5;

    private static boolean xapXi(double a, double b) {
        return Math.abs(a - b) <= SAI_SO;
    }

    public static String kiemTraTamGiac(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Cạnh tam giác phải lớn hơn 0.");
        }

        double[] canh = {a, b, c};
        Arrays.sort(canh);

        if (canh[0] + canh[1] <= canh[2]) {
            return "Không phải tam giác";
        }

        double c1_bp = Math.pow(canh[0], 2);
        double c2_bp = Math.pow(canh[1], 2);
        double c3_bp = Math.pow(canh[2], 2);

        boolean deu = xapXi(canh[0], canh[1]) && xapXi(canh[1], canh[2]);
        boolean can = xapXi(canh[0], canh[1]) || xapXi(canh[1], canh[2]);
        boolean vuong = xapXi(c1_bp + c2_bp, c3_bp);

        if (deu) return "Tam giác đều";
        if (vuong && can) return "Tam giác vuông cân";
        if (vuong) return "Tam giác vuông";
        if (can) return "Tam giác cân";
        
        return "Tam giác thường";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print("Nhập 3 cạnh a, b, c: ");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    double c = scanner.nextDouble();

                    System.out.println("Kết quả: " + kiemTraTamGiac(a, b, c));

                } catch (IllegalArgumentException e) {
                    System.out.println("Lỗi: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Lỗi: Vui lòng nhập số.");
                    scanner.nextLine(); // Xóa buffer rác
                }

                System.out.print("Tiếp tục? (y/n): ");
                scanner.nextLine(); 
                if (!scanner.nextLine().equalsIgnoreCase("y")) break;
            }
        }
    }
}