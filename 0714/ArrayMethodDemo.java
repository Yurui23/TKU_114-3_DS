public class ArrayMethodDemo {

    public static void main(String[] args) {
        int[][] matrix1 = {
            {9, 5, 2},
            {8, 1, 3},
            {7, 6, 4}
        };

        System.out.println("=== 排序前矩陣 ===");
        printMatrix(matrix1);

        sortRowWise(matrix1);

        System.out.println("\n=== 逐列排序後矩陣 ===");
        printMatrix(matrix1);

        int[][] matrix2 = {
            {9, 5, 2},
            {8, 1, 3},
            {7, 6, 4}
        };

        sortWholeMatrix(matrix2);

        System.out.println("\n=== 全矩陣排序後矩陣 ===");
        printMatrix(matrix2);
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

    public static void sortWholeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalElements = rows * cols;
        int[] flat = new int[totalElements];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flat[index++] = matrix[i][j];
            }
        }

        for (int i = 0; i < totalElements - 1; i++) {
            for (int j = 0; j < totalElements - 1 - i; j++) {
                if (flat[j] > flat[j + 1]) {
                    int temp = flat[j];
                    flat[j] = flat[j + 1];
                    flat[j + 1] = temp;
                }
            }
        }

        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = flat[index++];
            }
        }
    }
}