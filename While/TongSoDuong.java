package While;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TongSoDuong {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n, tong = 0;
            System.out.print("Nhập số phần tử n = ");
            n = sc.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Số lượng phần tử phải lớn hơn 0.");
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Nhập phần tử a[%d]: ", i);
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (a[i] <= 0) {
                    continue;
                }
                tong += a[i];
            }
            System.out.println("Tổng các phần tử dương trong dãy là: " + tong);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên.");
        }
    }
}