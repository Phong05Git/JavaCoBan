package For;

import java.util.InputMismatchException;
import java.util.Scanner;

public class forB2 {

    public static void adjust(int r, int n, int a[]) {
        int v = a[r];
        while (r * 2 <= n - 2) {
            int c = r * 2 + 1;
            if (c < n - 1 && a[c] < a[c + 1]) c++;
            if (a[c] < v) break;
            a[r] = a[c];
            r = c;
        }
        a[r] = v;
    }

    public static void HeapSort(int a[], int n) {
        if (a == null || n <= 0 || a.length < n) {
            throw new IllegalArgumentException("Dữ liệu đầu vào cho HeapSort không hợp lệ.");
        }
        
        for (int i = (n - 2) / 2; i >= 0; i--) adjust(i, n, a);
        for (int i = n - 1; i > 0; i--) {
            int x = a[0];
            a[0] = a[i];
            a[i] = x;
            adjust(0, i, a);
        }
    }

    private static void inMang(int[] a){
        for (int pt : a) System.out.print(pt + "  ");
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập vào số lượng phần tử: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Số lượng phần tử phải > 0");
            }

            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("Phần tử a[%d] = ", i);
                a[i] = scanner.nextInt();
            }

            System.out.print("Mảng ban đầu: ");
            inMang(a);

            HeapSort(a, n);

            System.out.print("\nMảng sau khi Heap Sort: ");
            inMang(a);

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên.");
        }
    }
}