package Chuong4;

class Animal {

    public void Sound() {
        System.out.println("Âm thanh động vật");
    }
}

class Dog extends Animal {

    @Override
    public void Sound() {
        System.out.println("Gâu gâu!");
    }
}

class Cat extends Animal {

    @Override
    public void Sound() {
        System.out.println("Meo meo!");
    }
}

public class DaHinhThuaKe {

    public static void main(String[] args) {
        Animal[] dSachDV = new Animal[4];
        dSachDV[0] = new Cat();
        dSachDV[1] = new Dog();
        dSachDV[2] = new Dog();
        dSachDV[3] = new Cat();
        for (Animal cv : dSachDV) {
            cv.Sound();
        }
    }
}
