package Chuong4;

import java.util.ArrayList;

public class HeThongDatHangTrucTuyen {

    public static void main(String[] args) {
        try {
            ShoppingCart cart = new ShoppingCart();

            Product p1 = new Product("P01", "Laptop Dell", 1500.0, "Laptop gaming cấu hình cao");
            Product p2 = new Product("P02", "Chuột Logitech", 25.5, "Chuột không dây");

            Service s1 = new Service("Bảo hành mở rộng", 50.0, "Bảo hành thêm 1 năm");
            Service s2 = new Service("Cài đặt phần mềm", 10.0, "Cài Win và Office bản quyền");

            cart.addItem(p1);
            cart.addItem(p2);
            cart.addItem(s1);
            cart.addItem(s2);

//            cart.addItem(null); 
//            Product pError = new Product("", "Lỗi", -100, "Mô tả");
            System.out.println("--- DANH SÁCH ĐƠN HÀNG ---");
            cart.showItems();

            System.out.println("TỔNG TIỀN THANH TOÁN: $" + cart.calculateTotal());

        } catch (Exception e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());
        }
    }
}

interface Sellable {

    double getPrice();

    String getName();

    String getDescription();
}

class Product implements Sellable {

    private String id;
    private String name;
    private double price;
    private String description;

    public Product(String id, String name, double price, String description) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Mã sản phẩm không được trống");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Tên sản phẩm không được trống");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Giá sản phẩm không được âm");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getName() {
        return "sản phẩm: " + this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDescription() {
        return this.description + " (Mã SP: " + this.id + ")";
    }
}

class Service implements Sellable {

    private String name;
    private double price;
    private String description;

    public Service(String name, double price, String description) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Tên dịch vụ không được trống");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Giá dịch vụ không được âm");
        }

        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return "dịch vụ: " + this.name;
    }

    @Override
    public String getDescription() {
        return "[Dịch vụ] " + this.description;
    }
}

class ShoppingCart {

    private ArrayList<Sellable> list = new ArrayList<>();

    public void addItem(Sellable item) {
        if (item == null) {
            throw new IllegalArgumentException("Không thể thêm mục rỗng vào giỏ hàng");
        }
        list.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (Sellable item : list) {
            total += item.getPrice();
        }
        return total;
    }

    public void showItems() {
        for (Sellable item : list) {
            System.out.println("Tên " + item.getName());
            System.out.println("Mô tả: " + item.getDescription());
            System.out.println("Giá: $" + item.getPrice());
            System.out.println("-------------------------------------------");
        }
    }
}
