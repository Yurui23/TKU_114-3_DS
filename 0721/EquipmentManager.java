import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    private static ArrayList<Equipment> equipmentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 6) {
                System.out.println("感謝使用設備管理系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 設備管理系統 ===");
        System.out.println("1. 新增設備");
        System.out.println("2. 依代碼搜尋設備");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("5. 列出所有可借用設備");
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
                addEquipment(scanner);
                break;
            case 2:
                searchEquipment(scanner);
                break;
            case 3:
                borrowEquipment(scanner);
                break;
            case 4:
                returnEquipment(scanner);
                break;
            case 5:
                listAvailableEquipment();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 6 之間的數字！");
        }
    }

    private static Equipment findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Equipment eq : equipmentList) {
            if (eq.getId().equalsIgnoreCase(id.trim())) {
                return eq;
            }
        }
        return null;
    }

    private static void addEquipment(Scanner scanner) {
        System.out.print("請輸入設備代碼: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("錯誤：設備代碼不可為空白！");
            return;
        }

        if (findById(id) != null) {
            System.out.println("錯誤：設備代碼已存在，不可重複新增！");
            return;
        }

        System.out.print("請輸入設備名稱: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：設備名稱不可為空白！");
            return;
        }

        Equipment eq = new Equipment(id, name);
        equipmentList.add(eq);
        System.out.println("新增成功！" + eq);
    }

    private static void searchEquipment(Scanner scanner) {
        System.out.print("請輸入要搜尋的設備代碼: ");
        String id = scanner.nextLine().trim();

        Equipment eq = findById(id);
        if (eq != null) {
            System.out.println("找到設備: " + eq);
        } else {
            System.out.println("找不到代碼為 " + id + " 的設備！");
        }
    }

    private static void borrowEquipment(Scanner scanner) {
        System.out.print("請輸入要借出的設備代碼: ");
        String id = scanner.nextLine().trim();

        Equipment eq = findById(id);
        if (eq == null) {
            System.out.println("借出失敗：找不到該設備！");
            return;
        }

        if (eq.borrowEquipment()) {
            System.out.println("借出成功！" + eq);
        } else {
            System.out.println("借出失敗：該設備已被借出中！");
        }
    }

    private static void returnEquipment(Scanner scanner) {
        System.out.print("請輸入要歸還的設備代碼: ");
        String id = scanner.nextLine().trim();

        Equipment eq = findById(id);
        if (eq == null) {
            System.out.println("歸還失敗：找不到該設備！");
            return;
        }

        if (eq.returnEquipment()) {
            System.out.println("歸還成功！" + eq);
        } else {
            System.out.println("歸還失敗：該設備目前並未被借出！");
        }
    }

    private static void listAvailableEquipment() {
        System.out.println("\n--- 可借用設備列表 ---");
        boolean found = false;
        for (Equipment eq : equipmentList) {
            if (eq.isAvailable()) {
                System.out.println(eq);
                found = true;
            }
        }
        if (!found) {
            System.out.println("目前沒有可借用的設備。");
        }
    }
}