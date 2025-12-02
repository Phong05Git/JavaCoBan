package For;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NhapInMaTran {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập số hàng của ma trận: ");
            int n = sc.nextInt();
            System.out.print("Nhập số cột của ma trận: ");
            int m = sc.nextInt();

            if (n <= 0 || m <= 0) {
                throw new IllegalArgumentException("Kích thước hàng và cột phải lớn hơn 0");
            }

            int[][] a = new int[n][m];
            System.out.println("Nhập các phần tử của ma trận A:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("a[" + i + "][" + j + "] = ");
                    a[i][j] = sc.nextInt();
                }
            }

            System.out.println("Ma trận A vừa nhập là:");
            for (int[] hang : a) {
                for (int pt : hang) {
                    System.out.print(pt + "\t");
                }
                System.out.println();
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Dữ liệu nhập vào phải là số nguyên.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        }
    }
}