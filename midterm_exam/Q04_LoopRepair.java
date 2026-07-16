package midterm_exam;

public class Q04_LoopRepair {
    public static void main(String[] args) {
        System.out.println(sumOddRange(3, 7));
        System.out.println(sumOddRange(7, 3));
        System.out.println(sumOddRange(2, 2));
        System.out.println(sumOddRange(-3, 3));
    }

    public static int sumOddRange(int start, int end) {
        int minVal = start < end ? start : end;
        int maxVal = start > end ? start : end;
        int total = 0;

        for (int val = minVal; val <= maxVal; val++) {
            if (val % 2 != 0) {
                total += val;
            }
        }
        return total;
    }
}
