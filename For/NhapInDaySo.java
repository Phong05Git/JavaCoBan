package For;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NhapInDaySo {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập số phần tử của dãy: ");
            int n = sc.nextInt();
            
            if (n <= 0) {
                throw new IllegalArgumentException("Số phần tử mảng phải > 0");
            }
            
            int[] a = new int[n];
            System.out.println("Nhập các phần tử của dãy:");
            for (int i = 0; i < n; i++) {
                System.out.print("a[" + i + "] = ");
                a[i] = sc.nextInt();
            }
            
            System.out.print("Dãy số vừa nhập là: ");
            for (int pt : a) {
                System.out.print(pt + "  ");
            }
            System.out.println();
            
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}