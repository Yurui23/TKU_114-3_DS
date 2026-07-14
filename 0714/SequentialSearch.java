public class SequentialSearch {

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 5, 2},
            {8, 1, 3},
            {7, 6, 4}
        };

        System.out.println("=== 排序前矩陣 ===");
        printMatrix(matrix);

        sortRowWise(matrix);

        System.out.println("\n=== 排序後矩陣 ===");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void sortRowWise(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int n = matrix[i].length;
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n - 1 - j; k++) {
                    if (matrix[i][k] > matrix[i][k + 1]) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k + 1];
                        matrix[i][k + 1] = temp;
                    }
                }
            }
        }
    }
}