import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CounterServiceSystem {

    private Queue<Customer> waitingQueue;
    private List<Customer> servedHistory;
    private int numberCounter;

    public CounterServiceSystem() {
        this.waitingQueue = new LinkedList<>();
        this.servedHistory = new ArrayList<>();
        this.numberCounter = 1;
    }

    private static class Customer {
        private int number;
        private String name;

        public Customer(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "號碼: " + number + "號 | 姓名: " + name;
        }
    }

    public static void main(String[] args) {
        CounterServiceSystem system = new CounterServiceSystem();

        System.out.println("=== 測試 1: 空佇列嘗試叫號與查看 ===");
        system.callNext();
        system.peekNext();
        system.printWaitingCount();

        System.out.println("\n=== 測試 2: 顧客取號 ===");
        system.takeNumber("Alice");
        system.takeNumber("Bob");
        system.takeNumber("Charlie");
        system.printWaitingCount();

        System.out.println("\n=== 測試 3: 查看下一位 ===");
        system.peekNext();

        System.out.println("\n=== 測試 4: 櫃台連續叫號服務 ===");
        system.callNext();
        system.callNext();
        system.printWaitingCount();

        System.out.println("\n=== 測試 5: 新顧客取號與叫號 ===");
        system.takeNumber("David");
        system.callNext();
        system.callNext();

        System.out.println("\n=== 測試 6: 再次叫號 (空佇列) ===");
        system.callNext();

        System.out.println("\n=== 測試 7: 列出已服務歷史紀錄 ===");
        system.printHistory();
    }

    public void takeNumber(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("取號失敗：姓名不可為空白！");
            return;
        }

        Customer customer = new Customer(numberCounter++, name.trim());
        waitingQueue.offer(customer);
        System.out.println("取號成功：" + customer);
    }

    public void callNext() {
        if (waitingQueue.isEmpty()) {
            System.out.println("叫號失敗：目前沒有等待中的顧客！");
            return;
        }

        Customer servedCustomer = waitingQueue.poll();
        servedHistory.add(servedCustomer);
        System.out.println("請 " + servedCustomer + " 至櫃台辦理業務！");
    }

    public void peekNext() {
        if (waitingQueue.isEmpty()) {
            System.out.println("目前沒有下一位等待的顧客。");
            return;
        }

        System.out.println("下一位準備服務的顧客為：" + waitingQueue.peek());
    }

    public void printWaitingCount() {
        System.out.println("當前等待人數：" + waitingQueue.size() + " 人");
    }

    public void printHistory() {
        System.out.println("--- 已完成服務歷史紀錄 ---");
        if (servedHistory.isEmpty()) {
            System.out.println("目前尚無已服務的顧客紀錄。");
            return;
        }

        for (int i = 0; i < servedHistory.size(); i++) {
            System.out.println((i + 1) + ". " + servedHistory.get(i));
        }
    }
}