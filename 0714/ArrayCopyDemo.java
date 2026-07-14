import java.util.Scanner;

public class ArrayCopyDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            printMenu();
            System.out.print("請選擇功能 (0-4): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < 0 || choice > 4) {
                    System.out.println("無此選項，請重新輸入！\n");
                    continue;
                }
            } else {
                System.out.println("輸入錯誤，請輸入整數數字！\n");
                sc.next();
                continue;
            }

            if (choice == 0) {
                System.out.println("感謝使用，系統已關閉。");
                break;
            }

            switch (choice) {
                case 1:
                    printMultiplicationTable();
                    break;
                case 2:
                    int height1 = readPositiveInt(sc, "請輸入正三角形的高度: ");
                    printTriangle(height1);
                    break;
                case 3:
                    int height2 = readPositiveInt(sc, "請輸入倒三角形的高度: ");
                    printReverseTriangle(height2);
                    break;
                case 4:
                    int rows = readPositiveInt(sc, "請輸入列數: ");
                    int cols = readPositiveInt(sc, "請輸入欄數: ");
                    printNumberGrid(rows, cols);
                    break;
            }
            System.out.println();
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== 圖形與表格產生器 ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形星號");
        System.out.println("3. 倒三角形星號");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
        System.out.println("=======================");
    }

    public static int readPositiveInt(Scanner sc, String message) {
        int val;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                val = sc.nextInt();
                if (val > 0) {
                    return val;
                } else {
                    System.out.println("錯誤：輸入值必須大於 0，請重新輸入。");
                }
            } else {
                System.out.println("錯誤：請輸入有效的整數數字。");
                sc.next();
            }
        }
    }

    public static void printMultiplicationTable() {
        System.out.println("\n[ 九九乘法表 ]");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d*%d=%-2d  ", j, i, (i * j));
            }
            System.out.println();
        }
    }

    public static void printTriangle(int height) {
        System.out.println("\n[ 正三角形星號 ]");
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printReverseTriangle(int height) {
        System.out.println("\n[ 倒三角形星號 ]");
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printNumberGrid(int rows, int cols) {
        System.out.println("\n[ 數字方格 ]");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}