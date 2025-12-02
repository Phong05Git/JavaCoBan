package Chuong3;

class Printer1 {

    public void printStudent(Student2 s) {
        System.out.println("Tên sinh viên: " + s.getName());
    }
}

class Student2 {

    private String name;

    public Student2(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Tên sinh viên không hợp lệ");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show(Printer1 printer) {
        if (printer == null) {
            throw new IllegalArgumentException("Printer không được null");
        }
        printer.printStudent(this);
    }
}

class Main2 {

    public static void main(String[] args) {
        try {
            Student2 s = new Student2("Nam");
            Printer1 p = new Printer1();
            s.show(p);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
