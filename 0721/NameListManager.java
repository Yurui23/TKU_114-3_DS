import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    private static ArrayList<String> nameList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 6) {
                System.out.println("感謝使用名單管理系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 名單管理系統 ===");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部姓名");
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
                addName(scanner);
                break;
            case 2:
                searchName(scanner);
                break;
            case 3:
                updateName(scanner);
                break;
            case 4:
                deleteName(scanner);
                break;
            case 5:
                listAllNames();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 6 之間的數字！");
        }
    }

    private static void addName(Scanner scanner) {
        System.out.print("請輸入要新增的姓名: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：姓名不可為空白！");
            return;
        }

        nameList.add(name);
        System.out.println("成功新增姓名: " + name);
    }

    private static void searchName(Scanner scanner) {
        System.out.print("請輸入要搜尋的姓名: ");
        String target = scanner.nextLine().trim();

        if (target.isEmpty()) {
            System.out.println("錯誤：搜尋名稱不可為空白！");
            return;
        }

        boolean found = false;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(target)) {
                System.out.println("找到姓名: " + nameList.get(i) + " (位置索引: " + i + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到姓名: " + target);
        }
    }

    private static void updateName(Scanner scanner) {
        System.out.print("請輸入要修改的原姓名: ");
        String oldName = scanner.nextLine().trim();

        int index = findIndexIgnoreCase(oldName);
        if (index == -1) {
            System.out.println("修改失敗：找不到該姓名！");
            return;
        }

        System.out.print("請輸入新的姓名: ");
        String newName = scanner.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("錯誤：新姓名不可為空白！修改取消。");
            return;
        }

        nameList.set(index, newName);
        System.out.println("成功將 \"" + oldName + "\" 修改為 \"" + newName + "\"！");
    }

    private static void deleteName(Scanner scanner) {
        System.out.print("請輸入要刪除的姓名: ");
        String target = scanner.nextLine().trim();

        int index = findIndexIgnoreCase(target);
        if (index != -1) {
            String removedName = nameList.remove(index);
            System.out.println("成功刪除姓名: " + removedName);
        } else {
            System.out.println("刪除失敗：找不到該姓名！");
        }
    }

    private static void listAllNames() {
        System.out.println("\n--- 全部位名單 ---");
        if (nameList.isEmpty()) {
            System.out.println("目前名單為空。");
            return;
        }

        for (int i = 0; i < nameList.size(); i++) {
            System.out.println((i + 1) + ". " + nameList.get(i));
        }
    }

    private static int findIndexIgnoreCase(String target) {
        if (target == null || target.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
}