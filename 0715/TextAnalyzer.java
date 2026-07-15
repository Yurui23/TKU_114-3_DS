import java.util.Scanner;

public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = readValidInput(sc);
        String trimmed = input.trim();

        System.out.println("\n=== 文字分析結果 ===");
        System.out.println("原始字元數：" + input.length());
        System.out.println("Trim 後有效字元數：" + trimmed.length());

        String[] words = splitWords(trimmed);
        System.out.println("單字數量：" + words.length);

        int vowelCount = countVowels(trimmed);
        System.out.println("英文字母母音 (a, e, i, o, u) 總數：" + vowelCount);

        String longestWord = findLongestWord(words);
        System.out.println("最長單字：" + longestWord);

        System.out.print("\n請輸入欲搜尋的關鍵字：");
        String keyword = sc.nextLine();
        int keywordCount = countKeyword(trimmed, keyword);
        System.out.println("關鍵字 \"" + keyword + "\" 出現次數 (忽略大小寫)：" + keywordCount);

        sc.close();
    }

    public static String readValidInput(Scanner sc) {
        while (true) {
            System.out.print("請輸入一行非空白文字：");
            String input = sc.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input;
            }
            System.out.println("錯誤：輸入不能為空或全空白，請重新輸入！");
        }
    }

    public static String[] splitWords(String text) {
        return text.split("\\s+");
    }

    public static int countVowels(String text) {
        int count = 0;
        String lower = text.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static String findLongestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String longest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        return longest;
    }

    public static int countKeyword(String text, String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return 0;
        }
        String textLower = text.toLowerCase();
        String keyLower = keyword.toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = textLower.indexOf(keyLower, index)) != -1) {
            count++;
            index += keyLower.length();
        }
        return count;
    }
}