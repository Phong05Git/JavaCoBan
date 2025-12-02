package Chuong3;

class Product {

    private final String productId;
    private String name;
    private double price;
    private int quantity;

    public Product(String productId, String name, double price) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID không hợp lệ");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không hợp lệ");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Giá không được âm");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void updateQuantity(int change) {
        if (this.quantity + change < 0) {
            throw new IllegalArgumentException("[ERROR] SP " + this.productId + ": Không đủ hàng tồn! (Hiện có: " + quantity + ")");
        }

        this.quantity += change;

        if (change > 0) {
            System.out.println("[INFO]  SP " + this.productId + ": Nhập " + change + " -> Tổng: " + quantity);
        } else {
            System.out.println("[INFO]  SP " + this.productId + ": Xuất " + -change + " -> Còn: " + quantity);
        }
    }

    @Override
    public String toString() {
        return this.productId + " - " + this.name;
    }
}

class InventoryManager {

    private static final int MAX_PRODUCTS = 20;
    private static final Product[] inventory = new Product[MAX_PRODUCTS];
    private static int productCount = 0;

    //thêm sản phẩm
    public static boolean addProduct(String productId, String name, double price) {
        if (productCount >= MAX_PRODUCTS) {
            throw new IllegalStateException("[ERROR] Kho đã đầy!");
        }
        for (int i = 0; i < productCount; i++) {
            if (inventory[i].getProductId().equals(productId)) {
                throw new IllegalArgumentException("[ERROR] ID " + productId + " đã tồn tại.");
            }
        }
        inventory[productCount] = new Product(productId, name, price);
        // Giữ nguyên thông báo gốc
        System.out.println("[INFO]  Đã thêm sản phẩm " + inventory[productCount++]);
        return true;
    }

    //tìm sản phẩm
    public static Product findProductById(String productId) {
        for (int i = 0; i < productCount; i++) {
            if (inventory[i].getProductId().equals(productId)) {
                return inventory[i];
            }
        }
        return null;
    }

    //thêm/xuất
    public static void updateProductQuantity(String productId, int change) {
        Product p = findProductById(productId);
        if (p != null) {
            p.updateQuantity(change);
        } else {
            throw new IllegalArgumentException("[ERROR] Không tìm thấy SP: " + productId);
        }
    }

    //hiển thị danh sách
    public static void displayInventory() {
        if (productCount == 0) {
            System.out.println(">> Kho hàng trống.");
            return;
        }

        System.out.println("\nDANH SÁCH SẢN PHẨM:");
        System.out.println("+------+--------+---------------------------+--------------+----------+");
        System.out.format("| %-4s | %-6s | %-25s | %-12s | %-8s |%n", "STT", "ID", "Tên sản phẩm", "Giá", "Số lượng");
        System.out.println("+------+--------+---------------------------+--------------+----------+");

        for (int i = 0; i < productCount; i++) {
            Product p = inventory[i];
            System.out.format("| %-4d | %-6s | %-25s | %,12.2f | %8d |%n",
                    (i + 1),
                    p.getProductId(),
                    p.getName(),
                    p.getPrice(),
                    p.getQuantity()
            );
        }
        System.out.println("+------+--------+---------------------------+--------------+----------+\n");
    }
}

class Store {

    public static void main(String[] args) {
        try {
            InventoryManager.addProduct("SP01", "Bút bi Thiên Long", 60000);
            InventoryManager.addProduct("SP02", "Bút chì 2B", 20000);
            InventoryManager.addProduct("SP03", "Giấy A4 Double A", 70000);

            InventoryManager.displayInventory();

            System.out.println("--- CẬP NHẬT SỐ LƯỢNG ---");
            InventoryManager.updateProductQuantity("SP01", 100);
            InventoryManager.updateProductQuantity("SP02", 150);
            InventoryManager.updateProductQuantity("SP02", -50);

            InventoryManager.updateProductQuantity("SP03", -100);

            InventoryManager.updateProductQuantity("SP05", 10);

            InventoryManager.displayInventory();

            System.out.println("--- TÌM KIẾM ---");
            Product p = InventoryManager.findProductById("SP01");
            if (p != null) {
                System.out.println("Tìm thấy: " + p);
            }

            InventoryManager.addProduct("SP01", "Bút mực", 50000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
