public class SalesMatrixDemo {

    public static void main(String[] args) {
        int[][] sales = {
            {5, 8, 6, 7},
            {3, 4, 5, 6},
            {10, 12, 9, 11}
        };

        System.out.println("=== 商品銷售數據表格 ===");
        for (int row = 0; row < sales.length; row++) {
            for (int column = 0; column < sales[row].length; column++) {
                System.out.print(sales[row][column] + " ");
            }
            System.out.println();
        }

        System.out.println("\n=== 各商品銷售總量統計 ===");
        for (int row = 0; row < sales.length; row++) {
            int total = 0;
            for (int column = 0; column < sales[row].length; column++) {
                total += sales[row][column];
            }
            System.out.println("商品 " + (row + 1) + " 銷售總量: " + total);
        }
    }
}