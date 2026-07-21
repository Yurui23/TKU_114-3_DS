import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    private static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 6) {
                System.out.println("感謝使用聯絡人管理系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 聯絡人管理系統 ===");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人 (代碼或姓名)");
        System.out.println("3. 修改聯絡人電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 列出完整清單");
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
                addContact(scanner);
                break;
            case 2:
                searchContact(scanner);
                break;
            case 3:
                updateContactPhone(scanner);
                break;
            case 4:
                deleteContact(scanner);
                break;
            case 5:
                listAllContacts();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 6 之間的數字！");
        }
    }

    private static Contact findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Contact c : contactList) {
            if (c.getId().equalsIgnoreCase(id.trim())) {
                return c;
            }
        }
        return null;
    }

    private static void addContact(Scanner scanner) {
        System.out.print("請輸入聯絡人代碼: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("錯誤：代碼不可為空白！");
            return;
        }

        if (findById(id) != null) {
            System.out.println("錯誤：代碼已存在，不可重複新增！");
            return;
        }

        System.out.print("請輸入聯絡人姓名: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：姓名不可為空白！");
            return;
        }

        System.out.print("請輸入電話: ");
        String phone = scanner.nextLine().trim();

        System.out.print("請輸入電子郵件: ");
        String email = scanner.nextLine().trim();

        Contact contact = new Contact(id, name, phone, email);
        contactList.add(contact);
        System.out.println("成功新增聯絡人！" + contact);
    }

    private static void searchContact(Scanner scanner) {
        System.out.print("請輸入要搜尋的代碼或姓名: ");
        String query = scanner.nextLine().trim();

        if (query.isEmpty()) {
            System.out.println("錯誤：搜尋關鍵字不可為空白！");
            return;
        }

        boolean found = false;
        for (Contact c : contactList) {
            if (c.getId().equalsIgnoreCase(query) || c.getName().equalsIgnoreCase(query)) {
                System.out.println("找到聯絡人: " + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到符合 \"" + query + "\" 的聯絡人！");
        }
    }

    private static void updateContactPhone(Scanner scanner) {
        System.out.print("請輸入要修改電話的聯絡人代碼: ");
        String id = scanner.nextLine().trim();

        Contact c = findById(id);
        if (c == null) {
            System.out.println("修改失敗：找不到該代碼的聯絡人！");
            return;
        }

        System.out.print("請輸入新的電話號碼: ");
        String newPhone = scanner.nextLine().trim();

        if (newPhone.isEmpty()) {
            System.out.println("錯誤：電話號碼不可為空白！修改取消。");
            return;
        }

        c.setPhone(newPhone);
        System.out.println("電話修改成功！" + c);
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("請輸入要刪除的聯絡人代碼: ");
        String id = scanner.nextLine().trim();

        Contact c = findById(id);
        if (c != null) {
            contactList.remove(c);
            System.out.println("成功刪除聯絡人: " + c.getName());
        } else {
            System.out.println("刪除失敗：找不到該代碼的聯絡人！");
        }
    }

    private static void listAllContacts() {
        System.out.println("\n--- 完整聯絡人清單 ---");
        if (contactList.isEmpty()) {
            System.out.println("目前沒有任何聯絡人。");
            return;
        }

        for (Contact c : contactList) {
            System.out.println(c);
        }
    }
}