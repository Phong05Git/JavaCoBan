import java.util.Scanner;
import java.util.InputMismatchException;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n========= MENU QUẢN LÝ TEST =========");
            System.out.println("1. Test class Student (Cơ bản)");
            System.out.println("2. Test class BankAccount (Giao dịch cơ bản)");
            System.out.println("3. Test class BankAccount2 (Inner Class Transaction)");
            System.out.println("4. Test class Car & Engine (Quan hệ kết hợp)");
            System.out.println("5. Test class SinhVien (Nhập xuất, xếp loại)");
            System.out.println("6. Test class PhanSo (Phép tính phân số)");
            System.out.println("7. Test class MaTranVuong (Ma trận)");
            System.out.println("0. Thoát chương trình");
            System.out.println("=====================================");
            System.out.print("Mời bạn chọn chức năng (0-7): ");

            try {
                choice = scanner.nextInt();
                //xóa bộ đệm dòng (dấu enter thừa)
                scanner.nextLine(); 
                
            } catch (InputMismatchException e) {
                System.out.println(">> Lỗi: Vui lòng chỉ nhập số nguyên!");
                
                // xóa dữ liệu rác trong scanner để tránh lặp vô hạn
                scanner.nextLine(); 
                choice = -1; // Đặt về -1 để vòng lặp tiếp tục
            }

            System.out.println("\n---------------- KẾT QUẢ ----------------");

            try {
                switch (choice) {
                    case 1:
                        testStudent();
                        break;
                    case 2:
                        testBankAccount();
                        break;
                    case 3:
                        testBankAccount2();
                        break;
                    case 4:
                        testCarEngine();
                        break;
                    case 5:
                        testSinhVien(scanner);
                        break;
                    case 6:
                        testPhanSo();
                        break;
                    case 7:
                        testMaTranVuong(scanner);
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình. Tạm biệt!");
                        break;
                    default:
                        System.out.println(">> Lựa chọn không hợp lệ (chỉ từ 0-7).");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
                e.printStackTrace();
            }
            
            System.out.println("\n");
            if (choice != 0) {
                System.out.println("Ấn Enter để quay lại menu...");
                scanner.nextLine(); // Chờ người dùng ấn Enter mới hiện lại menu
                clearScreen();
            }

        } while (choice != 0);
        
        scanner.close();
    }
    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    private static void testStudent() {
        Student sv = new Student();
        sv.setAge(30);
        sv.setName("Bình");
        System.out.println("Sinh viên: " + sv.getName() + ", tuổi: " + sv.getAge());
    }

    private static void testBankAccount() {
        BankAccount tk1 = new BankAccount(100000);
        tk1.deposit(20000);
        tk1.withdraw(5000);
        System.out.println("Số dư cuối cùng: " + tk1.getBalance() + "đ");
    }

    private static void testBankAccount2() {
        BankAccount2 acc = new BankAccount2("Nguyễn Thanh Phong", 1000000);
        acc.showBalance();
        BankAccount2.Transaction tran1 = acc.new Transaction("deposit", 200000);
        tran1.process();
        BankAccount2.Transaction tran2 = acc.new Transaction("withdraw", 500000);
        tran2.process();
        acc.showBalance();
    }

    private static void testCarEngine() {
        Engine engine = new Engine("V8", 1280);
        Car car = new Car("Koenigsegg", "Jesko Absolute", engine);
        car.startCar();
    }

    private static void testSinhVien(Scanner scanner) {
        SinhVien sv = new SinhVien();
        sv.nhap(scanner);
        sv.hienThi();
        System.out.printf("Điểm trung bình của sinh viên là: %.2f\n", sv.tinhDiemTrungBinh());
        sv.xepLoai();
    }

    private static void testPhanSo() {
        try {
            PhanSo ps1 = new PhanSo(2, -3);
            PhanSo ps2 = new PhanSo(6, 8);
            System.out.println("Phân số 1: " + ps1);
            System.out.println("Phân số 2: " + ps2);
            System.out.println(ps1 + " + " + ps2 + " = " + ps1.cong(ps2));
            System.out.println(ps1 + " * " + ps2 + " = " + ps1.nhan(ps2));
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi phân số: " + e.getMessage());
        }
    }

    private static void testMaTranVuong(Scanner scanner) {
        System.out.println("--- Test 1: Khởi tạo sẵn ---");
        int[][] dt1 = {{1, 2, 3}, {2, 3, 4}, {4, 5, 6}};
        int[][] dt2 = {{3, 2, 3}, {2, 5, 4}, {4, 2, 6}};
        MaTranVuong mt1 = new MaTranVuong(dt1);
        mt1.inMaTran();
        MaTranVuong mt2 = new MaTranVuong(dt2);
        mt2.inMaTran();
        mt1.congMaTran(mt2).inMaTran();

        System.out.println("\n--- Test 2: Nhập từ bàn phím ---");
        int n = 0;
        
        while(true) {
             try {
                System.out.print("Nhập kích thước ma trận vuông n = ");
                n = scanner.nextInt();
                scanner.nextLine(); // Xử lý trôi lệnh sau khi nhập số
                
                if (n > 0) break;
                System.out.println("Kích thước phải > 0");
             } catch (InputMismatchException e) {
                 System.out.println("Vui lòng nhập số nguyên!");
                 scanner.nextLine(); // Xóa buffer khi nhập sai
             }
        }

        MaTranVuong ma1 = new MaTranVuong(n);
        ma1.nhap(scanner);
        ma1.inMaTran();
        MaTranVuong ma2 = new MaTranVuong(n);
        ma2.nhap(scanner);
        ma2.inMaTran();
        ma1.nhanMaTran(ma2).inMaTran();
    }
}