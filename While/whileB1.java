package While;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class whileB1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Số lượng phần tử của dãy 1: ");
            int n = scanner.nextInt();

            if (n < 0) {
                throw new IllegalArgumentException("Số lượng phần tử không được âm.");
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Phần tử %d = ", i);
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);

            System.out.print("Số lượng phần tử của dãy 2: ");
            int m = scanner.nextInt();

            if (m < 0) {
                throw new IllegalArgumentException("Số lượng phần tử không được âm.");
            }

            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                System.out.printf("Phần tử %d = ", i);
                b[i] = scanner.nextInt();
            }
            Arrays.sort(b);

            int[] c = new int[n + m];

            int i = 0, j = 0, k = 0;
            while (i < n && j < m) {
                if (a[i] < b[j]) {
                    c[k++] = a[i++];
                } else {
                    c[k++] = b[j++];
                }
            }
            while (i < n) {
                c[k++] = a[i++];
            }
            while (j < m) {
                c[k++] = b[j++];
            }

            System.out.print("Dãy 1: " + Arrays.toString(a));
            System.out.print("\nDãy 2: " + Arrays.toString(b));
            System.out.print("\nDãy 3: " + Arrays.toString(c));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên.");
        }
    }
}
