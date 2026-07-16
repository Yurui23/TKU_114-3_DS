package midterm_exam;
import java.util.Scanner;

public class Q02_ScannerInputFix {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("請輸入數量：");
        int count = keyboard.nextInt();
        keyboard.nextLine(); // 消除換行

        System.out.print("請輸入課程名稱：");
        String title = keyboard.nextLine();

        System.out.print("請輸入單價：");
        int unitPrice = keyboard.nextInt();
        keyboard.nextLine(); // 消除換行

        System.out.print("請輸入備註：");
        String memo = keyboard.nextLine();

        int sum = count * unitPrice;

        System.out.println("=== 登記結果 ===");
        System.out.println("課程：" + title);
        System.out.println("數量：" + count);
        System.out.println("總額：" + sum);
        System.out.println("備註：" + memo);

        keyboard.close();
    }
}