import java.util.Scanner;

public class AtmMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = -1;
        int balance = 1000;

        while (option != 0) {
            System.out.println("=== ATM Menu ===");
            System.out.println("1. 查詢餘額");
            System.out.println("2. 存款");
            System.out.println("3. 提款");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("目前餘額：" + balance + " 元");
                    break;

                case 2:
                    System.out.print("請輸入存款金額：");
                    int deposit = sc.nextInt();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("存款成功，目前餘額：" + balance + " 元");
                    } else {
                        System.out.println("存款金額必須大於 0");
                    }
                    break;

                case 3:
                    System.out.print("請輸入提款金額：");
                    int withdraw = sc.nextInt();
                    if (withdraw <= 0) {
                        System.out.println("提款金額必須大於 0");
                    } else if (withdraw > balance) {
                        System.out.println("提款失敗，餘額不足");
                    } else {
                        balance -= withdraw;
                        System.out.println("提款成功，目前餘額：" + balance + " 元");
                    }
                    break;

                case 0:
                    System.out.println("離開系統");
                    break;

                default:
                    System.out.println("未知選項，請重新輸入。");
            }
            System.out.println();
        }

        sc.close();
    }
}