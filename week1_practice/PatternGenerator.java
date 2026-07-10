package week1_practice;

import java.util.Scanner;

public class PatternGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("感謝使用，再見！");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("無效的選項，請重新輸入。");
                continue;
            }

            int rows = readValidRows(sc, choice);
            
            System.out.print("請輸入要使用的字元 (例如 * 或 #)：");
            char patternChar = sc.next().charAt(0);

            System.out.println("\n--- 生成圖形 ---");
            drawPattern(choice, rows, patternChar);
        }

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\n=== 圖形生成器選單 ===");
        System.out.println("1. 直角三角形");
        System.out.println("2. 等腰三角形");
        System.out.println("3. 倒直角三角形");
        System.out.println("4. 菱形");
        System.out.println("0. 離開");
        System.out.print("請輸入選項：");
    }

    public static int readValidRows(Scanner sc, int type) {
        int rows = 0;
        while (true) {
            System.out.print("請輸入行數 (1-20)：");
            rows = sc.nextInt();

            if (rows < 1 || rows > 20) {
                System.out.println("錯誤：行數必須在 1 到 20 之間！");
                continue;
            }

            if (type == 4 && rows % 2 == 0) {
                System.out.println("錯誤：菱形的行數必須是奇數！");
                continue;
            }

            break;
        }
        return rows;
    }

    public static void drawPattern(int type, int rows, char c) {
        switch (type) {
            case 1:
                printRightTriangle(rows, c);
                break;
            case 2:
                printIsoscelesTriangle(rows, c);
                break;
            case 3:
                printInvertedRightTriangle(rows, c);
                break;
            case 4:
                printDiamond(rows, c);
                break;
        }
    }

    public static void printRightTriangle(int rows, char c) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void printIsoscelesTriangle(int rows, char c) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void printInvertedRightTriangle(int rows, char c) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void printDiamond(int rows, char c) {
        int n = rows / 2;
        // 上半部 (包含中間行)
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print(c);
            }
            System.out.println();
        }
        // 下半部
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i + 1); k++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}