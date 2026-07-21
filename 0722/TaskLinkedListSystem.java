import java.util.Scanner;

public class TaskLinkedListSystem {

    private static TaskLinkedList taskList = new TaskLinkedList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 8) {
                System.out.println("感謝使用工作項目系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 工作項目管理系統 ===");
        System.out.println("1. 新增【緊急工作】(加到前端)");
        System.out.println("2. 新增【一般工作】(加到尾端)");
        System.out.println("3. 標記工作為【已完成】");
        System.out.println("4. 刪除工作");
        System.out.println("5. 列出【未完成】工作");
        System.out.println("6. 列出【完整】工作清單");
        System.out.println("7. 輸出統計資訊 (總數與未完成數量)");
        System.out.println("8. 離開系統");
        System.out.print("請選擇操作 (1-8): ");
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
                addTask(scanner, true);
                break;
            case 2:
                addTask(scanner, false);
                break;
            case 3:
                completeTask(scanner);
                break;
            case 4:
                deleteTask(scanner);
                break;
            case 5:
                taskList.displayUncompletedTasks();
                break;
            case 6:
                taskList.displayAllTasks();
                break;
            case 7:
                taskList.printTaskStatistics();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 8 之間的數字！");
        }
    }

    private static void addTask(Scanner scanner, boolean isUrgent) {
        System.out.print("請輸入工作代碼: ");
        String id = scanner.nextLine();

        System.out.print("請輸入工作說明: ");
        String description = scanner.nextLine();

        if (isUrgent) {
            taskList.addFirst(id, description);
        } else {
            taskList.addLast(id, description);
        }
    }

    private static void completeTask(Scanner scanner) {
        System.out.print("請輸入要標記完成的工作代碼: ");
        String id = scanner.nextLine();

        taskList.markAsCompleted(id);
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("請輸入要刪除的工作代碼: ");
        String id = scanner.nextLine();

        taskList.removeById(id);
    }
}