import java.util.Scanner;

public class ProductManagementSystem {
    private static Product[] products = new Product[10];
    private static int productCount = 0;
    private static int totalOperations = 0;

    public static void main(String[] args) {
        initProducts();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = getIntInput(scanner);
            if (choice == 9) {
                exitAndShowSummary();
                break;
            }
            handleChoice(choice, scanner);
        }
        scanner.close();
    }

    private static void initProducts() {
        products[0] = new Product("Switch", 1800, 8);
        products[1] = new Product("Mouse", 1200, 3);
        products[2] = new Product("Keyboard", 2500, 12);
        products[3] = new Product("Monitor", 5000, 2);
        products[4] = new Product("Headset", 1500, 6);
        productCount = 5;
    }

    private static void printMenu() {
        System.out.println("\n=== 商品管理系統 ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 依完整名稱搜尋");
        System.out.println("3. 新增商品");
        System.out.println("4. 出售商品");
        System.out.println("5. 補充庫存");
        System.out.println("6. 修改商品價格");
        System.out.println("7. 顯示低庫存商品");
        System.out.println("8. 顯示全部庫存總價值");
        System.out.println("9. 結束並顯示操作摘要");
        System.out.print("請選擇操作 (1-9): ");
    }

    private static int getIntInput(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void handleChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                displayAll();
                break;
            case 2:
                searchProduct(scanner);
                break;
            case 3:
                addProduct(scanner);
                break;
            case 4:
                sellProduct(scanner);
                break;
            case 5:
                restockProduct(scanner);
                break;
            case 6:
                updatePrice(scanner);
                break;
            case 7:
                displayLowStock();
                break;
            case 8:
                displayTotalValue();
                break;
            default:
                System.out.println("無效的選擇，請重新輸入！");
        }
    }

    private static void displayAll() {
        System.out.println("\n--- 全部商品列表 ---");
        boolean empty = true;
        for (Product p : products) {
            if (p != null) {
                System.out.println(p);
                empty = false;
            }
        }
        if (empty) {
            System.out.println("目前沒有任何商品。");
        }
        totalOperations++;
    }

    private static Product findProductByName(String name) {
        if (name == null) {
            return null;
        }
        String searchName = name.trim();
        for (Product p : products) {
            if (p != null && p.getName().trim().equalsIgnoreCase(searchName)) {
                return p;
            }
        }
        return null;
    }

    private static void searchProduct(Scanner scanner) {
        System.out.print("請輸入要搜尋的商品完整名稱: ");
        String name = scanner.nextLine();
        Product p = findProductByName(name);
        if (p != null) {
            System.out.println("找到商品: " + p);
        } else {
            System.out.println("找不到此商品！");
        }
        totalOperations++;
    }

    private static void addProduct(Scanner scanner) {
        if (productCount >= products.length) {
            System.out.println("錯誤：商品庫位已滿（最多 10 項），無法新增！");
            return;
        }
        System.out.print("請輸入新商品名稱: ");
        String name = scanner.nextLine();
        if (findProductByName(name) != null) {
            System.out.println("錯誤：商品名稱已存在，不可重複新增！");
            return;
        }
        System.out.print("請輸入價格: ");
        int price = getIntInput(scanner);
        System.out.print("請輸入庫存數量: ");
        int stock = getIntInput(scanner);

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = new Product(name, price, stock);
                productCount++;
                System.out.println("新增成功！" + products[i]);
                break;
            }
        }
        totalOperations++;
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("請輸入要出售的商品名稱: ");
        String name = scanner.nextLine();
        Product p = findProductByName(name);
        if (p == null) {
            System.out.println("錯誤：找不到該商品！");
            return;
        }
        System.out.print("請輸入要售出的數量: ");
        int amount = getIntInput(scanner);
        p.sell(amount);
        totalOperations++;
    }

    private static void restockProduct(Scanner scanner) {
        System.out.print("請輸入要補貨的商品名稱: ");
        String name = scanner.nextLine();
        Product p = findProductByName(name);
        if (p == null) {
            System.out.println("錯誤：找不到該商品！");
            return;
        }
        System.out.print("請輸入要補充的數量: ");
        int amount = getIntInput(scanner);
        p.restock(amount);
        totalOperations++;
    }

    private static void updatePrice(Scanner scanner) {
        System.out.print("請輸入要修改價格的商品名稱: ");
        String name = scanner.nextLine();
        Product p = findProductByName(name);
        if (p == null) {
            System.out.println("錯誤：找不到該商品！");
            return;
        }
        System.out.print("請輸入新價格: ");
        int price = getIntInput(scanner);
        p.setPrice(price);
        System.out.println("修改完成！" + p);
        totalOperations++;
    }

    private static void displayLowStock() {
        System.out.println("\n--- 低庫存商品列表 ---");
        boolean found = false;
        for (Product p : products) {
            if (p != null && p.isLowStock()) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("目前沒有低庫存商品。");
        }
        totalOperations++;
    }

    private static void displayTotalValue() {
        int total = 0;
        for (Product p : products) {
            if (p != null) {
                total += p.getInventoryValue();
            }
        }
        System.out.println("\n目前全部庫存總價值為: " + total + " 元");
        totalOperations++;
    }

    private static void exitAndShowSummary() {
        System.out.println("\n=== 系統關閉 ===");
        System.out.println("本次操作摘要：");
        System.out.println("1. 總執行操作次數: " + totalOperations + " 次");
        System.out.println("2. 目前系統內商品種類數: " + productCount + " 種");
        int totalValue = 0;
        for (Product p : products) {
            if (p != null) {
                totalValue += p.getInventoryValue();
            }
        }
        System.out.println("3. 系統關閉前庫存總價值: " + totalValue + " 元");
        System.out.println("感謝使用商品管理系統！");
    }
}