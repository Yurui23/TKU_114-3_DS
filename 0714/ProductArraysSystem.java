import java.util.Scanner;

public class ProductArraysSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int totalBoughtCount = 0;
        int totalSpentAmount = 0;
        int totalReplenishedCount = 0;

        while (true) {
            printMenu();
            System.out.print("請選擇選單功能 (1-7): ");
            if (!sc.hasNextInt()) {
                System.out.println("錯誤：請輸入有效的數字功能鍵！\n");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();

            if (choice == 7) {
                printSummary(totalBoughtCount, totalSpentAmount, totalReplenishedCount);
                break;
            }

            switch (choice) {
                case 1:
                    displayAllProducts(names, prices, stocks);
                    break;
                case 2:
                    queryProductById(sc, names, prices, stocks);
                    break;
                case 3:
                    int[] purchaseResult = purchaseProduct(sc, names, prices, stocks);
                    totalBoughtCount += purchaseResult[0];
                    totalSpentAmount += purchaseResult[1];
                    break;
                case 4:
                    totalReplenishedCount += replenishStock(sc, names, stocks);
                    break;
                case 5:
                    displayLowStock(names, prices, stocks);
                    break;
                case 6:
                    int totalValue = calculateTotalValue(prices, stocks);
                    System.out.println("\n全部庫存總價值: " + totalValue + " 元");
                    break;
                default:
                    System.out.println("錯誤：無此選項，請輸入 1-7 之間的數字！");
            }
            System.out.println();
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品陣列管理系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依商品編號查詢");
        System.out.println("3. 購買商品並扣除庫存");
        System.out.println("4. 補充商品庫存");
        System.out.println("5. 顯示低庫存商品");
        System.out.println("6. 顯示全部庫存總價值");
        System.out.println("7. 結束並顯示操作摘要");
        System.out.println("=======================");
    }

    public static void displayAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n商品列表：");
        System.out.println("編號\t名稱\t\t價格\t庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d\t%-12s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
        }
    }

    public static void queryProductById(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("\n請輸入商品編號 (1-" + names.length + "): ");
        if (sc.hasNextInt()) {
            int id = sc.nextInt();
            if (id >= 1 && id <= names.length) {
                int index = id - 1;
                System.out.println("查詢結果：商品編號 " + id + " ｜ 名稱: " + names[index] + " ｜ 單價: " + prices[index] + " 元 ｜ 目前庫存: " + stocks[index]);
            } else {
                System.out.println("錯誤：商品編號不存在！");
            }
        } else {
            System.out.println("錯誤：請輸入有效的整數數字！");
            sc.next();
        }
    }

    public static int[] purchaseProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        int[] result = new int[2];
        System.out.print("\n請輸入欲購買的商品編號 (1-" + names.length + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("錯誤：請輸入有效的整數數字！");
            sc.next();
            return result;
        }
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：商品編號不存在！");
            return result;
        }

        int index = id - 1;
        if (stocks[index] == 0) {
            System.out.println("錯誤：該商品目前已無庫存，無法購買！");
            return result;
        }

        while (true) {
            System.out.print("請輸入欲購買數量 (目前庫存 " + stocks[index] + "): ");
            if (sc.hasNextInt()) {
                int qty = sc.nextInt();
                if (qty > 0) {
                    if (qty <= stocks[index]) {
                        stocks[index] -= qty;
                        int cost = prices[index] * qty;
                        System.out.println("成功購買 " + names[index] + " 共 " + qty + " 件，總共 " + cost + " 元。");
                        result[0] = qty;
                        result[1] = cost;
                        return result;
                    } else {
                        System.out.println("錯誤：庫存不足，請輸入小於或等於庫存的數量！");
                    }
                } else {
                    System.out.println("錯誤：購買數量必須大於 0！");
                }
            } else {
                System.out.println("錯誤：請輸入有效的整數數量！");
                sc.next();
            }
        }
    }

    public static int replenishStock(Scanner sc, String[] names, int[] stocks) {
        System.out.print("\n請輸入欲補貨的商品編號 (1-" + names.length + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("錯誤：請輸入有效的整數數字！");
            sc.next();
            return 0;
        }
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：商品編號不存在！");
            return 0;
        }

        int index = id - 1;
        while (true) {
            System.out.print("請輸入要補貨的數量: ");
            if (sc.hasNextInt()) {
                int qty = sc.nextInt();
                if (qty > 0) {
                    stocks[index] += qty;
                    System.out.println("商品 " + names[index] + " 已成功補貨 " + qty + " 件，目前庫存為: " + stocks[index]);
                    return qty;
                } else {
                    System.out.println("錯誤：補貨數量必須大於 0！");
                }
            } else {
                System.out.println("錯誤：請輸入有效的整數數量！");
                sc.next();
            }
        }
    }

    public static void displayLowStock(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n低庫存商品警告 (庫存 < 10)：");
        System.out.println("編號\t名稱\t\t價格\t庫存");
        boolean hasLowStock = false;
        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) {
                System.out.printf("%d\t%-12s\t%d\t%d\n", (i + 1), names[i], prices[i], stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("（目前沒有任何商品庫存低於 10）");
        }
    }

    public static int calculateTotalValue(int[] prices, int[] stocks) {
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * stocks[i];
        }
        return total;
    }

    public static void printSummary(int totalBought, int totalSpent, int totalReplenished) {
        System.out.println("\n=======================");
        System.out.println("系統結束，本次操作摘要如下：");
        System.out.println("1. 累計購買商品件數: " + totalBought + " 件");
        System.out.println("2. 累計消費總金額: " + totalSpent + " 元");
        System.out.println("3. 累計補貨商品件數: " + totalReplenished + " 件");
        System.out.println("感謝使用商品管理系統！");
        System.out.println("=======================");
    }
}