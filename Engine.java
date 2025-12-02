public class Engine {

    private String type;
    private int HP;

    public Engine(String type, int HP) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Loại động cơ không được để trống");
        }
        if (HP <= 0) {
            throw new IllegalArgumentException("Mã lực (HP) phải lớn hơn 0. Giá trị nhập: " + HP);
        }
        this.type = type;
        this.HP = HP;
    }

    public void start() {
        System.out.println("Động cơ " + type + " khởi động với " + HP + " mã lực!");
    }
}