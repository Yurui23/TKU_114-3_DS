package week1_practice;

import java.util.Scanner;

public class GradeStatistics {

    public static void main(String[] args) {
        Scanner scoreScanner = new Scanner(System.in);
        
        int totalScore = 0;
        int maxScore = -1;
        int minScore = 101;
        int totalCount = 0;
        int passCount = 0;
        int failCount = 0;

        while (true) {
            System.out.print("請輸入成績 (輸入 -1 結束)：");
            int currentInput = scoreScanner.nextInt();

            if (currentInput == -1) {
                break;
            }

            if (!isValidScore(currentInput)) {
                System.out.println("輸入不合法，分數必須在 0 到 100 之間，請重新輸入。");
                continue;
            }

            totalScore += currentInput;
            totalCount++;

            if (currentInput > maxScore) {
                maxScore = currentInput;
            }
            if (currentInput < minScore) {
                minScore = currentInput;
            }

            if (isPassing(currentInput)) {
                passCount++;
            } else {
                failCount++;
            }
        }

        if (totalCount == 0) {
            System.out.println("\nNo scores entered.");
        } else {
            double finalAverage = (double) totalScore / totalCount;
            String letterGrade = getGrade(finalAverage);
            
            printSummary(totalCount, totalScore, finalAverage, maxScore, minScore, passCount, failCount, letterGrade);
        }

        scoreScanner.close();
    }

    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    public static boolean isPassing(int score) {
        return score >= 60;
    }

    public static String getGrade(double average) {
        if (average >= 90.0) {
            return "A";
        } else if (average >= 80.0) {
            return "B";
        } else if (average >= 70.0) {
            return "C";
        } else if (average >= 60.0) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void printSummary(int count, int total, double average, int max, int min, int passCount, int failCount, String grade) {
        System.out.println("\n=== Grade Summary ===");
        System.out.println("Count: " + count);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Pass count: " + passCount);
        System.out.println("Fail count: " + failCount);
        System.out.println("Average grade: " + grade);
    }
}