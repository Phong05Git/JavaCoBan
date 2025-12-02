package Chuong3;

class Student1 {

    private static int count = 0;
    private String name;

    public Student1(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Tên không được null");
        }
        this.name = name;
        count++;
    }

    // Phương thức tĩnh để lấy số lượng SV
    public static int getStudentCount() {
        return count; // Trả về số lượng sinh viên đã tạo
    }

    public static void main(String[] args) {
        try {
            Student1 s1 = new Student1("Trung");
            Student1 s2 = new Student1("Kiên");
            Student1 s3 = new Student1("Cường");
            System.out.println("Total students: " + Student1.getStudentCount());
            System.out.println("Total students: " + s2.getStudentCount());
            System.out.println(Student1.count);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
