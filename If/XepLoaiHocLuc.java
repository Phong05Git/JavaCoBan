package If;

import java.util.Scanner;
import java.util.InputMismatchException;

public class XepLoaiHocLuc {

    public static String xepLoai(int diem) {
        if (diem < 0 || diem > 10) {
            throw new IllegalArgumentException("Điểm không hợp lệ (phải từ 0 đến 10).");
        }

        switch (diem) {
            case 9, 10: return "Học lực Giỏi!";
            case 7, 8:  return "Học lực Khá!";
            case 5, 6:  return "Học lực Trung bình!";
            default:    return "Học lực Yếu!";
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập điểm (0-10): ");
            int diem = scanner.nextInt();

            System.out.println(xepLoai(diem));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi logic: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Lỗi nhập liệu: Vui lòng nhập số nguyên.");
        }
    }
}