public class Student {

    private String name;
    private int age;

    public void setName(String name_) {
        if (name_ == null || name_.isEmpty()) {
            throw new IllegalArgumentException("Tên sinh viên không hợp lệ");
        }
        name = name_;
    }

    public void setAge(int age_) {
        if (age_ >= 0) {
            age = age_;
        } else {
            throw new IllegalArgumentException("Tuổi không hợp lệ (phải >= 0): " + age_);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}