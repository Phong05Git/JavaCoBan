public class BankAccount2 {

    private String owner;
    private double balance;

    public BankAccount2(String owner_, double balance_) {
        if (owner_ == null || owner_.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên chủ tài khoản không được để trống.");
        }
        if (balance_ < 0) {
            throw new IllegalArgumentException("Số dư khởi tạo không được âm.");
        }
        owner = owner_;
        balance = balance_;
    }

    class Transaction { // Lớp lồng bên trong

        private String type;
        private double amount;

        public Transaction(String type_, double amount_) {
            if (amount_ <= 0) {
                throw new IllegalArgumentException("Số tiền giao dịch phải lớn hơn 0.");
            }
            type = type_;
            amount = amount_;
        }

        public void process() {
            if (!type.equals("deposit") && !type.equals("withdraw")) {
                throw new IllegalArgumentException("Loại giao dịch không hợp lệ: " + type);
            }

            if (type.equals("deposit")) {
                balance += amount;
            } else if (type.equals("withdraw")) {
                if (balance < amount) {
                    throw new IllegalArgumentException("Số dư không đủ để rút (Có: " + balance + ", Rút: " + amount + ")");
                }
                balance -= amount;
            }
            
            System.out.println("Thực hiện " + type + " " + amount + "₫ thành công. Số dư mới: " + balance + "₫");
        }
    } // Hết khai báo Lớp lồng bên trong

    public void showBalance() {
        System.out.println("Số dư hiện tại của " + owner + ": " + balance + "₫");
    }
}
