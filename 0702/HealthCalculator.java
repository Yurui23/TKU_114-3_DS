// 匯入 Scanner 類別以讀取使用者輸入
import java.util.Scanner;

// 類別名稱必須為 HealthCalculator，檔名必須為 HealthCalculator.java
public class HealthCalculator {

    public static void main(String[] args) {
        
        // 建立 Scanner 物件
        Scanner sc = new Scanner(System.in);

        // 1. 讀取使用者輸入資料
        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();  

        System.out.print("請輸入身高（公尺）：");
        double height = sc.nextDouble(); 

        System.out.print("請輸入體重（公斤）：");
        double weight = sc.nextDouble();

        // 2. 計算 BMI
        double bmi = weight / (height * height);

        System.out.println(); 

        // 3. 依照範例格式輸出完整資訊
        System.out.println("=== 個人健康資料 ===");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("身高：" + height);
        System.out.println("體重：" + weight);
        System.out.println("BMI：" + bmi);

        sc.close();
    }
}