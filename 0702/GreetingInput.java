import java.util.Scanner;

public class GreetingInput {
    public static void main(String[] args) {

        // 1. 建立 Scanner 物件，準備讀取系統的標準輸入（鍵盤）
        Scanner sc = new Scanner(System.in);

        // 2. 提示使用者輸入姓名，並讀取一整行文字
        System.out.print("請輸入姓名：");
        String name = sc.nextLine(); // 讀取字串

        // 3. 提示使用者輸入年齡，並讀取整數值
        System.out.print("請輸入年齡：");
        int age = sc.nextInt();      // 讀取整數

        // 4. 依照規定的格式串接變數並輸出
        System.out.println("Hello, " + name + ". You are " + age + " years old.");

        // 5. 良好的程式習慣：關閉 Scanner 資源
        sc.close();
    }
}