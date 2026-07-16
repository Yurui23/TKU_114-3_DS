package midterm_exam;

public class Q09_MatrixReport {
    public static void main(String[] args) {
        int[][] data = {
            {5, 8, 2},
            {9, 4, 7},
            {3, 6, 10}
        };

        System.out.println("第 1 列總和：" + rowSum(data, 1));
        System.out.println("第 2 欄總和：" + columnSum(data, 2));
        System.out.println("大於等於 7 的筆數：" + countAtLeast(data, 7));
        System.out.println("總和最大的列索引：" + findRowWithLargestTotal(data));
    }

    public static int rowSum(int[][] data, int row) {
        if (row < 0 || row >= data.length) {
            return -1;
        }

        int total = 0;
        for (int i = 0; i < data[row].length; i++) {
            total += data[row][i];
        }
        return total;
    }

    public static int columnSum(int[][] data, int column) {
        if (data.length == 0 || column < 0 || column >= data[0].length) {
            return -1;
        }

        int total = 0;
        for (int r = 0; r < data.length; r++) {
            total += data[r][column];
        }
        return total;
    }

    public static int countAtLeast(int[][] data, int target) {
        int count = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] >= target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int findRowWithLargestTotal(int[][] data) {
        if (data.length == 0) {
            return -1;
        }

        int maxRowIdx = 0;
        int maxSum = rowSum(data, 0);

        for (int r = 1; r < data.length; r++) {
            int currentSum = rowSum(data, r);
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxRowIdx = r;
            }
        }
        return maxRowIdx;
    }
}