import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {

    private static ArrayList<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 6) {
                System.out.println("感謝使用購物車系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 購物車管理系統 ===");
        System.out.println("1. 加入商品至購物車");
        System.out.println("2. 修改商品數量");
        System.out.println("3. 移除購物車商品");
        System.out.println("4. 顯示購物車內容與總額");
        System.out.println("5. 清空購物車");
        System.out.println("6. 離開系統");
        System.out.print("請選擇操作 (1-6): ");
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
                addToCart(scanner);
                break;
            case 2:
                updateQuantity(scanner);
                break;
            case 3:
                removeItem(scanner);
                break;
            case 4:
                displayCart();
                break;
            case 5:
                clearCart();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 6 之間的數字！");
        }
    }

    private static CartItem findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (CartItem item : cart) {
            if (item.getId().equalsIgnoreCase(id.trim())) {
                return item;
            }
        }
        return null;
    }

    private static void addToCart(Scanner scanner) {
        System.out.print("請輸入商品代碼: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("錯誤：商品代碼不可為空白！");
            return;
        }

        System.out.print("請輸入欲購買數量: ");
        int quantity = getIntInput(scanner);

        if (quantity <= 0) {
            System.out.println("錯誤：數量必須大於 0！");
            return;
        }

        CartItem existingItem = findById(id);
        if (existingItem != null) {
            existingItem.addQuantity(quantity);
            System.out.println("該商品已在購物車中，已為您累加數量！");
            System.out.println("更新後項目: " + existingItem);
            return;
        }

        System.out.print("請輸入商品名稱: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：商品名稱不可為空白！");
            return;
        }

        System.out.print("請輸入商品單價: ");
        int price = getIntInput(scanner);

        if (price <= 0) {
            System.out.println("錯誤：單價必須大於 0！");
            return;
        }

        CartItem newItem = new CartItem(id, name, price, quantity);
        cart.add(newItem);
        System.out.println("成功加入購物車！" + newItem);
    }

    private static void updateQuantity(Scanner scanner) {
        System.out.print("請輸入要修改數量的商品代碼: ");
        String id = scanner.nextLine().trim();

        CartItem item = findById(id);
        if (item == null) {
            System.out.println("修改失敗：購物車中找不到該商品！");
            return;
        }

        System.out.print("請輸入新的數量: ");
        int newQuantity = getIntInput(scanner);

        if (newQuantity <= 0) {
            System.out.println("錯誤：更新數量小於或等於 0 時不接受更新！");
            return;
        }

        item.setQuantity(newQuantity);
        System.out.println("數量修改成功！" + item);
    }

    private static void removeItem(Scanner scanner) {
        System.out.print("請輸入要移除的商品代碼: ");
        String id = scanner.nextLine().trim();

        CartItem item = findById(id);
        if (item != null) {
            cart.remove(item);
            System.out.println("成功將商品 [" + item.getName() + "] 從購物車移除！");
        } else {
            System.out.println("移除失敗：購物車中找不到該商品！");
        }
    }

    private static void displayCart() {
        System.out.println("\n--- 購物車內容 ---");
        if (cart.isEmpty()) {
            System.out.println("購物車目前是空的。");
            return;
        }

        int totalAmount = 0;
        for (CartItem item : cart) {
            System.out.println(item);
            totalAmount += item.getSubtotal();
        }

        System.out.println("---------------------------------------------");
        System.out.println("購物車總金額: " + totalAmount + " 元");
    }

    private static void clearCart() {
        cart.clear();
        System.out.println("已清空購物車！");
    }
}