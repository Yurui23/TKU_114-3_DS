public class TwoDimensionalArray {

    public static void main(String[] args) {
        int[][] sales = {
            {5, 8, 6, 7},
            {3, 4, 5, 6},
            {10, 12, 9, 11}
        };

        System.out.println("第 1 列、第 3 欄的值 (sales[0][2]): " + sales[0][2]);

        System.out.println("列數 (sales.length): " + sales.length);

        for (int i = 0; i < sales.length; i++) {
            System.out.println("第 " + (i + 1) + " 列的欄數 (sales[" + i + "].length): " + sales[i].length);
        }

        System.out.println("\n完整的銷售數據表格：");
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }
}