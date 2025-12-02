package For;

import java.util.InputMismatchException;
import java.util.Scanner;

public class forB4 {

    public static int[][] taoMaTranXoanOc(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Cấp ma trận phải là số nguyên dương (n > 0).");
        }

        int[][] a = new int[n][n];
        int h1 = 0, h2 = n - 1, c1 = 0, c2 = n - 1, k = 1;
        
        while (k <= n * n) {
            for (int i = c1; i <= c2; i++) a[h1][i] = k++;
            ++h1;
            for (int i = h1; i <= h2; i++) a[i][c2] = k++;
            --c2;
            if (c1 <= c2) {
                for (int i = c2; i >= c1; i--) a[h2][i] = k++;
            }
            --h2;
            if (h1 <= h2) {
                for (int i = h2; i >= h1; i--) a[i][c1] = k++;
            }
            ++c1;
        }
        return a;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Cấp của ma trận: ");
            int n = scanner.nextInt();

            int[][] matrix = taoMaTranXoanOc(n);

            System.out.println("--- Ma trận xoắn ốc cấp " + n + " ---");
            for (int[] hang : matrix) {
                for (int pt : hang) {
                    System.out.print(pt + "\t");
                }
                System.out.println();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi nhập liệu: Bạn phải nhập một số nguyên.");
        } catch (Exception e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());
        }
    }
}