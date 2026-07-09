import java.util.Scanner;

public class OrderSystemRefactor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalItems = 0;
        int totalAmount = 0;
        int itemCode = -1;

        while (itemCode != 0) {
            printMenu();
            itemCode = input.nextInt();

            if (itemCode == 0) {
                break;
            }

            int price = getPrice(itemCode);
            if (price == 0) {
                System.out.println("無效的選項，請重新輸入。");
                continue;
            }

            int qty = readValidQuantity(input);
            int subtotal = calculateSubtotal(price, qty);

            totalItems += qty;
            totalAmount += subtotal;

            System.out.println("已加入購物車，小計: " + subtotal + " 元");
        }

        printReceipt(totalItems, totalAmount);
        input.close();
    }

    public static void printMenu() {
        System.out.println("=== 點餐系統 ===");
        System.out.println("1. 紅茶 - 30 元");
        System.out.println("2. 綠茶 - 25 元");
        System.out.println("3. 咖啡 - 50 元");
        System.out.println("0. 結帳並離開");
        System.out.print("請輸入品項編號: ");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 25;
            case 3: return 50;
            default: return 0;
        }
    }

    public static int readValidQuantity(Scanner sc) {
        int qty = 0;
        while (qty <= 0) {
            System.out.print("請輸入數量 (必須大於 0): ");
            qty = sc.nextInt();
            if (qty <= 0) {
                System.out.println("數量輸入錯誤，請重新輸入。");
            }
        }
        return qty;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n=== 您的消費收據 ===");
        System.out.println("總購買件數: " + totalItems + " 件");
        System.out.println("應付總金額: " + totalAmount + " 元");
        System.out.println("謝謝惠顧，歡迎下次光臨！");
    }
}