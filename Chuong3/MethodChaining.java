package Chuong3;

class Person {

    private String name;
    private int age;

    public Person setName(String name) {
        if (name == null) throw new IllegalArgumentException("Tên không được null");
        this.name = name;
        return this;
    }

    public Person setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Tuổi không được âm");
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
}

class Main1 {

    public static void main(String[] args) {
        try {
            Person p = new Person();
            p.setName("Nam").setAge(12);
            System.out.println(p.getName());
            System.out.println(p.getAge());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}