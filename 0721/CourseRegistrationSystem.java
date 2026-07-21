import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    private static ArrayList<Course> courseList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);

            if (choice == 8) {
                System.out.println("感謝使用選課管理系統，再見！");
                break;
            }

            handleChoice(choice, scanner);
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== 選課管理系統 ===");
        System.out.println("1. 新增課程");
        System.out.println("2. 學生選課 (加選)");
        System.out.println("3. 學生退選");
        System.out.println("4. 刪除課程");
        System.out.println("5. 搜尋課程");
        System.out.println("6. 列出所有課程");
        System.out.println("7. 統計與額滿課程資訊");
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
                addCourse(scanner);
                break;
            case 2:
                enrollCourse(scanner);
                break;
            case 3:
                dropCourse(scanner);
                break;
            case 4:
                deleteCourse(scanner);
                break;
            case 5:
                searchCourse(scanner);
                break;
            case 6:
                listAllCourses();
                break;
            case 7:
                displayStatistics();
                break;
            default:
                System.out.println("無效的選擇，請輸入 1 到 8 之間的數字！");
        }
    }

    private static Course findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return null;
        }
        for (Course c : courseList) {
            if (c.getId().equalsIgnoreCase(id.trim())) {
                return c;
            }
        }
        return null;
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("請輸入課程代碼: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("錯誤：課程代碼不可為空白！");
            return;
        }

        if (findById(id) != null) {
            System.out.println("錯誤：課程代碼已存在，不可重複新增！");
            return;
        }

        System.out.print("請輸入課程名稱: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：課程名稱不可為空白！");
            return;
        }

        System.out.print("請輸入課程容量: ");
        int capacity = getIntInput(scanner);

        if (capacity <= 0) {
            System.out.println("錯誤：課程容量必須大於 0！");
            return;
        }

        Course course = new Course(id, name, capacity);
        courseList.add(course);
        System.out.println("成功新增課程！" + course);
    }

    private static void enrollCourse(Scanner scanner) {
        System.out.print("請輸入要加選的課程代碼: ");
        String id = scanner.nextLine().trim();

        Course course = findById(id);
        if (course == null) {
            System.out.println("選課失敗：找不到該課程！");
            return;
        }

        if (course.enroll()) {
            System.out.println("加選成功！" + course);
        } else {
            System.out.println("加選失敗：該課程已額滿，無法再增加人數！");
        }
    }

    private static void dropCourse(Scanner scanner) {
        System.out.print("請輸入要退選的課程代碼: ");
        String id = scanner.nextLine().trim();

        Course course = findById(id);
        if (course == null) {
            System.out.println("退選失敗：找不到該課程！");
            return;
        }

        if (course.drop()) {
            System.out.println("退選成功！" + course);
        } else {
            System.out.println("退選失敗：該課程目前選課人數為 0！");
        }
    }

    private static void deleteCourse(Scanner scanner) {
        System.out.print("請輸入要刪除的課程代碼: ");
        String id = scanner.nextLine().trim();

        Course course = findById(id);
        if (course != null) {
            courseList.remove(course);
            System.out.println("成功刪除課程: " + course.getName());
        } else {
            System.out.println("刪除失敗：找不到該課程！");
        }
    }

    private static void searchCourse(Scanner scanner) {
        System.out.print("請輸入要搜尋的課程代碼或名稱: ");
        String query = scanner.nextLine().trim();

        if (query.isEmpty()) {
            System.out.println("錯誤：搜尋關鍵字不可為空白！");
            return;
        }

        boolean found = false;
        for (Course c : courseList) {
            if (c.getId().equalsIgnoreCase(query) || c.getName().equalsIgnoreCase(query)) {
                System.out.println("找到課程: " + c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到符合 \"" + query + "\" 的課程！");
        }
    }

    private static void listAllCourses() {
        System.out.println("\n--- 完整課程清單 ---");
        if (courseList.isEmpty()) {
            System.out.println("目前沒有任何課程。");
            return;
        }

        for (Course c : courseList) {
            System.out.println(c);
        }
    }

    private static void displayStatistics() {
        System.out.println("\n=== 統計與額滿課程資訊 ===");
        System.out.println("總課程數: " + courseList.size() + " 門");

        int totalEnrolled = 0;
        ArrayList<Course> fullCourses = new ArrayList<>();

        for (Course c : courseList) {
            totalEnrolled += c.getCurrentEnrolled();
            if (c.isFull()) {
                fullCourses.add(c);
            }
        }

        System.out.println("總選課人次: " + totalEnrolled + " 人");
        System.out.println("\n--- 額滿課程清單 (" + fullCourses.size() + " 門) ---");

        if (fullCourses.isEmpty()) {
            System.out.println("目前沒有額滿的課程。");
        } else {
            for (Course c : fullCourses) {
                System.out.println(c);
            }
        }
    }
}