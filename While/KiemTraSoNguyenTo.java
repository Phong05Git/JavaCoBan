package While;

import java.util.Scanner;
import java.util.InputMismatchException;

public class KiemTraSoNguyenTo {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            boolean laNguyenTo = true;
            System.out.print("Nhập số n = ");
            n = sc.nextInt();
            
            if (n < 2) {
                laNguyenTo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        laNguyenTo = false;
                        break;
                    }
                }
            }
            
            if (laNguyenTo) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải là số nguyên tố.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên.");
        }
    }
}