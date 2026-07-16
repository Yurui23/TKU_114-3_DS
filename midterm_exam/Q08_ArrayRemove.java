package midterm_exam;

public class Q08_ArrayRemove {
    public static void main(String[] args) {
        int[] values = {4, 7, 2, 7, 9, 7, 1};
        int target = 7;

        System.out.println("出現次數：" + countOccurrences(values, target));
        System.out.println("最後索引：" + findLastIndex(values, target));

        int[] result = removeAll(values, target);
        System.out.print("移除後：");
        showArray(result);
        System.out.print("原始陣列：");
        showArray(values);
    }

    public static int countOccurrences(int[] data, int target) {
        int cnt = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int findLastIndex(int[] data, int target) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] removeAll(int[] data, int target) {
        int matchingCount = countOccurrences(data, target);
        int[] newArr = new int[data.length - matchingCount];
        int idx = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != target) {
                newArr[idx] = data[i];
                idx++;
            }
        }
        return newArr;
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
