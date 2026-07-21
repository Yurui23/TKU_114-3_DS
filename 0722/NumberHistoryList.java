public class NumberHistoryList {

    private IntNode head;

    public static void main(String[] args) {
        NumberHistoryList list = new NumberHistoryList();

        System.out.println("=== 測試 1: 印出與統計初始空串列 ===");
        list.printList();
        list.printStats();

        System.out.println("\n=== 測試 2: 前端新增 20 ===");
        list.addFirst(20);
        list.printList();

        System.out.println("\n=== 測試 3: 前端新增 10 ===");
        list.addFirst(10);
        list.printList();

        System.out.println("\n=== 測試 4: 尾端新增 30 ===");
        list.addLast(30);
        list.printList();

        System.out.println("\n=== 測試 5: 尾端新增 40 ===");
        list.addLast(40);
        list.printList();

        System.out.println("\n=== 測試 6: 搜尋元素 (20 與 99) ===");
        System.out.println("搜尋 20: " + list.contains(20));
        System.out.println("搜尋 99: " + list.contains(99));

        System.out.println("\n=== 測試 7: 刪除頭節點 (10) 與 中間節點 (30) ===");
        list.remove(10);
        list.remove(30);
        list.printList();

        System.out.println("\n=== 測試 8: 刪除不存在的數字 (100) 與 統計最終狀態 ===");
        list.remove(100);
        list.printList();
        list.printStats();
    }

    public void addFirst(int data) {
        IntNode newNode = new IntNode(data);
        newNode.next = head;
        head = newNode;
        System.out.println("前端成功新增: " + data);
    }

    public void addLast(int data) {
        IntNode newNode = new IntNode(data);
        if (head == null) {
            head = newNode;
            System.out.println("尾端成功新增: " + data);
            return;
        }

        IntNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("尾端成功新增: " + data);
    }

    public boolean contains(int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int target) {
        if (head == null) {
            System.out.println("刪除失敗：串列為空！");
            return;
        }

        if (head.data == target) {
            head = head.next;
            System.out.println("成功刪除: " + target);
            return;
        }

        IntNode current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("成功刪除: " + target);
        } else {
            System.out.println("刪除失敗：找不到資料 " + target);
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("當前串列: [空串列]");
            return;
        }

        System.out.print("當前串列: ");
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public void printStats() {
        if (head == null) {
            System.out.println("--- 統計結果 ---");
            System.out.println("大小 (size) : 0");
            System.out.println("總和 (sum)  : 0");
            System.out.println("最大值 (max): 無（串列為空）");
            System.out.println("最小值 (min): 無（串列為空）");
            return;
        }

        int count = 0;
        int sum = 0;
        int max = head.data;
        int min = head.data;

        IntNode current = head;
        while (current != null) {
            count++;
            sum += current.data;
            if (current.data > max) {
                max = current.data;
            }
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }

        System.out.println("--- 統計結果 ---");
        System.out.println("大小 (size) : " + count);
        System.out.println("總和 (sum)  : " + sum);
        System.out.println("最大值 (max): " + max);
        System.out.println("最小值 (min): " + min);
    }
}