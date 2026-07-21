import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ClinicQueueSystem {

    private Queue<Patient> queue;
    private int totalServedCount;

    public ClinicQueueSystem() {
        this.queue = new LinkedList<>();
        this.totalServedCount = 0;
    }

    public static void main(String[] args) {
        ClinicQueueSystem system = new ClinicQueueSystem();

        System.out.println("=== 1. 空佇列操作測試 ===");
        system.callNext();
        system.peekNext();
        system.displayStatistics();

        System.out.println("\n=== 2. 病患掛號 ===");
        system.register(101, "張三", "內科");
        system.register(102, "李四", "外科");
        system.register(103, "王五", "內科");
        system.register(104, "趙六", "眼科");

        System.out.println("\n=== 3. 測試重複號碼掛號 ===");
        system.register(102, "陳七", "小兒科");

        System.out.println("\n=== 4. 查看當前等待清單與下一位 ===");
        system.displayWaitingList();
        system.peekNext();

        System.out.println("\n=== 5. 進行叫號看診 ===");
        system.callNext();
        system.callNext();

        System.out.println("\n=== 6. 新增掛號與查看統計 ===");
        system.register(105, "孫八", "內科");
        system.displayWaitingList();
        system.displayStatistics();
    }

    public boolean register(int number, String name, String department) {
        if (name == null || name.trim().isEmpty() || department == null || department.trim().isEmpty()) {
            System.out.println("掛號失敗：姓名與科別不可為空白！");
            return false;
        }

        if (isNumberExists(number)) {
            System.out.println("掛號失敗：號碼 " + number + " 已存在，不可重複掛號！");
            return false;
        }

        Patient patient = new Patient(number, name.trim(), department.trim());
        queue.offer(patient);
        System.out.println("掛號成功：" + patient);
        return true;
    }

    public void callNext() {
        if (queue.isEmpty()) {
            System.out.println("叫號失敗：當前沒有等待看診的病患！");
            return;
        }

        Patient patient = queue.poll();
        totalServedCount++;
        System.out.println("請 " + patient + " 入內看診！");
    }

    public void peekNext() {
        if (queue.isEmpty()) {
            System.out.println("當前無等待看診的病患。");
            return;
        }

        System.out.println("下一位看診病患：" + queue.peek());
    }

    public void displayWaitingList() {
        System.out.println("\n--- 當前候診清單 ---");
        if (queue.isEmpty()) {
            System.out.println("候診區目前為空。");
            return;
        }

        int index = 1;
        for (Patient patient : queue) {
            System.out.println(index++ + ". " + patient);
        }
    }

    public void displayStatistics() {
        System.out.println("\n=== 診所看診統計 ===");
        System.out.println("當前總等待人數: " + queue.size() + " 人");
        System.out.println("已完成看診人數: " + totalServedCount + " 人");

        Map<String, Integer> deptCountMap = new HashMap<>();
        for (Patient patient : queue) {
            String dept = patient.getDepartment();
            deptCountMap.put(dept, deptCountMap.getOrDefault(dept, 0) + 1);
        }

        System.out.println("--- 各科別等待人數 ---");
        if (deptCountMap.isEmpty()) {
            System.out.println("無等待中的科別。");
        } else {
            for (Map.Entry<String, Integer> entry : deptCountMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " 人");
            }
        }
    }

    private boolean isNumberExists(int number) {
        for (Patient patient : queue) {
            if (patient.getNumber() == number) {
                return true;
            }
        }
        return false;
    }
}