public class BankAccount {

    private double balance; // Số dư tài khoản

    // Hàm tạo để khởi tạo số dư ban đầu
    public BankAccount(double initialBalance) {
        if (!isValidAmount(initialBalance)) { 
            throw new IllegalArgumentException("Số dư ban đầu không hợp lệ (phải > 0).");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) { // Gửi tiền
        if (!isValidAmount(amount)) { 
            throw new IllegalArgumentException("Số tiền gửi không hợp lệ (phải > 0).");
        }
        balance += amount;
        logTransaction("Gửi tiền: " + amount); 
    }

    public void withdraw(double amount) { // Rút tiền
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Số tiền rút không hợp lệ (phải > 0).");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Số tiền rút không hợp lệ hoặc không đủ số dư (Có: " + balance + ", Rút: " + amount + ").");
        }
        
        balance -= amount;
        logTransaction("Rút tiền: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    private boolean isValidAmount(double amount) { // Phương thức private
        return amount > 0;
    }

    private void logTransaction(String message) {// Phương thức private
        System.out.println("[LOG] Giao dịch thành công: " + message + ". Số dư mới: " + balance);
    }
}
