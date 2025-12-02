package Chuong3;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListInteger {

    public static void main(String[] args) {
        try {
            ArrayList<Integer> ds = new ArrayList<>();
            ds.add(4); // có chỉ số 0
            ds.add(2); // có chỉ số 1
            ds.add(8); // có chỉ số 2
            ds.add(5); // có chỉ số 3
            ds.add(6); // có chỉ số 4
            System.out.println("Dãy ban đầu   : " + ds);

            if (ds.isEmpty()) {
                throw new IllegalStateException("Danh sách rỗng");
            }

            Collections.sort(ds); // Sắp xếp tăng dần
            System.out.println("K.quả sắp xếp: " + ds);
            Collections.reverse(ds); // Đảo ngược
            System.out.println("K.quả đảo ngược: " + ds);
            // Tìm min và max
            int min = Collections.min(ds);
            int max = Collections.max(ds);
            System.out.println("Giá trị nhỏ nhất: " + min);
            System.out.println("Giá trị lớn nhất: " + max);
            System.out.println(ds.contains(4));//có 4 không
            System.out.println(ds.indexOf(4));//chỉ số của 4
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
