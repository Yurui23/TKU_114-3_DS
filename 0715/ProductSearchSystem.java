import java.util.Scanner;

public class ProductSearchSystem {

    /*
     * 測試案例紀錄 (Test Cases):
     * 1. 完整名稱搜尋 - 正常輸入: 輸入 "  keyboard  " -> 預期找到 Keyboard。
     * 2. 完整名稱搜尋 - 找不到: 輸入 "MousePad" -> 預期顯示找不到商品。
     * 3. 部分名稱搜尋 - 正常多筆: 輸入 "e" -> 預期找到 Keyboard, Mouse, Headset。
     * 4. 部分名稱搜尋 - 找不到: 輸入 "xyz" -> 預期顯示找不到任何相符商品。
     * 5. 最長商品名稱 - 正常判定: 執行選項 4 -> 預期顯示 "USB Cable" (9個字元)。
     * 6. 搜尋關鍵字第一次出現位置 - 正常比對: 選擇商品 4 (USB Cable)，輸入 "C" -> 預期顯示在索引 4。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        while (true) {
            printMenu();
            System.out.print("請選擇功能 (1-6): ");
            if (!sc.hasNextInt()) {
                System.out.println("錯誤：請輸入有效的數字功能鍵！\n");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 6) {
                System.out.println("系統已結束，感謝使用！");
                break;
            }

            switch (choice) {
                case 1:
                    displayAllProducts(names, prices, stocks);
                    break;
                case 2:
                    exactSearch(sc, names, prices, stocks);
                    break;
                case 3:
                    partialSearch(sc, names, prices, stocks);
                    break;
                case 4:
                    findLongestProductName(names);
                    break;
                case 5:
                    findKeywordIndexInProduct(sc, names);
                    break;
                default:
                    System.out.println("錯誤：無此選項，請輸入 1-6 之間的數字！");
            }
            System.out.println();
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品名稱搜尋系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 完整名稱搜尋 (忽略大小寫與前後空白)");
        System.out.println("3. 部分名稱搜尋 (可顯示多筆結果)");
        System.out.println("4. 顯示名稱最長的商品");
        System.out.println("5. 顯示商品名稱與搜尋關鍵字第一次出現的位置");
        System.out.println("6. 結束");
        System.out.println("=======================");
    }

    public static void displayAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n商品列表：");
        System.out.println("編號\t名稱\t\t價格\t庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d\t%-12s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void exactSearch(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("\n請輸入欲搜尋的完整商品名稱：");
        String target = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().equals(target)) {
                System.out.println("找到商品！編號: " + (i + 1) + " | 名稱: " + names[i] + " | 價格: " + prices[i] + " 元 | 庫存: " + stocks[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("找不到符合完整名稱 \"" + target + "\" 的商品！");
        }
    }

    public static void partialSearch(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("\n請輸入欲搜尋的部分關鍵字：");
        String target = sc.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("搜尋結果：");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(target)) {
                System.out.println("編號: " + (i + 1) + " | 名稱: " + names[i] + " | 價格: " + prices[i] + " 元 | 庫存: " + stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到任何包含 \"" + target + "\" 的商品！");
        }
    }

    public static void findLongestProductName(String[] names) {
        String longest = names[0];
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > longest.length()) {
                longest = names[i];
            }
        }
        System.out.println("\n名稱最長的商品是 \"" + longest + "\" (字元長度: " + longest.length() + ")");
    }

    public static void findKeywordIndexInProduct(Scanner sc, String[] names) {
        System.out.print("\n請輸入欲比對的商品編號 (1-" + names.length + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("錯誤：請輸入有效的整數編號！");
            sc.next();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine(); 

        if (id < 1 || id > names.length) {
            System.out.println("錯誤：商品編號不存在！");
            return;
        }

        int index = id - 1;
        String productName = names[index];
        System.out.println("選定商品為: " + productName);
        System.out.print("請輸入欲搜尋的關鍵字：");
        String keyword = sc.nextLine();

        int pos = productName.toLowerCase().indexOf(keyword.toLowerCase());
        if (pos != -1) {
            System.out.println("關鍵字 \"" + keyword + "\" 第一次出現在商品名稱中的索引位置為: " + pos);
        } else {
            System.out.println("在商品名稱 \"" + productName + "\" 中找不到關鍵字 \"" + keyword + "\"！");
        }
    }
}