public class BankAccountDemo {
    public static void main(String[] args) {
        System.out.println("=== 開始測試銀行帳戶系統 ===\n");

        BankAccount accountA = new BankAccount("123-456", "小白", 1000);
        BankAccount accountB = new BankAccount("987-654", "小黑", 500);

        System.out.println("【初始狀態】");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println("----------------------------------------");

        System.out.println("-> 小白嘗試存款 500 元:");
        if (accountA.deposit(500)) {
            System.out.println("存款成功！" + accountA);
        }
        System.out.println("----------------------------------------");

        System.out.println("-> 小黑嘗試提款 200 元:");
        if (accountB.withdraw(200)) {
            System.out.println("提款成功！" + accountB);
        }
        System.out.println("----------------------------------------");

        System.out.println("-> 小黑嘗試超額提款 1000 元:");
        if (!accountB.withdraw(1000)) {
            System.out.println("提款判定失敗！" + accountB);
        }
        System.out.println("----------------------------------------");

        System.out.println("-> 小白嘗試轉帳 400 元給小黑:");
        if (accountA.transferTo(accountB, 400)) {
            System.out.println("轉帳成功！");
            System.out.println("更新後 " + accountA);
            System.out.println("更新後 " + accountB);
        }
        System.out.println("----------------------------------------");

        System.out.println("-> 小白嘗試轉帳 2000 元給小黑 (餘額不足):");
        if (accountA.transferTo(accountB, 2000)) {
            System.out.println("轉帳成功（這不應該發生！）");
        } else {
            System.out.println("轉帳判定失敗！");
            System.out.println("交易安全，" + accountA);
            System.out.println("交易安全，" + accountB);
        }
        System.out.println("----------------------------------------");
    }
}