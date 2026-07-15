import java.util.Scanner;

public class ProductDataManager {

    private static String[] names = new String[100];
    private static int[] prices = new int[100];
    private static int[] stocks = new int[100];
    private static int productCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
        };

        for (String r : records) {
            parseAndAddRecord(r);
        }

        while (true) {
            printMenu();
            System.out.print("請選擇功能 (1-7): ");
            if (!sc.hasNextInt()) {
                System.out.println("錯誤：請輸入 1 到 7 的數字！\n");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 7) {
                System.out.println("系統結束，掰掰！");
                break;
            }

            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    exactSearch(sc);
                    break;
                case 3:
                    partialSearch(sc);
                    break;
                case 4:
                    displayLowStock();
                    break;
                case 5:
                    calculateTotalValue();
                    break;
                case 6:
                    addNewRecord(sc);
                    break;
                default:
                    System.out.println("錯誤：無此選項，請重新輸入！");
            }
            System.out.println();
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品文字資料管理器 ===");
        System.out.println("1. 顯示解析後商品表格");
        System.out.println("2. 完整名稱搜尋 (忽略大小寫與前後空白)");
        System.out.println("3. 部分名稱搜尋");
        System.out.println("4. 顯示低庫存商品 (庫存 < 10)");
        System.out.println("5. 顯示庫存總價值");
        System.out.println("6. 輸入新文字資料並解析新增");
        System.out.println("7. 結束系統");
        System.out.println("=======================");
    }

    public static void parseAndAddRecord(String record) {
        if (record == null || record.trim().isEmpty()) {
            return;
        }
        String[] parts = record.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("格式錯誤：欄位數量不等於 3 (必須為名稱,價格,庫存)");
        }

        String name = parts[0].trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("格式錯誤：商品名稱不能為空");
        }

        int price = Integer.parseInt(parts[1].trim());
        int stock = Integer.parseInt(parts[2].trim());

        if (price < 0 || stock < 0) {
            throw new IllegalArgumentException("數值錯誤：價格或庫存不能小於 0");
        }

        names[productCount] = name;
        prices[productCount] = price;
        stocks[productCount] = stock;
        productCount++;
    }

    public static void displayAllProducts() {
        System.out.println("\n解析後商品表格：");
        System.out.println("編號\t名稱\t\t價格\t庫存");
        for (int i = 0; i < productCount; i++) {
            System.out.printf("%d\t%-12s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void exactSearch(Scanner sc) {
        System.out.print("\n請輸入欲搜尋的完整商品名稱：");
        String target = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        for (int i = 0; i < productCount; i++) {
            if (names[i].toLowerCase().equals(target)) {
                System.out.println("找到商品！編號: " + (i + 1) + " | 名稱: " + names[i] + " | 價格: " + prices[i] + " | 庫存: " + stocks[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("找不到符合完整名稱 \"" + target + "\" 的商品！");
        }
    }

    public static void partialSearch(Scanner sc) {
        System.out.print("\n請輸入部分商品名稱關鍵字：");
        String target = sc.nextLine().toLowerCase();
        boolean found = false;

        System.out.println("搜尋結果：");
        for (int i = 0; i < productCount; i++) {
            if (names[i].toLowerCase().contains(target)) {
                System.out.println("編號: " + (i + 1) + " | 名稱: " + names[i] + " | 價格: " + prices[i] + " | 庫存: " + stocks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("找不到任何名稱含有 \"" + target + "\" 的商品！");
        }
    }

    public static void displayLowStock() {
        System.out.println("\n低庫存商品 (庫存 < 10)：");
        System.out.println("編號\t名稱\t\t價格\t庫存");
        boolean hasLowStock = false;
        for (int i = 0; i < productCount; i++) {
            if (stocks[i] < 10) {
                System.out.printf("%d\t%-12s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("（目前沒有任何商品庫存低於 10）");
        }
    }

    public static void calculateTotalValue() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += prices[i] * stocks[i];
        }
        System.out.println("\n目前所有庫存總價值: " + total + " 元");
    }

    public static void addNewRecord(Scanner sc) {
        System.out.print("\n請輸入新商品文字資料 (格式: 名稱,價格,庫存): ");
        String line = sc.nextLine();

        try {
            parseAndAddRecord(line);
            System.out.println("新增成功！目前共有 " + productCount + " 筆商品資料。");
        } catch (NumberFormatException e) {
            System.out.println("新增失敗！原因：價格或庫存必須是整數數字。");
        } catch (IllegalArgumentException e) {
            System.out.println("新增失敗！原因：" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("新增失敗！原因：陣列容量已滿 (最多 100 筆資料)。");
        }
    }
}