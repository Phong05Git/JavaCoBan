package Chuong3;


public class LopBao {

    public static void main(String[] args) {
        int n = 123; // kiểu nguyên thủy
        // Autoboxing: int → Integer, từ Java 5
        Integer a = n;     // lớp bao
        Integer b = 20;  // lớp bao
        int m = b; // Unboxing: Integer → int            
        System.out.println("n = " + n);
        System.out.println("a = " + a);
        System.out.println("m = " + m);
        System.out.println("b = " + b);
        System.out.println("n + b = " + (n + b));
        int x = b.intValue(); // Integer → int 
        // int → Integer
        Integer y = Integer.valueOf(n);
        // Chuyển số thành chuỗi
        String s1 = a.toString(); // Qua lớp bao
        String s2 = String.valueOf(n);// Qua kiểu int
        // Lấy giá trị lớn nhất của kiểu int
        int max = Integer.MAX_VALUE;
        System.out.println("MAX = " + max);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
