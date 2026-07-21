import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeliveryProcessingSystem {

    private Queue<DeliveryTask> pendingQueue;
    private Stack<DeliveryTask> completedStack;

    public DeliveryProcessingSystem() {
        this.pendingQueue = new LinkedList<>();
        this.completedStack = new Stack<>();
    }

    public static void main(String[] args) {
        DeliveryProcessingSystem system = new DeliveryProcessingSystem();

        System.out.println("=== 1. 空狀態操作測試 ===");
        system.completeNext();
        system.peekNext();
        system.undoLastCompleted();
        system.printStatus();

        System.out.println("\n=== 2. 新增配送任務 ===");
        system.addTask("DEL-001", "台北市信義區路一段1號");
        system.addTask("DEL-002", "台中市西屯區大道二段2號");
        system.addTask("DEL-003", "高雄市苓雅區三多三路3號");
        system.printStatus();

        System.out.println("\n=== 3. 查看下一筆與完成兩筆任務 ===");
        system.peekNext();
        system.completeNext();
        system.completeNext();
        system.printStatus();

        System.out.println("\n=== 4. 復原最近完成的任務 (DEL-002 回到 Queue 尾端) ===");
        system.undoLastCompleted();
        system.printStatus();

        System.out.println("\n=== 5. 依序完成剩餘任務 ===");
        system.completeNext();
        system.completeNext();
        system.printStatus();
    }

    public boolean addTask(String id, String address) {
        if (id == null || id.trim().isEmpty() || address == null || address.trim().isEmpty()) {
            System.out.println("新增失敗：任務單號與地址不可為空白！");
            return false;
        }

        DeliveryTask task = new DeliveryTask(id.trim(), address.trim());
        pendingQueue.offer(task);
        System.out.println("成功新增配送任務：" + task);
        return true;
    }

    public void completeNext() {
        if (pendingQueue.isEmpty()) {
            System.out.println("操作失敗：當前沒有待配送的任務！");
            return;
        }

        DeliveryTask task = pendingQueue.poll();
        completedStack.push(task);
        System.out.println("已完成配送：" + task);
    }

    public void peekNext() {
        if (pendingQueue.isEmpty()) {
            System.out.println("當前沒有下一筆待配送任務。");
            return;
        }

        System.out.println("下一筆待配送任務：" + pendingQueue.peek());
    }

    public void undoLastCompleted() {
        if (completedStack.isEmpty()) {
            System.out.println("復原失敗：沒有已完成的配送紀錄可供復原！");
            return;
        }

        DeliveryTask task = completedStack.pop();
        pendingQueue.offer(task);
        System.out.println("已復原任務：" + task + "（重新回到待配送 Queue 尾端）");
    }

    public void printStatus() {
        System.out.println("\n--- 當前系統狀態 ---");
        System.out.println("待配送數量 (Queue): " + pendingQueue.size() + " 筆");
        System.out.println("已完成數量 (Stack): " + completedStack.size() + " 筆");

        System.out.println("【待配送清單】");
        if (pendingQueue.isEmpty()) {
            System.out.println(" (無)");
        } else {
            int index = 1;
            for (DeliveryTask task : pendingQueue) {
                System.out.println("  " + index++ + ". " + task);
            }
        }

        System.out.println("【已完成歷史 (最新完成在前)】");
        if (completedStack.isEmpty()) {
            System.out.println(" (無)");
        } else {
            for (int i = completedStack.size() - 1; i >= 0; i--) {
                System.out.println("  - " + completedStack.get(i));
            }
        }
    }
}