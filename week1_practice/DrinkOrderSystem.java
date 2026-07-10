package week1_practice;

import java.util.Scanner;

public class DrinkOrderSystem {

    public static void main(String[] args) {
        Scanner orderScanner = new Scanner(System.in);

        int blackTeaQty = 0;
        int greenTeaQty = 0;
        int milkTeaQty = 0;
        int coffeeQty = 0;
        int sumItems = 0;
        int totalBeforeDiscount = 0;

        int userSelection = -1;

        while (userSelection != 0) {
            printMenu();
            userSelection = orderScanner.nextInt();

            if (userSelection == 0) {
                break;
            }

            int itemPrice = getPrice(userSelection);
            if (itemPrice == 0) {
                System.out.println("無效的選項，請重新輸入。");
                continue;
            }

            String itemName = getItemName(userSelection);
            int validQty = readValidQuantity(orderScanner);
            int itemSubtotal = calculateSubtotal(itemPrice, validQty);

            switch (userSelection) {
                case 1: blackTeaQty += validQty; break;
                case 2: greenTeaQty += validQty; break;
                case 3: milkTeaQty += validQty; break;
                case 4: coffeeQty += validQty; break;
            }

            sumItems += validQty;
            totalBeforeDiscount += itemSubtotal;

            System.out.println(itemName + " x " + validQty);
            System.out.println("Subtotal: " + itemSubtotal);
        }

        int finalTotalAmount = calculateDiscountedTotal(totalBeforeDiscount);
        printReceipt(blackTeaQty, greenTeaQty, milkTeaQty, coffeeQty, sumItems, totalBeforeDiscount, finalTotalAmount);

        orderScanner.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Drink Menu ===");
        System.out.println("1. Black tea   $30");
        System.out.println("2. Green tea   $35");
        System.out.println("3. Milk tea    $45");
        System.out.println("4. Coffee      $50");
        System.out.println("0. Checkout");
        System.out.print("請輸入選項：");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 45;
            case 4: return 50;
            default: return 0;
        }
    }

    public static String getItemName(int option) {
        switch (option) {
            case 1: return "Black tea";
            case 2: return "Green tea";
            case 3: return "Milk tea";
            case 4: return "Coffee";
            default: return "Unknown";
        }
    }

    public static int readValidQuantity(Scanner sc) {
        int qty = 0;
        while (qty <= 0) {
            System.out.print("請輸入數量：");
            qty = sc.nextInt();
            if (qty <= 0) {
                System.out.println("數量必須大於 0，請重新輸入。");
            }
        }
        return qty;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) {
            return (int) (totalAmount * 0.9);
        }
        return totalAmount;
    }

    public static void printReceipt(int blackTeaCount, int greenTeaCount, int milkTeaCount, int coffeeCount, int totalItems, int totalAmount, int finalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Black tea: " + blackTeaCount);
        System.out.println("Green tea: " + greenTeaCount);
        System.out.println("Milk tea: " + milkTeaCount);
        System.out.println("Coffee: " + coffeeCount);
        System.out.println("Total items: " + totalItems);
        System.out.println("Original amount: " + totalAmount);
        
        if (totalAmount >= 300) {
            System.out.println("Discount: 9折");
        } else {
            System.out.println("Discount: No");
        }
        
        System.out.println("Final amount: " + finalAmount);
    }
}