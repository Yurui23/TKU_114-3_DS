import java.util.Scanner;

/*
 * === 這次作業的除錯心得報告 (Debugging Report) ===
 * 
 * 1. 補分號的大Bug
 *    - 錯誤位置:第 29 行的 System.out.println("系統結束，年齡：" + age)
 *    - 錯誤類型：Compile Error (編譯直接死掉)
 *    - 原因：傻眼，這行結尾居然漏掉分號「;」，難怪一開始一直編譯失敗，超白癡。
 *    - 修正方式：在括號後面乖乖補上分號「;」就好了。
 * 
 * 2. 陣列越界、直接當機
 *    - 錯誤位置：第 11 行 for 迴圈裡的 i <= scores.length
 *    - 錯誤類型：Runtime Error (執行到一半直接噴 Exception 當掉)
 *    - 原因：因為 scores 陣列長度只有 3，所以索引值最多只到 2 (也就是 0, 1, 2)。
 *              迴圈條件寫 <= 的話，跑到 i = 3 就會去抓 scores[3]，直接噴 ArrayIndexOutOfBoundsException。
 *    - 修正方式：把 <= 改成 <，讓迴圈最多跑到 i < scores.length 就好。
 * 
 * 3. 平均分數被自動捨去
 *    - 錯誤位置：第 16 行的 total / scores.length
 *    - 錯誤類型：Logical Error (邏輯出事，算出來的數字是錯的)
 *    - 原因：因為 total 跟 scores.length 都是 int (整數)，在 Java 裡面「整數除以整數」會自動把小數點砍掉。
 *              雖然前面宣告 average 是 double，但沒用，因為算的時候就已經失真了。
 *    - 修正方式：把 total 強制轉型成 double，改成 (double) total / scores.length，這樣小數點才會留著。
 * 
 * 4. 指令輸入直接被跳過
 *    - 錯誤位置：第 23 行讀取年齡的 sc.nextInt() 後面
 *    - 錯誤類型：Scanner 緩衝區的問題 (Keyboard Buffer Buffer Issue)
 *    - 原因：這個超雷！nextInt() 讀完數字之後，我們按 Enter 的「換行符號」還殘留在緩衝區裡。
 *              結果底下的 nextLine() 讀指令時，直接把那個換行符號吃掉，導致根本不給人打字就直接跳下一步了。
 *    - 修正方式：在讀完數字 nextInt() 的下一行，多塞一條 sc.nextLine(); 來把殘留的換行符號清乾淨。
 * 
 * 5. 字串比較用錯符號
 *    - 錯誤位置：第 28 行判斷 command == "exit"
 *    - 錯誤類型：Logical Error (邏輯錯誤，輸入 exit 卻不會結束)
 *    - 原因：Java 的字串如果用 == 比較，它是在比這兩個東西的「記憶體位址」，而不是文字內容。
 *              所以你輸入 "exit"，它也會覺得這兩個字串不一樣，條件直接判定成 false。
 *    - 修正方式：字串比較要用 .equals()，所以改成 command.equals("exit")。
 * 
 * 6. Breakpoint 偵錯變數紀錄：
 *    - 這裡我用 IDE 跑斷點，在它計算平均值之前停下來看變數：
 *      * scores 陣列 = {80, 75, 92}
 *      * total 累加出來的值 = 247
 *      * scores.length 長度 = 3
 *      * 預期平均值算出來應該是：247 / 3.0 = 82.333... (四捨五入到小數第二位是 82.33)
 */
public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        double average = (double) total / scores.length;
        System.out.printf("平均 : %.2f%n", average);

        System.out.print("請輸入年齡 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("請輸入指令 : ");
        String command = sc.nextLine();

        if (command.equals("exit")) {
            System.out.println("系統結束，年齡 : " + age);
        }

        sc.close();
    }
}