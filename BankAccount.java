public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        if (!isValidAmount(balance)) {
            throw new IllegalArgumentException("Số dư khởi tạo không hợp lệ (phải >= 0): " + balance);
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Số tiền nạp không hợp lệ: " + amount);
        }
        balance += amount;
        logTransaction("Nạp tiền: " + amount + "đ");
    }

    public void withdraw(double amount) {
        if (!isValidAmount(amount) || amount < 10000) {
            throw new IllegalArgumentException("Số tiền rút tối thiểu là 10000đ");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Số dư không đủ để rút " + amount + "đ");
        }
        balance -= amount;
        logTransaction("Rút tiền: " + amount + "đ");
    }

    private boolean isValidAmount(double amount) {
        return amount >= 0; // Chấp nhận 0 hoặc lớn hơn
    }

    private void logTransaction(String message) {
        System.out.println("[LOG] Giao dịch thành công: " + message);
        System.out.println("Số dư mới: " + balance + "đ");
    }
}