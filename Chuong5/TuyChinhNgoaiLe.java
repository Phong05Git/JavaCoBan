package Chuong5;


import java.util.Scanner;

class AgeException extends Exception {

    public AgeException(String message) {
        super(message);
    }
} // Tạo ngoại lệ tuỳ chỉnh

class TuyChinhNgoaiLe {

    public static void checkAge(int age) {
        try {
            if (age < 18) { // Nơi phát sinh lỗi
                throw new AgeException("Tuổi phải >= 18");
            }
            System.out.println("Tuổi hợp lệ: " + age);
        } catch (AgeException e) {
            System.out.println("Lỗi đã được xử lý tại chỗ: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();
        checkAge(age);
        System.out.println("Chương trình vẫn tiếp tục bình thường.");
    }
}
