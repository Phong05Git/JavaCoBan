package Chuong3;

class Logger {

    public Logger(Student3 s) {
        System.out.println("Tạo logger cho sinh viên: " + s.getName());
    }
}

class Student3 {

    private String name;

    public Student3(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Tên sinh viên không hợp lệ");
        }
        this.name = name;
        new Logger(this);
    }

    public String getName() {
        return name;
    }
}

class Main3 {

    public static void main(String[] args) {
        try {
            Student3 s = new Student3("An");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
