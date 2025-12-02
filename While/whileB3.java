package While;

import java.util.Scanner;
import java.util.InputMismatchException;

public class whileB3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập vào GDP năm 2020: ");
            double gdp = scanner.nextDouble();
            System.out.print("Nhập vào tốc độ tăng trưởng bình quân (%): ");
            double t = scanner.nextDouble();

            if (gdp <= 0) {
                throw new IllegalArgumentException("GDP phải là số dương.");
            }
            if (t <= 0) {
                throw new IllegalArgumentException("Tốc độ tăng trưởng phải > 0 để tránh lặp vô tận.");
            }

            int y = 2020;
            double temp = gdp;
            
            System.out.println("\tNăm\t\t  GDP");
            System.out.printf("\t%d\t\t%.3f\n", y++, temp);
            while (temp < 2 * gdp) {
                temp = temp * (100 + t) / 100;
                System.out.printf("\t%d\t\t%.3f\n", y++, temp);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số hợp lệ.");
        }
    }
}