public class BankAccount2 {
    private String owner;
    private double balance;

    public BankAccount2(String owner, double balance) {
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Tên chủ tài khoản không được để trống");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Số dư khởi tạo không được âm");
        }
        this.owner = owner;
        this.balance = balance;
    }

    class Transaction {
        private String type;
        private double amount;

        public Transaction(String type, double amount) {
            if (amount <= 100) {
                throw new IllegalArgumentException("Số tiền giao dịch phải lớn hơn 100");
            }
            if (!type.equals("deposit") && !type.equals("withdraw")) {
                throw new IllegalArgumentException("Loại giao dịch không hợp lệ: " + type);
            }
            this.type = type;
            this.amount = amount;
        }

        public void process() {
            if (type.equals("deposit")) {
                balance += amount;
            } else if (type.equals("withdraw")) {
                if (balance < amount) {
                    throw new IllegalStateException("Số dư không đủ để thực hiện giao dịch");
                }
                balance -= amount;
            }
            
            System.out.println("Thực hiện " + type + " " + amount + "đ thành công!");
            System.out.println("Số dư mới: " + balance + "đ");
        }
    }

    public void showBalance() {
        System.out.println("Số dư hiện tại của " + owner + ": " + balance + "₫");
    }
}