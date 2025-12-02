


public class Car {

    private String brand;
    private String model;
    private Engine engine;

    public Car(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("Xe " + brand + " " + model + " đang khởi động...");
        engine.start();
    }
}
