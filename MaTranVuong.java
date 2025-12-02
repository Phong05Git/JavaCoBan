

import java.util.Scanner;
import java.util.InputMismatchException;

public class MaTranVuong {

    private int[][] data;
    private int n;

    public MaTranVuong() {
    }
    
    public MaTranVuong(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Kích thước ma trận phải lớn hơn 0");
        }
        this.n = n;
        this.data = new int[n][n];
    }
    
    //khởi tạo từ đầu
    public MaTranVuong(int data[][]){
        if (data == null || data.length <= 0){
            throw new IllegalArgumentException("Ma trận không được rỗng");
        }
        
        if (data.length != data[0].length ){
            throw new IllegalArgumentException("Kích thước ma trận phải lớn hơn 0");
        }
        this.n = data.length;
        this.data = new int[n][n];
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length; j++){
                this.data[i][j] = data[i][j];
            }
        }
    }
    //nhập từ bàn phím
    public void nhap(Scanner scanner) {
        System.out.println("Nhập các phần tử cho ma trận " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                while (true) {
                    try {
                        System.out.print("a[" + i + "][" + j + "] = ");
                        this.data[i][j] = scanner.nextInt();
                        break; 
                    
                    } catch (InputMismatchException e) {
                        System.out.println("Lỗi: Vui lòng nhập một số nguyên. Nhập lại.");
                        scanner.next(); 
                    }
                }
            }
        }
        scanner.nextLine(); 
    }

    public int getSize() {
        return this.n;
    }

    public void setValue(int row, int col, int value) {
        if (row >= 0 && row < n && col >= 0 && col < n) {
            this.data[row][col] = value;
        } else {
            throw new IndexOutOfBoundsException("Chỉ số hàng/cột không hợp lệ.");
        }
    }

    public int getValue(int row, int col) {
        if (row >= 0 && row < n && col >= 0 && col < n) {
            return this.data[row][col];
        } else {
            throw new IndexOutOfBoundsException("Chỉ số hàng/cột không hợp lệ.");
        }
    }

    public void inMaTran() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(this.data[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public MaTranVuong congMaTran(MaTranVuong other) {
        if (this.getSize() != other.getSize()) {
            throw new IllegalArgumentException("Để cộng, hai ma trận phải có cùng kích thước.");
        }

        MaTranVuong res = new MaTranVuong(this.n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = this.getValue(i, j) + other.getValue(i, j);
                res.setValue(i, j, sum);
            }
        }
        return res;
    }

    public MaTranVuong nhanMaTran(MaTranVuong other) {
        if (this.getSize() != other.getSize()) {
            throw new IllegalArgumentException("Để nhân, hai ma trận phải có cùng kích thước.");
        }

        MaTranVuong res = new MaTranVuong(this.n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += this.getValue(i, k) * other.getValue(k, j);
                }
                res.setValue(i, j, sum);
            }
        }
        return res;
    }
}