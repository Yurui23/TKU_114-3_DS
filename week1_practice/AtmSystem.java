package week1_practice;

import java.util.Scanner;

public class AtmSystem {

    public static void main(String[] args) {
        Scanner atmScanner = new Scanner(System.in);
        int balance = 1000;
        
        int depositCount = 0;
        int withdrawCount = 0;
        int totalDeposit = 0;
        int totalWithdraw = 0;

        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = atmScanner.nextInt();

            switch (choice) {
                case 1:
                    printBalance(balance);
                    break;
                case 2:
                    int dAmount = readPositiveAmount(atmScanner, "請輸入存款金額：");
                    balance = deposit(balance, dAmount);
                    depositCount++;
                    totalDeposit += dAmount;
                    break;
                case 3:
                    int wAmount = readPositiveAmount(atmScanner, "請輸入提款金額：");
                    if (!canWithdraw(balance, wAmount)) {
                        System.out.println("錯誤：提款金額大於目前餘額，無法提款！");
                    } else {
                        balance = withdraw(balance, wAmount);
                        withdrawCount++;
                        totalWithdraw += wAmount;
                    }
                    break;
                case 4:
                    System.out.println("--- 目前操作統計 ---");
                    System.out.println("存款次數: " + depositCount + ", 總存款額: " + totalDeposit);
                    System.out.println("提款次數: " + withdrawCount + ", 總提款額: " + totalWithdraw);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入。");
            }
        }

        printSummary(balance, depositCount, withdrawCount, totalDeposit, totalWithdraw);
        atmScanner.close();
    }

    public static void printMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show summary");
        System.out.println("0. Exit");
        System.out.print("請輸入選項：");
    }

    public static int readPositiveAmount(Scanner sc, String message) {
        int amount = 0;
        while (amount <= 0) {
            System.out.print(message);
            amount = sc.nextInt();
            if (amount <= 0) {
                System.out.println("錯誤：金額必須大於 0，請重新輸入。");
            }
        }
        return amount;
    }

    public static int deposit(int balance, int amount) {
        int nextBalance = balance + amount;
        System.out.println("Balance: " + nextBalance);
        return nextBalance;
    }

    public static int withdraw(int balance, int amount) {
        int nextBalance = balance - amount;
        System.out.println("提款成功，請領取現金。");
        return nextBalance;
    }

    public static boolean canWithdraw(int balance, int amount) {
        return amount <= balance;
    }

    public static void printBalance(int balance) {
        System.out.println("Balance: " + balance);
    }

    public static void printSummary(int balance, int depositCount, int withdrawCount, int totalDeposit, int totalWithdraw) {
        System.out.println("\n=== ATM Summary ===");
        System.out.println("Final balance: " + balance);
        System.out.println("Deposit count: " + depositCount);
        System.out.println("Withdraw count: " + withdrawCount);
        System.out.println("Total deposit: " + totalDeposit);
        System.out.println("Total withdraw: " + totalWithdraw);
    }
}