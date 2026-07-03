public class MyScoreAverage {

    public static void main(String[] args) {

        // 1. 宣告三科分數的整數變數 (int)
        int javaScore = 85;     
        int englishScore = 78;  
        int mathScore = 92;   

        // 2. 計算三科平均值
        double average = (javaScore + englishScore + mathScore) / 3.0;

        // 3. 依照規定的輸出格式印出結果
        System.out.println("Average score: " + average);
    }
}