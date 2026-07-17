public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private int balance;

    // 建構子
    public BankAccount(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("警告：開戶餘額不能為負數，已預設為 0 元。");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        System.out.println("錯誤：存款金額必須大於 0 元！");
        return false;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("錯誤：提款金額必須大於 0 元！");
            return false;
        }
        if (amount > this.balance) {
            System.out.println("錯誤：餘額不足，提款失敗！");
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount target, int amount) {
        if (amount <= 0) {
            System.out.println("錯誤：轉帳金額必須大於 0 元！");
            return false;
        }
        if (target == null) {
            System.out.println("錯誤：轉帳目標帳戶不存在！");
            return false;
        }
        
        if (this.withdraw(amount)) {
            target.deposit(amount);
            return true;
        }

        System.out.println("轉帳失敗，交易取消。");
        return false;
    }

    @Override
    public String toString() {
        return "帳戶資訊 -> 帳號: " + accountNumber + " | 戶名: " + ownerName + " | 餘額: " + balance + " 元";
    }
}