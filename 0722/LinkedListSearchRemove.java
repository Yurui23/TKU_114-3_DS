public class LinkedListSearchRemove {

    public static void main(String[] args) {
        IntNode head = buildSampleList();
        System.out.println("=== 初始鏈結串列 ===");
        printList(head);

        System.out.println("\n=== 測試 contains 方法 ===");
        System.out.println("包含 20 ? " + contains(head, 20));
        System.out.println("包含 99 ? " + contains(head, 99));

        System.out.println("\n=== 1. 測試刪除 head (10) ===");
        head = removeValue(head, 10);
        printList(head);

        System.out.println("\n=== 2. 測試刪除 中間節點 (30) ===");
        head = removeValue(head, 30);
        printList(head);

        System.out.println("\n=== 3. 測試刪除 尾節點 (40) ===");
        head = removeValue(head, 40);
        printList(head);

        System.out.println("\n=== 4. 測試刪除 找不到的資料 (99) ===");
        head = removeValue(head, 99);
        printList(head);
    }

    public static boolean contains(IntNode head, int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static IntNode removeValue(IntNode head, int target) {
        if (head == null) {
            System.out.println("串列為空，無法刪除！");
            return null;
        }

        if (head.data == target) {
            System.out.println("成功刪除頭節點: " + target);
            return head.next;
        }

        IntNode current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        if (current.next != null) {
            System.out.println("成功刪除節點: " + target);
            current.next = current.next.next;
        } else {
            System.out.println("刪除失敗：找不到數值 " + target);
        }

        return head;
    }

    public static void printList(IntNode head) {
        if (head == null) {
            System.out.println("目前鏈結串列為空。");
            return;
        }

        System.out.print("當前鏈結串列 : ");
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    private static IntNode buildSampleList() {
        IntNode n1 = new IntNode(10);
        IntNode n2 = new IntNode(20);
        IntNode n3 = new IntNode(30);
        IntNode n4 = new IntNode(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }
}