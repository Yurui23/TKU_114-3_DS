import java.util.Scanner;

public class OrderSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option = -1;
        int totalQuantity = 0;
        int totalAmount = 0;

        while (option != 0) {
            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            option = sc.nextInt();

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                case 2:
                case 3:
                    System.out.print("請輸入數量：");
                    int quantity = sc.nextInt();
                    while (quantity <= 0) {
                        System.out.print("請重新輸入（必須大於 0）：");
                        quantity = sc.nextInt();
                    }

                    int price = 0;
                    if (option == 1) {
                        price = 30;
                    } else if (option == 2) {
                        price = 35;
                    } else {
                        price = 50;
                    }

                    int subtotal = price * quantity;
                    totalQuantity += quantity;
                    totalAmount += subtotal;

                    System.out.println("Subtotal: " + subtotal);
                    break;

                default:
                    System.out.println("未知選項，請重新輸入。");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("=== Receipt ===");
        System.out.println("Total items: " + totalQuantity);
        System.out.println("Total amount: " + totalAmount);

        sc.close();
    }
}