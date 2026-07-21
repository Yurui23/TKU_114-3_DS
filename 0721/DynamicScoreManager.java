import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        while (true) {
            System.out.print("請輸入成績 (0-100，輸入 -1 結束): ");
            if (!scanner.hasNextInt()) {
                System.out.println("錯誤：請輸入有效的整數數字！");
                scanner.next();
                continue;
            }

            int score = scanner.nextInt();
            if (score == -1) {
                break;
            }

            if (score < 0 || score > 100) {
                System.out.println("錯誤：成績必須介於 0 到 100 之間！");
            } else {
                scores.add(score);
            }
        }

        if (scores.isEmpty()) {
            System.out.println("\n未輸入任何有效成績。");
        } else {
            System.out.println("\n=== 成績統計結果 ===");
            System.out.println("總筆數 : " + scores.size());
            System.out.printf("平均分數 : %.2f%n", calculateAverage(scores));
            System.out.println("最高分 : " + findMax(scores));
            System.out.println("最低分 : " + findMin(scores));
            System.out.println("及格名單 (>= 60) : " + getPassedScores(scores));
        }

        scanner.close();
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public static int findMax(ArrayList<Integer> scores) {
        int max = scores.get(0);
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(ArrayList<Integer> scores) {
        int min = scores.get(0);
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static ArrayList<Integer> getPassedScores(ArrayList<Integer> scores) {
        ArrayList<Integer> passed = new ArrayList<>();
        for (int score : scores) {
            if (score >= 60) {
                passed.add(score);
            }
        }
        return passed;
    }
}