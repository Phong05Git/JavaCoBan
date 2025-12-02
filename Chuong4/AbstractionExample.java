package Chuong4;

abstract class Shape {

    String color;

    Shape(String color) {
        this.color = color;
    }

    public void displayColor() {
        System.out.println("Màu sắc của hình là: " + color);
    }

    public abstract double tinhDienTich();
}

class Circle extends Shape {

    double radius;

    Circle(String color, double radius) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("Bán kính phải > 0");
        }
        this.radius = radius;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {

    double width, height;

    Rectangle(String color, double width, double height) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Cạnh hình chữ nhật phải > 0");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double tinhDienTich() {
        return width * height;
    }
}

public class AbstractionExample {

    public static void main(String[] args) {
        try {
            Circle circle = new Circle("Đỏ", 5.0);
            circle.displayColor();
            System.out.println("Diện tích hình tròn: " + circle.tinhDienTich());

            Rectangle rectangle = new Rectangle("Xanh", 4.0, 6.0);
            rectangle.displayColor();
            System.out.println("Diện tích hình chữ nhật: " + rectangle.tinhDienTich());

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
