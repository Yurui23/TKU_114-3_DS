// 匯入 Scanner 類別以讀取使用者輸入
import java.util.Scanner;

public class ScoreReport {

    public static void main(String[] args) {

        // 建立 Scanner 物件來接收鍵盤輸入
        Scanner sc = new Scanner(System.in);

        // 1. 讀取使用者輸入的個人資料與成績
        System.out.print("請輸入姓名：");
        String name = sc.nextLine(); 

        System.out.print("請輸入 Java 成績：");
        int javaScore = sc.nextInt(); 

        System.out.print("請輸入 English 成績：");
        int englishScore = sc.nextInt();

        System.out.print("請輸入 Math 成績：");
        int mathScore = sc.nextInt();

        // 2. 計算平均分數

        double average = (javaScore + englishScore + mathScore) / 3.0;

        // 換行以符合範例輸出的間隔
        System.out.println();

        // 3. 依照範例格式輸出完整成績報表
        System.out.println("=== 成績報表 ===");
        System.out.println("姓名：" + name);
        System.out.println("Java：" + javaScore);
        System.out.println("English：" + englishScore);
        System.out.println("Math：" + mathScore);
        System.out.println("平均：" + average);

        sc.close();
    }
}