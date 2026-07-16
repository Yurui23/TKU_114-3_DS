package midterm_exam;

public class Q07_ArrayAudit {
    private static final int LOW_LIMIT = 10;
    private static final int HIGH_LIMIT = 60;
    private static final int CRITERIA = 35;
    private static final int EMPTY_VAL = -1;

    public static void main(String[] args) {
        int[] readings = {12, 71, 35, -4, 35, 22, 60, 9, 48, 61};

        System.out.println("有效筆數：" + countValid(readings));
        System.out.printf("有效平均：%.2f%n", averageValid(readings));
        System.out.println("最後符合門檻的索引：" + findLastAtLeast(readings, CRITERIA));

        int[] cleaned = createCleanCopy(readings);
        System.out.print("清理後資料：");
        showArray(cleaned);
        System.out.print("原始資料：");
        showArray(readings);
    }

    private static boolean checkValid(int num) {
        return num >= LOW_LIMIT && num <= HIGH_LIMIT;
    }

    public static int countValid(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (checkValid(data[i])) {
                count++;
            }
        }
        return count;
    }

    public static double averageValid(int[] data) {
        int sum = 0;
        int validCount = 0;

        for (int i = 0; i < data.length; i++) {
            if (checkValid(data[i])) {
                sum += data[i];
                validCount++;
            }
        }

        if (validCount == 0) {
            return -1.0;
        }
        return (double) sum / validCount;
    }

    public static int findLastAtLeast(int[] data, int target) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (checkValid(data[i]) && data[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] createCleanCopy(int[] data) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = checkValid(data[i]) ? data[i] : EMPTY_VAL;
        }
        return result;
    }

    private static void showArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
