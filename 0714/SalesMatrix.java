import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sales = inputSales(sc);

        System.out.println("\n=== 銷售矩陣報表 ===");
        printMatrix(sales);

        int[] productTotals = calculateProductTotals(sales);
        int[] dayTotals = calculateDayTotals(sales);

        System.out.println("\n=== 各商品銷售總量 ===");
        for (int i = 0; i < productTotals.length; i++) {
            System.out.println("商品 " + (i + 1) + " 銷售總量: " + productTotals[i]);
        }

        System.out.println("\n=== 每天銷售總量 ===");
        for (int j = 0; j < dayTotals.length; j++) {
            System.out.println("第 " + (j + 1) + " 天銷售總量: " + dayTotals[j]);
        }

        int maxProductIndex = findMaxProduct(productTotals);
        System.out.println("\n總銷售量最高的商品為: 商品 " + (maxProductIndex + 1) + " (總銷售量: " + productTotals[maxProductIndex] + ")");

        sc.close();
    }

    public static int[][] inputSales(Scanner sc) {
        int[][] matrix = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                while (true) {
                    System.out.print("請輸入商品 " + (i + 1) + " 第 " + (j + 1) + " 天的銷售量: ");
                    if (sc.hasNextInt()) {
                        int value = sc.nextInt();
                        if (value >= 0) {
                            matrix[i][j] = value;
                            break;
                        }
                    } else {
                        sc.next();
                    }
                    System.out.println("錯誤：銷售量不得小於 0，請重新輸入！");
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] sales) {
        System.out.println("商品\\天\t第一天\t第二天\t第三天\t第四天");
        for (int i = 0; i < sales.length; i++) {
            System.out.print("商品 " + (i + 1) + "\t");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[] calculateProductTotals(int[][] sales) {
        int[] totals = new int[sales.length];
        for (int i = 0; i < sales.length; i++) {
            int sum = 0;
            for (int j = 0; j < sales[i].length; j++) {
                sum += sales[i][j];
            }
            totals[i] = sum;
        }
        return totals;
    }

    public static int[] calculateDayTotals(int[][] sales) {
        int[] totals = new int[sales[0].length];
        for (int j = 0; j < sales[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < sales.length; i++) {
                sum += sales[i][j];
            }
            totals[j] = sum;
        }
        return totals;
    }

    public static int findMaxProduct(int[] productTotals) {
        int maxIndex = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}