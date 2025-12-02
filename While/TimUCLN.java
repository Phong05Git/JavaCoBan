package While;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TimUCLN {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a, b, r;
            System.out.print("Nhập số a: ");
            a = sc.nextInt();
            System.out.print("Nhập số b: ");
            b = sc.nextInt();
            
            if (a == 0 && b == 0) {
                throw new IllegalArgumentException("Không tồn tại UCLN của hai số 0.");
            }

            while (b != 0) {
                r = a % b;
                a = b;
                b = r;
            }

            System.out.println("Ước số chung lớn nhất là: " + a);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Vui lòng chỉ nhập số nguyên.");
        }
    }
}