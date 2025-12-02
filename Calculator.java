
/**
 * Lớp Calculator mô phỏng một máy tính đơn giản có thể thực hiện
 * các phép toán cộng, trừ, nhân, chia trên hai số.
 *
 * <p>
 * Ví dụ sử dụng:
 * <pre>
 *     Calculator c = new Calculator();
 *     int kq = c.add(5, 3);  // 8
 * </pre>
 *
 * @author Nguyễn Thanh Phong
 * @version 1.0
 */
public class Calculator {

    /**
     * Cộng hai số nguyên.
     *
     * @param a Số nguyên thứ nhất.
     * @param b Số nguyên thứ hai.
     * @return Tổng của a và b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Trừ hai số nguyên.
     *
     * @param a Số bị trừ.
     * @param b Số trừ.
     * @return Hiệu của a và b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Nhân hai số nguyên.
     *
     * @param a Số thứ nhất.
     * @param b Số thứ hai.
     * @return Tích của a và b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Chia hai số nguyên.
     *
     * @param a Tử số.
     * @param b Mẫu số (phải khác 0).
     * @return Thương của a và b.
     */
    public double divide(int a, int b) {
        return (double) a / b;
    }

    /**
     * Phương thức main để chạy thử lớp Calculator.
     *
     * @param args Đối số dòng lệnh.
     */
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("5 + 3 = " + c.add(5, 3));
        System.out.println("5 - 3 = " + c.subtract(5, 3));
        System.out.println("5 * 3 = " + c.multiply(5, 3));
        System.out.println("5 / 3 = " + c.divide(5, 3));
    }
}
